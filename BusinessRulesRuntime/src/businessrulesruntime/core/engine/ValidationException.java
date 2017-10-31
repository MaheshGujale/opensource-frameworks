package businessrulesruntime.core.engine;

public class ValidationException extends Exception {
	private static final long serialVersionUID = 1L;

	private ExceptionType type;
	private String description;
	private String exceptionCause;

	public ValidationException(ExceptionType type, String description, String exceptionCause) {
		super(exceptionCause);
		this.type = type;
		this.description = description;
		this.exceptionCause = exceptionCause;
	}

	public ExceptionType getType() {
		return type;
	}

	public void setType(ExceptionType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExceptionCause() {
		return exceptionCause;
	}

	public void setExceptionCause(String exceptionCause) {
		this.exceptionCause = exceptionCause;
	}
}