package businessrules.ui.features.businessrule;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Scope;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import businessrulesruntime.core.engine.BusinessRuleInfo;
import businessrulesruntime.core.engine.FieldInfo;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class AddBusinessRuleDialog extends TitleAreaDialog {
	private static Logger logger = Logger.getLogger(AddBusinessRuleDialog.class);
	protected ParametersComposite parametersComposite;
	private CodeComposite codeComposite;
	private BusinessRuleInfo businessRuleInfo;
	protected CTabFolder tabFolder;
	protected CTabItem informationCTabItem;
	protected CTabItem parametersCTabItem;
	protected CTabItem ruleCTabItem;
	private Composite parent;
	protected Table tblBase;
	protected Table tblReference;

	private String groupName;
	private Set<String> names = new HashSet<String>();
	private String title;
	private String headerMessage;
	private String lastTabName;
	private boolean injectRequired;
	private List<String> returnTypeRequiredList;
	private List<FieldInfo> workflowParamsInfo;
	protected String stepName;

	public AddBusinessRuleDialog(Shell parentShell, BusinessRuleInfo businessRuleInfo, String title,
			String headerMessage, String lastTabName, String groupName, String stepName, boolean injectRequired,
			List<String> returnTypeRequiredList, Set<String> names) {
		super(parentShell);
		this.businessRuleInfo = CloneObjectUtil.cloneObject(businessRuleInfo);
		this.title = title;
		this.headerMessage = headerMessage;
		this.lastTabName = lastTabName;
		this.injectRequired = injectRequired;
		this.returnTypeRequiredList = returnTypeRequiredList;
		this.groupName = groupName;
		this.stepName = stepName;
		this.names = names;
		setShellStyle(SWT.CLOSE | SWT.MIN | SWT.MAX | SWT.RESIZE | SWT.APPLICATION_MODAL);
		setHelpAvailable(false);
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		contents.getShell().setText(title);
		setTitle(title);
		setMessage(headerMessage);
		return contents;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		this.parent = parent;
		parent.setLayout(new GridLayout(1, false));

		tabFolder = new CTabFolder(parent, SWT.BOTTOM);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		parametersCTabItem = new CTabItem(tabFolder, SWT.NONE);
		parametersCTabItem.setText("Parameters");
		parametersComposite = new ParametersComposite(tabFolder, SWT.NONE, businessRuleInfo.getParameterInfos(),
				workflowParamsInfo, groupName, stepName, injectRequired);
		parametersCTabItem.setControl(parametersComposite);

		ruleCTabItem = new CTabItem(tabFolder, SWT.NONE);
		ruleCTabItem.setControl(getCodeComposite(tabFolder, ruleCTabItem, eventManager, sqlTypeList,
				returnTypeRequiredList, lastTabName, groupName, businessRuleInfo.getCodeInfo()));

		tabFolder.setSelection(0);

		// for excel code
		parametersComposite.publishParameters();

		return parent;
	}

	protected Control getStepInfoComposite(CTabFolder tabFolder, BusinessRuleInfo businessRuleInfo, String groupName) {
		stepInfoComposite = new StepInfoComposite(tabFolder, SWT.NONE, true);
		stepInfoComposite.populateStepInfoComposite(businessRuleInfo.getName(), businessRuleInfo.getDisplayName(),
				businessRuleInfo.getDescription());
		return stepInfoComposite;
	}

	protected Control getCodeComposite(CTabFolder tabFolder, CTabItem ruleCTabItem, List<String> returnRestrictedList, String lastTabName, String groupName,
			CodeInfo codeInfo) {
		ruleCTabItem.setText(lastTabName);
		if (lastTabName.equals("Service")) {
			codeComposite = new ServiceComposite(tabFolder, SWT.NONE, codeInfo, groupName, eventManager, sqlTypeList,
					returnRestrictedList);
		} else if (lastTabName.equals("Commit")) {
			codeComposite = new CommitComposite(tabFolder, SWT.NONE, codeInfo, groupName, eventManager, sqlTypeList,
					returnRestrictedList);
		} else {
			codeComposite = new CodeComposite(tabFolder, SWT.NONE, codeInfo, groupName, eventManager, sqlTypeList,
					returnRestrictedList);
		}
		return codeComposite;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void okPressed() {
		if (!getStepInformation()) {
			return;
		}

		CodeInfo codeInfo = getCodeCompositeInfo();

		if (codeInfo == null) {
			tabFolder.setSelection(2);
			return;
		} else {

			if (codeInfo.getCodeType().equals(CodeType.Database)) {
				List<FieldInfo> parametersInfo = parametersComposite.getFieldInfos();
				if (isInjectProvided(parametersInfo) == false) {
					return;
				}
				codeInfo.getCodeDetail().getMethodInfo().setParametersInfo(parametersInfo);
				businessRuleInfo.setParameterInfos(parametersInfo);
				businessRuleInfo.setCodeInfo(codeInfo);
				businessRuleInfo.setParameterInfos(parametersInfo);
				super.okPressed();
			} else if (codeInfo.getCodeDetail().getMethodInfo() != null) {
				List<FieldInfo> unusedFieldInfos = updateParametersInMethod(codeInfo);
				List<FieldInfo> parametersInfo = parametersComposite.getFieldInfos();
				if (isInjectProvided(parametersInfo) == false) {
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
				businessRuleInfo.setCodeInfo(codeInfo);
				businessRuleInfo.setParameterInfos(parametersInfo);
				super.okPressed();
			}
		}
	}

	private boolean isInjectProvided(List<FieldInfo> parametersInfo) {
		if (injectRequired) {
			for (FieldInfo fieldInfo : parametersInfo) {
				if (fieldInfo.getInjectInfo() == null || fieldInfo.getInjectText().equals("")) {
					MessageDialog.openError(getShell(), "Error", "Inject information is not given for parameter "
							+ fieldInfo.getName());
					tabFolder.setSelection(1);
					return false;
				}
			}
		}
		return true;
	}

	private List<FieldInfo> updateParametersInMethod(CodeInfo codeInfo) {
		List<FieldInfo> usedFieldInfos = new ArrayList<FieldInfo>();
		List<FieldInfo> unusedFieldInfos = new ArrayList<FieldInfo>();
		List<FieldInfo> parametersInfo = parametersComposite.getFieldInfos();
		if (codeInfo.getCodeDetail().getMethodInfo() != null) {
			Map<String, FieldInfo> previousFieldInfos = new HashMap<String, FieldInfo>();
			List<FieldInfo> fieldInfos = codeInfo.getCodeDetail().getMethodInfo().getParametersInfo();
			if (fieldInfos != null) {
				usedFieldInfos.addAll(fieldInfos);
				for (FieldInfo fieldInfo : fieldInfos) {
					previousFieldInfos.put(fieldInfo.getName() + fieldInfo.getDataType(), fieldInfo);
				}
				for (FieldInfo fieldInfo : parametersInfo) {
					String key = fieldInfo.getName() + fieldInfo.getDataType();
					if (previousFieldInfos.containsKey(key)) {
						usedFieldInfos.set(fieldInfos.indexOf(previousFieldInfos.get(key)), fieldInfo);
					} else {
						unusedFieldInfos.add(fieldInfo);
					}
				}
			}
			codeInfo.getCodeDetail().getMethodInfo().setParametersInfo(usedFieldInfos);
			businessRuleInfo.setParameterInfos(parametersInfo);
		}
		return unusedFieldInfos;
	}

	@Override
	public boolean close() {
		if (getReturnCode() == Window.CANCEL) {
			if (codeComposite != null) {
				boolean canClose = codeComposite.canClose();
				if (!canClose) {
					boolean returnToDialog = MessageDialog.openConfirm(getShell(), "Exit",
							"Changes made to the dialog will be lost.\n"
									+ "Press Ok to exit without saving or Cancel to return to dialog.");
					if (!returnToDialog) {
						return false;
					}
				}
			}
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

	protected CodeInfo getCodeCompositeInfo() {
		CodeInfo codeInfo = codeComposite.getCodeInfo();
		if (lastTabName.equals("Service") && codeInfo != null) {
			CacheConfiguration cacheConfiguration = serviceCacheComposite.getCacheConfiguration();
			LoadType loadType = cacheConfiguration.getLoadType();
			if (serviceCacheComposite.isCacheEnabled()) {
				if (codeInfo.getCodeType() != CodeType.Database
						&& codeInfo.getCodeDetail().getMethodInfo().getReturnInfo().getDataType().equals("void")) {
					MessageDialog.openError(getShell(), "Error", "Method returnType cannot be void if cache required.");
					return null;
				} else if (codeInfo.getCodeType() == CodeType.Database && loadType == LoadType.Preload
						&& cacheConfiguration.getScope() == Scope.Global) {
					CodeInfo tempCodeInfo = codeComposite.getCodeInfo();
					DatabaseCodeDetail codeDetail = (DatabaseCodeDetail) tempCodeInfo.getCodeDetail();
					if (codeDetail.getSqlType() == SQLType.Insert || codeDetail.getSqlType() == SQLType.Delete
							|| codeDetail.getSqlType() == SQLType.Update) {
						MessageDialog.openError(getShell(), "Error", "SQL type " + codeDetail.getSqlType()
								+ " is not allowed if preload is choosen.");
						return null;
					}
				}
			}
			if (serviceCacheComposite.isCacheEnabled() && loadType == LoadType.Preload
					&& cacheConfiguration.getScope() == Scope.Global) {
				CodeInfo tempCodeInfo = codeComposite.getCodeInfo();
				CodeType codeType = tempCodeInfo.getCodeType();
				String dataType = null;
				if (!(codeType == CodeType.Database)) {
					FieldInfo fieldInfo = codeComposite.getCodeInfo().getCodeDetail().getMethodInfo().getReturnInfo();
					String[] splitValues = fieldInfo.getDataType().split("\\.");
					dataType = splitValues[splitValues.length - 1];
				} else if (codeType == CodeType.Database) {
					DatabaseCodeDetail codeDetail = (DatabaseCodeDetail) tempCodeInfo.getCodeDetail();
					dataType = codeDetail.getReturnAs();
					if (dataType == null) {
						FieldInfo fieldInfo = codeDetail.getMethodInfo().getReturnInfo();
						String[] splitValues = fieldInfo.getDataType().split("\\.");
						dataType = splitValues[splitValues.length - 1];
					}
				}
				if ((!dataType.equals("Map")) && (!dataType.equals("HashMap"))) {
					MessageDialog.openError(getShell(), "Error",
							"Return type should be \"Map\" or \"HashMap\" if preload is choosen.");
					return null;
				}
			}
			ServiceCodeInfo serviceCodeInfo = new ServiceCodeInfo();
			serviceCodeInfo.setCodeInfo(codeInfo.getCodeDetail());
			serviceCodeInfo.setCodeType(codeInfo.getCodeType());
			serviceCodeInfo.setCacheEnabled(serviceCacheComposite.isCacheEnabled());
			serviceCodeInfo.setCacheConfiguration(cacheConfiguration);
			return serviceCodeInfo;
		}
		return codeInfo;

	}

	protected boolean getStepInformation() {
		if (validateName(stepInfoComposite.getStepName().trim()) == false) {
			return false;
		} else if (stepInfoComposite.getStepDisplayName().isEmpty()) {
			MessageDialog.openError(getShell(), "Error", "Display name should not be empty");
			return false;
		} else if (stepInfoComposite.getStepDescription().isEmpty()) {
			MessageDialog.openError(getShell(), "Error", "Description should not be empty");
			return false;
		}
		businessRuleInfo.setName(stepInfoComposite.getStepName());
		businessRuleInfo.setDisplayName(stepInfoComposite.getStepDisplayName());
		businessRuleInfo.setDescription(stepInfoComposite.getStepDescription());
		return true;
	}

	protected boolean validateName(String stepName) {
		for (String name : names) {
			if (name.equalsIgnoreCase(stepName)) {
				MessageDialog.openError(getShell(), "Duplicate name", "Name " + stepName + " already exists");
				return false;
			}
		}
		if (stepName.equals("")) {
			MessageDialog.openError(getShell(), "Error", "Name should not be empty");
			return false;
		}
		if (stepName.contains(" ")) {
			MessageDialog.openError(getShell(), "Error", "Name should not contain blank spaces");
			return false;
		}
		return true;
	}

	public BusinessRuleInfo getBusinessRuleInfo() {
		return businessRuleInfo;
	}
}