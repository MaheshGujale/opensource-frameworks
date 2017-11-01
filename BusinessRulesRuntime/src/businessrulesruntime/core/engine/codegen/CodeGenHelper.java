package businessrulesruntime.core.engine.codegen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import businessrulesruntime.core.engine.FieldInfo;
import businessrulesruntime.core.engine.util.DataTypeUtil;
import businessrulesruntime.core.engine.util.ReturnAs;
import businessrulesruntime.core.engine.util.VariableInfo;

public class CodeGenHelper {
	private static Logger logger = Logger.getLogger(CodeGenHelper.class);
	private static final String Const_forwardSlash = "/";

	private String basePackageName;
	private String bizflowName;
	private Map<String, List<String>> imports = new LinkedHashMap<String, List<String>>();
	private List<String> members = new ArrayList<String>();
	private List<String> defaultPackage = new ArrayList<String>();

	private Map<String, List<VariableInfo>> variableInfos = new HashMap<String, List<VariableInfo>>();

	private Map<String, Map<Object, String>> constantInfos = new HashMap<String, Map<Object, String>>();

	private int constantCounter = 1;
	private int groupCounter = 1;

	private static final String const_GroupNamePrefix = "<[[[";
	private static final String const_GroupNamePostfix = "]]]>";

	public CodeGenHelper(String basePackageName) {
		this.basePackageName = basePackageName;
		defaultPackage.add("java.lang");
	}

	public void addImport(String importURI) {
		if (isDefaultImport(importURI) || DataTypeUtil.isPrimitive(importURI)) {
			return;
		}
		String classShortName;
		if (!importURI.contains("<")) {
			classShortName = getClassShortName(importURI);
		} else {
			int index = importURI.indexOf("<");
			classShortName = importURI.substring(0, index);
			if (classShortName.equals(ReturnAs.List.toString())) {
				String objectName = importURI.substring(index + 1, importURI.length() - 1);
				if (!isDefaultImport(objectName) || !DataTypeUtil.isPrimitive(objectName)) {
					addImport(objectName);
				}
				importURI = "java.util.List";
			} else if (classShortName.equals(ReturnAs.Map.toString())) {
				String keyName = importURI.substring(importURI.indexOf("<") + 1, importURI.indexOf(","));
				if (!isDefaultImport(keyName) || !DataTypeUtil.isPrimitive(keyName)) {
					addImport(keyName);
				}
				String objectName = importURI.substring(importURI.indexOf(",") + 1, importURI.indexOf(">"));
				if (!isDefaultImport(objectName) || !DataTypeUtil.isPrimitive(objectName)) {
					addImport(objectName);
				}
				importURI = "java.util.Map";
			}
		}
		List<String> importList = imports.get(classShortName);

		if (importList == null) {
			importList = new ArrayList<String>();
			imports.put(classShortName, importList);
		}
		if (importList.contains(importURI) == false) {
			importList.add(importURI);
		}

	}

	private boolean isDefaultImport(String importURI) {
		int lastIndex = importURI.lastIndexOf(".");
		if (lastIndex == -1) {
			return false;
		}

		String packageName = importURI.substring(0, lastIndex);

		return defaultPackage.contains(packageName);
	}

	public List<String> getImports() {
		List<String> allImports = new ArrayList<String>();
		for (List<String> importList : imports.values()) {
			allImports.addAll(importList);
		}

		return allImports;
	}

	public void addMembers(String memberName) {
		if (!members.contains(memberName)) {
			members.add(memberName);
		}
	}

	public List<String> getMembers() {
		return members;
	}

	public String getQualifiedTypeName(String typeName) {
		String classShortName;
		if (!typeName.contains("<")) {
			classShortName = getClassShortName(typeName);
		} else {
			int index = typeName.indexOf("<");
			classShortName = typeName.substring(0, index);
			if (classShortName.equals(ReturnAs.List.toString())) {
				String objectName = typeName.substring(index + 1, typeName.length() - 1);
				return "List<" + getClassShortName(objectName) + ">";

			} else if (classShortName.equals(ReturnAs.Map.toString())) {
				String keyName = typeName.substring(index + 1, typeName.indexOf(","));
				String objectName = typeName.substring(typeName.indexOf(",") + 1, typeName.indexOf(">"));
				return "Map<" + getClassShortName(keyName) + "," + getClassShortName(objectName) + ">";

			}
		}
		if (isDefaultImport(typeName) == true) {
			return classShortName;
		}
		List<String> importList = imports.get(classShortName);
		if (importList == null) {
			return typeName;
		}

		if (importList.size() == 1 || importList.get(0).equals(typeName)) {
			return classShortName;
		}
		return typeName;
	}

	public static String getClassShortName(String canonicalName) {
		String[] splitValues = canonicalName.split("\\.");
		return splitValues[splitValues.length - 1];
	}

	public void setDefaultImports(List<String> defaultImports) {
		for (String defaultImport : defaultImports) {
			addImport(defaultImport);
		}
	}

	public static void writeSourceCodeFiles(File srcGenPath, Map<String, String> generatedCodes) {
		Iterator<Entry<String, String>> iterator = generatedCodes.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			int index = entry.getKey().lastIndexOf(".");
			String packageName = entry.getKey().substring(0, index).toLowerCase();
			File file = new File(srcGenPath + Const_forwardSlash + packageName.replace(".", Const_forwardSlash));
			if (!file.exists()) {
				file.mkdirs();
			}

			try {
				File javaFile = new File(srcGenPath + Const_forwardSlash
						+ entry.getKey().replace(".", Const_forwardSlash) + ".java");
				FileUtils.writeStringToFile(javaFile, entry.getValue());
			} catch (IOException e) {
				logger.error(e);
			}

		}
	}

	public void setBasePackageName(String basePackageName) {
		this.basePackageName = basePackageName;
	}

	public String getBasePackageName() {
		return basePackageName;
	}


	public static String getWrapperDataType(String primitiveType) {
		if (primitiveType.equals("boolean")) {
			return "java.lang.Boolean";
		} else if (primitiveType.equals("int")) {
			return "java.lang.Integer";
		} else if (primitiveType.equals("long")) {
			return "java.lang.Long";
		} else if (primitiveType.equals("float")) {
			return "java.lang.Float";
		} else if (primitiveType.equals("double")) {
			return "java.lang.Double";
		}
		return primitiveType;
	}

	public static String getFullDataType(String shortDataType) {
		if (shortDataType.equals("String")) {
			return "java.lang.String";
		} else if (shortDataType.equals("Boolean")) {
			return "java.lang.Boolean";
		} else if (shortDataType.equals("Long")) {
			return "java.lang.Long";
		} else if (shortDataType.equals("Date")) {
			return "java.util.Date";
		}
		return shortDataType;
	}

	public static String getShortDataType(String fullDataType) {
		if (fullDataType.equals("java.lang.String")) {
			return "String";
		} else if (fullDataType.equals("java.lang.Boolean")) {
			return "Boolean";
		} else if (fullDataType.equals("java.lang.Long")) {
			return "Long";
		} else if (fullDataType.equals("java.util.Date")) {
			return "Date";
		}
		return fullDataType;
	}

	public static String getDBDataType(String javaDataType) {
		if (javaDataType.equals("java.lang.String")) {
			return "VARCHAR";
		} else if (javaDataType.equals("java.lang.Boolean")) {
			return "BOOLEAN";
		} else if (javaDataType.equals("java.lang.Long") || javaDataType.equals("java.lang.Integer")) {
			return "NUMERIC";
		} else if (javaDataType.equals("java.util.Date")) {
			return "DATE";
		}
		return javaDataType;
	}

	public void addGroup(String group) {
		List<VariableInfo> groupVariables = variableInfos.get(group);
		if (groupVariables == null) {
			groupVariables = new ArrayList<VariableInfo>();
			variableInfos.put(group, groupVariables);
		}
	}

	public String createGroupName() {
		String groupName = const_GroupNamePrefix + (groupCounter++) + const_GroupNamePostfix;
		addGroup(groupName);
		return groupName;
	}

	public String createGroupName(String name) {
		String groupName = const_GroupNamePrefix + name + const_GroupNamePostfix;
		addGroup(groupName);
		return groupName;
	}

	public String getGroupName(String groupName) {
		return const_GroupNamePrefix + groupName + const_GroupNamePostfix;
	}

	public boolean addVariable(String group, VariableInfo variableInfo) {
		List<VariableInfo> groupVariables = variableInfos.get(group);
		if (groupVariables == null) {
			groupVariables = new ArrayList<VariableInfo>();
			variableInfos.put(group, groupVariables);
		} else {
			if (isDuplicateVariable(groupVariables, variableInfo) == true) {
				return false;
			}
		}
		groupVariables.add(variableInfo);
		return true;
	}

	private boolean isDuplicateVariable(List<VariableInfo> groupVariables, VariableInfo variableInfo) {
		for (VariableInfo vInfo : groupVariables) {
			if (vInfo.getName().equals(variableInfo.getName())) {
				return true;
			}
		}
		return false;
	}

	public String createConstantName(String prefix, String dataType, Object data) {
		Map<Object, String> constants = constantInfos.get(dataType);
		if (constants == null) {
			constants = new HashMap<Object, String>();
			constantInfos.put(dataType, constants);
		}

		String constantName = constants.get(data);
		if (constantName != null) {
			return constantName;
		}

		prefix = (prefix == null) ? "" : prefix;
		constantName = "Const_" + prefix + constantCounter;
		constantCounter++;

		constants.put(data, constantName);
		return constantName;
	}

	public Set<String> getAllGroupNames() {
		return variableInfos.keySet();
	}

	public String getCodeForGroup(String groupName) {
		List<VariableInfo> variables = variableInfos.get(groupName);
		if (variables == null) {
			return "";
		}

		String code = "";
		for (VariableInfo variableInfo : variables) {
			code += variableInfo.getCode() + "\n\t";
		}
		return code;
	}

	public String getCodeForImports() {
		StringBuffer importStringBuffer = new StringBuffer();
		for (String importClass : getImports()) {
			importStringBuffer.append("import " + importClass + ";\n");
		}
		return importStringBuffer.toString().trim();
	}

	public boolean isClassType(FieldInfo fieldInfo) {
		String dataType = fieldInfo.getDataType();
		if (dataType.equals("int") || dataType.equals("long") || dataType.equals("double")
				|| dataType.equals("boolean") || dataType.equals("float")) {
			return false;
		}
		if (dataType.equals("java.lang.Integer") || dataType.equals("java.lang.Long")
				|| dataType.equals("java.lang.Float") || dataType.equals("java.lang.Double")
				|| dataType.equals("java.lang.String") || dataType.equals("java.lang.Boolean")) {
			return false;
		}
		return true;
	}

	public String generateCacheKeyCode(List<FieldInfo> fieldInfos) {
		StringBuilder cacheKeyCode = new StringBuilder();
		List<FieldInfo> eligibleFieldInfos = getEligibleFieldInfo(fieldInfos);
		if (eligibleFieldInfos.size() > 0) {
			cacheKeyCode.append("StringBuilder strBuilder = new StringBuilder(32);\n");
			for (int index = 0; index < eligibleFieldInfos.size(); index++) {
				FieldInfo fieldInfo = eligibleFieldInfos.get(index);
				cacheKeyCode.append("strBuilder.append(" + fieldInfo.getName() + ");\n");
				if ((index + 1) != eligibleFieldInfos.size()) {
					cacheKeyCode.append("strBuilder.append(\"^\");\n");
				}
			}
			cacheKeyCode.append("key = strBuilder.toString();\n");
		}
		return cacheKeyCode.toString();
	}

	private List<FieldInfo> getEligibleFieldInfo(List<FieldInfo> fieldInfos) {
		List<FieldInfo> eligibleFieldInfo = new ArrayList<FieldInfo>();
		for (FieldInfo fieldInfo : fieldInfos) {
			if (!isClassType(fieldInfo)) {
				eligibleFieldInfo.add(fieldInfo);
			}
		}
		return eligibleFieldInfo;
	}

	public String getMethodName(String identifier) {
		if (identifier == null || identifier.equals("")) {
			return "";
		}
		String startLetter = String.valueOf(identifier.substring(0, 1));
		return startLetter.toUpperCase() + identifier.substring(1);
	}

	public String getIdentifier(String name) {
		if (name == null || name.equals("")) {
			return "";
		}
		String startLetter = String.valueOf(name.substring(0, 1));
		return startLetter.toLowerCase() + name.substring(1);
	}

	public String getBizflowName() {
		return bizflowName;
	}

	public void setBizflowName(String bizflowName) {
		this.bizflowName = bizflowName;
	}

}