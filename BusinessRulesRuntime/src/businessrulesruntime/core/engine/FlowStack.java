package businessrulesruntime.core.engine;

import java.util.ArrayList;
import java.util.List;

public class FlowStack {

	private static final String EMPTY_STRING = "";
	
	private List<String> queue = new ArrayList<String>();

	public void push(String item) {
		queue.add(item);
	}

	public void pop() {
		int size = queue.size();
		if (size > 0) {
			queue.remove(size - 1);
		}
	}

	@Override
	public String toString() {
		int size = queue.size();
		if (size == 0) {
			return EMPTY_STRING;
		}
		StringBuilder stringBuilder = new StringBuilder(256);
		int index = (size - 5) > 0 ? (size - 5) : 0;
		for (; index < size; index++) {
			String value = queue.get(index);
			stringBuilder.append(value);
			if (index + 1 == size) {
				break;
			}
			stringBuilder.append("->");
		}
		return stringBuilder.toString();
	}

}
