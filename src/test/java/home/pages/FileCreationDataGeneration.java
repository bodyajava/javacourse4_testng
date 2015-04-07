package home.pages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileCreationDataGeneration {
	
	public static void main(String[] args) throws IOException {
		File file1 = new File("fileNames1.txt");
		List<String> fileNames1 = generateRandomFileNames("file", (int)(Math.random()*50+1));
		saveContactsToCsvFile(fileNames1, file1);
	}
	
	private static List<String> generateRandomFileNames(String prefix, int amount) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < amount; i++) {
			list.add((String) generateRandomName(prefix));
		}	
		return list;
	}
	
	private static Object generateRandomName(String prefix) {
		return prefix + new Random().nextInt();
	}

	private static void saveContactsToCsvFile(List<String> fileNames, File file) throws IOException {
		if (file.exists()) {
			file.delete();
		}
		
		FileWriter writer = new FileWriter(file);
		for (String fileName : fileNames) {
			writer.write(fileName + ".txt" + "\n");
		}
		writer.close();		
	}
	
}
