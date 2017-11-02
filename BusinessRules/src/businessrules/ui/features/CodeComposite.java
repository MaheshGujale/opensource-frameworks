package businessrules.ui.features;

import java.util.Date;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import businessrules.ui.utils.CloneObjectUtil;
import businessrules.ui.utils.EventManager;
import businessrulesruntime.core.engine.BusinessRuleInfo;
import businessrulesruntime.core.engine.CodeDetail;

public class CodeComposite extends Composite {
	protected CTabFolder ruleTabFolder;
	protected ExcelCodeComposite excelCodeComposite;

	private BusinessRuleInfo businessRuleInfo;
	private EventManager eventManager;
	private String groupName;
	private List<String> returnRestrictedList;
	private Text txtRulename;
	private Label lblStartTime;
	private CDateTime dateTimeFromDate;
	private Label lblEndTime;
	private CDateTime dateTimeEndDate;

	public CodeComposite(Composite parent, int style, BusinessRuleInfo businessRuleInfo, String groupName, EventManager eventManager,
			List<String> returnRestrictedList) {
		super(parent, style);
		this.businessRuleInfo = CloneObjectUtil.cloneObject(businessRuleInfo);
		this.groupName = groupName;
		this.eventManager = eventManager;
		this.returnRestrictedList = returnRestrictedList;
		createCompositeArea(this);
	}
	
	protected void createCompositeArea(Composite parent) {
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);
		
		Composite nameComposite = new Composite(this, SWT.NONE);
		nameComposite.setLayout(new GridLayout(6, false));
		Label label = new Label(nameComposite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label.setText("Rule Name : ");
		
		txtRulename = new Text(nameComposite, SWT.BORDER);
		GridData gd_txtRulename = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtRulename.widthHint = 123;
		txtRulename.setLayoutData(gd_txtRulename);
		
		lblStartTime = new Label(nameComposite, SWT.NONE);
		lblStartTime.setText("Start Time");
		
		dateTimeFromDate = new CDateTime(nameComposite, CDT.BORDER | CDT.DROP_DOWN | CDT.DATE_SHORT
				| CDT.TIME_MEDIUM);
		dateTimeFromDate.setEditable(true);
		dateTimeFromDate.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, true));
		dateTimeFromDate.setBackground(ColorConstants.white);

		lblEndTime = new Label(nameComposite, SWT.NONE);
		lblEndTime.setText("End Time");
		
		dateTimeEndDate = new CDateTime(nameComposite, CDT.BORDER | CDT.DROP_DOWN | CDT.DATE_SHORT
				| CDT.TIME_MEDIUM);
		dateTimeEndDate.setEditable(true);
		dateTimeEndDate.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, true));
		dateTimeEndDate.setBackground(ColorConstants.white);


		ruleTabFolder = new CTabFolder(this, SWT.NONE);
		ruleTabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		ruleTabFolder.setSelectionBackground(
				Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

		getExcelComposite(businessRuleInfo.getCodeDetail(), returnRestrictedList);

		populateCodeInfo(businessRuleInfo.getCodeDetail());
	}

	protected void populateCodeInfo(CodeDetail codeInfo) {
		if(businessRuleInfo.getName() != null) {
			txtRulename.setText(businessRuleInfo.getName());
		}
		if(businessRuleInfo.getRuleStartTime() != null) {
			dateTimeFromDate.setSelection(new Date(businessRuleInfo.getRuleStartTime()));
		}
		if(businessRuleInfo.getRuleExpireTime() != null) {
			dateTimeEndDate.setSelection(new Date(businessRuleInfo.getRuleExpireTime()));
		}
		ruleTabFolder.setSelection(0);
	}

	protected void getExcelComposite(CodeDetail codeInfo, List<String> returnRestrictedList) {
		CTabItem tbtmExcel = new CTabItem(ruleTabFolder, SWT.NONE);
		tbtmExcel.setText("Excel Code");

		excelCodeComposite = new ExcelCodeComposite(ruleTabFolder, SWT.BORDER, codeInfo, groupName,
				returnRestrictedList);
		excelCodeComposite.setEventManager(eventManager);
		GridData gd_compFileLayout = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		excelCodeComposite.setLayoutData(gd_compFileLayout);
		GridLayout gl_compFileLayout = new GridLayout(1, false);
		gl_compFileLayout.marginWidth = 0;
		gl_compFileLayout.marginHeight = 0;
		excelCodeComposite.setLayout(gl_compFileLayout);
		tbtmExcel.setControl(excelCodeComposite);
	}

	public BusinessRuleInfo getBusinessRuleInfo() {
		CodeDetail codeInfo = excelCodeComposite.getCodeInfo();
		String ruleName = txtRulename.getText().trim();
		if(codeInfo != null) {
			if(ruleName != null) {
				String className = Character.toUpperCase(ruleName.charAt(0)) + ruleName.substring(1);
				codeInfo.setJavaCode(codeInfo.getJavaCode().replace("${className}", className));
				codeInfo.setClassName(className);
			}
			businessRuleInfo.setCodeDetail(codeInfo);
		}
		businessRuleInfo.setName(ruleName);
		Date fromDate = dateTimeFromDate.getSelection();
		if(fromDate != null) {
			businessRuleInfo.setRuleStartTime(fromDate.getTime());
		}
		Date toDate = dateTimeEndDate.getSelection();
		if(toDate != null) {
			businessRuleInfo.setRuleExpireTime(toDate.getTime());
		}
		
		return businessRuleInfo;
	}
}