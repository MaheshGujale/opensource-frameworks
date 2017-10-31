package businessrulesruntime.core.script;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.apache.commons.jci.compilers.CompilationResult;
import org.apache.commons.jci.compilers.EclipseJavaCompiler;
import org.apache.commons.jci.compilers.JavaCompiler;
import org.apache.commons.jci.compilers.JavaCompilerSettings;
import org.apache.commons.jci.problems.CompilationProblem;
import org.apache.commons.jci.readers.MemoryResourceReader;
import org.apache.commons.jci.stores.MemoryResourceStore;
import org.apache.commons.jci.stores.ResourceStore;
import org.apache.log4j.Logger;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;

public class JavaScriptHandler {
	private static Logger logger = Logger.getLogger(JavaScriptHandler.class);
	private JavaCompiler compiler = new EclipseJavaCompiler();
	private static JavaScriptHandler instance = new JavaScriptHandler();
	private Exception exception;
	private CustomClassLoader customClassLoader;

	private JavaScriptHandler() {
	}

	public static JavaScriptHandler get() {
		return instance;
	}

	@SuppressWarnings({ "rawtypes" })
	synchronized public Class loadClass(String scriptName, String script, boolean useNewClassLoader) {
		return loadClass(scriptName, script, useNewClassLoader, null);
	}

	synchronized public Class<?> loadClass(String scriptName, String script, boolean useNewClassLoader,
			List<String> additionalClassPath) {
		String pResourceName = scriptName.replace(".", "/") + ".java";
		String classFileName = scriptName.replace(".", "/") + ".class";

		MemoryResourceReader pReader = new MemoryResourceReader();
		pReader.add(pResourceName, script.getBytes());

		compiler = new EclipseJavaCompiler();
		JavaCompilerSettings settings = compiler.createDefaultSettings();
		settings.setSourceVersion(CompilerOptions.VERSION_1_5);
		settings.setTargetVersion(CompilerOptions.VERSION_1_5);

		ResourceStore pStore = new MemoryResourceStore();
		customClassLoader = new CustomClassLoader(getClassLoader(additionalClassPath));
		CompilationResult compilationResult = compiler.compile(new String[] { pResourceName }, pReader, pStore,
				customClassLoader, settings);
		if (compilationResult.getErrors().length > 0) {
			StringBuffer errorMessages = new StringBuffer();
			for (CompilationProblem cProblem : compilationResult.getErrors()) {
				errorMessages.append(cProblem.getMessage());
			}
			try {
				throw new Exception(errorMessages.toString());
			} catch (Exception e) {
				logger.error(e);
				throw new IllegalArgumentException(e);
			}
		}
		return customClassLoader.loadClass(scriptName, pStore.read(classFileName));
	}

	@SuppressWarnings("rawtypes")
	public Object getInstance(String scriptName, String script, boolean useNewClassLoader) {
		Object instance = null;
		Class clss = loadClass(scriptName, script, useNewClassLoader);
		try {
			instance = clss.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return instance;
	}

	public ClassLoader getClassLoader(List<String> additionalClassPath) {
		ClassLoader classLoader;
		if (additionalClassPath != null && additionalClassPath.size() > 0) {
			int index = 0;
			URL[] urls = new URL[additionalClassPath.size()];
			for (String classPath : additionalClassPath) {
				File file = new File(classPath);
				URL url = null;
				try {
					url = file.toURI().toURL();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				urls[index++] = url;
			}
			classLoader = new URLClassLoader(urls);
		} else {
			classLoader = this.getClass().getClassLoader();
		}
		return classLoader;
	}

	public Exception getException() {
		return exception;
	}

}