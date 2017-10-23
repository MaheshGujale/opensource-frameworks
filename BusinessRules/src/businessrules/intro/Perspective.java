package businessrules.intro;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import businessrules.ui.views.WorkflowView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		layout.setFixed(false);
		layout.addStandaloneView(WorkflowView.ID, true, IPageLayout.LEFT, 0.2f, editorArea);
		layout.getViewLayout(WorkflowView.ID).setCloseable(false);

	}
}
