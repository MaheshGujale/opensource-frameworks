package businessrules.ui.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import businessrules.ui.utils.WorkflowUtil;
import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;

public class DirectEditFeature extends AbstractDirectEditingFeature {

	public DirectEditFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}

	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		if (bo instanceof EBaseStep && ga instanceof Text) {
			return true;
		}

		return false;
	}

	@Override
	public String getInitialValue(IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object businessObject = getBusinessObjectForPictogramElement(pe);
		if (businessObject instanceof EBaseStep) {
			EBaseStep node = (EBaseStep) businessObject;
			return node.getName();
		}

		return null;
	}

	@Override
	public void setValue(String value, IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object businessObject = getBusinessObjectForPictogramElement(pe);
		if (businessObject instanceof EBaseStep) {
			EBaseStep node = (EBaseStep) businessObject;
			node.setName(value);
		}

		updatePictogramElement(((Shape) pe).getContainer());
	}

	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		if (value.length() < 1) {
			return "Please enter any text.";
		}

		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof Shape) {
			if (value.contains(" ")) {
				return "Name should not contain blank space";
			}
			if (value.endsWith("_")) {
				return "Step Name cannot end with underscore.";
			}
			if (WorkflowUtil.validateStepName(getDiagram(), value, (Shape) pictogramElement)) {
				return "Please enter another name. Name '" + value + "' already exists.";
			}
		}

		return super.checkValueValid(value, context);
	}
}
