package businessrulesruntime.core.engine;

import java.io.Serializable;
import java.util.List;


public interface IStep<mT extends IMessage, cT extends IContext> extends Serializable {
	void setName(String name);

	String getName();

	void setDisplayName(String displayName);

	String getDisplayName();

	void setDescription(String description);

	String getDescription();

	void setWorkflowName(String workflowName);

	String getWorkflowName();

	void setIncomingLinks(Links<mT, cT> links);

	Links<mT, cT> getIncomingLinks();

	void setOutgoingLinks(Links<mT, cT> links);

	Links<mT, cT> getOutgoingLinks();

	boolean isHandleException();

	void setHandleException(boolean handleException);

	void onUnHandleException(mT message, cT context);

	boolean hasSubProcess();

	boolean isSuspendableStep();

	void beforeSuspend(int suspendId, mT message, cT context);

	void afterSuspend(mT message, cT context);

	Object onResume(Object response, mT message, cT context);

	int getType();

	List<FieldInfo> getParameterInfos();

	void setParameterInfos(List<FieldInfo> parameterInfos);

	Object execute(mT message, cT context) throws RuntimeException;

	List<ValidationException> validate();

	IStepSession<mT, cT> beforeExecute(mT message, cT context);

	void afterExecute(IStepSession<mT, cT> stepSession, mT message, cT context);

	boolean isThrowOnInterrupt();

	void interrupt(mT message, cT context);
}