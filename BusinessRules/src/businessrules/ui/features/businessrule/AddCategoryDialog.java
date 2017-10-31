package businessrules.ui.features.businessrule;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class AddCategoryDialog extends TitleAreaDialog {
	private Text txtCategoryname;

	private List<String> categoryNames = new ArrayList<String>();
	private String categoryName;
	private String category;

	public AddCategoryDialog(Shell parentShell, List<String> categoryNames, String category) {
		super(parentShell);
		this.categoryNames = categoryNames;
		this.category = category;
		setHelpAvailable(false);
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		contents.getShell().setText("Add/Edit Category");
		getShell().pack();
		setTitle("Add/Edit Category");
		setMessage("Provide category name");
		return contents;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		Composite parentComposite = new Composite(parent, SWT.NONE);
		parentComposite.setLayout(new GridLayout(2, false));
		parentComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Label lblCategoryName = new Label(parentComposite, SWT.NONE);
		lblCategoryName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblCategoryName.setText("Category name : ");

		txtCategoryname = new Text(parentComposite, SWT.BORDER);
		GridData gd_txtCategoryname = new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1);
		gd_txtCategoryname.widthHint = 145;
		txtCategoryname.setLayoutData(gd_txtCategoryname);

		if (category != null) {
			txtCategoryname.setText(category);
		}

		return parent;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void okPressed() {
		categoryName = txtCategoryname.getText().trim();
		if (categoryName.equals("")) {
			MessageDialog.openError(getShell(), "Error", "Category name should not be blank.");
		} else if (categoryNames.contains(categoryName) && category == null) {
			MessageDialog.openError(getShell(), "Duplicate name", "Category '" + categoryName + "' already exists.");
		} else {
			super.okPressed();
		}
	}

	public String getCategoryName() {
		return categoryName;
	}
}
