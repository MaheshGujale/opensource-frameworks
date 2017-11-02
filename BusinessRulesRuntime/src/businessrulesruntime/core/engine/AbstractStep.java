package businessrulesruntime.core.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public abstract class AbstractStep<mT extends IMessage, cT extends IContext> implements IStep<mT, cT> {
	private static final Logger logger = Logger.getLogger(AbstractStep.class);
	private static final long serialVersionUID = 1L;

	protected String workflowName;
	private String name;
	private String displayName;
	private String description;

	private transient Links<mT, cT> incomingLinks = new Links<mT, cT>();
	private transient Links<mT, cT> outgoingLinks = new Links<mT, cT>();

	private List<FieldInfo> parameterInfos = new ArrayList<FieldInfo>();
	private String returnValueText;
	protected InjectInfo returnValueInfo;

	protected boolean handleException = false;

	public AbstractStep(String workflowName, String name) {
		this.workflowName = workflowName;
		this.name = name;
		this.displayName = name;
	}

	public AbstractStep(String workflowName, String name, String displayName) {
		this.workflowName = workflowName;
		this.name = name;
		this.displayName = displayName;
	}

	public AbstractStep(String workflowName, String name, String displayName, String description) {
		this.workflowName = workflowName;
		this.name = name;
		this.displayName = displayName;
		this.description = description;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
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
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setIncomingLinks(Links<mT, cT> links) {
		this.incomingLinks = links;
	}

	@Override
	public Links<mT, cT> getIncomingLinks() {
		if(incomingLinks == null) {
			incomingLinks = new Links<mT, cT>();
		}
		return incomingLinks;
	}

	@Override
	public void setOutgoingLinks(Links<mT, cT> links) {
		this.outgoingLinks = links;
	}

	@Override
	public Links<mT, cT> getOutgoingLinks() {
		if(outgoingLinks == null) {
			outgoingLinks = new Links<mT, cT>();
		}
		return outgoingLinks;
	}

	public String getReturnValueText() {
		return returnValueText;
	}

	public void setReturnValueText(String returnValueText) {
		this.returnValueText = returnValueText;
	}

	public InjectInfo getReturnValueInfo() {
		return returnValueInfo;
	}

	public void setReturnValueInfo(InjectInfo returnValueInfo) {
		this.returnValueInfo = returnValueInfo;
	}

	public List<FieldInfo> getParameterInfos() {
		return parameterInfos;
	}

	public void setParameterInfos(List<FieldInfo> parameterInfos) {
		this.parameterInfos = parameterInfos;
	}

	@Override
	public Object execute(mT message, cT context) {
		Object retVal = null;
		try {
			retVal = doExecute(message, context);
			context.setReturnValue(retVal);
			ILink executionLink = getNextExecutionLink(message, context);
			if (executionLink != null) {
				IStep targetStep = executionLink.getTarget();
				if (targetStep != null) {
					return targetStep.execute(message, context);
				}
			}
		} catch (Exception lastExecutedStepException) {
			context.getStepErrorList().add(lastExecutedStepException);
			logger.error("Error while executing step '" + name + " ", lastExecutedStepException);
		} finally {
		}
		return retVal;
	}
	
	protected ILink getNextExecutionLink(mT message, cT context) {
		Links links = getOutgoingLinks();
		if (links == null) {
			return null;
		}

		List<ILink> listLink = links.getLinks();
		if (listLink == null) {
			return null;
		}

		if (listLink.size() > 0) {
			return listLink.get(0);
		}

		return null;
	}


	@Override
	public boolean hasSubProcess() {
		return false;
	}

	@Override
	public IStepSession<mT, cT> beforeExecute(mT message, cT context) {
		return null;
	}

	@Override
	public void afterExecute(IStepSession<mT, cT> stepSession, mT message, cT context) {
	}

	@Override
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	@Override
	public String getWorkflowName() {
		return workflowName;
	}

	@Override
	public boolean isThrowOnInterrupt() {
		return false;
	}

	@Override
	public boolean isHandleException() {
		return handleException;
	}

	@Override
	public void setHandleException(boolean handleException) {
		this.handleException = handleException;
	}

	@Override
	public boolean isSuspendableStep() {
		return false;
	}

	@Override
	public void beforeSuspend(int suspendId, mT message, cT context) {

	}

	@Override
	public void afterSuspend(mT message, cT context) {
	}

	@Override
	public Object onResume(Object response, mT message, cT context) {
		return null;
	}

	public abstract Object doExecute(mT message, cT context) throws Exception;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void onUnHandleException(mT message, cT context) {
		List<Exception> stepErrorList = context.getStepErrorList();
		Exception lastException = stepErrorList.get(stepErrorList.size() - 1);
		context.setWorkflowException(new WorkflowException(message, context,name, workflowName, lastException));
	}

	@Override
	public void interrupt(mT message, cT context) {
	}
}
