package resource;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import businessrulesruntime.core.engine.WorkflowEngine;
import businessrulesruntime.core.engine.model.Context;
import businessrulesruntime.core.engine.model.Message;

@Path("rule")
public class RuleTester {

	@Singleton
	private WorkflowEngine workFlowEngine = new WorkflowEngine();

	@Path("/prescreening")
	@POST
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public BusinessRuleResponse prescreening(Message obj) {
		System.out.println("received input msg object.");
		Object executionResult = workFlowEngine.execute(obj, new Context());
		BusinessRuleResponse response = new BusinessRuleResponse();
		if (executionResult instanceof Boolean && (Boolean) executionResult) {
			response.setSuccess("yes");
		} else {
			response.setSuccess("no");
			response.setError("Rule name - ");
		}
		return response;
	}

}
