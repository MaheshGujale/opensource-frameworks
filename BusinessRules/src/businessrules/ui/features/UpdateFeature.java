package businessrules.ui.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;
import businessrulesruntime.core.engine.ConditionalLink;
import businessrulesruntime.core.engine.ILink;
import businessrulesruntime.core.engine.IStep;

public class UpdateFeature extends AbstractUpdateFeature {

	public UpdateFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		return (bo instanceof EBaseStep);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public IReason updateNeeded(IUpdateContext context) {
		// retrieve name from pictogram model
		String pictogramName = null;
		PictogramElement pictogramElement = context.getPictogramElement();
		boolean isTextFieldFound = false;
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape cs = (ContainerShape) pictogramElement;

			for (Shape shape : cs.getChildren()) {
				if (shape.getGraphicsAlgorithm() instanceof Text) {
					Text text = (Text) shape.getGraphicsAlgorithm();
					isTextFieldFound = true;
					pictogramName = text.getValue();
				}
			}
		}

		if (pictogramElement instanceof Connection) {
			Connection connection = (Connection) pictogramElement;
			EList<ConnectionDecorator> decorators = connection.getConnectionDecorators();
			for (ConnectionDecorator decorator : decorators) {
				if (decorator.getGraphicsAlgorithm() instanceof Text) {
					Text text = (Text) decorator.getGraphicsAlgorithm();
					pictogramName = text.getValue();
				}
			}
		}

		// retrieve name from business model
		String businessName = null;
		String priorityText = "";
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof EBaseStep) {
			EBaseStep node = (EBaseStep) bo;
			if (node.getStepInstance() != null && node.getStepInstance() instanceof IStep) {
				businessName = node.getName();
			} else if (node.getStepInstance() != null && node.getStepInstance() instanceof ConditionalLink) {
				ConditionalLink link = (ConditionalLink) node.getStepInstance();
				priorityText = link.getPriority() + ". ";
				businessName = priorityText + link.getDisplayName();
			}
		}

		// update needed, if names are different
		boolean updateNameNeeded = (isTextFieldFound == true && ((pictogramName == null && businessName != null) || (pictogramName != null && !pictogramName
				.equals(businessName))));
		if (updateNameNeeded) {
			return Reason.createTrueReason("Name is out of date");
		} else {
			return Reason.createFalseReason();
		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean update(IUpdateContext context) {
		// retrieve name from business model
		String businessName = null;
		String priorityText = "";
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		EBaseStep eClass = null;
		if (bo instanceof EBaseStep) {
			eClass = (EBaseStep) bo;
			if (eClass.getStepInstance() != null && eClass.getStepInstance() instanceof IStep) {
				businessName = eClass.getName();
			} else if (eClass.getStepInstance() != null && eClass.getStepInstance() instanceof ConditionalLink) {
				ConditionalLink linkInstance = (ConditionalLink) eClass.getStepInstance();
				priorityText = linkInstance.getPriority() + ". ";
				businessName = linkInstance.getDisplayName();
			}
		}

		// Set name in pictogram model
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape cs = (ContainerShape) pictogramElement;

			for (Shape shape : cs.getChildren()) {
				if (shape.getGraphicsAlgorithm() instanceof Text) {
					Text text = (Text) shape.getGraphicsAlgorithm();
					text.setValue(businessName);
					if (eClass != null) {
						try {
							eClass.setName(businessName);
						} catch (Exception e) {
						}
					}
					return true;
				}
			}
		}

		if (pictogramElement instanceof Connection) {
			Connection connection = (Connection) pictogramElement;
			EList<ConnectionDecorator> decorators = connection.getConnectionDecorators();
			for (ConnectionDecorator decorator : decorators) {
				if (decorator.getGraphicsAlgorithm() instanceof Text) {
					Text text = (Text) decorator.getGraphicsAlgorithm();
					text.setValue(priorityText + businessName);
					if (eClass != null) {
						try {
							((ILink) eClass.getStepInstance()).setDisplayName(businessName);
						} catch (Exception e) {
						}
					}
					return true;
				}
			}
		}

		return false;
	}

}
