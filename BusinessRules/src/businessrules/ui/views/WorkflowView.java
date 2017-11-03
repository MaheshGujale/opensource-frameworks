package businessrules.ui.views;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import businessrules.Activator;
import businessrules.ui.dialog.AddWorkflowDialog;
import businessrules.ui.editor.BusinessRuleEditorInput;
import businessrules.ui.editor.BusinessRuleEditorPart;
import businessrules.ui.utils.UIConstants;
import businessrules.ui.workflow.TreeContentProvider;
import businessrules.ui.workflow.TreeLabelProvider;
import businessrules.ui.workflow.Workflow;

public class WorkflowView extends ViewPart {
	public static final String ID = "BusinessRules.workflow.view";

	private static final byte ADD_WORKFLOW = 1;
	private static final byte DELETE_WORKFLOW = 2;
	private static final byte EXPORT_WORKFLOWS = 3;

	private TreeViewer treeViewer;
	private TreeContentProvider treeContentProvider;

	public WorkflowView() {
	}

	@Override
	public void createPartControl(Composite parent) {

		treeViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		treeContentProvider = new TreeContentProvider();
		treeViewer.setContentProvider(treeContentProvider);
		treeViewer.setLabelProvider(new TreeLabelProvider());
		treeViewer.setInput("");
		treeViewer.getTree().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem treeItem = (TreeItem) e.item;
				Object obj = treeItem.getData();
			}
		});
		getSite().setSelectionProvider(treeViewer);
		hookDoubleClickListener();
		this.initContextMenu();
	}

	private void initContextMenu() {

		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager manager) {
				setDynamicMenus(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(treeViewer.getTree());
		treeViewer.getTree().setMenu(menu);
		getSite().registerContextMenu(menuMgr, treeViewer);

	}

	private void setDynamicMenus(IMenuManager manager) {
		if (treeViewer.getSelection().isEmpty()) {
			return;
		}

		ISelection selection = treeViewer.getSelection();
		if (selection != null && selection instanceof IStructuredSelection) {
			int selectionCount = treeViewer.getTree().getSelectionCount();
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			if (obj != null) {
				if (obj instanceof String) {
					manager.add(addAction(ADD_WORKFLOW, new Workflow(), "Add Workflow"));
				} else if (obj instanceof Workflow) {
					manager.add(addAction(DELETE_WORKFLOW, obj, "Delete Workflow"));
					manager.add(addAction(EXPORT_WORKFLOWS, obj, "Export Workflow"));
				}
			}
		}
	}

	public Action addAction(Byte menuId, Object data, String text) {
		MenuAction action = new MenuAction(menuId, data);
		action.setText(text);
		Image image = getImageDescriptorForMenu(menuId);
		if (image != null) {
			ImageDescriptor desc = ImageDescriptor.createFromImage(image);
			action.setImageDescriptor(desc);
		}
		return action;
	}

	private Image getImageDescriptorForMenu(Byte menuId) {
		String imageName = getImageNameForMenuItem(menuId);
		if (imageName == null || imageName.equals("")) {
			return null;
		}

		try {
			return Activator.getImageDescriptor("/icons/" + imageName).createImage();
		} catch (Exception e) {
		}

		return null;
	}

	public String getImageNameForMenuItem(Byte menuId) {
		String imageName = "";
		switch (menuId) {

		case ADD_WORKFLOW:
			imageName = "icon_workFlow.gif";
			break;

		case DELETE_WORKFLOW:
			imageName = "icon_delete.gif";
			break;

		case EXPORT_WORKFLOWS:
			imageName = "Icon_Export.gif";
			break;
		}
		return imageName;
	}

	private class MenuAction extends Action {
		private Object data = null;
		private int menuId = 0;

		public MenuAction(int menuId, Object data) {
			this.menuId = menuId;
			this.data = data;
		}

		public int getMenuId() {
			return menuId;
		}

		public void run() {
			executeMenuAction(this, data);
		}

	}

	public void executeMenuAction(MenuAction action, final Object data) {

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		int menuId = action.getMenuId();

		switch (menuId) {
		case ADD_WORKFLOW: {
			AddWorkflowDialog workflowDialog = new AddWorkflowDialog(getSite().getShell(), null);
			if (workflowDialog.open() == Window.OK) {
				treeViewer.refresh();
			}
			break;
		}
		case DELETE_WORKFLOW: {
			Workflow workflow = (Workflow) data;
			if (workflow.getName() != null && MessageDialog.openConfirm(getSite().getShell(), "Confirm",
					"Are you sure you want to delete '" + workflow.getName() + "'")) {
				File workflowFolder = new File(UIConstants.datadir + workflow.getName());
				File[] files = workflowFolder.listFiles();
				for (File file : files) {
					file.delete();
				}
				workflowFolder.delete();
				treeViewer.refresh();
			}
			break;
		}
		case EXPORT_WORKFLOWS: {
			Workflow workflow = (Workflow) data;
			if (new File(workflow.getWorkflowConfigFile()).exists()) {
				FileDialog saveDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
				saveDialog.setFilterExtensions(new String[] { "*.zip" });
				saveDialog.setFilterNames(new String[] { "Business Rules Files (*.zip)" });
				saveDialog.setOverwrite(true);
				saveDialog.setFileName(workflow.getName());
				if (saveDialog.open() != null) {
					String path = saveDialog.getFilterPath() + "\\" + saveDialog.getFileName();
					FileOutputStream stream;
					try {
						stream = new FileOutputStream(path);
						ZipOutputStream out = new ZipOutputStream(stream);
						ZipEntry zipEntry = new ZipEntry(workflow.getName() + ".mdl");
						out.putNextEntry(zipEntry);
						InputStream inputStream = new FileInputStream(
								UIConstants.datadir + workflow.getName() + "/" + workflow.getName() + ".mdl");
						int len;
						byte[] buffer = new byte[1024];
						while ((len = inputStream.read(buffer)) > 0) {
							out.write(buffer);
						}
						inputStream.close();
						out.closeEntry();
						out.close();
						stream.close();
						MessageDialog.openInformation(getSite().getShell(), "Success", "Workflow exported successfully!");
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			} else {
				MessageDialog.openWarning(getSite().getShell(), "Warning", "Workflow is not created");
			}
			break;
		}
		}
	}

	private void hookDoubleClickListener() {
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent dblClickevent) {
				ISelection selection = treeViewer.getSelection();
				if (selection != null && selection instanceof IStructuredSelection) {
					Object obj = ((IStructuredSelection) selection).getFirstElement();
					if (obj instanceof Workflow) {
						Workflow workflow = (Workflow) obj;
						showWorkflowUI(workflow);
					}
				}
			}
		});

	}

	protected void showWorkflowUI(Workflow workflow) {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		try {
			page.openEditor(new BusinessRuleEditorInput(workflow), BusinessRuleEditorPart.ID);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setFocus() {
	}
}
