package businessrules.ui.workflow;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICopyFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IPasteFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import businessrules.ui.features.CopyFeature;
import businessrules.ui.features.DirectEditFeature;
import businessrules.ui.features.LayoutFeature;
import businessrules.ui.features.PasteFeature;
import businessrules.ui.features.PropertyCustomFeature;
import businessrules.ui.features.StartAddShapeFeature;
import businessrules.ui.features.StartCreateShapeFeature;
import businessrules.ui.features.UpdateFeature;
import businessrules.ui.features.connector.ConditionalConnectorAddFeature;
import businessrules.ui.features.connector.ConditionalConnectorCreateFeature;
import businessrules.ui.features.connector.ConnectorAddFeature;
import businessrules.ui.features.connector.ConnectorCreateFeature;
import businessrules.ui.utils.DiagramTypeConstants;
import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;

public class BizFlowFeatureProvider extends DefaultFeatureProvider {

	private Map<String, AbstractFeature> modelFeatures = new HashMap<String, AbstractFeature>();
	private URI baseURI;
	private String groupName;

	StartAddShapeFeature startAddShapeFeature = new StartAddShapeFeature(this);
	ConnectorAddFeature connectorAddFeature = new ConnectorAddFeature(this);
	ConditionalConnectorAddFeature conditionalConnectorAddFeature = new ConditionalConnectorAddFeature(this);
/*	DecisionAddShapeFeature decisionAddShapeFeature = new DecisionAddShapeFeature(this);
	ActivityAddShapeFeature activityAddShapeFeature = new ActivityAddShapeFeature(this);
	BusinessRuleAddShapeFeature businessRuleAddShapeFeature = new BusinessRuleAddShapeFeature(this);
*/
	public BizFlowFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		modelFeatures.put(DiagramTypeConstants.const_StartEvent, startAddShapeFeature);
		modelFeatures.put(DiagramTypeConstants.Const_Connector, connectorAddFeature);
		modelFeatures.put(DiagramTypeConstants.Const_ConditionalConnector, conditionalConnectorAddFeature);
/*		modelFeatures.put(DiagramTypeConstants.Const_Decision_BussinessAction, decisionAddShapeFeature);
		modelFeatures.put(DiagramTypeConstants.Const_Activity_BussinessAction, activityAddShapeFeature);
		modelFeatures.put(DiagramTypeConstants.Const_BusinessRule_BussinessAction, businessRuleAddShapeFeature);
*/	}

	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		if (context.getNewObject() instanceof EBaseStep) {
			String diagramType = ((EBaseStep) context.getNewObject()).getDiagramType();
			if (diagramType != null) {
				if (diagramType.equals(DiagramTypeConstants.const_StartEvent)) {
					return startAddShapeFeature;
				}
				if (diagramType.equals(DiagramTypeConstants.Const_Connector)) {
					return connectorAddFeature;
				}
				if (diagramType.equals(DiagramTypeConstants.Const_ConditionalConnector)) {
					return conditionalConnectorAddFeature;
				}
/*				if (diagramType.equals(DiagramTypeConstants.Const_Decision_BussinessAction)) {
					return decisionAddShapeFeature;
				}
				if (diagramType.equals(DiagramTypeConstants.Const_Activity_BussinessAction)) {
					return activityAddShapeFeature;
				}
				if (diagramType.equals(DiagramTypeConstants.Const_BusinessRule_BussinessAction)) {
					return businessRuleAddShapeFeature;
				}
*/			}
		}
		return super.getAddFeature(context);
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] { new StartCreateShapeFeature(this, "Start", "Start")/*,
				new DecisionCreateShapeFeature(this, "Decision", "Decision"),
				new ActivityCreateShapeFeature(this, "Activity", "Activity"),
				new BusinessRuleCreateShapeFeature(this, "BusinessRule", "BusinessRule")*/};
	}

	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] { new ConnectorCreateFeature(this, "Sequence flow", "Sequence flow"),
				new ConditionalConnectorCreateFeature(this, "Conditional flow", "Conditional flow") };
	}

	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[] { new PropertyCustomFeature(this)};
	}

	@Override
	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof EBaseStep) {
			return new DirectEditFeature(this);
		}

		return super.getDirectEditingFeature(context);
	}

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape || pictogramElement instanceof Connection) {
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo instanceof EBaseStep) {
				return new UpdateFeature(this);
			}
		}
		return super.getUpdateFeature(context);
	}

	@Override
	public ICopyFeature getCopyFeature(ICopyContext context) {
		PictogramElement pictogramElement = context.getPictogramElements()[0];
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		if (businessObject instanceof EBaseStep) {
			return new CopyFeature(this);
		}
		return super.getCopyFeature(context);
	}

	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof EBaseStep) {
			return new LayoutFeature(this);
		}
		return super.getLayoutFeature(context);
	}

	@Override
	public IPasteFeature getPasteFeature(IPasteContext context) {
		return new PasteFeature(this);
	}

	public Map<String, AbstractFeature> getModelFeatures() {
		return modelFeatures;
	}

	public URI getBaseURI() {
		return baseURI;
	}

	public void setBaseURI(URI baseURI) {
		this.baseURI = baseURI;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

}
