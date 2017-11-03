package businessrulesruntime.test;

import businessrulesruntime.core.engine.WorkflowEngine;
import businessrulesruntime.core.engine.WorkflowResponse;
import businessrulesruntime.core.engine.model.Context;
import businessrulesruntime.core.engine.model.Message;

public class TestWorkflow {
	public static void main(String[] args) {
		WorkflowEngine workflowEngine = new WorkflowEngine();
		Message message = new Message();
		message.setMti("1200");
		message.setPrimaryAccountNumber("5454540000054820");
		Context context = new Context();
		Object response = workflowEngine.execute(message, context);
		if(response instanceof WorkflowResponse) {
			WorkflowResponse workflowResponse = (WorkflowResponse) response;
			System.out.println(workflowResponse.isSuccess());
			System.out.println(workflowResponse.getFailureMessage());
		}
	}
}
