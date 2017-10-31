package businessrules.ui.features.businessrule;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
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

import businessrules.Activator;
import businessrules.ui.utils.WorkflowUtil;
import businessrulesruntime.core.engine.BusinessRuleInfo;
import businessrulesruntime.core.engine.FieldInfo;

@SuppressWarnings("rawtypes")
public class BusinessRulePropertyDialog extends TitleAreaDialog {

	private BusinessRuleComposite businessRuleComposite;
	private Table tblBase;
	private Table tblReference;
	private Diagram diagram;
	private Shape shape;

	private String stepName;
	private String stepDisplayName;
	private String stepDescription;
	private List<FieldInfo> parameterInfos = new ArrayList<FieldInfo>();
	private Map<String, List<BusinessRuleInfo>> businessRuleInfos = new LinkedHashMap<String, List<BusinessRuleInfo>>();
	private String groupName;
	private boolean handleException;

	public BusinessRulePropertyDialog(Shell parentShell, String stepName, String stepDisplayName,
			String stepDescription, List<FieldInfo> parameterInfos, boolean handleException, Diagram diagram,
			Shape shape, String groupName) {
		super(parentShell);
		setHelpAvailable(false);
		setShellStyle(SWT.CLOSE | SWT.MAX | SWT.RESIZE | SWT.APPLICATION_MODAL);
		this.stepName = stepName;
		this.stepDisplayName = stepDisplayName;
		this.stepDescription = stepDescription;
		this.parameterInfos = parameterInfos;
		this.diagram = diagram;
		this.shape = shape;
		this.groupName = groupName;
		this.handleException = handleException;
		setDefaultImage(Activator.getImageDescriptor("icons/icon_step_businessrule.png").createImage());
	}

	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		contents.getShell().setText("BusinessRule Details");
		setTitle("BusinessRule Details");
		setMessage("Provide business rules");
		return contents;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		CTabFolder tabFolder = new CTabFolder(parent, SWT.BOTTOM);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tabFolder.setSelectionBackground(
				Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

		CTabItem informationCTabItem = new CTabItem(tabFolder, SWT.NONE);
		informationCTabItem.setText("Information");

		CTabItem businessRuleCTabItem = new CTabItem(tabFolder, SWT.NONE);
		businessRuleCTabItem.setText("BusinessRules");

		businessRuleComposite = new BusinessRuleComposite(tabFolder, SWT.NONE, groupName, stepName);
		businessRuleComposite.setBusinessRuleInfos(businessRuleInfos);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		businessRuleComposite.setLayout(gridLayout);
		businessRuleCTabItem.setControl(businessRuleComposite);

		tabFolder.setSelection(0);
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
		stepName = businessRuleComposite.getStepName();
		stepDescription = businessRuleComposite.getStepName();
		if (stepName.contains(" ")) {
			MessageDialog.openError(getShell(), "Error", "Name should not contain blank space");
		} else if (stepName.endsWith("_")) {
			MessageDialog.openError(getShell(), "Error", "Name should not end with underscore.");
		} else if (WorkflowUtil.validateStepName(diagram, stepName, shape)) {
			MessageDialog.openError(getShell(), "Duplicate name",
					"Please give another name. Name '" + stepName + "' already exists.");
		} else if (stepDescription.equals("")) {
			MessageDialog.openError(getShell(), "Error", "Please enter step description.");
		} else {
			stepDisplayName = businessRuleComposite.getStepName();
			businessRuleInfos = businessRuleComposite.getBusinessRuleInfos();

			super.okPressed();
		}
	}

	@Override
	protected void cancelPressed() {
		super.cancelPressed();
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

	public Map<String, List<BusinessRuleInfo>> getBusinessRuleInfos() {
		return businessRuleInfos;
	}

	public void setBusinessRuleInfos(Map<String, List<BusinessRuleInfo>> businessRuleInfos) {
		this.businessRuleInfos = businessRuleInfos;
	}
}
