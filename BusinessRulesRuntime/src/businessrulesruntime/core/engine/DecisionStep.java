package businessrulesruntime.core.engine;

import java.util.ArrayList;
import java.util.List;

public class DecisionStep<mT extends IMessage, cT extends IContext> extends AbstractStep<mT, cT> {

	private static final long serialVersionUID = 1L;

	public DecisionStep(String workflowName, String name) {
		super(workflowName, name);
	}

	public DecisionStep(String workflowName, String name, String displayName) {
		super(workflowName, name, displayName);
	}

	public DecisionStep(String workflowName, String name, String displayName, String description) {
		super(workflowName, name, displayName, description);
	}

	@Override
	public Object doExecute(mT message, cT context) {
		return context.getReturnValue();
	}
	
	@Override
	public List<ValidationException> validate() {
		return new ArrayList<ValidationException>();
	}

	@Override
	public int getType() {
		return TypeConstants.DecisionStep;
	}

}
