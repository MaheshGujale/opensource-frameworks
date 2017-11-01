package businessrules.ui.features.inject;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.internal.ui.JavaUIMessages;
import org.eclipse.jdt.internal.ui.dialogs.OpenTypeSelectionDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.PlatformUI;

@SuppressWarnings("restriction")
public class TypeSelectorComposite extends Composite {
	private Logger logger = Logger.getLogger(TypeSelectorComposite.class);

	private Text typeText;
	private Menu primitiveTypeMenu = null;
	private ToolItem tltmDropdownItem;

	private boolean isPrimitiveTypeRequired;
	private IType type;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public TypeSelectorComposite(Composite parent, int style, boolean isPrimitiveTypeRequired) {
		super(parent, style);
		this.isPrimitiveTypeRequired = isPrimitiveTypeRequired;
		createCompositeArea(this);
	}

	private void createCompositeArea(Composite parent) {
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		setLayout(gridLayout);

		Composite compContainer = new Composite(parent, SWT.NONE);
		compContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		GridLayout gl_compContainer = new GridLayout(2, false);
		gl_compContainer.verticalSpacing = 0;
		gl_compContainer.marginWidth = 0;
		gl_compContainer.marginHeight = 0;
		gl_compContainer.horizontalSpacing = 2;
		compContainer.setLayout(gl_compContainer);

		typeText = new Text(compContainer, SWT.BORDER | SWT.READ_ONLY);
		typeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		ToolBar toolBar = new ToolBar(compContainer, SWT.FLAT | SWT.RIGHT | SWT.VERTICAL);
		toolBar.setToolTipText(JavaUIMessages.OpenTypeAction_dialogTitle);

		tltmDropdownItem = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmDropdownItem.setWidth(30);
		tltmDropdownItem.setText("...");

	}

	public void computeDropdownItemSelection(SelectionEvent e) {
		Menu dropMenu = null;

		if (dropMenu == null) {
			dropMenu = new Menu(getShell(), SWT.POP_UP);
			dropMenuSelected(dropMenu);
		}

		if (e.detail == SWT.ARROW) {
			final ToolItem toolItem = (ToolItem) e.widget;
			final ToolBar toolBar = toolItem.getParent();

			Point point = toolBar.toDisplay(new Point(e.x, e.y));
			dropMenu.setLocation(point.x, point.y);
			dropMenu.setVisible(true);
		} else {
			try {
				onOpenTypeClicked();
			} catch (JavaModelException e1) {
				logger.error(e);
			}
		}

	}

	private void dropMenuSelected(Menu dropMenu) {
		getShell().setMenu(dropMenu);

		if (isPrimitiveTypeRequired) {
			MenuItem primitiveTypeMenuItem = new MenuItem(dropMenu, SWT.MENU);
			primitiveTypeMenuItem.setText("Primitive type");
			primitiveTypeMenu = new Menu(primitiveTypeMenuItem);

			String[] primitiveDataTypes = new String[] { PrimitiveType.BOOLEAN.toString(),
					PrimitiveType.INT.toString(), PrimitiveType.LONG.toString(), PrimitiveType.FLOAT.toString(),
					PrimitiveType.DOUBLE.toString() };
			for (String primitiveType : primitiveDataTypes) {
				addMenuItem(primitiveTypeMenu, primitiveType);
			}
			primitiveTypeMenuItem.setMenu(primitiveTypeMenu);
		}

		MenuItem itemClear = new MenuItem(dropMenu, SWT.NONE);
		itemClear.setText("Clear");
		itemClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				typeText.setText("");
				if (primitiveTypeMenu != null) {
					for (MenuItem menuItem : primitiveTypeMenu.getItems()) {
						if (menuItem.getSelection()) {
							menuItem.setSelection(false);
						}
					}
				}
			}
		});
	}

	private void addMenuItem(Menu menu, String textValue) {
		final MenuItem menuItem = new MenuItem(menu, SWT.RADIO);
		menuItem.setText(textValue);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				typeText.setText(menuItem.getText());
			}
		});
	}

	private void onOpenTypeClicked() throws JavaModelException {
		IJavaSearchScope scope = SearchEngine.createWorkspaceScope();
		OpenTypeSelectionDialog dialog = new OpenTypeSelectionDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), true, PlatformUI.getWorkbench().getProgressService(), scope,
				IJavaSearchConstants.TYPE);

		dialog.setTitle(JavaUIMessages.OpenTypeAction_dialogTitle);
		dialog.setMessage(JavaUIMessages.OpenTypeAction_dialogMessage);

		int result = dialog.open();
		if (result == IDialogConstants.OK_ID) {
			Object[] types = dialog.getResult();
			if (types != null && types.length > 0) {
				IType javaType = null;
				for (int i = 0; i < types.length; i++) {
					javaType = (IType) types[i];
					String fullyQualifiedName = javaType.getFullyQualifiedName();
					typeText.setText(fullyQualifiedName);
					type = javaType;
				}
			}
		}
	}

	public String getType() {
		return typeText.getText().trim();
	}

	public void setType(String type) {
		if (type != null) {
			typeText.setText(type);
		}
	}

	public List<IMethod> getMethods() {
		List<IMethod> methods = new ArrayList<IMethod>();
		if (type != null) {
			try {
				IMethod[] allMethods = type.getMethods();

				for (IMethod method : allMethods) {
					if (method.isConstructor() || Modifier.isPrivate(method.getFlags())
							|| Modifier.isProtected(method.getFlags())) {
						continue;
					}
					methods.add(method);
				}
			} catch (JavaModelException e1) {
				logger.error(e1);
			}
		}
		return methods;
	}

	/**
	 * @return the tltmDropdownItem
	 */
	public ToolItem getTltmDropdownItem() {
		return tltmDropdownItem;
	}
}