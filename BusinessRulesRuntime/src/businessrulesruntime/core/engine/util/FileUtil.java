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
	
	private FileUtil(){
	}
	
	public static BizflowContent readFromFile(File inputFile) {
		BizflowContent bizflowContent = new BizflowContent();
		try (FileReader fileReader = new FileReader(inputFile.getCanonicalFile())){
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
			StringBuffer bizflowDiagram = new StringBuffer();
			StringBuffer bizflowModel = new StringBuffer();
			boolean diagramStartTag = false;
			boolean modelStartTag = false;
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains("<BizDiagram>")) {
					if (line.contains("</BizDiagram>")) {
						line = line.replace("<BizDiagram>", "").replace("</BizDiagram>", "");
					} else {
						line = line.replace("<BizDiagram>", "");
						diagramStartTag = true;
					}
					bizflowDiagram.append(line.replace("&lt;", "<").replace("&gt;", ">") + "\n");
				} else if (diagramStartTag) {
					if (line.contains("</BizDiagram>")) {
						line = line.replace("</BizDiagram>", "");
						diagramStartTag = false;
					}
					bizflowDiagram.append(line.replace("&lt;", "<").replace("&gt;", ">") + "\n");
				} else if (line.contains("<BizModel>")) {
					if (line.contains("</BizModel>")) {
						line = line.replace("<BizModel>", "").replace("</BizModel>", "");
					} else {
						line = line.replace("<BizModel>", "");
						modelStartTag = true;
					}
					bizflowModel.append(line + "\n");
				} else if (modelStartTag) {
					if (line.contains("</BizModel>")) {
						line = line.replace("</BizModel>", "");
						modelStartTag = false;
					}
					bizflowModel.append(line + "\n");

				}
			}
			bizflowContent.setBizflowDiagram(bizflowDiagram.toString());
			bizflowContent.setBizflowModel(bizflowModel.toString());

			bufferedReader.close();

		} catch (IOException e) {
			logger.error(e);
		}
		return bizflowContent;
	}

	public static void convertOldBizflowFormatToNewFormat(File inputFile) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(inputFile);
			bufferedReader = new BufferedReader(fileReader);
			StringBuffer buffer = new StringBuffer();
			String line;
			try {
				while ((line = bufferedReader.readLine()) != null) {
					buffer.append(line);
				}
			} catch (IOException e) {
				logger.error(e);
			}
			fileReader.close();
			bufferedReader.close();
			
			String oldBizflowDiagram = buffer.toString();
			oldBizflowDiagram = oldBizflowDiagram.replace("<", "&lt;").replace(">", "&gt;");

			String file = inputFile.getAbsolutePath();
			String filePath = file.substring(0, file.lastIndexOf('\\'));
			String fileName = file.substring(file.lastIndexOf('\\') + 1, file.lastIndexOf('.'));
			File dataFile = new File(filePath + "\\" + fileName + ".mdl");
			fileReader = new FileReader(dataFile);
			bufferedReader = new BufferedReader(fileReader);
			buffer = new StringBuffer();
			try {
				while ((line = bufferedReader.readLine()) != null) {
					buffer.append(line);
				}
			} catch (IOException e) {
				logger.error(e);
			}
			String oldBizflowModel = buffer.toString();
			writeToFile(inputFile.getAbsolutePath(), inputFile, oldBizflowModel);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			if(fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
			
			if(bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
	}

	public static void writeToFile(String outFilePath, File diagramFile, String model) {
		try (FileReader fileReader = new FileReader(diagramFile);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				FileOutputStream outputStream = new FileOutputStream(outFilePath);){
			StringBuffer buffer = new StringBuffer();
			String line;
			try {
				while ((line = bufferedReader.readLine()) != null) {
					buffer.append(line + "\n");
				}
			} catch (IOException e) {
				logger.error(e);
			}

			String content = buffer.toString();
			content = content.replace("<", "&lt;").replace(">", "&gt;");
			String bizflowContent = "<BizDiagram>" + content + "</BizDiagram>\n<BizModel>" + model + "</BizModel>";

			outputStream.write(bizflowContent.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			logger.error(e);
		}
	}
}
