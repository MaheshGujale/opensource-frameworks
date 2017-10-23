package businessrules.ui.features.connector;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import businessrules.ui.editor.BusinessRuleEditorPart;
import businessrules.ui.features.IDoubleClickSupport;
import businessrules.ui.utils.DiagramTypeConstants;
import businessrules.ui.workflow.BizFlowFeatureProvider;
import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;
import businessrulesruntime.core.engine.ConditionalLink;
import businessrulesruntime.core.engine.FieldInfo;
import businessrulesruntime.core.engine.IStep;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ConditionalConnectorAddFeature extends AbstractAddFeature implements IDoubleClickSupport {

	public static final String stepName = "ConditionalLink";
	public static final String stepDescription = "Conditional Link";
	public static final String linkDefaultPriority = "0. ";

	public ConditionalConnectorAddFeature(IFeatureProvider fp) {
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
		Polyline polyline = gaService.createPolyline(connection);
		polyline.setLineWidth(1);
		polyline.setForeground(manageColor(IColorConstant.BLACK));

		Graphiti.getPeService().setPropertyValue(connection, DiagramTypeConstants.Const_NodeType,
				DiagramTypeConstants.Const_ConditionalConnector);

		EBaseStep sourceStep = (EBaseStep) connection.getStart().getParent().getLink().getBusinessObjects().get(0);
		EBaseStep targetStep = (EBaseStep) connection.getEnd().getParent().getLink().getBusinessObjects().get(0);

		if (connector.getStepInstance() == null) {
			String linkName = sourceStep.getName() + "_" + targetStep.getName();
			connector.setName(linkName);
			connector.setStepInstance(new ConditionalLink(stepName, linkName, stepName, stepDescription));
		}

		// create link and wire it
		link(connection, connector);

		ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.4, true);
		Text text = gaService.createDefaultText(getDiagram(), textDecorator);
		text.setForeground(manageColor(IColorConstant.BLACK));
		gaService.setLocationAndSize(text, -20, -20, 0, 5);
		link(textDecorator, connector);

		ConditionalLink conditionalLink = (ConditionalLink) connector.getStepInstance();

		// set reference name in the text decorator
		text.setValue("0. " + conditionalLink.getDisplayName());

		// add start decorator
		ConnectionDecorator startDecorator = peCreateService.createConnectionDecorator(connection, false, 0, true);
		createEllipse(startDecorator);

		// add end decorator
		ConnectionDecorator endDecorator = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
		createArrow(endDecorator);

		return connection;
	}

	private void createArrow(GraphicsAlgorithmContainer gaContainer) {
		IGaService gaService = Graphiti.getGaService();
		Polyline polyline = gaService.createPolyline(gaContainer, new int[] { -5, 5, 0, 0, -5, -5 });
		polyline.setForeground(manageColor(IColorConstant.BLACK));
		polyline.setLineWidth(2);
	}

	private void createEllipse(GraphicsAlgorithmContainer gaContainer) {
		IGaService gaService = Graphiti.getGaService();
		Ellipse ellipse = gaService.createEllipse(gaContainer);
		ellipse.setForeground(manageColor(IColorConstant.BLACK));
		ellipse.setBackground(manageColor(IColorConstant.BLACK));
		ellipse.setFilled(true);
		ellipse.setLineWidth(1);
		gaService.setSize(ellipse, 6, 6);
	}

	@Override
	public void onDoubleClick(ICustomContext context) {
		PictogramElement[] pictogramElements = context.getPictogramElements();
		if (pictogramElements == null || pictogramElements.length == 0) {
			return;
		}

		Object businessObject = getBusinessObjectForPictogramElement(pictogramElements[0]);
		EBaseStep eBaseStep = (EBaseStep) businessObject;

		ConditionalLink link = (ConditionalLink) eBaseStep.getStepInstance();
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		BizFlowFeatureProvider featureProvider = ((BizFlowFeatureProvider) getFeatureProvider());
		ConnectorPropertyDialog dialog = new ConnectorPropertyDialog(shell, link.getName(), link.getDisplayName(),
				link.getDescription(), link.getParameterInfos(), link.getPriority(), link.getCodeDetail(), getDiagram(),
				(Connection) pictogramElements[0], featureProvider.getGroupName());
		if (dialog.open() == Window.OK) {
			link.setDisplayName(dialog.getStepDisplayName());
			link.setDescription(dialog.getStepDescription());
			link.setParameterInfos(dialog.getParameterInfo());
			link.setPriority(dialog.getPriority());
			link.setCodeDetail(dialog.getCodeDetail());

			updatePictogramElement(pictogramElements[0]);
		}
	}
	
}
