package businessrules.ui.utils;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import businessrules.Activator;

public abstract class TableComposite extends Composite {

	private TableViewer tableViewer;
	private Table table;
	private TableViewerColumn tableViewerColumn;
	private TableColumn tblclmn;
	private Button btnAdd;
	private Button btnDelete;
	private Button btnEdit;
	private Button btnUp;
	private Button btnDown;
	private KeyListener keyListener;
	private MenuItem pasteMenuItem;

	public TableComposite(Composite parent, int style, int columnCount, boolean addReq, boolean delReq,
			boolean editReq, boolean arrange, boolean isWhiteBackgroundRequired) {
		super(parent, style);
		if (isWhiteBackgroundRequired) {
			setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		}
		GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.marginLeft = 0;
		layout.marginRight = 5;
		setLayout(layout);

		tableViewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.addListener(SWT.MouseDoubleClick, new Listener() {

			@Override
			public void handleEvent(Event event) {
				Point point = new Point(event.x, event.y);
				final TableItem tableitem = table.getItem(point);
				if (tableitem == null)
					return;
				onEditClick();
			}
		});

		table.addListener(SWT.MouseHover, new Listener() {

			@Override
			public void handleEvent(Event event) {
				Point point = new Point(event.x, event.y);
				final TableItem tableitem = table.getItem(point);
				if (tableitem == null)
					return;
				onMouseHover(tableitem.getData());
			}
		});
		tableViewer.setContentProvider(new ArrayContentProvider());

		for (int index = 0; index < columnCount; index++) {
			tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
			tblclmn = tableViewerColumn.getColumn();
			tblclmn.setWidth(getColumnWidth(index));
			tblclmn.setText(getColumnCaption(index));
			tblclmn.setResizable(true);
			tblclmn.setMoveable(true);
			final int columnIndex = index;
			tableViewerColumn.setLabelProvider(new CellLabelProvider() {
				public void update(ViewerCell cell) {
					cell.setText(getTableColumnLabel(cell.getElement(), columnIndex));
				}
			});
		}
		setViewerInput();

		keyListener = new KeyListener() {
			public void keyPressed(KeyEvent evt) {
				if (evt.keyCode == SWT.INSERT) {
					doOperation(OperationType.Add, table.getSelectionIndex());
				} else if (evt.keyCode == SWT.DEL) {
					onDeleteClick();
				} else if ((evt.stateMask & SWT.CTRL) != 0 && evt.keyCode == SWT.ARROW_UP) {
					onMoveUpClick();
				} else if ((evt.stateMask & SWT.CTRL) != 0 && evt.keyCode == SWT.ARROW_DOWN) {
					onMoveDownClick();
				} else if ((evt.stateMask & SWT.CTRL) != 0 && (evt.keyCode == 'c' || evt.keyCode == 'C')) {
					copyFromTable();
				} else if ((evt.stateMask & SWT.CTRL) != 0 && (evt.keyCode == 'v' || evt.keyCode == 'V')) {
					pasteOnTable();
				}
			}

			public void keyReleased(KeyEvent evt) {
			}
		};
		tableViewer.getTable().addKeyListener(keyListener);

		Composite btnComposite = new Composite(this, SWT.NONE);
		if (isWhiteBackgroundRequired) {
			btnComposite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		}
		btnComposite.setLayout(new GridLayout(1, false));
		btnComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));

		if (addReq) {
			// Add button
			btnAdd = new Button(btnComposite, SWT.NONE);
			btnAdd.setImage(Activator.getImageDescriptor("/icons/icon_add.png").createImage());
			GridData gd_btnAdd = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
			gd_btnAdd.widthHint = 34;
			gd_btnAdd.heightHint = 32;
			btnAdd.setLayoutData(gd_btnAdd);
			btnAdd.setToolTipText("Add - INSERT KEY");
			btnAdd.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					doOperation(OperationType.Add, table.getSelectionIndex());
				}
			});
		}
		if (delReq) {
			// Delete button
			btnDelete = new Button(btnComposite, SWT.NONE);
			btnDelete.setImage(Activator.getImageDescriptor("/icons/icon_delete.png").createImage());
			btnDelete.setToolTipText("Delete - DEL KEY");
			GridData gd_btnDelete = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
			gd_btnDelete.widthHint = 34;
			gd_btnDelete.heightHint = 32;
			btnDelete.setLayoutData(gd_btnDelete);
			btnDelete.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					onDeleteClick();
				}
			});
		}
		if (editReq) {
			// Edit button
			btnEdit = new Button(btnComposite, SWT.NONE);
			btnEdit.setImage(Activator.getImageDescriptor("/icons/icon_edit.png").createImage());
			GridData gd_btnEdit = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
			gd_btnEdit.widthHint = 34;
			gd_btnEdit.heightHint = 32;
			btnEdit.setLayoutData(gd_btnEdit);
			btnEdit.setToolTipText("Edit");// CTRL+Enter");
			btnEdit.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					onEditClick();
				}
			});
		}
		if (arrange) {
			// button move up
			btnUp = new Button(btnComposite, SWT.NONE);
			btnUp.setImage(Activator.getImageDescriptor("/icons/icon_previous.png").createImage());
			btnUp.setToolTipText("MoveUp CTRL+UP_ARROW");
			btnUp.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					onMoveUpClick();
				}
			});
			GridData gd_btnUp = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
			gd_btnUp.widthHint = 34;
			gd_btnUp.heightHint = 32;
			btnUp.setLayoutData(gd_btnUp);

			// button move down
			btnDown = new Button(btnComposite, SWT.NONE);
			btnDown.setImage(Activator.getImageDescriptor("/icons/icon_next.png").createImage());
			btnDown.setToolTipText("MoveDown CTRL+DOWN_ARROW");
			btnDown.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					onMoveDownClick();
				}
			});
			GridData gd_btnDown = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
			gd_btnDown.widthHint = 34;
			gd_btnDown.heightHint = 32;
			btnDown.setLayoutData(gd_btnDown);
		}

		// addPopupMenu();
	}

	protected void onMouseHover(Object object) {
	}

	public void setToolTip(String message) {
		table.setToolTipText(message);
	}

	public void addPopupMenu() {
		Menu menu = new Menu(getShell(), SWT.POP_UP);
		getShell().setMenu(menu);
		table.setMenu(menu);
		MenuItem copyMenuItem = new MenuItem(menu, SWT.PUSH);
		copyMenuItem.setText("Copy (Ctrl+C)");
		copyMenuItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				copyFromTable();
			}
		});

		pasteMenuItem = new MenuItem(menu, SWT.PUSH);
		pasteMenuItem.setText("Paste (Ctrl+V)");
		pasteMenuItem.setEnabled(true);

		pasteMenuItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				pasteOnTable();
			}
		});
	}

	protected int[] copyFromTable() {
		int[] selectionIndices = table.getSelectionIndices();
		if (selectionIndices.length == 0) {
			MessageDialog.openError(getShell(), "No record(s) selected", "Please select record to copy");
		}
		return selectionIndices;
	}

	protected void pasteOnTable() {
	}

	protected void onDeleteClick() {
		if (table.getItems().length != 0) {
			int index = table.getSelectionIndex();
			if (index != -1) {
				if (MessageDialog.openConfirm(getShell(), "Confirm", "Are you sure you want to delete '"
						+ table.getItem(index).getText() + "' record?")) {
					doOperation(OperationType.Del, index);
				}
			} else {
				MessageDialog.openError(getShell(), "No record selectd", "Please select record from table to delete.");
			}
		} else {
			MessageDialog.openError(getShell(), "No records", "No record exists in the table to delete.");
		}
	}

	protected void onMoveUpClick() {
		if (table.getItems().length != 0) {
			int index = table.getSelectionIndex();
			if (index == 0) {
				MessageDialog.openInformation(getShell(), "Information", "This is first position cannot move up.");
			} else if (index != -1) {
				Collections.swap(getData(), index, index - 1);
				refreshTable();
			} else {
				MessageDialog.openError(getShell(), "No record selectd", "Please select record from table to move up.");
			}
		} else {
			MessageDialog.openError(getShell(), "No records", "No record exists in the table to move up.");
		}
	}

	protected void onMoveDownClick() {
		if (table.getItems().length != 0) {
			int index = table.getSelectionIndex();
			List<?> data = getData();
			if ((index + 1) == data.size()) {
				MessageDialog.openInformation(getShell(), "Information", "This is last position cannot move down.");
			} else if (index != -1) {
				Collections.swap(data, index, index + 1);
				refreshTable();
			} else {
				MessageDialog.openError(getShell(), "No record selectd",
						"Please select record from table to move down.");
			}
		} else {
			MessageDialog.openError(getShell(), "No records", "No record exists in the table to move down.");
		}
	}

	protected void onEditClick() {
		if (table.getItems().length != 0) {
			int index = table.getSelectionIndex();
			if (index != -1) {
				doOperation(OperationType.Edit, index);
			} else {
				MessageDialog.openError(getShell(), "No record selected", "Please select record from table to edit.");
			}
		} else {
			MessageDialog.openError(getShell(), "No records", "No record exists in the table to edit.");
		}
	}

	public void refreshTable() {
		tableViewer.refresh();
	}

	public void setViewerInput() {
		tableViewer.setInput(getData());
	}

	public abstract String getColumnCaption(int index);

	public abstract int getColumnWidth(int index);

	public abstract List<?> getData();

	public abstract String getTableColumnLabel(Object element, int columnIndex);

	public abstract void doOperation(OperationType operationType, int index);
}
