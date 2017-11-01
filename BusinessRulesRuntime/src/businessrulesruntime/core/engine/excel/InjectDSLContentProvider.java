package businessrulesruntime.core.engine.excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import businessrulesruntime.core.engine.FieldInfo;

public class InjectDSLContentProvider {

	private static InjectDSLContentProvider instance = new InjectDSLContentProvider();
	private Map<String, String> registerDataType = new HashMap<String, String>();
	private Map<String, FieldInfo> localVariables = new HashMap<String, FieldInfo>();
	private List<String> blackList = new ArrayList<String>();

	public static InjectDSLContentProvider getInstance() {
		return instance;
	}

	public Map<String, String> getRegisterDataType() {
		return registerDataType;
	}

	public void setRegisterDataType(Map<String, String> registerDataType) {
		this.registerDataType = registerDataType;
	}

	public Map<String, FieldInfo> getLocalVariables() {
		return localVariables;
	}

	public void setLocalVariables(Map<String, FieldInfo> localVariables) {
		this.localVariables = localVariables;
	}

	public List<String> getBlackList() {
		return blackList;
	}

	public void setBlackList(List<String> blackList) {
		this.blackList = blackList;
	}

}
