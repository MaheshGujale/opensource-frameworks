package businessrules.ui.features;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.tools.ToolProvider;

import org.apache.log4j.Logger;
import org.br.excel.exceldsl.ExcelDSLRuntimeModule;
import org.br.excel.exceldsl.ui.ExcelDSLUiModule;
import org.br.excel.exceldsl.ui.internal.ExcelDSLActivator;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.shared.SharedStateModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

import businessrules.ui.features.inject.EmbeddedXtextEditor;
import businessrules.ui.features.inject.TypeSelectorComposite;
import businessrules.ui.utils.EventManager;
import businessrules.ui.utils.ExceptionDialog;
import businessrules.ui.utils.JavaCodeGenerator;
import businessrulesruntime.core.engine.CodeDetail;
import businessrulesruntime.core.engine.FieldInfo;
import businessrulesruntime.core.engine.MethodInfo;
import businessrulesruntime.core.engine.excel.ExcelFormulaContentProvider;
import businessrulesruntime.core.engine.excel.ExcelFunctions;
import businessrulesruntime.core.script.JavaScriptHandler;

public class ExcelCodeComposite extends Composite implements PropertyChangeListener {
	private static Logger logger = Logger.getLogger(ExcelCodeComposite.class);

	public static Injector injector;
	private EmbeddedXtextEditor editor;
	private SourceViewer viewer;
	private ExcelFormulaContentProvider excelFormulaContentProvider = ExcelFormulaContentProvider.getInstance();
	private Composite parent;
	private Combo cboResultClassName;
	private TypeSelectorComposite typeSelectorComposite;

	private String javacode;
	private List<FieldInfo> parameterFieldInfos;
	private String groupName;
	private List<String> returnRestrictedList;

	private Label lblResultClassname;

	public ExcelCodeComposite(Composite parent, int style, CodeDetail codeInfo, String groupName,
			List<String> returnRestrictedList) {
		super(parent, style);
		this.parent = parent;
		this.groupName = groupName;
		this.returnRestrictedList = returnRestrictedList;
		setLayout(new GridLayout(1, false));
		try {
			editor = new EmbeddedXtextEditor(this, getInjector());
		} catch (InvocationTargetException e) {
			logger.error(e);
		} catch (InterruptedException e) {
			logger.error(e);
		}
		viewer = editor.getViewer();
		viewer.appendVerifyKeyListener(new VerifyKeyListener() {
			public void verifyKey(VerifyEvent event) {
				// Check for Ctrl+Spacebar
				if (event.stateMask == SWT.CTRL && event.character == ' ') {
					// Check if source viewer is able to perform operation
					if (viewer.canDoOperation(SourceViewer.CONTENTASSIST_PROPOSALS))
						// Perform operation
						viewer.doOperation(SourceViewer.CONTENTASSIST_PROPOSALS);
					// Veto this key press to avoid further processing
					event.doit = false;
				}
			}
		});
		GridData gridData = new GridData();
		gridData.horizontalSpan = 1;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessVerticalSpace = true;
		viewer.getControl().setLayoutData(gridData);
		viewer.getTextWidget().update();

		if (returnRestrictedList != null && returnRestrictedList.isEmpty()) {
			Composite dynamicComposite = new Composite(this, SWT.NONE);
			GridLayout gridLayout = new GridLayout(3, false);
			gridLayout.marginWidth = 0;
			gridLayout.marginHeight = 0;
			dynamicComposite.setLayout(gridLayout);
			dynamicComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

			Label lblResultClassname = new Label(dynamicComposite, SWT.NONE);
			lblResultClassname.setText("Result Type");

			Label lblColon3 = new Label(dynamicComposite, SWT.NONE);
			lblColon3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblColon3.setText(":");

			typeSelectorComposite = new TypeSelectorComposite(dynamicComposite, SWT.NONE, false);
			typeSelectorComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
			typeSelectorComposite.getTltmDropdownItem().addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					typeSelectorComposite.computeDropdownItemSelection(e);
					if (typeSelectorComposite.getType() != null && !(typeSelectorComposite.getType().equals(""))) {
						// populateKeyColumn();
					}
				}
			});
		} else if (returnRestrictedList != null) {
			Composite dynamicComposite = new Composite(this, SWT.NONE);
			GridLayout gridLayout = new GridLayout(3, false);
			gridLayout.marginWidth = 0;
			gridLayout.marginHeight = 0;
			dynamicComposite.setLayout(gridLayout);
			dynamicComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

			lblResultClassname = new Label(dynamicComposite, SWT.NONE);
			lblResultClassname.setText("Result Type");

			Label lblColon3 = new Label(dynamicComposite, SWT.NONE);
			lblColon3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblColon3.setText(":");

			cboResultClassName = new Combo(dynamicComposite, SWT.READ_ONLY);
			cboResultClassName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			if (returnRestrictedList.contains("boolean")) {
				cboResultClassName.add("Boolean");
			}
			if (returnRestrictedList.contains("int")) {
				cboResultClassName.add("Integer");
			}
			if (returnRestrictedList.contains("String")) {
				cboResultClassName.add("String");
			}
			cboResultClassName.select(0);
		}

		if (codeInfo != null) {
			CodeDetail excelCodeDetail = codeInfo;
			if (excelCodeDetail.getExcelFormula() != null && !excelCodeDetail.getExcelFormula().equals("")) {
				viewer.getTextWidget().setText(excelCodeDetail.getExcelFormula());
			} else {
				viewer.getTextWidget().setText("");
			}
			if (returnRestrictedList != null && returnRestrictedList.isEmpty()) {
				typeSelectorComposite.setType(excelCodeDetail.getMethodInfo().getReturnInfo().getName());
			} else if (returnRestrictedList != null) {
				cboResultClassName.setText(excelCodeDetail.getMethodInfo().getReturnInfo().getName());
			}
		}
	}

	public String getViewerText() {
		String viewerText = viewer.getTextWidget().getText();
		if (viewerText != null && viewerText.trim().equals("") == false) {
			return viewerText;
		}
		return "";
	}

	public static Injector getInjector() throws InvocationTargetException, InterruptedException {
		if (injector == null) {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
			dialog.run(true, false, new IRunnableWithProgress() {

				@Override
				public void run(final IProgressMonitor monitor) {
					monitor.beginTask("Preparing excel formula assistance", IProgressMonitor.UNKNOWN);
					injector = Guice.createInjector(Modules
							.override(Modules.override(new ExcelDSLRuntimeModule())
									.with(new ExcelDSLUiModule(ExcelDSLActivator.getInstance())))
							.with(new SharedStateModule()));
					monitor.done();
				}
			});
		}
		return injector;
	}

	public void setEditorText(String inject) {
		viewer.getTextWidget().setText(inject);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equalsIgnoreCase("Parameters")) {
			List<FieldInfo> parameterFieldInfos = (List<FieldInfo>) event.getNewValue();
			this.parameterFieldInfos = parameterFieldInfos;
			excelFormulaContentProvider.setJavaObjcetList(parameterFieldInfos);
		}
	}

	public void setEventManager(EventManager evtManager) {
		evtManager.subscribe(this);
	}

	public CodeDetail getCodeInfo() {
		if (validate()) {
			return getCodeDetail();
		} else {
			return null;
		}
	}

	private CodeDetail getCodeDetail() {
		CodeDetail excelCodeDetail = new CodeDetail();
		excelCodeDetail.setClassName("${className}");
		MethodInfo methodInfo = new MethodInfo();
		methodInfo.setName("doExecute");
		methodInfo.setParametersInfo(parameterFieldInfos);
		FieldInfo returnInfo = new FieldInfo();
		if (returnRestrictedList == null) {
			returnInfo.setName("Object");
			returnInfo.setDataType("java.lang.Object");
		} else if (returnRestrictedList != null && returnRestrictedList.isEmpty()) {
			returnInfo.setName(getClassShortName(typeSelectorComposite.getType()));
			returnInfo.setDataType(typeSelectorComposite.getType());
		} else {
			if (cboResultClassName.getText().equals("Boolean")) {
				returnInfo.setName("Boolean");
				returnInfo.setDataType("java.lang.Boolean");
			} else if (cboResultClassName.getText().equals("String")) {
				returnInfo.setName("String");
				returnInfo.setDataType("java.lang.String");
			} else if (cboResultClassName.getText().equals("Integer")) {
				returnInfo.setName("Integer");
				returnInfo.setDataType("java.lang.Integer");
			}
		}
		methodInfo.setReturnInfo(returnInfo);
		methodInfo.setStatic(false);
		excelCodeDetail.setMethodInfo(methodInfo);
		excelCodeDetail.setJavaCode(getJavaCode(excelCodeDetail));
		return excelCodeDetail;
	}

	private String getJavaCode(CodeDetail excelCodeDetail) {
		if (viewer.getTextWidget().getText() != null && !viewer.getTextWidget().getText().trim().equals("")) {
			excelCodeDetail.setExcelFormula(viewer.getTextWidget().getText());
			return javacode;
		} else {
			return "";
		}
	}

	public boolean validate() {
		EList<Diagnostic> errors = editor.getResource().getErrors();
		if (errors != null && errors.size() > 0) {
			MessageDialog.openError(getShell(), "Error", errors.get(0).toString());
			return false;
		}
		if (viewer.getTextWidget().getText() == null || viewer.getTextWidget().getText().trim().equals("")) {
			MessageDialog.openError(getShell(), "Error", "Excel formula cannot be empty.");
			return false;
		}
		JavaScriptHandler javaScriptHandler = JavaScriptHandler.get();
		try {
			if (viewer.getTextWidget().getText() != null && !viewer.getTextWidget().getText().trim().equals("")) {
				JavaCodeGenerator javaCodeGenerator = new JavaCodeGenerator(parameterFieldInfos,
						viewer.getTextWidget().getText(), editor.getResource().getContents(), groupName,
						(returnRestrictedList != null && returnRestrictedList.isEmpty())
								? typeSelectorComposite.getType()
								: ((returnRestrictedList != null) ? cboResultClassName.getText() : "Object"));
				javacode = javaCodeGenerator.generateJavaCode();
				List<String> allClassPaths = new ArrayList<>();
				javaScriptHandler.loadClass("Excel", javacode.replace("${className}", "Excel"), true, allClassPaths);
			}
			return true;
		} catch (Exception exception) {
			logger.error(exception);
			ExceptionDialog exceptionDialog = new ExceptionDialog(parent.getShell(),
					javaScriptHandler.getException() != null ? javaScriptHandler.getException() : exception,
					javacode.toString().replace("${className}", "Excel"));
			exceptionDialog.open();
			return false;
		}
	}

	/**
	 * @return the editor
	 */
	public EmbeddedXtextEditor getEditor() {
		return editor;
	}

	public String getClassShortName(String canonicalName) {
		String[] splitValues = canonicalName.split("\\.");
		return splitValues[splitValues.length - 1];
	}
}
