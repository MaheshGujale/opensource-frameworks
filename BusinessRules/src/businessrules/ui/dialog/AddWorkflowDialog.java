package businessrules.ui.dialog;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import businessrules.ui.utils.FileUtils;
import businessrules.ui.workflow.Workflow;

public class AddWorkflowDialog extends TitleAreaDialog {
	private Text txtWorkflowName;
	private String workflowName;
	int returnCode = Window.CANCEL;

	public AddWorkflowDialog(Shell parentShell, String jobName) {
		super(parentShell);
		setHelpAvailable(false);
		this.workflowName = jobName;
		setShellStyle(getShellStyle());
	}

	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		contents.getShell().setText("Add Workflow");
		setTitle("Add Workflow");
		setMessage("Enter Workflow Details", IMessageProvider.INFORMATION);
		return contents;
	}

	@Override
	protected Point getInitialSize() {
		return new Point(375, 182);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		comp.setLayout(new GridLayout(2, false));

		Label lblJobName = new Label(comp, SWT.NONE);
		lblJobName.setText("Workflow Name : ");
		GridData grdJobNameData = new GridData();
		grdJobNameData.horizontalSpan = 1;
		lblJobName.setLayoutData(grdJobNameData);

		txtWorkflowName = new Text(comp, SWT.BORDER);
		GridData grdJobData = new GridData();
		grdJobData.horizontalSpan = 1;
		grdJobData.widthHint = 189;
		txtWorkflowName.setTextLimit(100);
		txtWorkflowName.setLayoutData(grdJobData);
		if (workflowName != null) {
			txtWorkflowName.setText(workflowName);
		}
		return comp;
	}

	/*
	 * @Override protected void createButtonsForButtonBar(Composite parent) {
	 * createOkButton(parent, IDialogConstants.OK_ID, "Ok", true);
	 * createButton(parent, IDialogConstants.CANCEL_ID,
	 * IDialogConstants.CANCEL_LABEL, false); }
	 */

	@Override
	protected void okPressed() {
		String errorMsg = "";

		if (txtWorkflowName.getText().trim().equals("")) {
			errorMsg = "Workflow Name is mandatory\n";
		}

		if (txtWorkflowName.getText().contains(" ")) {
			errorMsg = "Whitespace characters are not allowed in workflow name.\n";
		}

		if (StringUtils.isNumeric(String.valueOf(txtWorkflowName.getText().charAt(0)))) {
			errorMsg = "Starting with Numeric characters are not allowed in job name.\n";
		}

		if (!errorMsg.equals("")) {
			MessageDialog.openWarning(getShell(), "Warning", errorMsg);
			return;
		} else {
			try {
				if (workflowName != null && workflowName.equalsIgnoreCase(txtWorkflowName.getText().trim())) {
					returnCode = Window.CANCEL;
				} else {
					List<String> jobFolders = FileUtils.getAllFolders();

					int size = jobFolders.size();
					for (int index = 0; index < size; index++) {
						if (jobFolders.get(index).equalsIgnoreCase(txtWorkflowName.getText().trim())) {
							MessageDialog.openError(getShell(), "Error",
									txtWorkflowName.getText().trim() + " already exists");
							return;
						}
					}
					Workflow workflow = new Workflow();
					workflow.setName(txtWorkflowName.getText().trim());

					workflow.save();

					MessageDialog.openInformation(getShell(), "Information",
							"'" + txtWorkflowName.getText().trim() + "' workflow has been saved successfully");
					super.okPressed();
				}
			} catch (Exception e) {
				MessageDialog.openError(getShell(), "Error", e.getMessage());
			}
		}
	}
}