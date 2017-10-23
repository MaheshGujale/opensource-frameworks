package businessrules.ui.workflow;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.IPaletteEntry;
import org.eclipse.graphiti.palette.impl.ConnectionCreationToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;

import businessrules.ui.features.IDoubleClickSupport;
import businessrules.ui.features.IValidationSupport;
import businessrules.ui.features.connector.ConditionalConnectorCreateFeature;
import businessrules.ui.features.connector.ConnectorCreateFeature;
import businessrules.ui.utils.DiagramTypeConstants;
import businessrulesruntime.core.engine.ExceptionType;
import businessrulesruntime.core.engine.ValidationException;

public class ToolBehaviorProvider extends DefaultToolBehaviorProvider {

	public ToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}

	@Override
	public IContextMenuEntry[] getContextMenu(ICustomContext context) {
		// create a menu-entry in the sub-menu for each custom feature
		List<IContextMenuEntry> menuEntries = new ArrayList<IContextMenuEntry>();
		if (context instanceof ICustomContext) {
			ICustomContext customContext = (ICustomContext) context;
			ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(customContext);
			for (int i = 0; i < customFeatures.length; i++) {
				ICustomFeature customFeature = customFeatures[i];
				if (customFeature.isAvailable(customContext)) {
					ContextMenuEntry menuEntry = new ContextMenuEntry(customFeature, context);
					menuEntries.add(menuEntry);
				}
			}
		}

		IContextMenuEntry ret[] = menuEntries.toArray(new IContextMenuEntry[] {});
		return ret;
	}

	@Override
	public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
		PictogramElement[] pElements = context.getPictogramElements();
		if (pElements != null && pElements.length > 0) {
			String diagramType = Graphiti.getPeService().getPropertyValue(pElements[0],
					DiagramTypeConstants.Const_NodeType);
			if (diagramType != null) {
				BizFlowFeatureProvider featureProvider = (BizFlowFeatureProvider) getFeatureProvider();
				AbstractFeature addShapeFeature = featureProvider.getModelFeatures().get(diagramType);
				if (addShapeFeature != null && addShapeFeature instanceof IDoubleClickSupport) {
					IDoubleClickSupport features = (IDoubleClickSupport) addShapeFeature;
					features.onDoubleClick(context);
				}
			}

		}
		return super.getDoubleClickFeature(context);
	}

	private PaletteCompartmentEntry getPaletteCompartmentEntry(
			List<IPaletteCompartmentEntry> allPaletteCompartmentEntry, String compartmentEntryLabel,
			String compartmentEntryIconId) {

		for (IPaletteCompartmentEntry paletteCompartmentEntry : allPaletteCompartmentEntry) {
			if (paletteCompartmentEntry.getLabel().equals(compartmentEntryLabel)) {
				return (PaletteCompartmentEntry) paletteCompartmentEntry;
			}
		}

		PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry(compartmentEntryLabel,
				compartmentEntryIconId);
		allPaletteCompartmentEntry.add(compartmentEntry);
		return compartmentEntry;
	}

	@Override
	public IPaletteCompartmentEntry[] getPalette() {
		List<IPaletteCompartmentEntry> ret = new ArrayList<IPaletteCompartmentEntry>();

		// add all create-features to the new stack-entry
		IFeatureProvider featureProvider = getFeatureProvider();
		ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
		for (ICreateFeature cf : createFeatures) {
			if (cf instanceof IPaletteEntry) {
				ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry(cf.getCreateName(),
						cf.getCreateDescription(), ((IPaletteEntry) cf).getIconId(), cf.getCreateLargeImageId(), cf);
				PaletteCompartmentEntry compartmentEntry = getPaletteCompartmentEntry(ret,
						((IPaletteEntry) cf).getLabel(), cf.getCreateImageId());
				compartmentEntry.addToolEntry(objectCreationToolEntry);
			}
		}

		// add all create-connection-features to the new stack-entry
		ICreateConnectionFeature[] createConnectionFeatures = featureProvider.getCreateConnectionFeatures();
		for (ICreateConnectionFeature cf : createConnectionFeatures) {
			if (cf instanceof IPaletteEntry) {
				ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry(
						cf.getCreateName(), cf.getCreateDescription(), ((IPaletteEntry) cf).getIconId(),
						cf.getCreateLargeImageId());
				connectionCreationToolEntry.addCreateConnectionFeature(cf);
				PaletteCompartmentEntry compartmentEntry = getPaletteCompartmentEntry(ret,
						((IPaletteEntry) cf).getLabel(), cf.getCreateImageId());
				compartmentEntry.addToolEntry(connectionCreationToolEntry);
			}
		}

		return ret.toArray(new IPaletteCompartmentEntry[ret.size()]);
	}

	@Override
	public IDecorator[] getDecorators(PictogramElement pe) {
		String diagramType = Graphiti.getPeService().getPropertyValue(pe, DiagramTypeConstants.Const_NodeType);
		if (diagramType != null) {
			BizFlowFeatureProvider featureProvider = (BizFlowFeatureProvider) getFeatureProvider();
			AbstractFeature addShapeFeature = featureProvider.getModelFeatures().get(diagramType);
			if (addShapeFeature != null && addShapeFeature instanceof IValidationSupport) {
				try {
					((IValidationSupport) addShapeFeature).validate(pe);
				} catch (ValidationException validationException) {
					String image = IPlatformImageConstants.IMG_ECLIPSE_ERROR_TSK;
					if (validationException.getType().equals(ExceptionType.Warn)) {
						image = IPlatformImageConstants.IMG_ECLIPSE_WARNING_TSK;
					}
					IDecorator imageRenderingDecorator = new ImageDecorator(image);
					imageRenderingDecorator.setMessage(validationException.getExceptionCause());
					return new IDecorator[] { imageRenderingDecorator };
				}
			}
		}

		return super.getDecorators(pe);
	}

	@Override
	public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {
		IContextButtonPadData data = super.getContextButtonPad(context);
		PictogramElement pe = context.getPictogramElement();

		setGenericContextButtons(data, pe, CONTEXT_BUTTON_DELETE | CONTEXT_BUTTON_UPDATE);

		CreateConnectionContext ccc = new CreateConnectionContext();
		ccc.setSourcePictogramElement(pe);
		Anchor anchor = null;
		if (pe instanceof Anchor) {
			anchor = (Anchor) pe;
		} else if (pe instanceof AnchorContainer) {
			anchor = Graphiti.getPeService().getChopboxAnchor((AnchorContainer) pe);
		}
		ccc.setSourceAnchor(anchor);

		ContextButtonEntry sequenceFlowButton = new ContextButtonEntry(null, context);
		sequenceFlowButton.setText("Sequence connection");
		sequenceFlowButton.setIconId(ImageProvider.ICON_LINK_FLOW);
		ContextButtonEntry conditionalFlowButton = new ContextButtonEntry(null, context);
		conditionalFlowButton.setText("Conditional connection");
		conditionalFlowButton.setIconId(ImageProvider.ICON_LINK_CONDITIONALFLOW);
		ICreateConnectionFeature[] features = getFeatureProvider().getCreateConnectionFeatures();
		for (ICreateConnectionFeature feature : features) {
			if (feature.isAvailable(ccc) && feature.canStartConnection(ccc))
				if (feature instanceof ConnectorCreateFeature) {
					sequenceFlowButton.addDragAndDropFeature(feature);
				} else if (feature instanceof ConditionalConnectorCreateFeature) {
					conditionalFlowButton.addDragAndDropFeature(feature);
				}
		}

		data.getDomainSpecificContextButtons().add(sequenceFlowButton);
		data.getDomainSpecificContextButtons().add(conditionalFlowButton);
		return data;
	}
}
