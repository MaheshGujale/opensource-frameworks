package businessrulesruntime.core.engine;

public interface IStepSession<mT extends IMessage, cT extends IContext> {
	IStep<mT, cT> getStep();

	void setStep(IStep<mT, cT> step);

	boolean handleException();

	mT getCurrentMessage();

	void setCurrentMessage(mT currentMessage);

}
