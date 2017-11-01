package businessrulesruntime.core.engine.excel;

public class ExcelFunctionInfo {
	private String name;
	private String groupName;
	private String description;
	private String syntax;
	private String syntaxDescription;
	private String example;
	private String exampleDescription;
	private String code;
	private String imports;
	private String returnType;
	private String parameters;
	private boolean systemDefined;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSyntax() {
		return syntax;
	}

	public void setSyntax(String syntax) {
		this.syntax = syntax;
	}

	public String getSyntaxDescription() {
		return syntaxDescription;
	}

	public void setSyntaxDescription(String syntaxDescription) {
		this.syntaxDescription = syntaxDescription;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public String getExampleDescription() {
		return exampleDescription;
	}

	public void setExampleDescription(String exampleDescription) {
		this.exampleDescription = exampleDescription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public boolean isSystemDefined() {
		return systemDefined;
	}

	public void setSystemDefined(boolean systemDefined) {
		this.systemDefined = systemDefined;
	}

	public String getImports() {
		return imports;
	}

	public void setImports(String imports) {
		this.imports = imports;
	}

	public String getDisplayInformation() {
		StringBuffer displayInfo = new StringBuffer();
		displayInfo.append(getDescription() + "\n\n");
		displayInfo.append("Syntax:" + "\n");
		displayInfo.append(getSyntax() + "\n\n");
		displayInfo.append(getSyntaxDescription() + "\n\n");
		displayInfo.append("Example:" + "\n");
		displayInfo.append(getExample() + "\n");
		displayInfo.append(getExampleDescription() + "\n");

		return displayInfo.toString();
	}

}
