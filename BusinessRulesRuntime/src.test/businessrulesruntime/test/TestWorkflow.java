package businessrulesruntime.test;

import businessrulesruntime.core.engine.WorkflowEngine;
import businessrulesruntime.core.engine.model.Context;
import businessrulesruntime.core.engine.model.Message;

public class TestWorkflow {
	public static void main(String[] args) {
		WorkflowEngine workflowEngine = new WorkflowEngine();
		Message message = new Message();
		message.setMti("1200");
		message.setPrimaryAccountNumber("488787878878787878");
		Context context = new Context();
		System.out.println(workflowEngine.execute(message, context));
	}
}
