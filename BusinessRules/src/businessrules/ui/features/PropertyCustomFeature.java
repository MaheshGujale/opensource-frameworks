package businessrules.ui.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import businessrules.ui.workflow.BizFlowFeatureProvider;

public class PropertyCustomFeature extends AbstractCustomFeature {

	public PropertyCustomFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getName() {
		return "Properties...";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		IDoubleClickSupport doubleClickSupport = getDoubleClickSupportInstance(context);
		if (doubleClickSupport == null) {
			return;
		}

		doubleClickSupport.onDoubleClick(context);
	}

	private IDoubleClickSupport getDoubleClickSupportInstance(IContext context) {
		if (context instanceof CustomContext == false) {
			return null;
		}

		CustomContext customContext = (CustomContext) context;
		PictogramElement[] pes = customContext.getPictogramElements();
		if (pes == null || pes.length == 0) {
			return null;
		}

		if (pes[0].getProperties().size() == 0) {
			return null;
		}

		Property property = pes[0].getProperties().get(0);
		if (property == null) {
			return null;
		}

		BizFlowFeatureProvider featureProvider = (BizFlowFeatureProvider) getFeatureProvider();
		AbstractFeature addShapeFeature = featureProvider.getModelFeatures().get(property.getValue());
		if (addShapeFeature != null && addShapeFeature instanceof IDoubleClickSupport) {
			return (IDoubleClickSupport) addShapeFeature;
		}

		return null;
	}

	@Override
	public boolean isAvailable(IContext context) {
		return (getDoubleClickSupportInstance(context) != null);
	}

}
