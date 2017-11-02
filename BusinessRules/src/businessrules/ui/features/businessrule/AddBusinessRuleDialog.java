package businessrules.ui.features.businessrule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
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
import org.eclipse.swt.widgets.Text;

import businessrules.ui.features.CodeComposite;
import businessrules.ui.utils.CloneObjectUtil;
import businessrules.ui.utils.EventManager;
import businessrules.ui.utils.ParametersComposite;
import businessrulesruntime.core.engine.BusinessRuleInfo;
import businessrulesruntime.core.engine.CodeDetail;
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
		tabFolder.setSelectionBackground(
				Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

		// eventManager
		EventManager eventManager = new EventManager();

		ruleCTabItem = new CTabItem(tabFolder, SWT.NONE);
		ruleCTabItem.setControl(getCodeComposite(tabFolder, ruleCTabItem, returnTypeRequiredList, lastTabName,
				groupName, eventManager, businessRuleInfo.getCodeDetail()));

		tabFolder.setSelection(0);

		return parent;
	}

	protected Control getCodeComposite(CTabFolder tabFolder, CTabItem ruleCTabItem, List<String> returnRestrictedList,
			String lastTabName, String groupName, EventManager eventManager, CodeDetail codeDetail) {
		ruleCTabItem.setText(lastTabName);
		/*Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		Text ruleName = new Text(composite, SWT.NONE);*/
		
		codeComposite = new CodeComposite(tabFolder, SWT.NONE, codeDetail, groupName, eventManager,
				returnRestrictedList);
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

		CodeDetail codeDetail = getCodeCompositeInfo();

		if (codeDetail == null) {
			tabFolder.setSelection(2);
			return;
		} else {

			if (codeDetail.getMethodInfo() != null) {
				List<FieldInfo> unusedFieldInfos = updateParametersInMethod(codeDetail);
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
				businessRuleInfo.setCodeDetail(codeDetail);
				businessRuleInfo.setParameterInfos(parametersInfo);
				super.okPressed();
			}
		}
	}

	private boolean isInjectProvided(List<FieldInfo> parametersInfo) {
		if (injectRequired) {
			for (FieldInfo fieldInfo : parametersInfo) {
				if (fieldInfo.getInjectInfo() == null || fieldInfo.getInjectText().equals("")) {
					MessageDialog.openError(getShell(), "Error",
							"Inject information is not given for parameter " + fieldInfo.getName());
					tabFolder.setSelection(1);
					return false;
				}
			}
		}
		return true;
	}

	private List<FieldInfo> updateParametersInMethod(CodeDetail codeDetail) {
		List<FieldInfo> usedFieldInfos = new ArrayList<FieldInfo>();
		List<FieldInfo> unusedFieldInfos = new ArrayList<FieldInfo>();
		List<FieldInfo> parametersInfo = parametersComposite.getFieldInfos();
		if (codeDetail.getMethodInfo() != null) {
			Map<String, FieldInfo> previousFieldInfos = new HashMap<String, FieldInfo>();
			List<FieldInfo> fieldInfos = codeDetail.getMethodInfo().getParametersInfo();
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
			codeDetail.getMethodInfo().setParametersInfo(usedFieldInfos);
			businessRuleInfo.setParameterInfos(parametersInfo);
		}
		return unusedFieldInfos;
	}

	protected CodeDetail getCodeCompositeInfo() {
		return codeComposite.getCodeInfo();

	}

	protected boolean getStepInformation() {
		if (validateName(stepName.trim()) == false) {
			return false;
		}
		businessRuleInfo.setName(stepName);
		businessRuleInfo.setDisplayName(stepName);
		businessRuleInfo.setDescription(stepName);
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