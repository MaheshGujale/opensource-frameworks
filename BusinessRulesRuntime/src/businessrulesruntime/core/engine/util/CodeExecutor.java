package businessrulesruntime.core.engine.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import businessrulesruntime.core.engine.CodeDetail;
import businessrulesruntime.core.engine.FieldInfo;
import businessrulesruntime.core.engine.MethodInfo;
import businessrulesruntime.core.engine.model.Context;
import businessrulesruntime.core.engine.model.Message;
import businessrulesruntime.core.script.JavaScriptHandler;

public class CodeExecutor {
	private static Logger logger = Logger.getLogger(CodeExecutor.class);

	private String name;
	private Object instance;
	private Method method;

	private CodeDetail codeDetail;
	private Long startTime;

	public CodeExecutor(String name, CodeDetail codeDetail) throws ClassNotFoundException, SecurityException,
			NoSuchMethodException, InstantiationException, IllegalAccessException {
		this.name = name;
		this.codeDetail = codeDetail;
		initialize(codeDetail);
	}

	public String getName() {
		return name;
	}

	private void initialize(CodeDetail codeDetail) throws ClassNotFoundException, SecurityException,
			NoSuchMethodException, InstantiationException, IllegalAccessException {
		Class<?> clzz = JavaScriptHandler.get().loadClass(codeDetail.getClassName(), codeDetail.getJavaCode(), false);
		initialize(clzz, codeDetail.getMethodInfo());
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	private void initialize(Class<?> clzz, MethodInfo methodInfo) throws ClassNotFoundException, SecurityException,
			NoSuchMethodException, InstantiationException, IllegalAccessException {
		String methodName = methodInfo.getName();

		List<Class<?>> parameterTypes = new ArrayList<Class<?>>();
		parameterTypes.add(Message.class);
		parameterTypes.add(Context.class);

		method = clzz.getDeclaredMethod(methodName, parameterTypes.toArray(new Class<?>[] {}));

		if (methodInfo.isStatic() == false) {
			instance = clzz.newInstance();
		}
	}

	public Object execute(Object instance, Object[] params)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		return method.invoke(instance, params);
	}

	public Object execute(Object[] params)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		return execute(this.instance, params);
	}

	public CodeDetail getCodeDetail() {
		return codeDetail;
	}
}
