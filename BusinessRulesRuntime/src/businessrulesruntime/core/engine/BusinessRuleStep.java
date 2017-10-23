package businessrulesruntime.core.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import businessrulesruntime.core.engine.util.CodeExecutor;

public class BusinessRuleStep<mT extends IMessage, cT extends IContext> extends AbstractStep<mT, cT> {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(BusinessRuleStep.class);

	protected Map<String, List<BusinessRuleInfo<mT, cT>>> businessRuleInfos;
	private Map<String, List<CodeExecutor>> codeExecutors;

	public BusinessRuleStep(String workflowName, String name) {
		super(workflowName, name);
	}

	public BusinessRuleStep(String workflowName, String name, String displayName) {
		super(workflowName, name, displayName);
	}

	public BusinessRuleStep(String workflowName, String name, String displayName, String description) {
		super(workflowName, name, displayName, description);
	}

	@Override
	public Object doExecute(mT message, cT context) {
		if (businessRuleInfos != null) {
			try {
				if (codeExecutors == null) {
					loadCodeExecutors();
				}

				Iterator<Entry<String, List<CodeExecutor>>> iterator = codeExecutors.entrySet().iterator();

				while (iterator.hasNext()) {
					List<CodeExecutor> codeExecutorList = iterator.next().getValue();

					for (CodeExecutor codeExecutor : codeExecutorList) {
						Object returnValue = executeRule(codeExecutor, message, context);
						if ((returnValue instanceof Boolean && (Boolean) returnValue)
								|| (returnValue instanceof Integer && ((Integer) returnValue).equals(new Integer(1)))) {
							continue;
						} else {
							return false;
						}
					}
				}
			} catch (Exception e) {
				logger.error(e);
			}
			return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	public Object executeRule(CodeExecutor codeExecutor, mT message, cT context) throws Exception {
		List<FieldInfo> parameterInfos = codeExecutor.getCodeDetail().getMethodInfo().getParametersInfo();
		List<Object> arguments = new ArrayList<Object>();
		for (FieldInfo fieldInfo : parameterInfos) {
			InjectInfo injectInfo = fieldInfo.getInjectInfo();
		}

		return codeExecutor.execute(arguments.toArray());
	}

	private synchronized void loadCodeExecutors() throws SecurityException, ClassNotFoundException,
			NoSuchMethodException, InstantiationException, IllegalAccessException {
		if (codeExecutors != null) {
			return;
		}

		codeExecutors = new LinkedHashMap<String, List<CodeExecutor>>();
		Iterator<Entry<String, List<BusinessRuleInfo<mT, cT>>>> iterator = businessRuleInfos.entrySet().iterator();

		List<CodeExecutor> codeExecutorList;
		CodeExecutor codeExecutor;
		while (iterator.hasNext()) {
			Entry<String, List<BusinessRuleInfo<mT, cT>>> entry = iterator.next();
			List<BusinessRuleInfo<mT, cT>> businessRuleInfos = entry.getValue();
			codeExecutorList = new ArrayList<CodeExecutor>();
			for (BusinessRuleInfo<mT, cT> businessRuleInfo : businessRuleInfos) {
				codeExecutor = new CodeExecutor(getName(), businessRuleInfo.getCodeDetail());
				codeExecutorList.add(codeExecutor);
			}
			codeExecutors.put(entry.getKey(), codeExecutorList);
		}
	}

	@Override
	public List<ValidationException> validate() {
		List<ValidationException> validationInfos = new ArrayList<ValidationException>();
		ValidationException validationInfo;
		if (businessRuleInfos == null) {
			validationInfo = new ValidationException(ExceptionType.Error, getDescription(),
					getDisplayName() + " is not defined");
			validationInfos.add(validationInfo);
			return validationInfos;
		}
		Iterator<Entry<String, List<BusinessRuleInfo<mT, cT>>>> iterator = businessRuleInfos.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, List<BusinessRuleInfo<mT, cT>>> entry = iterator.next();
			List<BusinessRuleInfo<mT, cT>> businessRulelList = entry.getValue();
			for (BusinessRuleInfo<mT, cT> businessRuleInfo : businessRulelList) {
				CodeDetail codeDetail = businessRuleInfo.getCodeDetail();
				if (codeDetail.getExcelFormula() == null || codeDetail.getExcelFormula().equals("")) {
					validationInfo = new ValidationException(ExceptionType.Error, getDescription(),
							"Formula is not given in excel code " + businessRuleInfo.getDisplayName());
					validationInfos.add(validationInfo);
				}
				List<FieldInfo> parameterInfos = businessRuleInfo.getParameterInfos();
				for (FieldInfo fieldInfo : parameterInfos) {
					if (fieldInfo.getInjectInfo() == null || fieldInfo.getInjectText().equals("")) {
						validationInfo = new ValidationException(ExceptionType.Error, getDescription(),
								"Inject information is not given for Parameter-\"" + fieldInfo.getName()
										+ "\" in Rule-\"" + businessRuleInfo.getDisplayName() + "\" where Category-\""
										+ entry.getKey() + "\"");
						validationInfos.add(validationInfo);
					}
				}
			}
		}
		return validationInfos;
	}

	public Map<String, List<BusinessRuleInfo<mT, cT>>> getBusinessRuleInfos() {
		return businessRuleInfos;
	}

	public void setBusinessRuleInfos(Map<String, List<BusinessRuleInfo<mT, cT>>> businessRuleInfos) {
		this.businessRuleInfos = businessRuleInfos;
	}

	@Override
	public int getType() {
		return TypeConstants.BusinessRuleStep;
	}
}
