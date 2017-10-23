package businessrules.ui.features.connector;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;

import businessrules.ui.utils.DiagramTypeConstants;
import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;
import businessrulesruntime.core.engine.SequenceLink;

@SuppressWarnings("rawtypes")
public class ConnectorAddFeature extends AbstractAddFeature {

	public ConnectorAddFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		if (context instanceof IAddConnectionContext && context.getNewObject() instanceof EBaseStep) {
			return true;
		}

		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		IAddConnectionContext addConContext = (IAddConnectionContext) context;
		EBaseStep connector = (EBaseStep) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();

		// CONNECTION WITH POLYLINE
		Connection connection = peCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());

		IGaService gaService = Graphiti.getGaService();
		Polyline polyline = gaService.createPolyline(connection, new int[] { -15, 0, 0, 0, 15, 0 });
		polyline.setLineWidth(1);
		polyline.setForeground(manageColor(IColorConstant.BLACK));

		Graphiti.getPeService().setPropertyValue(connection, DiagramTypeConstants.Const_NodeType,
				DiagramTypeConstants.Const_Connector);
		EBaseStep sourceStep = (EBaseStep) connection.getStart().getParent().getLink().getBusinessObjects().get(0);
		EBaseStep targetStep = (EBaseStep) connection.getEnd().getParent().getLink().getBusinessObjects().get(0);
		if (connector.getStepInstance() == null) {
			String linkName = sourceStep.getName() + "_" + targetStep.getName();
			connector.setName(linkName);
			connector.setStepInstance(new SequenceLink(linkName, linkName));
		}

		// create link and wire it
		link(connection, connector);

		// add static graphical decorator (composition and navigable)
		ConnectionDecorator cd;
		cd = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
		createArrow(cd);

		return connection;
	}

	private Polyline createArrow(GraphicsAlgorithmContainer gaContainer) {
		IGaService gaService = Graphiti.getGaService();
		Polyline polyline = gaService.createPolyline(gaContainer, new int[] { -5, 5, 0, 0, -5, -5 });
		polyline.setForeground(manageColor(IColorConstant.BLACK));
		polyline.setLineWidth(2);
		return polyline;
	}
}
