package businessrules.ui.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.palette.IPaletteEntry;

import businessrules.ui.utils.DiagramTypeConstants;
import businessrules.ui.workflow.ImageProvider;
import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;
import businessrules.ui.workflow.common.emf.model.Workflow.EWorkflowFactory;

public class StartCreateShapeFeature extends AbstractCreateFeature implements IPaletteEntry {

	public StartCreateShapeFeature(IFeatureProvider fp, String name, String description) {
		super(fp, name, description);
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		EList<Shape> allChildrens = getDiagram().getChildren();

		for (Shape children : allChildrens) {
			Object businessObject = getBusinessObjectForPictogramElement(children);
			if (businessObject instanceof EBaseStep) {
				EBaseStep eBaseStep = (EBaseStep) (businessObject);
				if (eBaseStep.getDiagramType().equals(DiagramTypeConstants.const_StartEvent)) {
					return false;
				}
			}
		}
		return (context.getTargetContainer() instanceof Diagram);
	}

	@Override
	public Object[] create(ICreateContext context) {
		EBaseStep model = EWorkflowFactory.eINSTANCE.createEBaseStep();
		model.setDiagramType(DiagramTypeConstants.const_StartEvent);
		addGraphicalRepresentation(context, model);
		return new Object[] { model };
	}

	@Override
	public String getLabel() {
		return "Events";
	}

	@Override
	public String getIconId() {
		return ImageProvider.ICON_STEP_START;
	}
}
