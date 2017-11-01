package businessrulesruntime.core.engine.excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import businessrulesruntime.core.engine.FieldInfo;

public class ExcelFormulaContentProvider {

	private List<String> variableNames = new ArrayList<String>();
	private List<ExcelFunctionInfo> inBuildFunction = new ArrayList<ExcelFunctionInfo>();
	private List<FieldInfo> javaObjcetList = new ArrayList<FieldInfo>();
	private Map<String, String> registerDataType = new HashMap<String, String>();
	private List<String> staticImportClassNames = new ArrayList<String>();

	private static ExcelFormulaContentProvider excelFormulaContentProvider = new ExcelFormulaContentProvider();

	public static ExcelFormulaContentProvider getInstance() {
		return excelFormulaContentProvider;
	}

	public List<String> getVariableNames() {
		return variableNames;
	}

	public void setVariableNames(List<String> variableNames) {
		this.variableNames = variableNames;
	}

	public List<ExcelFunctionInfo> getInBuildFunction() {
		return inBuildFunction;
	}

	public void setInBuildFunction(List<ExcelFunctionInfo> inBuildFunction) {
		this.inBuildFunction = inBuildFunction;
	}

	public List<FieldInfo> getJavaObjectList() {
		return javaObjcetList;
	}

	public void setJavaObjcetList(List<FieldInfo> javaObjcetList) {
		this.javaObjcetList = javaObjcetList;
	}

	public Map<String, String> getRegisterDataType() {
		return registerDataType;
	}

	public void setRegisterDataType(Map<String, String> registerDataType) {
		this.registerDataType = registerDataType;
	}

	public List<String> getStaticImportClassNames() {
		return staticImportClassNames;
	}

	public void setStaticImportClassNames(List<String> staticImportClassNames) {
		this.staticImportClassNames = staticImportClassNames;
	}

}
