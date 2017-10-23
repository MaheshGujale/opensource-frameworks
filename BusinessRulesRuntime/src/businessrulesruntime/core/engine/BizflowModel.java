package businessrulesruntime.core.engine;

import java.util.Map;

@SuppressWarnings("rawtypes")
public class BizflowModel {
	private Map<String, IStep> steps;
	private Map<String, ILink> links;

	public BizflowModel() {
	}

	public BizflowModel(Map<String, IStep> steps, Map<String, ILink> links) {
		this.steps = steps;
		this.links = links;
	}

	public Map<String, IStep> getSteps() {
		return steps;
	}

	public void setSteps(Map<String, IStep> steps) {
		this.steps = steps;
	}

	public Map<String, ILink> getLinks() {
		return links;
	}

	public void setLinks(Map<String, ILink> links) {
		this.links = links;
	}
}
