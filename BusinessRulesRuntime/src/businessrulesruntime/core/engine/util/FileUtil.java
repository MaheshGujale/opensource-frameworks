package businessrulesruntime.core.engine.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import businessrulesruntime.core.engine.BizflowContent;

public class FileUtil {
	private static Logger logger = Logger.getLogger(FileUtil.class);

	private FileUtil() {
	}

	public static BizflowContent readFromFile(File inputFile) {
		BizflowContent bizflowContent = new BizflowContent();
		try (FileReader fileReader = new FileReader(inputFile.getCanonicalFile())) {
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bizflowContent = readFromReader(bufferedReader);
		} catch (IOException e) {
			logger.error(e);
		}
		return bizflowContent;
	}

	public static BizflowContent readFromReader(BufferedReader bufferedReader) {
		BizflowContent bizflowContent = new BizflowContent();
		try {
			StringBuffer bizflowModel = new StringBuffer();
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				bizflowModel.append(line + "\n");
			}
			bizflowContent.setBizflowModel(bizflowModel.toString());

			bufferedReader.close();

		} catch (IOException e) {
			logger.error(e);
		}
		return bizflowContent;
	}

	public static void writeToFile(File modelFile, String model) {
		try (FileOutputStream outputStream = new FileOutputStream(modelFile);) {
			outputStream.write(model.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			logger.error(e);
		}
	}
}