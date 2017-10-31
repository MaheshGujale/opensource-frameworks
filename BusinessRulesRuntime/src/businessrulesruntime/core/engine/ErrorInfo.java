package businessrulesruntime.core.engine;

public class ErrorInfo {
	private int errorNo;
	private String errorDescription;
	private String cause;

	public ErrorInfo(int errorNo, String errorDescription, String cause) {
		this.errorNo = errorNo;
		this.errorDescription = errorDescription;
		this.cause = cause;
	}

	public int getErrorNo() {
		return errorNo;
	}

	public void setErrorNo(int errorNo) {
		this.errorNo = errorNo;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}
}
