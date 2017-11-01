package businessrules.ui.features;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import businessrules.ui.utils.EventManager;
import businessrulesruntime.core.engine.CodeDetail;

public class CodeComposite extends Composite {
	protected CTabFolder ruleTabFolder;
	protected ExcelCodeComposite excelCodeComposite;

	private CodeDetail codeDetail;
	private EventManager eventManager;
	private String groupName;
	private List<String> returnRestrictedList;

	public CodeComposite(Composite parent, int style, CodeDetail codeInfo, String groupName, EventManager eventManager,
			List<String> returnRestrictedList) {
		super(parent, style);
		this.codeDetail = codeInfo;
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

		ruleTabFolder = new CTabFolder(this, SWT.NONE);
		ruleTabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		ruleTabFolder.setSelectionBackground(
				Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

		getExcelComposite(codeDetail, returnRestrictedList);

		populateCodeInfo(codeDetail);
	}

	protected void populateCodeInfo(CodeDetail codeInfo) {
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

	public CodeDetail getCodeInfo() {
		return excelCodeComposite.getCodeInfo();
	}
}
