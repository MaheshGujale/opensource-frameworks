package businessrulesruntime.core.engine.util;

import java.util.Map;

import businessrulesruntime.core.engine.BizflowModel;
import businessrulesruntime.core.engine.ILink;
import businessrulesruntime.core.engine.IStep;
import businessrulesruntime.core.engine.Links;
import businessrulesruntime.core.engine.StartStep;

public class WorkflowRuntimeUtil {
	@SuppressWarnings("unchecked")
	public static IStep linkSteps(BizflowModel bizflowModel) {
		Map<String, IStep> steps = bizflowModel.getSteps();
		Map<String, ILink> links = bizflowModel.getLinks();

		IStep startStep = null;
		for (IStep step : steps.values()) {
			step.setIncomingLinks(new Links());
			step.setOutgoingLinks(new Links());

			if (step instanceof StartStep) {
				startStep = step;
			}
		}

		for (ILink link : links.values()) {
			link.setSource(steps.get(link.getSourceStepId()));
			link.setTarget(steps.get(link.getTargetStepId()));
		}

		for (IStep step : steps.values()) {
			step.getOutgoingLinks().sort();
		}

		return startStep;
	}
}
