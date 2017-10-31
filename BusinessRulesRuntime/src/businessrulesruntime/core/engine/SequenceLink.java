package businessrulesruntime.core.engine;

import java.util.ArrayList;
import java.util.List;

public class SequenceLink<mT extends IMessage, cT extends IContext> extends AbstractLink<mT, cT> {

	private static final long serialVersionUID = 1L;

	public SequenceLink(String workflowName, String name) {
		super(workflowName, name);
	}

	public SequenceLink(String workflowName, String name, String displayName) {
		super(workflowName, name, displayName);
	}

	public SequenceLink(String workflowName, String name, String displayName, String description) {
		super(workflowName, name, displayName, description);
	}

	@Override
	public void setPriority(int priority) {
	}

	@Override
	public int getPriority() {
		return 99999;
	}

	@Override
	public List<ValidationException> doValidate() {
		return new ArrayList<ValidationException>();
	}

	@Override
	public boolean doExecute(mT message, cT context) throws Exception {
		return true;
	}

	@Override
	public int getType() {
		return TypeConstants.Connector;
	}
}
