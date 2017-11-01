package businessrules.ui.utils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EventManager {

	PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	public EventManager() {
	}

	public void subscribe(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	public void publish(String propertyName, Object value) {
		propertyChangeSupport.firePropertyChange(propertyName, null, value);
	}
}
