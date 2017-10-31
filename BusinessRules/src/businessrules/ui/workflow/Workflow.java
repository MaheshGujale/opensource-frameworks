package businessrules.ui.workflow;

import java.io.File;

import businessrules.ui.utils.FileUtils;

public class Workflow {
	private String name;
	private String workflowConfigFile;

	public String getWorkflowConfigFile() {
		return workflowConfigFile;
	}

	public void setWorkflowConfigFile(String workflowConfigFile) {
		this.workflowConfigFile = workflowConfigFile;
	}

	public Workflow(){
	}
	
	public Workflow(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void save() {
		File workFlowFolder = new File(FileUtils.jobDir + name);
		workFlowFolder.mkdir();
	}
}
