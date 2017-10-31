package businessrulesruntime.core.engine;

public class CodeDetail {
	private String className;
	private MethodInfo methodInfo;
	private String javaCode;
	private String excelFormula;

	public String getExcelFormula() {
		return excelFormula;
	}

	public void setExcelFormula(String excelFormula) {
		this.excelFormula = excelFormula;
	}

	public String getJavaCode() {
		return javaCode;
	}

	public void setJavaCode(String javaCode) {
		this.javaCode = javaCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public MethodInfo getMethodInfo() {
		return methodInfo;
	}

	public void setMethodInfo(MethodInfo methodInfo) {
		this.methodInfo = methodInfo;
	}

}
