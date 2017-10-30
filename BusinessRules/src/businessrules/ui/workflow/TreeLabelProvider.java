package businessrules.ui.workflow;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import businessrules.Activator;
import businessrules.ui.utils.UIConstants;

public class TreeLabelProvider implements ILabelProvider {

	@Override
	public Image getImage(Object element) {
		String imageName = "";
		if (element instanceof String) {
			imageName = "workflow.png";
		} else if (element instanceof Workflow) {
			imageName = "workflow_name.png";
		}
		Image image = Activator.getImageDescriptor(UIConstants.imgdir + imageName).createImage();
		return image;
	}

	// @Override
	public String getText(Object element) {
		if (element instanceof String) {
			return (String) element;
		}

		if (element instanceof Workflow) {
			Workflow source = (Workflow) element;
			return source.getName();
		}

		return null;
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void removeListener(ILabelProviderListener listener) {

	}
}
