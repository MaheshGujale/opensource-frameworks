package businessrulesruntime.core.script;

class CustomClassLoader extends ClassLoader {
	public CustomClassLoader() {
		super(ClassLoader.getSystemClassLoader());
	}
	
	public CustomClassLoader(ClassLoader classLoader) {
		super(classLoader);
	}
	
	public Class<?> loadClass(String className, byte classByte[]) {
		try {
			return findSystemClass(className);
		} catch (Exception e) {
		}
		return defineClass(className, classByte, 0, classByte.length, null);
	}
}