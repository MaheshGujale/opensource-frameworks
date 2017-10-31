package businessrules.ui.workflow;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;
import org.eclipse.graphiti.ui.platform.IImageProvider;

public class ImageProvider extends AbstractImageProvider implements IImageProvider {

	public static final String ICON_STEP_START = "start";
	public static final String ICON_STEP_STOP = "stop";
	public static final String ICON_STEP_DECISION = "decision";
	public static final String ICON_STEP_ACTIVITY = "activity";
	public static final String ICON_STEP_BUSINESSRULE = "businessrule";

	public static final String ICON_DATABASE = "database";

	public static final String ICON_LINK_CONDITIONALFLOW = "conditionalflow";
	public static final String ICON_LINK_FLOW = "flow";

	@Override
	protected void addAvailableImages() {
		addImageFilePath(ICON_STEP_START, "./icons/icon_step_start.png");
		addImageFilePath(ICON_STEP_STOP, "icons/icon_step_stop.png");
		addImageFilePath(ICON_STEP_DECISION, "icons/icon_step_decision.png");
		addImageFilePath(ICON_STEP_ACTIVITY, "icons/icon_step_activity.png");
		addImageFilePath(ICON_STEP_BUSINESSRULE, "icons/icon_step_businessrule.png");

		addImageFilePath(ICON_LINK_CONDITIONALFLOW, "icons/icon_link_conditionalflow.png");
		addImageFilePath(ICON_LINK_FLOW, "icons/icon_link_flow.png");
	}
}
