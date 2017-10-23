package businessrulesruntime.core.engine;

import java.util.List;
import java.util.Map;

public interface IContext {
	public void setParentContext(IContext parentCtx);

	public IContext getParentContext();

	public void put(String key, Object value);

	public Object get(String key);

	public void remove(String key);

	public void clear();

	public <T> T getReturnValue();

	public void setReturnValue(Object retVal);

	public ErrorInfo getErrorInfo();

	public void setErrorInfo(ErrorInfo errorInfo);

	public ErrorInfo getPreviousErrorInfo();

	public void setPreviousErrorInfo(ErrorInfo errorInfo);

	public List<Exception> getStepErrorList();

	public <mT extends IMessage, cT extends IContext> void setParentSubProcessSession(
			IStepSession<mT, cT> parentSubProcessSession);

	public <mT extends IMessage, cT extends IContext> IStepSession<mT, cT> getParentSubProcessSession();

	public Map<String, Object> getWorkflowParams();

	public void setWorkflowParams(Map<String, Object> workflowParams);

	/*public <mT extends IMessage, cT extends IContext> WorkflowInstance<mT, cT> getWorkflowInstance();

	public <mT extends IMessage, cT extends IContext> void setWorkflowInstance(
			WorkflowInstance<mT, cT> workflowInstance);*/

	public WorkflowException<? extends IMessage, ? extends IContext> getWorkflowException();

	public void setWorkflowException(WorkflowException<? extends IMessage, ? extends IContext> workflowException);

	public Object getLocal();

	public void setLocal(Object local);

	public FlowStack getFlowStack();

	public void setFlowStack(FlowStack flowStack);

	public String getUniqueId();

	public void setUniqueId(String uniqueId);

}
