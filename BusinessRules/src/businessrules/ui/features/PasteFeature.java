package businessrules.ui.features;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.platform.IDiagramBehavior;
import org.eclipse.graphiti.ui.features.AbstractPasteFeature;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.thoughtworks.xstream.XStream;

import businessrules.ui.utils.DiagramTypeConstants;
import businessrules.ui.utils.WorkflowUtil;
import businessrules.ui.workflow.BizFlowFeatureProvider;
import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;
import businessrulesruntime.core.engine.IContext;
import businessrulesruntime.core.engine.ILink;
import businessrulesruntime.core.engine.IMessage;
import businessrulesruntime.core.engine.IStep;
import businessrulesruntime.core.engine.Links;

public class PasteFeature extends AbstractPasteFeature {

	private String bizflowName;

	public PasteFeature(IFeatureProvider fp) {
		super(fp);
		IDiagramBehavior diagramBehavior = fp.getDiagramTypeProvider().getDiagramBehavior();
		bizflowName = diagramBehavior.getDiagramContainer().getTitle();
	}

	public boolean canPaste(IPasteContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes.length != 1 || !(pes[0] instanceof Diagram)) {
			return false;
		}

		// can paste, if all objects on the clipboard are EClasses
		Clipboard clipboard = new Clipboard(Display.getCurrent());
		String fromClipboard = (String) clipboard.getContents(TextTransfer.getInstance());
		if (fromClipboard == null || fromClipboard.startsWith(CopyFeature.Const_ClipboardContentPrefix) == false) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public void paste(IPasteContext context) {
		XStream stream = new XStream();
		Clipboard clipboard = new Clipboard(Display.getCurrent());
		String clipboardText = (String) clipboard.getContents(TextTransfer.getInstance());
		clipboardText = clipboardText.replace(CopyFeature.Const_ClipboardContentPrefix, "");
		boolean appendCopyOf = false;
		try {
			Map<String, List<ClipboardContent>> objects = (Map<String, List<ClipboardContent>>) stream
					.fromXML(clipboardText);

			List<ClipboardContent> bizflow = objects.get(CopyFeature.Const_Bizflow);
			List<ClipboardContent> steps = objects.get(CopyFeature.Const_Steps);
			List<ClipboardContent> links = objects.get(CopyFeature.Const_Links);

			String copiedBizflowName = bizflow.get(0).getName();
			String pasteBizflowName = bizflowName;
			if (copiedBizflowName.equals(pasteBizflowName)) {
				appendCopyOf = true;
			}

			BizFlowFeatureProvider featureProvider = (BizFlowFeatureProvider) getFeatureProvider();
			ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
			ICreateConnectionFeature[] connectionFeatures = featureProvider.getCreateConnectionFeatures();

			for (ClipboardContent step : steps) {
				ICreateFeature createFeature = getCreateFeature(step.getType(), createFeatures);
				CreateContext cc = new CreateContext();
				cc.setTargetContainer(getDiagram());
				cc.setLocation(step.getX() + 10, step.getY() + 10);
				cc.setWidth(step.getWidth());
				cc.setHeight(step.getHeight());

				Object[] modelObjects = createFeature.create(cc);
				EBaseStep eBaseStep = (EBaseStep) modelObjects[0];
				eBaseStep.setStepInstance(step.getBusinessObject());
				WorkflowUtil
						.refreshPictogramElement(getDiagramBehavior().getEditingDomain(), eBaseStep, step.getName());

				if (appendCopyOf) {
					appendCopyOf(eBaseStep);
				}
			}

			for (ClipboardContent link : links) {
				CreateConnectionContext connectionContext = new CreateConnectionContext();
				ILink<IMessage, IContext> linkObject = (ILink<IMessage, IContext>) link.getBusinessObject();

				IStep<IMessage, IContext> sourceStep = getStep(steps, linkObject.getSourceStepId());
				IStep<IMessage, IContext> targetStep = getStep(steps, linkObject.getTargetStepId());

				PictogramElement sourcePictogramElement = getPictogramElement(sourceStep);
				PictogramElement targetPictogramElement = getPictogramElement(targetStep);
				if (sourcePictogramElement != null && targetPictogramElement != null) {
					connectionContext.setSourceAnchor((Anchor) sourcePictogramElement);
					connectionContext.setTargetAnchor((Anchor) targetPictogramElement);
					if (link.getType().equals(DiagramTypeConstants.Const_Connector)) {
						connectionFeatures[0].create(connectionContext);
					} else {
						Connection connection = connectionFeatures[1].create(connectionContext);
						EBaseStep eBaseStep = (EBaseStep) connection.getLink().getBusinessObjects().get(0);
						eBaseStep.setStepInstance(linkObject);
						updatePictogramElement(connection);

						if (appendCopyOf) {
							appendCopyOf(eBaseStep);
						}
					}
				}
			}
		} catch (Exception exception) {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			MessageDialog.openError(shell, "Error", "Copied content is not proper.");
		}
	}

	@SuppressWarnings("rawtypes")
	private void appendCopyOf(EBaseStep eBaseStep) {
		String name = "Copy_Of_" + eBaseStep.getName();
		eBaseStep.setName(name);
		IStep newStep = (IStep) eBaseStep.getStepInstance();
		newStep.setName(name);
		newStep.setDisplayName("Copy_Of_" + name);
	}

	@SuppressWarnings("unchecked")
	private IStep<IMessage, IContext> getStep(List<ClipboardContent> steps, String name) {
		IStep<IMessage, IContext> stepInstance = null;
		for (ClipboardContent step : steps) {
			if (step.getName().equals(name)) {
				stepInstance = (IStep<IMessage, IContext>) step.getBusinessObject();
				stepInstance.setIncomingLinks(new Links<IMessage, IContext>());
				stepInstance.setOutgoingLinks(new Links<IMessage, IContext>());
				break;
			}
		}
		return stepInstance;
	}

	@SuppressWarnings("unchecked")
	private PictogramElement getPictogramElement(IStep<IMessage, IContext> step) {
		EList<Shape> shapes = getDiagram().getChildren();

		for (Shape shape : shapes) {
			EList<EObject> businessObjects = shape.getLink().getBusinessObjects();
			EBaseStep object = (EBaseStep) businessObjects.get(0);
			IStep<IMessage, IContext> stepInstance = (IStep<IMessage, IContext>) object.getStepInstance();

			if (stepInstance.equals(step)) {
				return shape.getAnchors().get(0);
			}
		}

		return null;
	}

	private ICreateFeature getCreateFeature(String type, ICreateFeature[] createFeatures) {
		if (type.equals(DiagramTypeConstants.const_StartEvent)) {
			return createFeatures[0];
		} else if (type.equals(DiagramTypeConstants.const_StopEvent)) {
			return createFeatures[1];
		} else if (type.equals(DiagramTypeConstants.Const_Decision_BussinessAction)) {
			return createFeatures[2];
		} else if (type.equals(DiagramTypeConstants.Const_Activity_BussinessAction)) {
			return createFeatures[3];
		} else if (type.equals(DiagramTypeConstants.Const_BusinessRule_BussinessAction)) {
			return createFeatures[5];
		}
		return null;
	}
}