package businessrules.ui.features.connector;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.common.EventManager;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import businessrules.ui.editor.BusinessRuleEditorPart;
import businessrulesruntime.core.engine.CodeDetail;
import businessrulesruntime.core.engine.FieldInfo;
import businessrulesruntime.core.engine.IContext;
import businessrulesruntime.core.engine.IMessage;
import businessrulesruntime.core.engine.InjectInfo;

public class ConnectorPropertyDialog extends TitleAreaDialog {
	private static Logger logger = Logger.getLogger(ConnectorPropertyDialog.class);

	private GuardComposite guardComposite;
	private Table tblBase;
	private Table tblReference;
	private Diagram diagram;

	private String stepName;
	private String stepDisplayName;
	private String stepDescription;
	private List<FieldInfo> parameterInfos;
	private int priority;
	private CodeDetail codeDetail;
	private Connection connection;
	private String groupName;

	private CTabFolder tabFolder;

	public ConnectorPropertyDialog(Shell parentShell, String stepName, String stepDisplayName, String stepDescription,
			List<FieldInfo> parameterInfos, int priority, CodeDetail codeDetail, Diagram diagram, Connection connection,
			String groupName) {
		super(parentShell);
		setShellStyle(SWT.CLOSE | SWT.MAX | SWT.RESIZE | SWT.APPLICATION_MODAL);
		setHelpAvailable(false);
		this.stepName = stepName;
		this.stepDisplayName = stepDisplayName;
		this.stepDescription = stepDescription;
		this.parameterInfos = parameterInfos;
		this.priority = priority;
		this.codeDetail = codeDetail;
		this.diagram = diagram;
		this.connection = connection;
		this.groupName = groupName;
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		contents.getShell().setText("Connector Details");
		setTitle("Connector Details");
		setMessage("Provide connector details");
		return contents;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		tabFolder = new CTabFolder(parent, SWT.BOTTOM);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tabFolder.setSelectionBackground(
				Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

		CTabItem informationCTabItem = new CTabItem(tabFolder, SWT.NONE);
		informationCTabItem.setText("Information");

	/*	stepInfoComposite = new StepInfoComposite(tabFolder, SWT.NONE, false);
		stepInfoComposite.populateStepInfoComposite(stepName, stepDisplayName, stepDescription);
		informationCTabItem.setControl(stepInfoComposite);

		// eventManager in conditional connector
		EventManager eventManager = new EventManager();

		CTabItem parametersCTabItem = new CTabItem(tabFolder, SWT.NONE);
		parametersCTabItem.setText("Parameters");

		parametersComposite = new ParametersComposite(tabFolder, SWT.NONE, parameterInfos, workflowParamsInfo,
				groupName, stepName, true);
		parametersComposite.setEventManager(eventManager);

		parametersCTabItem.setControl(parametersComposite);
		new Label(parametersComposite, SWT.NONE);

		CTabItem gaurdCTabItem = new CTabItem(tabFolder, SWT.NONE);
		gaurdCTabItem.setText("Guard");

		guardComposite = new GuardComposite(tabFolder, SWT.NONE, priority, codeDetail, groupName, eventManager);

		gaurdCTabItem.setControl(guardComposite);
		parametersComposite.publishParameters();
*/		tabFolder.setSelection(0);

		return parent;
	}

	private void generateDiffComposite(Composite parent) {
		Composite diffComposite = new Composite(parent, SWT.NONE);
		GridLayout compLayout = new GridLayout(2, false);
		compLayout.marginHeight = 0;
		compLayout.marginWidth = 0;
		diffComposite.setLayout(compLayout);
		GridData compGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		compGridData.minimumHeight = 100;
		diffComposite.setLayoutData(compGridData);

		Label lblBase = new Label(diffComposite, SWT.NONE);
		lblBase.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		lblBase.setText("Base");

		Label lblRefference = new Label(diffComposite, SWT.NONE);
		lblRefference.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		lblRefference.setText("Reference");

		tblBase = new Table(diffComposite, SWT.BORDER);
		GridData baseData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		baseData.heightHint = 50;
		tblBase.setLayoutData(baseData);
		tblBase.setHeaderVisible(false);
		tblBase.setLinesVisible(false);
		tblBase.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tblBase.deselectAll();
			}
		});

		tblReference = new Table(diffComposite, SWT.BORDER);
		tblReference.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tblReference.setHeaderVisible(false);
		tblReference.setLinesVisible(false);
		tblReference.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tblReference.deselectAll();
			}
		});

		parent.pack();
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void okPressed() {
		/*stepName = stepInfoComposite.getStepName();
		stepDescription = stepInfoComposite.getStepDescription();
		if (stepName.contains(" ")) {
			MessageDialog.openError(getShell(), "Error", "Name should not contain blank space");
		} else if (stepName.endsWith("_")) {
			MessageDialog.openError(getShell(), "Error", "Name should not end with underscore.");
		} else if (WorkflowUtil.validateLinkName(diagram, stepName, connection)) {
			MessageDialog.openError(getShell(), "Duplicate name",
					"Please give another name. Name '" + stepName + "' already exists.");
		} else if (stepDescription.equals("")) {
			MessageDialog.openError(getShell(), "Error", "Please enter step description.");
		} else {
			stepDisplayName = stepInfoComposite.getStepDisplayName();
			parameterInfos = parametersComposite.getFieldInfos();
			priority = guardComposite.getPriority();
			codeDetail = guardComposite.getCodeInfo();
			if (codeDetail != null && codeDetail.getCodeDetail().getMethodInfo() != null) {
				List<FieldInfo> unusedFieldInfos = updateParametersInMethod();
				parameterInfos = parametersComposite.getFieldInfos();

				if (isInjectProvided() == false) {
					return;
				}

				if (unusedFieldInfos.isEmpty() == false) {
					String unusedFieldInfo = "";
					for (FieldInfo fieldInfo : unusedFieldInfos) {
						unusedFieldInfo += fieldInfo.getName() + "(" + fieldInfo.getDataType() + "), ";
					}
					boolean returnToDialog = MessageDialog.openConfirm(null, "Exit", "Parameter " + unusedFieldInfo
							+ " are not used.\n" + "Press Ok to exit or Cancel to return to dialog.");
					if (returnToDialog == false) {
						tabFolder.setSelection(1);
						return;
					}
				}

				// local variables
				processLocalVariables();

				super.okPressed();
			}
		}*/
	}

	
	private boolean isInjectProvided() {
		for (FieldInfo fieldInfo : parameterInfos) {
			if (fieldInfo.getInjectInfo() == null || fieldInfo.getInjectText().equals("")) {
				MessageDialog.openError(getShell(), "Error",
						"Inject information is not given for parameter " + fieldInfo.getName());
				tabFolder.setSelection(1);
				return false;
			}
		}
		return true;
	}

	
	@Override
	public boolean close() {
		if (getReturnCode() == Window.CANCEL) {
			/*boolean canClose = guardComposite.canClose();
			if (!canClose) {
				boolean returnToDialog = MessageDialog.openConfirm(getShell(), "Exit",
						"Changes made to the dialog will be lost.\n"
								+ "Press Ok to exit without saving or Cancel to return to dialog.");
				if (!returnToDialog) {
					return false;
				}
			}*/
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject project = workspace.getRoot().getProject(groupName);
		File tempFile = new File(project.getLocation() + "/src-gen/InlineJavaTempClass.java");
		if (tempFile.exists()) {
			tempFile.delete();
		}
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			logger.error(e);
		}
		return super.close();
	}

	public String getStepName() {
		return stepName;
	}

	public String getStepDisplayName() {
		return stepDisplayName;
	}

	public String getStepDescription() {
		return stepDescription;
	}

	public List<FieldInfo> getParameterInfo() {
		return parameterInfos;
	}

	public int getPriority() {
		return priority;
	}

	public CodeDetail getCodeDetail() {
		return codeDetail;
	}
	
}
