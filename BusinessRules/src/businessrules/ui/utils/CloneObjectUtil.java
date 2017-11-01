package businessrules.ui.utils;

import com.thoughtworks.xstream.XStream;

public class CloneObjectUtil {

	@SuppressWarnings("unchecked")
	public static <T> T cloneObject(Object instance) {
		XStream stream = new XStream();
		String serializedData = stream.toXML(instance);
		Object clonedInstance = stream.fromXML(serializedData);
		return (T) clonedInstance;
	}
}
