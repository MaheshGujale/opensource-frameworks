package businessrules.ui.features.connector;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.palette.IPaletteEntry;

import businessrules.ui.utils.DiagramTypeConstants;
import businessrules.ui.workflow.ImageProvider;
import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;
import businessrules.ui.workflow.common.emf.model.Workflow.EWorkflowFactory;

public class ConditionalConnectorCreateFeature extends AbstractCreateConnectionFeature implements IPaletteEntry {

	public ConditionalConnectorCreateFeature(IFeatureProvider fp, String name, String description) {
		super(fp, name, description);
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		EBaseStep sourceNode = getNode(context.getSourceAnchor());
		EBaseStep targetNode = getNode(context.getTargetAnchor());

		if (sourceNode != null && targetNode != null && sourceNode != targetNode) {
			return true;
		}

		return false;
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		EBaseStep sourceNode = getNode(context.getSourceAnchor());
		if (sourceNode != null) {
			return true;
		}

		return false;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;

		EBaseStep sourceNode = getNode(context.getSourceAnchor());
		EBaseStep targetNode = getNode(context.getTargetAnchor());

		if (sourceNode != null && targetNode != null) {
			EBaseStep connector = createConnector(sourceNode, targetNode);
			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(),
					context.getTargetAnchor());

			addContext.setNewObject(connector);
			newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
		}
		return newConnection;
	}

	private EBaseStep getNode(Anchor anchor) {
		if (anchor == null) {
			return null;
		}

		Object modelObject = getBusinessObjectForPictogramElement(anchor.getParent());
		if (modelObject instanceof EBaseStep) {
			return (EBaseStep) modelObject;
		}

		return null;
	}

	private EBaseStep createConnector(EBaseStep source, EBaseStep target) {
		EBaseStep connector = EWorkflowFactory.eINSTANCE.createEBaseStep();
		connector.setDiagramType(DiagramTypeConstants.Const_ConditionalConnector);
		getDiagram().eResource().getContents().add(connector);
		return connector;
	}

	@Override
	public String getLabel() {
		return "Connectors";
	}

	@Override
	public String getIconId() {
		return ImageProvider.ICON_LINK_CONDITIONALFLOW;
	}
}
