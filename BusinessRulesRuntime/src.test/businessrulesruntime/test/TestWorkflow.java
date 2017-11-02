package businessrulesruntime.test;

import businessrulesruntime.core.engine.WorkflowEngine;
import businessrulesruntime.core.engine.model.Context;
import businessrulesruntime.core.engine.model.Message;

public class TestWorkflow {
	public static void main(String[] args) {
		WorkflowEngine workflowEngine = new WorkflowEngine();
		Message message = new Message();
		message.setMti("1200");
		Context context = new Context();
		workflowEngine.execute(message, context);
	}
}
