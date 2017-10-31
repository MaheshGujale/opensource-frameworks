package businessrules.ui.features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IDiagramBehavior;
import org.eclipse.graphiti.ui.features.AbstractCopyFeature;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;

import com.thoughtworks.xstream.XStream;

import businessrules.ui.utils.DiagramTypeConstants;
import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;

public class CopyFeature extends AbstractCopyFeature {
	public static final String Const_ClipboardContentPrefix = "$$$BIZFLOW$$$";
	public static final String Const_Bizflow = "bizflow";
	public static final String Const_Steps = "steps";
	public static final String Const_Links = "links";
	private String bizflowName;

	public CopyFeature(IFeatureProvider fp) {
		super(fp);
		IDiagramBehavior diagramBehavior =fp.getDiagramTypeProvider().getDiagramBehavior();
		bizflowName = diagramBehavior.getDiagramContainer().getTitle();
	}

	public boolean canCopy(ICopyContext context) {
		final PictogramElement[] pes = context.getPictogramElements();
		if (pes == null || pes.length == 0) { // nothing selected
			return false;
		}

		// return true, if all selected elements are a EClasses
		for (PictogramElement pe : pes) {
			final Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof EBaseStep) {
				return true;
			}
		}
		return false;
	}

	public void copy(ICopyContext context) {
		// get the business-objects for all pictogram-elements
		// we already verified, that all business-objets are EClasses
		PictogramElement[] pes = context.getPictogramElements();
		Object[] bos = new Object[pes.length];

		XStream stream = new XStream();
		Clipboard clipboard = new Clipboard(Display.getCurrent());
		Map<String, List<ClipboardContent>> objects = new HashMap<String, List<ClipboardContent>>();

		List<ClipboardContent> steps = new ArrayList<ClipboardContent>();
		List<ClipboardContent> links = new ArrayList<ClipboardContent>();
		for (int i = 0; i < pes.length; i++) {
			PictogramElement pe = pes[i];
			bos[i] = getBusinessObjectForPictogramElement(pe);
			EBaseStep baseStep = (EBaseStep) bos[i];

			if (baseStep.getDiagramType().equals(DiagramTypeConstants.Const_Connector)
					|| baseStep.getDiagramType().equals(DiagramTypeConstants.Const_ConditionalConnector)) {
				links.add(new ClipboardContent(baseStep.getName(), pe.getGraphicsAlgorithm().getX(), pe
						.getGraphicsAlgorithm().getY(), pe.getGraphicsAlgorithm().getWidth(), pe.getGraphicsAlgorithm()
						.getHeight(), baseStep.getDiagramType(), baseStep.getStepInstance()));
			} else {
				steps.add(new ClipboardContent(baseStep.getName(), pe.getGraphicsAlgorithm().getX(), pe
						.getGraphicsAlgorithm().getY(), pe.getGraphicsAlgorithm().getWidth(), pe.getGraphicsAlgorithm()
						.getHeight(), baseStep.getDiagramType(), baseStep.getStepInstance()));
			}
		}
		objects.put(Const_Steps, steps);
		objects.put(Const_Links, links);
		List<ClipboardContent> bizflow = new ArrayList<ClipboardContent>();
		bizflow.add(new ClipboardContent(bizflowName, 0, 0, 0, 0, bizflowName, bizflowName));
		objects.put(Const_Bizflow, bizflow);

		// put all business objects to the clipboard
		clipboard.setContents(new Object[] { Const_ClipboardContentPrefix + stream.toXML(objects) },
				new Transfer[] { TextTransfer.getInstance() });
	}
}