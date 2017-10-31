package businessrulesruntime.core.engine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Links<mT extends IMessage, cT extends IContext> implements Serializable {

	private static final long serialVersionUID = 1L;

	List<ILink<mT, cT>> links = new ArrayList<ILink<mT, cT>>();

	public void addLink(ILink<mT, cT> link) {
		links.add(link);
	}

	public void removeLink(ILink<mT, cT> link) {
		links.remove(link);
	}

	public void removeLink(String linkId) {

	}

	public void clearLinks() {
		links.clear();
	}

	public List<ILink<mT, cT>> getLinks() {
		return links;
	}

	public void sort() {
		Collections.sort(links, new Comparator<ILink<mT, cT>>() {
			@Override
			public int compare(ILink<mT, cT> lhs, ILink<mT, cT> rhs) {
				return Integer.valueOf(lhs.getPriority()).compareTo(Integer.valueOf(rhs.getPriority()));
			}
		});
	}

}
