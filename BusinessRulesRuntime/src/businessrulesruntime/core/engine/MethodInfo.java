package businessrulesruntime.core.engine;

import java.util.List;

public class MethodInfo {
	private String name;
	private boolean isStatic;
	private List<FieldInfo> parametersInfo;
	private FieldInfo returnInfo;

	public MethodInfo() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FieldInfo> getParametersInfo() {
		return parametersInfo;
	}

	public void setParametersInfo(List<FieldInfo> parametersInfo) {
		this.parametersInfo = parametersInfo;
	}

	public FieldInfo getReturnInfo() {
		return returnInfo;
	}

	public void setReturnInfo(FieldInfo returnInfo) {
		this.returnInfo = returnInfo;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}
}
