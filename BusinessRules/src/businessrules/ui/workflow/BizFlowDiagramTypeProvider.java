package businessrules.ui.workflow;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class BizFlowDiagramTypeProvider extends AbstractDiagramTypeProvider {

	private IToolBehaviorProvider[] toolBehaviorProviders;

	public BizFlowDiagramTypeProvider() {
		super();
		setFeatureProvider(new BizFlowFeatureProvider(this));
	}

	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (toolBehaviorProviders == null) {
			toolBehaviorProviders = new IToolBehaviorProvider[] { new ToolBehaviorProvider(this) };
		}

		return toolBehaviorProviders;
	}
}
