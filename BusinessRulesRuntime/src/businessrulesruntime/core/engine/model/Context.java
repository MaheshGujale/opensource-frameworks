package businessrulesruntime.core.engine.model;

import java.util.List;
import java.util.Map;

import businessrulesruntime.core.engine.ErrorInfo;
import businessrulesruntime.core.engine.FlowStack;
import businessrulesruntime.core.engine.IContext;
import businessrulesruntime.core.engine.IMessage;
import businessrulesruntime.core.engine.IStepSession;
import businessrulesruntime.core.engine.WorkflowException;

public class Context implements IContext {

	@Override
	public void setParentContext(IContext parentCtx) {
		// TODO Auto-generated method stub

	}

	@Override
	public IContext getParentContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(String key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T getReturnValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReturnValue(Object retVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public ErrorInfo getErrorInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setErrorInfo(ErrorInfo errorInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ErrorInfo getPreviousErrorInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPreviousErrorInfo(ErrorInfo errorInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Exception> getStepErrorList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <mT extends IMessage, cT extends IContext> void setParentSubProcessSession(
			IStepSession<mT, cT> parentSubProcessSession) {
		// TODO Auto-generated method stub

	}

	@Override
	public <mT extends IMessage, cT extends IContext> IStepSession<mT, cT> getParentSubProcessSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getWorkflowParams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWorkflowParams(Map<String, Object> workflowParams) {
		// TODO Auto-generated method stub

	}

	@Override
	public WorkflowException<? extends IMessage, ? extends IContext> getWorkflowException() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWorkflowException(WorkflowException<? extends IMessage, ? extends IContext> workflowException) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getLocal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLocal(Object local) {
		// TODO Auto-generated method stub

	}

	@Override
	public FlowStack getFlowStack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFlowStack(FlowStack flowStack) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getUniqueId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUniqueId(String uniqueId) {
		// TODO Auto-generated method stub

	}

}
