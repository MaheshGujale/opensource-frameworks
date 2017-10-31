package businessrulesruntime.core.engine;

public class BaseFieldInfo {
	private String name;
	private String description;
	private String dataType;
	private boolean isArray;
	private String injectText;
	private InjectInfo injectInfo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getInjectText() {
		return injectText;
	}

	public void setInjectText(String inject) {
		this.injectText = inject;
	}

	public boolean isArray() {
		return isArray;
	}

	public void setArray(boolean array) {
		this.isArray = array;
	}

	public InjectInfo getInjectInfo() {
		return injectInfo;
	}

	public void setInjectInfo(InjectInfo injectInfo) {
		this.injectInfo = injectInfo;
	}
}
