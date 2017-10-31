package businessrulesruntime.core.engine;

public class WorkflowException<mT extends IMessage, cT extends IContext> {
	private mT message;
	private cT context;
	private String stepName;
	private String workflowName;
	private Exception exception;

	public WorkflowException(mT message, cT context,String stepName, String workflowName,
			Exception exception) {
		this.message = message;
		this.context = context;
		this.stepName = stepName;
		this.workflowName = workflowName;
		this.exception = exception;
	}

	public cT getContext() {
		return context;
	}

	public void setContext(cT context) {
		this.context = context;
	}

	public mT getMessage() {
		return message;
	}

	public void setMessage(mT message) {
		this.message = message;
	}
	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
}
