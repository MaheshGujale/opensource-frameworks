package businessrulesruntime.core.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import businessrulesruntime.core.engine.inject.ServiceInfo;

public class InjectInfo {
	String instanceName;
	String providerName;
	String serviceName;
	String dataType;

	List<ServiceInfo> additionalServiceNames;

	Map<String, Object> params = new HashMap<String, Object>();

	public InjectInfo(String instanceName, String serviceName) {
		this.instanceName = instanceName;
		this.serviceName = serviceName;
	}

	public String getInstanceName() {
		return instanceName;
	}

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName
	 *            the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the params
	 */
	public Map<String, Object> getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	/**
	 * @return the providerName
	 */
	public String getProviderName() {
		return providerName;
	}

	/**
	 * @param providerName
	 *            the providerName to set
	 */
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * @param dataType
	 *            the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the additionalServiceNames
	 */
	public List<ServiceInfo> getAdditionalServiceNames() {
		return additionalServiceNames;
	}

	/**
	 * @param additionalServiceNames
	 *            the additionalServiceNames to set
	 */
	public void setAdditionalServiceNames(List<ServiceInfo> additionalServiceNames) {
		this.additionalServiceNames = additionalServiceNames;
	}

}
