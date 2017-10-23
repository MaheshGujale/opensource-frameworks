package businessrulesruntime.core.engine;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import businessrulesruntime.core.engine.util.CodeExecutor;

public class ConditionalLink<mT extends IMessage, cT extends IContext> extends AbstractLink<mT, cT> {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ConditionalLink.class);

	protected CodeDetail codeDetail;
	private int priority;
	private transient CodeExecutor codeExecutor;

	public ConditionalLink(String workflowName, String name) {
		super(workflowName, name);
	}

	public ConditionalLink(String workflowName, String name, String displayName) {
		super(workflowName, name, displayName);
	}

	public ConditionalLink(String workflowName, String name, String displayName, String description) {
		super(workflowName, name, displayName, description);
	}

	public CodeDetail getCodeDetail() {
		return codeDetail;
	}

	public void setCodeDetail(CodeDetail codeDetail) {
		this.codeDetail = codeDetail;
	}

	@Override
	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean doExecute(mT message, cT context) {
		try {
			if (codeExecutor == null) {
				loadCodeExecutor();
			}
			List<FieldInfo> parameterInfos = getParameterInfos();
			List<Object> arguments = new ArrayList<Object>();
			for (FieldInfo fieldInfo : parameterInfos) {
				InjectInfo injectInfo = fieldInfo.getInjectInfo();
			}

			Object returnValue = codeExecutor.execute(arguments.toArray());
			if ((returnValue instanceof Boolean)) {
				return (Boolean) returnValue;
			} else if (returnValue instanceof Integer && ((Integer) returnValue).equals(new Integer(1))) {
				return true;
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
		return false;
	}

	private synchronized void loadCodeExecutor() throws SecurityException, ClassNotFoundException,
			NoSuchMethodException, InstantiationException, IllegalAccessException {
		if (codeExecutor != null) {
			return;
		}

		codeExecutor = new CodeExecutor(getName(), codeDetail);
	}

	@Override
	public List<ValidationException> doValidate() {
		List<ValidationException> validationInfos = new ArrayList<ValidationException>();
		ValidationException validationInfo;

		if (codeDetail == null) {
			validationInfo = new ValidationException(ExceptionType.Error, getDescription(),
					"Conditional link is not defined");
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
							"Inject information is not given for " + fieldInfo.getName()));
				}
			}
		}
		return validationInfos;
	}

	@Override
	public int getType() {
		return TypeConstants.ConditionalConnector;
	}
}