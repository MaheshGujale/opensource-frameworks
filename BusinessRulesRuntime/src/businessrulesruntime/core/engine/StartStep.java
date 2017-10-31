package businessrulesruntime.core.engine;

import java.util.ArrayList;
import java.util.List;

public class StartStep<mT extends IMessage, cT extends IContext> extends AbstractStep<mT, cT> {

	private static final long serialVersionUID = 1L;

	private static final String stepName = "Start";

	public StartStep(String workflowName) {
		super(workflowName, stepName);
	}

	@Override
	public Object doExecute(mT message, cT context) {
		return true;
	}

	@Override
	public List<ValidationException> validate() {
		return new ArrayList<ValidationException>();
	}

	@Override
	public int getType() {
		return TypeConstants.StartStep;
	}

	@Override
	public boolean isHandleException() {
		return true;
	}
}
