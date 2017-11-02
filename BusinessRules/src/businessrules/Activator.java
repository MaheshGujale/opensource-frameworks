package businessrules;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.thoughtworks.xstream.XStream;

import businessrules.ui.workflow.common.emf.model.Workflow.EWorkflowPackage;
import businessrulesruntime.core.engine.excel.ExcelFormulaContentProvider;
import businessrulesruntime.core.engine.excel.ExcelFunctionInfo;
import businessrulesruntime.core.engine.model.Message;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "BusinessRules"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		// Loading excel excel functions
		InputStream inputStream = Activator.class.getResourceAsStream("/resources/SystemDefinedFunctions.fun");
		ExcelFormulaContentProvider excelFormulaContentProvider = ExcelFormulaContentProvider.getInstance();
		if (inputStream != null) {
			XStream stream = new XStream();
			stream.alias("ExcelFunctionInfo", ExcelFunctionInfo.class);
			List<ExcelFunctionInfo> systemDefinedFunctions = (List<ExcelFunctionInfo>) stream.fromXML(inputStream);
			excelFormulaContentProvider.setInBuildFunction(systemDefinedFunctions);
			Field[] fieldNames = Message.class.getDeclaredFields();
			List<String> variableNames = new ArrayList<>();
			for (Field field : fieldNames) {
				variableNames.add(field.getName());
			}
			excelFormulaContentProvider.setVariableNames(variableNames);
		}

		// initialize the EWorkflowPackage
		EWorkflowPackage workflowPackage = EWorkflowPackage.eINSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
	 * BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 *
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
