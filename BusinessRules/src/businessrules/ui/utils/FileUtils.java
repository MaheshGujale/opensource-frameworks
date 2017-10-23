package businessrules.ui.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	public static String jobDir = "./data/workflows/";

	public static List<String> getAllFolders() {
		File folder = new File(jobDir);

		FileFilter dirFilter = new FileFilter() {
			public boolean accept(File dir) {
				return (dir.isDirectory() && !dir.getName().startsWith("."));
			}
		};

		File[] listOfFiles = folder.listFiles(dirFilter);
		List<String> folderList = new ArrayList<String>();
		if (listOfFiles == null) {
			return folderList;
		}

		int size = listOfFiles.length;
		for (int i = 0; i < size; i++) {
			folderList.add(listOfFiles[i].getName());
		}

		return folderList;
	}

	public static boolean recursiveDelete(File dirPath) {
		String[] ls = dirPath.list();

		for (int idx = 0; idx < ls.length; idx++) {
			File file = new File(dirPath, ls[idx]);
			if (file.isDirectory())
				recursiveDelete(file);
			file.delete();
		}
		return dirPath.delete();
	}
}