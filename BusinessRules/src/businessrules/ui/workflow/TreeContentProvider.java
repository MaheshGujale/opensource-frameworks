package businessrules.ui.workflow;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TreeContentProvider implements ITreeContentProvider {

	public TreeContentProvider() {
	}

	public Object[] getChildren(Object parentElement) {
		try {
			if (parentElement instanceof String) {
				// get all workflow files
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