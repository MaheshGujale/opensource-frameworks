package businessrulesruntime.core.engine.inject;

import java.util.ArrayList;
import java.util.List;

import businessrulesruntime.core.engine.FieldInfo;

public class ServiceInfo {
	String serviceName;
	String description;
	String returnType;
	boolean isArray;
	List<FieldInfo> parameters = new ArrayList<FieldInfo>();

	public ServiceInfo() {
	}

	public ServiceInfo(String serviceName) {
		this.serviceName = serviceName;
	}

	public ServiceInfo(String serviceName, String description, String returnType, List<FieldInfo> parameters) {
		this.serviceName = serviceName;
		this.description = description;
		this.returnType = returnType;
		this.parameters = parameters;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String dataType) {
		this.returnType = dataType;
	}

	public List<FieldInfo> getParameters() {
		return parameters;
	}

	public void setParameters(List<FieldInfo> parameters) {
		this.parameters = parameters;
	}

	@Override
	public boolean equals(Object obj) {
		return getServiceName().equals(((ServiceInfo) obj).getServiceName());
	}

	public boolean isArray() {
		return isArray;
	}

	public void setArray(boolean isArray) {
		this.isArray = isArray;
	}

}