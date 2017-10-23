package businessrulesruntime.core.engine;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractLink<mT extends IMessage, cT extends IContext> implements ILink<mT, cT> {

	private static final long serialVersionUID = 1L;

	protected String workflowName;
	private String name;
	private String displayName;
	private String description;

	private String sourceStepId;
	private String targetStepId;

	private transient IStep<mT, cT> source;
	private transient IStep<mT, cT> target;

	private List<FieldInfo> parameterInfos = new ArrayList<FieldInfo>();

	public AbstractLink(String workflowName,String name) {
		this.workflowName=workflowName;
		this.name = name;
		this.displayName = name;
	}

	public AbstractLink(String workflowName,String name, String displayName) {
		this.workflowName=workflowName;
		this.name = name;
		this.displayName = displayName;
	}

	public AbstractLink(String workflowName,String name, String displayName, String description) {
		this.workflowName=workflowName;
		this.name = name;
		this.displayName = displayName;
		this.description = description;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public void setSource(IStep<mT, cT> source) {
		this.source = source;
		sourceStepId = source.getName();
		source.getOutgoingLinks().addLink(this);
	}

	@Override
	public IStep<mT, cT> getSource() {
		return source;
	}

	@Override
	public void setTarget(IStep<mT, cT> target) {
		this.target = target;
		targetStepId = target.getName();
		target.getIncomingLinks().addLink(this);
	}

	@Override
	public IStep<mT, cT> getTarget() {
		return target;
	}

	@Override
	public List<FieldInfo> getParameterInfos() {
		return parameterInfos;
	}

	@Override
	public void setParameterInfos(List<FieldInfo> parameterInfos) {
		this.parameterInfos = parameterInfos;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean execute(mT message, cT context) throws Exception {
		try {
			return doExecute(message, context);
		} catch (Exception exception) {
			context.getStepErrorList().add(exception);
			context.setWorkflowException(new WorkflowException(message, context,name, workflowName, exception));
			throw exception;
		}
	};

	@Override
	public String getSourceStepId() {
		return sourceStepId;
	}

	@Override
	public String getTargetStepId() {
		return targetStepId;
	}
	
	public abstract List<ValidationException> doValidate();

	public abstract boolean doExecute(mT message, cT context) throws Exception;
}
