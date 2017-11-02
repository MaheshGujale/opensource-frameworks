package businessrulesruntime.core.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;

import businessrulesruntime.core.engine.model.Message;
import businessrulesruntime.core.engine.util.WorkflowRuntimeUtil;

public class WorkflowEngine {
	private static final Logger LOGGER = Logger.getLogger(WorkflowEngine.class);
	private IStep rootStep;
	
	public WorkflowEngine() {
		objectizeWorkflow();
	}

	public Object execute(IMessage message, IContext context) {
		LOGGER.info("Executing workflow");
		try {
			return rootStep.execute(message, context);
		} finally {
			LOGGER.info("Exiting workflow");
		}
	}

	private void objectizeWorkflow() {
		String filePath = System.getenv("businessrules.workflow.filepath");
		if (filePath == null || "".equals(filePath)) {
			throw new RuntimeException("businessrules.workflow.filepath is not provided in environment variable.");
		}
		List<BizflowModel> workflows = unZipModels(filePath);
		if(workflows.size() > 0) {
			rootStep = WorkflowRuntimeUtil.linkSteps(workflows.get(0));
		}
	}

	public static List<BizflowModel> unZipModels(String zipFilePath) {
		ZipFile zipFile;
		@SuppressWarnings("unused")
		List<BizflowModel> bizflowModels = new ArrayList<>();
		try {
			zipFile = new ZipFile(zipFilePath);
			Enumeration entries = zipFile.entries();

			while (entries.hasMoreElements()) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				bizflowModels.add((BizflowModel) WorkflowEngine.getXStream().fromXML(zipFile.getInputStream(entry)));
			}
			zipFile.close();
		} catch (IOException ioe) {
		}
		return bizflowModels;
	}

	public static XStream getXStream() {
		XStream stream = new XStream();
		stream.alias("BizflowModel", BizflowModel.class);
		stream.alias("StartStep", StartStep.class);
		stream.alias("DecisionStep", DecisionStep.class);
		stream.alias("ActivityStep", ActivityStep.class);
		stream.alias("BusinessRuleStep", BusinessRuleStep.class);

		stream.alias("SequenceLink", SequenceLink.class);
		stream.alias("ConditionalLink", ConditionalLink.class);

		stream.alias("BusinessRuleInfo", BusinessRuleInfo.class);
		stream.alias("FieldInfo", FieldInfo.class);
		stream.alias("Message", Message.class);
		stream.alias("CodeDetail", CodeDetail.class);

		return stream;
	}
}
