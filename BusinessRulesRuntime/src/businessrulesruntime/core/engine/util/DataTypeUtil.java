package businessrulesruntime.core.engine.util;

public class DataTypeUtil {

	public static boolean isPrimitive(String dataType) {
		if (dataType.equals("int") || dataType.equals("long") || dataType.equals("double")
				|| dataType.equals("boolean") || dataType.equals("float")) {
			return true;
		}

		return false;
	}

	public static String getWrapperClass(String dataType) {
		String type = "";
		if (dataType.equals("int")) {
			type = "Integer";
		} else if (dataType.equals("double")) {
			type = "Double";
		} else if (dataType.equals("long")) {
			type = "Long";
		} else if (dataType.equals("boolean")) {
			type = "Boolean";
		} else if (dataType.equals("float")) {
			type = "Float";
		} else {
			type = dataType;
		}
		return type;
	}
}
