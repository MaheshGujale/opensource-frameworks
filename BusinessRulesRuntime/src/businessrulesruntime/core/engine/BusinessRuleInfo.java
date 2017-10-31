package businessrulesruntime.core.engine;

import java.util.ArrayList;
import java.util.List;


public class BusinessRuleInfo<mT extends IMessage, cT extends IContext> extends AbstractStep<mT, cT> {

	private static final long serialVersionUID = 1L;

	protected CodeDetail codeDetail;

	public BusinessRuleInfo(String name, String displayName, String description) {
		super(name, name, displayName, description);
	}

	public CodeDetail getCodeDetail() {
		return codeDetail;
	}

	public void setCodeDetail(CodeDetail codeInfo) {
		this.codeDetail = codeInfo;
	}

	@Override
	public Object doExecute(mT message, cT context) throws Exception {
		return null;
	}

	@Override
	public List<ValidationException> validate() {
		List<ValidationException> validationInfos = new ArrayList<ValidationException>();
		ValidationException validationInfo;
		if (codeDetail == null) {
			validationInfo = new ValidationException(ExceptionType.Error, getDescription(),
					"Rule is not defined for " + getName());
			validationInfos.add(validationInfo);
		}
		return validationInfos;
	}

	@Override
	public int getType() {
		return 0;
	}
}
