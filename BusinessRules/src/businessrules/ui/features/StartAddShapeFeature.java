package businessrules.ui.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import businessrules.ui.utils.DiagramTypeConstants;
import businessrules.ui.utils.StyleUtil;
import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;
import businessrulesruntime.core.engine.IContext;
import businessrulesruntime.core.engine.IMessage;
import businessrulesruntime.core.engine.StartStep;

public class StartAddShapeFeature extends AbstractAddShapeFeature {
	public static final String workflowName = "Bizflow";

	public StartAddShapeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		if (context.getTargetContainer() instanceof Diagram == false) {
			return false;
		}

		if (context.getNewObject() instanceof EBaseStep == false) {
			return false;
		}

		return true;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		EBaseStep model = (EBaseStep) context.getNewObject();
		Diagram targetDiagram = (Diagram) context.getTargetContainer();

		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);

		int width = context.getWidth() <= 0 ? 49 : context.getWidth();
		int height = context.getHeight() <= 0 ? 49 : context.getHeight();
		IGaService gaService = Graphiti.getGaService();

		Ellipse circle = gaService.createEllipse(containerShape);
		StyleUtil.applyBGStyle(circle, this);
		gaService.setLocationAndSize(circle, context.getX(), context.getY(), width, height);

		if (model.eResource() == null) {
			getDiagram().eResource().getContents().add(model);
		}

		Graphiti.getPeService().setPropertyValue(containerShape, DiagramTypeConstants.Const_NodeType,
				DiagramTypeConstants.const_StartEvent);

		if (model.getStepInstance() == null) {
			StartStep<IMessage, IContext> startStep = new StartStep<IMessage, IContext>(workflowName);
			model.setStepInstance(startStep);
			model.setName(startStep.getName());
		}

		link(containerShape, model);

		// add a chopbox anchor to the shape
		peCreateService.createChopboxAnchor(containerShape);

		// call the layout feature
		layoutPictogramElement(containerShape);

		return containerShape;
	}
}
