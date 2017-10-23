package businessrulesruntime.core.engine;

import java.io.Serializable;
import java.util.List;

public interface ILink<mT extends IMessage, cT extends IContext> extends Serializable {
	void setName(String name);

	String getName();

	void setDisplayName(String displayName);

	String getDisplayName();

	void setDescription(String description);

	String getDescription();

	void setPriority(int priority);

	int getPriority();

	void setSource(IStep<mT, cT> source);

	IStep<mT, cT> getSource();

	void setTarget(IStep<mT, cT> target);

	IStep<mT, cT> getTarget();

	public String getSourceStepId();

	public String getTargetStepId();

	List<FieldInfo> getParameterInfos();

	void setParameterInfos(List<FieldInfo> parameterInfos);

	boolean execute(mT message, cT context) throws RuntimeException,Exception;

	int getType();
}