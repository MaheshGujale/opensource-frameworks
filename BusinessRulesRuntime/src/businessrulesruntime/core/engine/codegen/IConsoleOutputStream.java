package businessrulesruntime.core.engine.codegen;

public interface IConsoleOutputStream {
	void debug(String message);

	void error(String message);

	void info(String message);

	void close();
}
