package businessrules.ui.features.businessrule;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.palette.IPaletteEntry;

import businessrules.ui.utils.DiagramTypeConstants;
import businessrules.ui.workflow.ImageProvider;
import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;
import businessrules.ui.workflow.common.emf.model.Workflow.EWorkflowFactory;

public class BusinessRuleCreateShapeFeature extends AbstractCreateFeature implements IPaletteEntry {

	public BusinessRuleCreateShapeFeature(IFeatureProvider fp, String name, String description) {
		super(fp, name, description);
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return (context.getTargetContainer() instanceof Diagram);
	}

	@Override
	public Object[] create(ICreateContext context) {
		EBaseStep model = EWorkflowFactory.eINSTANCE.createEBaseStep();
		model.setDiagramType(DiagramTypeConstants.Const_BusinessRule_BussinessAction);
		addGraphicalRepresentation(context, model);
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		return new Object[] { model };
	}

	@Override
	public String getLabel() {
		return "Steps";
	}

	@Override
	public String getIconId() {
		return ImageProvider.ICON_STEP_BUSINESSRULE;
	}

}
