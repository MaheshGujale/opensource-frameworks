package businessrules.ui.features;


import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.ui.forms.IMessage;

import businessrulesruntime.core.engine.IContext;
import businessrulesruntime.core.engine.IStep;
import businessrulesruntime.core.engine.ValidationException;

public interface IValidationSupport {

	public void validate(PictogramElement pictogramElement) throws ValidationException;

	public void validate(IStep<? extends IMessage, ? extends IContext> step) throws ValidationException;

}
