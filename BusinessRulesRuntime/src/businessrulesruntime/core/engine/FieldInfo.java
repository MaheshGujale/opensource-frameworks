package businessrulesruntime.core.engine;

public class FieldInfo extends BaseFieldInfo {

	private String value;
	private boolean isFieldReferenced;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean isFieldReferenced() {
		return isFieldReferenced;
	}

	public void setIsFieldReferenced(boolean isFieldReferenced) {
		this.isFieldReferenced = isFieldReferenced;
	}

	@Override
	public boolean equals(Object arg0) {
		return getName().equals(((FieldInfo) arg0).getName());
	}
}
