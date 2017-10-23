package businessrulesruntime.core.engine;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import businessrulesruntime.core.engine.util.CodeExecutor;

public class ActivityStep<mT extends IMessage, cT extends IContext> extends AbstractStep<mT, cT> {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ActivityStep.class);

	protected CodeDetail codeDetail;
	private transient CodeExecutor codeExecutor;

	public ActivityStep(String workflowName, String name) {
		super(workflowName, name);
	}

	public ActivityStep(String workflowName, String name, String displayName) {
		super(workflowName, name, displayName);
	}

	public ActivityStep(String workflowName, String name, String displayName, String description) {
		super(workflowName, name, displayName, description);
	}

	@SuppressWarnings("unused")
	@Override
	public Object doExecute(mT message, cT context) {
		if (codeDetail != null) {
			try {
				if (codeExecutor == null) {
					loadCodeExecutor();
				}

				List<FieldInfo> parameterInfos = codeDetail.getMethodInfo().getParametersInfo();
				List<Object> arguments = new ArrayList<Object>();
				for (FieldInfo fieldInfo : parameterInfos) {
					InjectInfo injectInfo = fieldInfo.getInjectInfo();
					// arguments.add(ProviderUtil.getValue(injectInfo, message,
					// context, params));
				}

				return codeExecutor.execute(arguments.toArray());
			} catch (Exception ex) {
				logger.error(ex);
			}
		}
		return null;
	}

	private synchronized void loadCodeExecutor() throws SecurityException, ClassNotFoundException,
			NoSuchMethodException, InstantiationException, IllegalAccessException {
		if (codeExecutor != null) {
			return;
		}

		codeExecutor = new CodeExecutor(getName(), codeDetail);
	}

	@Override
	public List<ValidationException> validate() {
		List<ValidationException> validationInfos = new ArrayList<ValidationException>();
		ValidationException validationInfo;
		if (codeDetail == null) {
			validationInfo = new ValidationException(ExceptionType.Error, getDescription(), "Activity is not defined");
			validationInfos.add(validationInfo);
		} else {
			if (codeDetail.getExcelFormula() == null || codeDetail.getExcelFormula().equals("")) {
				validationInfo = new ValidationException(ExceptionType.Error, getDescription(),
						"Formula is not given in excel code");
				validationInfos.add(validationInfo);
			}
			List<FieldInfo> parameterInfos = getParameterInfos();
			for (FieldInfo fieldInfo : parameterInfos) {
				if (fieldInfo.getInjectInfo() == null || fieldInfo.getInjectText().equals("")) {
					validationInfos.add(new ValidationException(ExceptionType.Error, getDescription(),
							"Inject information is not given for Parameter-\"" + fieldInfo.getName() + "\""));
				}
			}
		}
		return validationInfos;
	}

	public CodeDetail getCodeDetail() {
		return codeDetail;
	}

	public void setCodeDetail(CodeDetail codeDetail) {
		this.codeDetail = codeDetail;
	}

	@Override
	public int getType() {
		return TypeConstants.ActivityStep;
	}
}
