package businessrules.ui.features;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import businessrulesruntime.core.engine.FieldInfo;
import businessrulesruntime.core.engine.InjectInfo;

public class AddParameterDialog extends TitleAreaDialog {
	private Text txtFieldName;
	private Text txtFieldDescription;
	private Button btnArrayType;
	private Composite parent;
	private Table tblBase;
	private Table tblReference;
	private Text txtValue;

	private FieldInfo fieldInfo = new FieldInfo();
	private List<FieldInfo> workflowParamsInfo;
	private boolean injectRequired;
	private String groupName;
	private boolean valueRequired;
	private Label lblInject;
	private Label lblFieldame;
	private Label lblParameterDescription;
	private Label lblDatatype;
	private String stepName;

	public AddParameterDialog(Shell parentShell, FieldInfo fieldInfo, boolean injectRequired,
			List<FieldInfo> workflowParamsInfo, boolean valueRequired) {
		super(parentShell);
		setHelpAvailable(false);
		this.fieldInfo = fieldInfo;
		this.workflowParamsInfo = workflowParamsInfo;
		this.injectRequired = injectRequired;
		this.valueRequired = valueRequired;
		setShellStyle(SWT.DIALOG_TRIM | SWT.MAX | SWT.RESIZE | SWT.APPLICATION_MODAL);
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		contents.getShell().setText("Add/Edit field");
		setTitle("Add/Edit field");
		setMessage("Provide field details");
		return contents;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		this.parent = parent;
		parent.setLayout(new GridLayout(1, false));
		Composite parentComposite = new Composite(parent, SWT.NONE);
		parentComposite.setLayout(new GridLayout(2, false));
		parentComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		{
			lblFieldame = new Label(parentComposite, SWT.NONE);
			lblFieldame.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblFieldame.setText("Field Name :");
		}
		{
			txtFieldName = new Text(parentComposite, SWT.BORDER);
			txtFieldName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		}
		{
			lblParameterDescription = new Label(parentComposite, SWT.NONE);
			lblParameterDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
			lblParameterDescription.setText("Description : ");
		}
		{
			txtFieldDescription = new Text(parentComposite, SWT.BORDER);
			GridData gd_txtInject = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
			gd_txtInject.heightHint = 40;
			txtFieldDescription.setLayoutData(gd_txtInject);
		}
		{
			lblDatatype = new Label(parentComposite, SWT.NONE);
			lblDatatype.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblDatatype.setText("Data Type : ");
		}

		{
			new Label(parentComposite, SWT.NONE);
		}
		{
			btnArrayType = new Button(parentComposite, SWT.CHECK);
			btnArrayType.setText("IsArrayType");
		}
		
		if (valueRequired) {
			{
				Label lblValue = new Label(parentComposite, SWT.NONE);
				lblValue.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
				lblValue.setText("Value : ");
			}
			{
				txtValue = new Text(parentComposite, SWT.BORDER);
				txtValue.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
			}
		}

		populateFields();
		return parent;
	}

	private void populateFields() {
		if (fieldInfo.getName() != null) {
			txtFieldName.setText(fieldInfo.getName());
		}
		if (fieldInfo.getDescription() != null) {
			txtFieldDescription.setText(fieldInfo.getDescription());
		}
		btnArrayType.setSelection(fieldInfo.isArray());
		if (valueRequired) {
			if (fieldInfo.getValue() != null) {
				txtValue.setText(fieldInfo.getValue());
			}
		}
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createOkButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	private Button createOkButton(Composite parent, int id, String label, boolean b) {
		((GridLayout) parent.getLayout()).numColumns++;
		Button btnOk = new Button(parent, SWT.PUSH);
		btnOk.setText(label);
		btnOk.setFont(JFaceResources.getDialogFont());
		btnOk.setData(new Integer(id));
		btnOk.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (onOkClick()) {
					setReturnCode(OK);
					close();
				}
			}
		});

		if (b) {
			Shell shell = parent.getShell();
			if (shell != null) {
				shell.setDefaultButton(btnOk);
			}
		}
		setButtonLayoutData(btnOk);
		return btnOk;
	}

	protected boolean onOkClick() {
		String errorMessage = "";
		String fieldName = txtFieldName.getText();
		if (fieldName.trim().equals("")) {
			errorMessage = "Field name should not be empty\n";
		}
		if (injectRequired) { // for excel code parameter redefinition
								// avoidance.
			if (fieldName.equals("_message") || fieldName.equals("_context") || fieldName.equals("_params")) {
				errorMessage = "System reserved keyword in field name are not allowed";
			}
		} else { // for service code parameter redefinition avoidance.
			if (fieldName.equals("message") || fieldName.equals("context") || fieldName.equals("params")) {
				errorMessage = "System reserved keyword in field name are not allowed";
			}
		}
		if (!Pattern.matches("[_a-zA-Z][_a-zA-z0-9]*", fieldName)) {
			errorMessage = "Special characters are not allowed";
		}
		if (valueRequired) {
			if (txtValue.getText() == null || txtValue.getText().trim().equals("")) {
				MessageDialog.openError(getShell(), "Error", "Value cannot be empty.");
				return false;
			}
		}
		if (!errorMessage.equals("")) {
			setErrorMessage(errorMessage);
			return false;
		} else {
			fieldInfo.setName(fieldName.trim());
			fieldInfo.setDescription(txtFieldDescription.getText().trim());
			if (btnArrayType != null) {
				fieldInfo.setArray(btnArrayType.getSelection());
			}
			if (valueRequired) {
				fieldInfo.setValue(txtValue.getText());
			}

			return true;
		}
	}

	public FieldInfo getFieldInfo() {
		return fieldInfo;
	}

	/**
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

}