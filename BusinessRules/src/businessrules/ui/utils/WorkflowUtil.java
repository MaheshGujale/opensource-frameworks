package businessrules.ui.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;

import com.thoughtworks.xstream.XStream;

import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;
import businessrulesruntime.core.engine.ActivityStep;
import businessrulesruntime.core.engine.BizflowContent;
import businessrulesruntime.core.engine.BizflowModel;
import businessrulesruntime.core.engine.BusinessRuleInfo;
import businessrulesruntime.core.engine.BusinessRuleStep;
import businessrulesruntime.core.engine.CodeDetail;
import businessrulesruntime.core.engine.ConditionalLink;
import businessrulesruntime.core.engine.DecisionStep;
import businessrulesruntime.core.engine.FieldInfo;
import businessrulesruntime.core.engine.ILink;
import businessrulesruntime.core.engine.IStep;
import businessrulesruntime.core.engine.Links;
import businessrulesruntime.core.engine.SequenceLink;
import businessrulesruntime.core.engine.StartStep;
import businessrulesruntime.core.engine.util.FileUtil;

@SuppressWarnings("rawtypes")
public class WorkflowUtil {
	private final static String Const_Link_Prefix = "link_";
	private final static String Const_Step_Prefix = "step_";
	private static final String Const_backSlash = "\\";
	private static final String Const_forwardSlash = "/";

	private static int linkCounter = 0;
	private static int stepCounter = 0;

	public static String generateLinkName() {
		linkCounter++;
		return Const_Link_Prefix + System.currentTimeMillis() + "_" + linkCounter;
	}

	public static String generateStepName() {
		stepCounter++;
		return Const_Step_Prefix + System.currentTimeMillis() + "_" + stepCounter;
	}

	public static boolean validateStepName(Diagram diagram, String name, Shape shapeToValidate) {
		Object currentStepObject = shapeToValidate.getLink().getBusinessObjects().get(0);
		for (Shape shape : diagram.getChildren()) {
			Object businessObject = shape.getLink().getBusinessObjects().get(0);
			if (businessObject == currentStepObject) {
				continue;
			}
			EBaseStep eBaseStep = (EBaseStep) businessObject;
			if (eBaseStep.getStepInstance() instanceof IStep) {
				String currentStepName = eBaseStep.getName().trim();
				if (currentStepName.equals(name)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean validateLinkName(Diagram diagram, String name, Connection connectionToValidate) {
		for (Connection connection : diagram.getConnections()) {
			if (connectionToValidate == connection) {
				continue;
			}
			Object businessObject = connection.getLink().getBusinessObjects().get(0);
			EBaseStep eBaseStep = (EBaseStep) businessObject;
			if (eBaseStep.getStepInstance() instanceof ILink) {
				String currentLinkName = ((ILink) eBaseStep.getStepInstance()).getName();
				if (currentLinkName.equals(name)) {
					return true;
				}
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public static BizflowModel getDiagramModels(Diagram diagram) {
		List<Shape> shapes = diagram.getChildren();

		BizflowModel bizflowModel = new BizflowModel();
		Map<String, IStep> steps = new HashMap<String, IStep>();
		Map<String, ILink> links = new HashMap<String, ILink>();

		// ..Updating Steps
		for (Shape shape : shapes) {
			EList<EObject> businessObjects = shape.getLink().getBusinessObjects();
			if (businessObjects == null || businessObjects.size() == 0) {
				continue;
			}

			EObject businessObject = businessObjects.get(0);
			if (businessObject instanceof EBaseStep == false) {
				continue;
			}

			EBaseStep nodeModel = (EBaseStep) businessObject;
			Object model = nodeModel.getStepInstance();
			if (model != null && model instanceof IStep) {
				IStep step = (IStep) model;

				// ..Clearing all incoming & outgoing links
				step.setIncomingLinks(new Links());
				step.setOutgoingLinks(new Links());

				step.setName(nodeModel.getName());

				steps.put(nodeModel.getName(), step);
			}
		}

		// ..Updating Connectors
		EList<Connection> connections = diagram.getConnections();
		for (Connection connection : connections) {

			EList<EObject> businessObjects = connection.getLink().getBusinessObjects();
			if (businessObjects == null || businessObjects.size() == 0) {
				continue;
			}

			EObject businessObject = businessObjects.get(0);
			if (businessObject instanceof EBaseStep == false) {
				continue;
			}

			EBaseStep nodeModel = (EBaseStep) businessObject;
			Object model = nodeModel.getStepInstance();

			EBaseStep sourceModel = (EBaseStep) connection.getStart().getParent().getLink().getBusinessObjects().get(0);
			EBaseStep targetModel = (EBaseStep) connection.getEnd().getParent().getLink().getBusinessObjects().get(0);

			if (model != null && model instanceof ILink) {
				ILink link = (ILink) model;

				link.setSource((IStep) steps.get(sourceModel.getName()));
				link.setTarget((IStep) steps.get(targetModel.getName()));
				link.setName(sourceModel.getName() + "_" + targetModel.getName());

				try {
					nodeModel.setName(link.getName());
				} catch (IllegalStateException ex) {
				}
				links.put(link.getName(), link);
			}
		}

		bizflowModel.setSteps(steps);
		bizflowModel.setLinks(links);
		return bizflowModel;
	}

	@SuppressWarnings("unchecked")
	public static void setDiagramModels(BizflowModel bizflowModel, Diagram diagram) {
		Map<String, IStep> steps = bizflowModel.getSteps();
		Map<String, ILink> links = bizflowModel.getLinks();

		// ..Updating Connectors
		EList<Connection> connections = diagram.getConnections();
		for (Connection connection : connections) {

			EList<EObject> businessObjects = connection.getLink().getBusinessObjects();
			if (businessObjects == null || businessObjects.size() == 0) {
				continue;
			}

			EObject businessObject = businessObjects.get(0);
			if (businessObject instanceof EBaseStep == false) {
				continue;
			}

			EBaseStep nodeModel = (EBaseStep) businessObject;
			try {
				nodeModel.setStepInstance(links.get(nodeModel.getName()));
			} catch (IllegalStateException ex) {
			}
		}

		List<Shape> shapes = diagram.getChildren();

		// ..Updating Steps
		for (Shape shape : shapes) {
			EList<EObject> businessObjects = shape.getLink().getBusinessObjects();
			if (businessObjects == null || businessObjects.size() == 0) {
				continue;
			}

			EObject businessObject = businessObjects.get(0);
			if (businessObject instanceof EBaseStep == false) {
				continue;
			}

			EBaseStep nodeModel = (EBaseStep) businessObject;
			try {
				IStep step = steps.get(nodeModel.getName());
				if (step != null) {
					step.setIncomingLinks(new Links());
					step.setOutgoingLinks(new Links());
					nodeModel.setStepInstance(step);
				}
			} catch (IllegalStateException ex) {
			}
		}

		for (ILink link : links.values()) {
			link.setSource(steps.get(link.getSourceStepId()));
			link.setTarget(steps.get(link.getTargetStepId()));
		}

	}

	public static IStep getStartStep(Diagram diagram) {
		IStep startStep = null;
		List<Shape> shapes = diagram.getChildren();

		// ..Updating Steps
		for (Shape shape : shapes) {
			EList<EObject> businessObjects = shape.getLink().getBusinessObjects();
			if (businessObjects == null || businessObjects.size() == 0) {
				continue;
			}

			EObject businessObject = businessObjects.get(0);
			if (businessObject instanceof EBaseStep == false) {
				continue;
			}

			EBaseStep nodeModel = (EBaseStep) businessObject;
			Object model = nodeModel.getStepInstance();
			if (model != null && model instanceof IStep) {
				IStep step = (IStep) model;
				if (step instanceof StartStep) {
					startStep = step;
				}
			}
		}
		if (startStep == null) {
			return null;
		}

		return startStep;
	}

	public static void refreshPictogramElement(TransactionalEditingDomain transactionalEditingDomain,
			final EBaseStep baseStep, final String name) {
		transactionalEditingDomain.getCommandStack().execute(new AbstractCommand() {

			@Override
			public void redo() {
			}

			@Override
			public boolean canExecute() {
				return true;
			}

			@Override
			public void execute() {
				baseStep.setName(name);
			}
		});
	}
	
	public static void refreshPictogramElement(TransactionalEditingDomain transactionalEditingDomain,
			final Diagram diagram, final String name) {
		transactionalEditingDomain.getCommandStack().execute(new AbstractCommand() {

			@Override
			public void redo() {
			}

			@Override
			public boolean canExecute() {
				return true;
			}

			@Override
			public void execute() {
				diagram.setName(name);
			}
		});
	}

	public static Collection<File> getModelPathInfo(File searchDirectory, boolean isRecursive) {
		File searchAbsolutePath = new File(searchDirectory.getAbsolutePath());
		return FileUtils.listFiles(searchAbsolutePath, new String[] { "bizflow" }, isRecursive);
	}

	@SuppressWarnings("unchecked")
	private static IStep linkSteps(BizflowModel bizflowModel) {
		Map<String, IStep> steps = bizflowModel.getSteps();
		Map<String, ILink> links = bizflowModel.getLinks();

		IStep startStep = null;
		for (IStep step : steps.values()) {
			step.setIncomingLinks(new Links());
			step.setOutgoingLinks(new Links());

			if (step instanceof StartStep) {
				startStep = step;
			}
		}

		for (ILink link : links.values()) {
			link.setSource(steps.get(link.getSourceStepId()));
			link.setTarget(steps.get(link.getTargetStepId()));
		}

		for (IStep step : steps.values()) {
			step.getOutgoingLinks().sort();
		}

		return startStep;
	}

	public static String convertToRelativeBizflowPath(String baseModelPath, String modelFileName) {
		String absoluteBaseModelPathFile = new File(baseModelPath).getAbsolutePath();
		String absoluteModelFileName = new File(modelFileName).getAbsolutePath();

		String modelRelativePath = absoluteModelFileName.substring(absoluteBaseModelPathFile.length() + 1);
		modelRelativePath = modelRelativePath.replace(Const_backSlash, Const_forwardSlash);
		return modelRelativePath;
	}

	public static BizflowModel deserializeWorkflow(File modelFile) throws FileNotFoundException {
		BizflowContent bizflowContent = FileUtil.readFromFile(modelFile);
		InputStream inputStream = IOUtils.toInputStream(bizflowContent.getBizflowModel());
		BizflowModel models = (BizflowModel) getXStream().fromXML(inputStream);

		linkSteps(models);
		return models;
	}

	private static XStream getXStream() {
		XStream stream = new XStream();
		stream.alias("BizflowModel", BizflowModel.class);
		stream.alias("StartStep", StartStep.class);
		stream.alias("DecisionStep", DecisionStep.class);
		stream.alias("ActivityStep", ActivityStep.class);
		stream.alias("BusinessRuleStep", BusinessRuleStep.class);

		stream.alias("SequenceLink", SequenceLink.class);
		stream.alias("ConditionalLink", ConditionalLink.class);

		stream.alias("BusinessRuleInfo", BusinessRuleInfo.class);
		stream.alias("FieldInfo", FieldInfo.class);
		//stream.alias("Message", Message.class);
		stream.alias("CodeDetail", CodeDetail.class);

		return stream;
	}
	
}