package businessrules.ui.features.businessrule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import businessrules.ui.features.IDoubleClickSupport;
import businessrules.ui.features.IValidationSupport;
import businessrules.ui.utils.DiagramTypeConstants;
import businessrules.ui.utils.StyleUtil;
import businessrules.ui.utils.WorkflowUtil;
import businessrules.ui.workflow.BizFlowFeatureProvider;
import businessrules.ui.workflow.ImageProvider;
import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;
import businessrulesruntime.core.engine.BusinessRuleInfo;
import businessrulesruntime.core.engine.BusinessRuleStep;
import businessrulesruntime.core.engine.CodeDetail;
import businessrulesruntime.core.engine.ExceptionType;
import businessrulesruntime.core.engine.IStep;
import businessrulesruntime.core.engine.ValidationException;
import businessrulesruntime.core.script.JavaScriptHandler;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BusinessRuleAddShapeFeature extends AbstractAddShapeFeature
		implements IDoubleClickSupport, IValidationSupport {

	private static final IColorConstant CLASS_TEXT_FOREGROUND = new ColorConstant(51, 51, 153);
	private String stepName = "BusinessRule";
	private String stepDescription = "BusinessRule";

	public BusinessRuleAddShapeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		if (context.getNewObject() instanceof EBaseStep) {
			if (context.getTargetContainer() instanceof Diagram) {
				return true;
			}
		}

		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		EBaseStep model = (EBaseStep) context.getNewObject();
		Diagram targetDiagram = (Diagram) context.getTargetContainer();

		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);

		int width = context.getWidth() <= 0 ? 100 : context.getWidth();
		int height = context.getHeight() <= 0 ? 50 : context.getHeight();

		IGaService gaService = Graphiti.getGaService();
		RoundedRectangle roundedRectangle;
		{
			// create and set graphics algorithm
			roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
			StyleUtil.applyBGStyle(roundedRectangle, this);
			gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), width, height);

			IGaService service = Graphiti.getGaService();
			Image img = service.createImage(roundedRectangle, ImageProvider.ICON_STEP_BUSINESSRULE);
			service.setLocationAndSize(img, 4, 2, 16, 16);

			// if added Class has no resource we add it to the resource
			// of the diagram
			// in a real scenario the business model would have its own resource
			if (model.eResource() == null) {
				getDiagram().eResource().getContents().add(model);
			}

			Graphiti.getPeService().setPropertyValue(containerShape, DiagramTypeConstants.Const_NodeType,
					DiagramTypeConstants.Const_BusinessRule_BussinessAction);
			if (model.getStepInstance() == null) {
				IStep step = new BusinessRuleStep(stepName, stepName, stepName, stepDescription);
				model.setName(stepName);
				model.setStepInstance(step);
			}

			// create link and wire it
			link(containerShape, model);
		}

		{
			// create shape for text
			Shape shape = peCreateService.createShape(containerShape, false);

			// create and set text graphics algorithm
			Text text = gaService.createDefaultText(getDiagram(), shape, stepName);
			text.setForeground(manageColor(CLASS_TEXT_FOREGROUND));
			text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
			gaService.setLocationAndSize(text, 0, 0, width, height);

			// create link and wire it
			link(shape, model);

			// provide information to support direct-editing directly
			// after object creation (must be activated additionally)
			IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
			// set container shape for direct editing after object creation
			directEditingInfo.setMainPictogramElement(containerShape);

			// set shape and graphics algorithm where the editor for
			// direct editing shall be opened after object creation
			directEditingInfo.setPictogramElement(shape);
			directEditingInfo.setGraphicsAlgorithm(text);
		}

		// add a chopbox anchor to the shape
		peCreateService.createChopboxAnchor(containerShape);

		// call the layout feature
		layoutPictogramElement(containerShape);

		return containerShape;
	}

	@Override
	public void onDoubleClick(ICustomContext context) {
		PictogramElement[] pictogramElements = context.getPictogramElements();
		if (pictogramElements == null || pictogramElements.length == 0) {
			return;
		}

		Object businessObject = getBusinessObjectForPictogramElement(pictogramElements[0]);
		EBaseStep eBaseStep = (EBaseStep) businessObject;

		BusinessRuleStep businessRulestep = (BusinessRuleStep) eBaseStep.getStepInstance();
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		BizFlowFeatureProvider featureProvider = (BizFlowFeatureProvider) getFeatureProvider();

		BusinessRulePropertyDialog dialog = new BusinessRulePropertyDialog(shell, eBaseStep.getName(),
				businessRulestep.getDisplayName(), businessRulestep.getDescription(),
				businessRulestep.getParameterInfos(), businessRulestep.isHandleException(), getDiagram(),
				(Shape) pictogramElements[0], featureProvider.getGroupName());
		dialog.setBusinessRuleInfos(businessRulestep.getBusinessRuleInfos());

		int returnCode = dialog.open();
		if (returnCode == Window.OK) {
			businessRulestep.setDisplayName(dialog.getStepDisplayName());
			businessRulestep.setDescription(dialog.getStepDescription());
			businessRulestep.setParameterInfos(dialog.getParameterInfo());
			businessRulestep.setBusinessRuleInfos(dialog.getBusinessRuleInfos());

			WorkflowUtil.refreshPictogramElement(getDiagramBehavior().getEditingDomain(), eBaseStep,
					dialog.getStepName());
			getDiagramBehavior().refreshRenderingDecorators(pictogramElements[0]);
		} else if (returnCode == Window.CANCEL) {
			businessRulestep.setBusinessRuleInfos(dialog.getBusinessRuleInfos());
		}
	}

	@Override
	public void validate(PictogramElement pictogramElement) throws ValidationException {
		EList<EObject> businessObjects = pictogramElement.getLink().getBusinessObjects();
		if (businessObjects == null || businessObjects.size() == 0) {
			return;
		}

		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		EBaseStep eBaseStep = (EBaseStep) businessObject;
		BusinessRuleStep businessRuleStep = (BusinessRuleStep) eBaseStep.getStepInstance();

		validate(businessRuleStep);
	}

	@Override
	public void validate(IStep step) throws ValidationException {
		BusinessRuleStep bStep = (BusinessRuleStep) step;
		Map<String, List<BusinessRuleInfo>> businessRuleInfos = bStep.getBusinessRuleInfos();
		if (businessRuleInfos == null) {
			throw new ValidationException(ExceptionType.Error, bStep.getDescription(), "BusinessRule is not defined");
		}

		JavaScriptHandler javaScriptHandler = JavaScriptHandler.get();

		Iterator<Entry<String, List<BusinessRuleInfo>>> iterator = businessRuleInfos.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, List<BusinessRuleInfo>> entry = iterator.next();
			List<BusinessRuleInfo> businessRulelList = entry.getValue();
			for (BusinessRuleInfo businessRuleInfo : businessRulelList) {
				CodeDetail codeDetail = businessRuleInfo.getCodeDetail();
				if (codeDetail.getExcelFormula() == null || codeDetail.getExcelFormula().equals("")) {
					throw new ValidationException(ExceptionType.Error, businessRuleInfo.getDescription(),
							"Excel formula is not given in " + businessRuleInfo.getDisplayName());
				}
				String javaCode = codeDetail.getJavaCode().replace("${className}", "ExcelJavaCode");
				List<String> allClassPaths = new ArrayList<>();
				String ruleName = businessRuleInfo.getName();
				javaScriptHandler.loadClass(Character.toUpperCase(ruleName.charAt(0)) + ruleName.substring(1), javaCode,
						true, allClassPaths);
			}

		}
	}
}