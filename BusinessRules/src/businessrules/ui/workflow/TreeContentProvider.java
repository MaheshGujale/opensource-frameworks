package businessrules.ui.workflow;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import businessrules.ui.utils.FileUtils;
import businessrules.ui.utils.UIConstants;

public class TreeContentProvider implements ITreeContentProvider {

	public TreeContentProvider() {
	}

	public Object[] getChildren(Object parentElement) {
		try {
			if (parentElement instanceof String) {
				List<String> allWorkflows = FileUtils.getAllFolders();
				int size = allWorkflows.size();
				Workflow[] workflow = new Workflow[size];
				for(int index = 0; index < size ;index++) {
					workflow[index] = new Workflow(allWorkflows.get(index));
					workflow[index].setWorkflowConfigFile(UIConstants.datadir + allWorkflows.get(index) + "/"
							+ allWorkflows.get(index) + ".rules");
				}
				return workflow;
			}
		} catch (Exception e) {
			return null;
		}
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof String) {
			return element.equals("Workflow");
		}
		return false;
	}

	public Object[] getElements(Object inputElement) {
		return new String[] { "Workflow" };
	}

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
}