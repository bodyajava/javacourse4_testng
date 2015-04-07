package home.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class FileCreationBase {
	
	String basedir = ("/Users/bogdanlaukhin/Documents/");
	String tmp_dir_prefix = "Temp3";	
	File dir = new File(basedir + tmp_dir_prefix);
	
	@BeforeClass
	public void setUp() {		
		if (!dir.exists()) {
			if (dir.mkdir()) {
				System.out.println("Temp directory is created.");
			}
		} else {
			try { FileUtils.cleanDirectory(dir); }
			catch (IOException e) { e.printStackTrace(); }
		}
	}
	
	@AfterClass
	public void tearDown() {
		try { FileUtils.cleanDirectory(dir); }
		catch (IOException e) { e.printStackTrace(); } 
		
		if (dir.exists()) {
			if (dir.delete()) {
				System.out.println("Temp directory is deleted");
			}
		}
	}
	
	public static List<Object[]> loadContactsFromCsvFile(File file) throws IOException {
		List<Object[]> list = new ArrayList<Object[]>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			//String part = line;
			list.add(new Object[] {line});
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

}
