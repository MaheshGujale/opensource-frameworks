package businessrules.ui.editor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.eclipse.core.internal.resources.BuildConfiguration;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.FileEditorInput;

import com.sun.xml.internal.ws.api.message.Message;
import com.thoughtworks.xstream.XStream;

import businessrules.Activator;
import businessrules.ui.utils.WorkflowUtil;
import businessrules.ui.workflow.BizFlowFeatureProvider;
import businessrulesruntime.core.engine.ActivityStep;
import businessrulesruntime.core.engine.BizflowContent;
import businessrulesruntime.core.engine.BizflowModel;
import businessrulesruntime.core.engine.BusinessRuleInfo;
import businessrulesruntime.core.engine.BusinessRuleStep;
import businessrulesruntime.core.engine.CodeDetail;
import businessrulesruntime.core.engine.ConditionalLink;
import businessrulesruntime.core.engine.DecisionStep;
import businessrulesruntime.core.engine.FieldInfo;
import businessrulesruntime.core.engine.SequenceLink;
import businessrulesruntime.core.engine.StartStep;
import businessrulesruntime.core.engine.util.FileUtil;

public class BusinessRuleEditorPart extends DiagramEditor {
	private Logger logger = Logger.getLogger(BusinessRuleEditorPart.class);
	private static final String Const_forwardSlash = "/";

	public static final String ID = "businessrules.ui.workflow.editor.BusinessRuleEditor";
	private static final int CONST_COMPILATION_UNIT = 8;
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private ScrolledForm frmHeader;

	private URI modelURI;
	private IProject activeProject;
	private String oldFilePath;
	private String newDiagramPath;
	private String fileName;
	public String editorInitializationError = null;
	private boolean diffView = false;
	private static final int PALETTE_HIDDEN = 8;
	private static final int PALETTE_PINNED = 4;
	private static IProgressMonitor monitor;

	public BusinessRuleEditorPart() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {

		frmHeader = toolkit.createScrolledForm(parent);
		frmHeader.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.paintBordersFor(frmHeader);

		IWorkbenchAction autoSaveAction = ActionFactory.SAVE
				.create(PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		frmHeader.getToolBarManager().add(autoSaveAction);
		getPalettePreferences().setPaletteState(PALETTE_PINNED);

		frmHeader.getToolBarManager().update(true);

		frmHeader.setText(fileName);
		toolkit.decorateFormHeading(frmHeader.getForm());

		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		frmHeader.getBody().setLayout(gridLayout);

		Composite compEditor = new Composite(frmHeader.getBody(), SWT.NONE);
		compEditor.setLayout(new FillLayout(SWT.HORIZONTAL));
		compEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		super.createPartControl(compEditor);
	}

	@Override
	public String getTitleToolTip() {
		return fileName;
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		BizflowContent bizflowContent = null;
		URI currentURI = null;
		BuildConfiguration buildConfiguration = null;
		IFile file = null;
		BusinessRuleEditorInput bruleInput = (BusinessRuleEditorInput) input;

		URI uri1 = URI.createFileURI(bruleInput.getName());
		Diagram diagram = Graphiti.getPeCreateService().createDiagram("Workflow", bruleInput.getName() + " (Workflow)",
				false);
		String providerId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(diagram.getDiagramTypeId());
		input = new DiagramEditorInput(uri1, providerId);

		if (input instanceof FileEditorInput) {
			file = ((FileEditorInput) input).getFile();
		} else if (input instanceof DiagramEditorInput) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IPath iPath = new Path(((DiagramEditorInput) input).getUriString());
			IPath paths = iPath.removeFirstSegments(1);
			file = workspace.getRoot().getFile(paths);
		}

		try {
			activeProject = file.getProject();
			// buildConfiguration =
			// ActiveProjectUtil.getConfiguration(activeProject);

			java.net.URI uri = file.getLocationURI();
			currentURI = URI.createURI(uri.toString());
			oldFilePath = uri.getPath();

			if (oldFilePath.contains("#") && input instanceof DiagramEditorInput) {
				oldFilePath = oldFilePath.substring(0, oldFilePath.lastIndexOf("#"));
			}

			String path = activeProject.getLocation() + "/temp";
			File tempFolder = new File(path);
			tempFolder.mkdir();

			fileName = oldFilePath.substring(oldFilePath.lastIndexOf(Const_forwardSlash) + 1,
					oldFilePath.lastIndexOf("."));

			newDiagramPath = path + "/tmp_" + fileName + ".bizflow";
			File diagramFile = new File(tempFolder, "/tmp_" + fileName + ".bizflow");

			File inputFile = new File(oldFilePath);
			bizflowContent = FileUtil.readFromFile(inputFile);
			if (bizflowContent.getBizflowDiagram().equals("")) {
				InputStream inputStream = Activator.class.getResourceAsStream("/resources/Diagram.template");
				int value = 0;
				StringBuffer buffer = new StringBuffer();
				while ((value = inputStream.read()) != -1) {
					buffer.append((char) value);
				}
				FileOutputStream outputStream = new FileOutputStream(inputFile);
				outputStream.write(buffer.toString().replace("<[[BizflowName]]>", fileName).getBytes());
				outputStream.flush();
				outputStream.close();
				bizflowContent = FileUtil.readFromFile(inputFile);
			}

			FileOutputStream outputStream = new FileOutputStream(diagramFile);
			outputStream.write(bizflowContent.getBizflowDiagram().getBytes());
			outputStream.flush();
			outputStream.close();

			input = new URIEditorInput(URI.createFileURI(newDiagramPath));
		} catch (Exception e) {
			if (buildConfiguration == null) {
				throw new PartInitException(
						"Bizflow diagram open failed because window preference of current project is not defined."
								+ " Please provide preference in Windows --> Preferences --> Business Rule Settings.");
			} else {
				throw new PartInitException(e.getMessage());
			}
		}

		super.init(site, input);

		BizFlowFeatureProvider featureProvider = ((BizFlowFeatureProvider) getDiagramTypeProvider()
				.getFeatureProvider());

		featureProvider.setGroupName(activeProject.getName());

		/*
		 * ExcelFormulaContentProvider.getInstance()
		 * .setStaticImportClassNames(buildConfiguration.
		 * getStaticImportClassNames());
		 * ActiveProjectUtil.registerBuildConfig(activeProject,
		 * buildConfiguration);
		 */
		URIConverter uriConverter = getEditingDomain().getResourceSet().getURIConverter();
		InputStream inputStream = null;

		if (uriConverter != null) {
			try {
				modelURI = currentURI;
				String modelData = bizflowContent.getBizflowModel();
				if (!modelData.trim().equals("")) {
					inputStream = IOUtils.toInputStream(modelData);
					BizflowModel bizflowModel = (BizflowModel) getXStream().fromXML(inputStream);

					WorkflowUtil.setDiagramModels(bizflowModel, getDiagramTypeProvider().getDiagram());
					inputStream.close();

					URI baseURI = modelURI.trimSegments(1);

					featureProvider.setBaseURI(baseURI);
				}
			} catch (IOException e) {
				logger.error(e);
			}
		}

		// listener to close all bizflow diagrams and bizflow compare
		// editors before closing eclipse
		// PlatformUI.getWorkbench().addWorkbenchListener(new
		// BizflowWorkbenchListener());
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		if (diffView) {
			return;
		}
		BizflowContent bizflowContent = new BizflowContent();
		EList<Resource> resources = getDiagramBehavior().getResourceSet().getResources();
		if (resources != null && resources.size() > 0) {
			resources.get(0).setModified(true);
		}

		final BizflowModel bizflowModel = WorkflowUtil.getDiagramModels(getDiagramTypeProvider().getDiagram());

		bizflowContent.setBizflowModel(getXStream().toXML(bizflowModel));

		super.doSave(monitor);

		File diagramFile = new File(newDiagramPath);
		FileUtil.writeToFile(oldFilePath, diagramFile, bizflowContent.getBizflowModel());

		if (activeProject == null) {
			return;
		}
		final File modelAbsoluteFile = new File(oldFilePath);

		/*
		 * final GenerateSourceCode generateSourceCode = new
		 * GenerateSourceCode(callBack, logger) { public File
		 * getAbsolutePath(String projectRelativePath) { IPath relativePath =
		 * activeProject.getFile(projectRelativePath).getProjectRelativePath();
		 * IPath path = relativePath.removeFirstSegments(1); IPath rawLocation =
		 * activeProject.getFile(path).getRawLocation(); if (rawLocation !=
		 * null) { return new File(rawLocation.toOSString()); } else { File file
		 * = new File(projectRelativePath); if (file.exists()) { return file; }
		 * } return new File(""); }
		 * 
		 * @Override public Map<String, String> formatJavaCodes(Map<String,
		 * String> generatedCodes) { IJavaProject javaProject =
		 * JavaCore.create(activeProject); Set<String> keys =
		 * generatedCodes.keySet(); for (String key : keys) { String sourceCode
		 * = generatedCodes.get(key); sourceCode =
		 * CodeFormatterUtil.format(CONST_COMPILATION_UNIT, sourceCode, 0, null,
		 * javaProject);
		 * 
		 * generatedCodes.put(key, sourceCode); }
		 * 
		 * return generatedCodes; } };
		 * 
		 * try { logger.debug("Generating source code..."); final
		 * BuildConfiguration buildConfiguration =
		 * ActiveProjectUtil.getConfiguration(activeProject); String
		 * errorMessage =
		 * ActiveProjectUtil.validateBuildConfiguration(buildConfiguration); if
		 * (buildConfiguration == null) { logger.error(
		 * "Source code generation failed."); logger.error(
		 * "Code generation failed because window preference of current project is not defined."
		 * ); logger.info(
		 * "Please provide preference in Window --> Preferences --> Business Rule Settings."
		 * ); } else if (errorMessage.isEmpty() == false) { logger.error(
		 * "Source code generation failed."); logger.error(
		 * "Code generation failed because " + errorMessage); } else { Shell
		 * shell =
		 * PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		 * ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
		 * dialog.run(true, false, new IRunnableWithProgress() {
		 * 
		 * @Override public void run(final IProgressMonitor monitor) {
		 * BizflowEditorPart.monitor = monitor; int totalWork = -1; try {
		 * BizflowModel bizflowInfo =
		 * generateSourceCode.objectizeWorkflow(modelAbsoluteFile); totalWork =
		 * (bizflowInfo.getSteps().size() + bizflowInfo.getLinks().size() + 1);
		 * } catch (Exception e) { logger.error(e); } monitor.beginTask(
		 * "Generating code for workflow", totalWork); try {
		 * generateSourceCode.generateWorkflow(buildConfiguration,
		 * modelAbsoluteFile, true); } catch (ValidationException
		 * validationException) { logger.error(validationException);
		 * logger.error(validationException.getExceptionCause()); logger.error(
		 * "Source code generation failed"); } catch (Exception exception) {
		 * logger.error(exception);
		 * logger.error(ConsoleStreamUtil.getStackTrace(exception));
		 * logger.error("Source code generation failed"); }
		 * 
		 * monitor.done(); } });
		 * 
		 * if (generateSourceCode.isWorkflowStatus() == true) { logger.debug(
		 * "Source code generated sucessfully!!!"); } else { logger.error(
		 * "Source code generation failed"); } } } catch (Exception exception) {
		 * logger.error(exception);
		 * logger.error(ConsoleStreamUtil.getStackTrace(exception));
		 * logger.error("Source code generation failed"); }
		 */
		try {
			activeProject.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			logger.error(e);
		}

	}

	protected String checkExistsOrNot(String stepName, String variableName, Map<String, Map<String, FieldInfo>> steps) {
		for (Map.Entry<String, Map<String, FieldInfo>> stepEntry : steps.entrySet()) {
			if (!stepEntry.getKey().equals(stepName)) {
				for (Map.Entry<String, FieldInfo> entry : stepEntry.getValue().entrySet()) {
					if (entry.getKey().equals(variableName) && entry.getValue() != null) {
						return stepEntry.getKey();
					}
				}
			}
		}
		return null;
	}

	@Override
	public String getPartName() {
		return fileName;
	}

	@Override
	public void dispose() {
		if (newDiagramPath != null) {
			File file = new File(newDiagramPath);
			if (file.exists()) {
				file.delete();
			}
		}
		super.dispose();
	}

	protected XStream getXStream() {
		XStream stream = new XStream();
		stream.alias("BizflowModel", BizflowModel.class);
		stream.alias("StartStep", StartStep.class);
		stream.alias("DecisionStep", DecisionStep.class);
		stream.alias("ActivityStep", ActivityStep.class);
		stream.alias("BusinessRuleStep", BusinessRuleStep.class);

		stream.alias("SequenceLink", SequenceLink.class);
		stream.alias("ConditionalLink", ConditionalLink.class);

		stream.alias("BusinessRuleInfo", BusinessRuleInfo.class);
		stream.alias("FieldInfo", FieldInfo.class);
		stream.alias("Message", Message.class);
		stream.alias("CodeDetail", CodeDetail.class);

		return stream;
	}

	@Override
	public boolean isDirty() {
		if (diffView) {
			return false;
		}
		return super.isDirty();
	}

	public boolean isDiffView() {
		return diffView;
	}

	public class ExtensionFilter implements FilenameFilter {
		private String extension;

		public ExtensionFilter(String extension) {
			this.extension = extension;
		}

		public boolean accept(java.io.File dir, String name) {
			return (name.endsWith(extension));
		}
	}

	private void writeFile(String fileName, byte[] bytes) {
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(fileName);
			outputStream.write(bytes);
		} catch (IOException e) {
			logger.error(e);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
	}

	public IProject getActiveProject() {
		return activeProject;
	}
}
