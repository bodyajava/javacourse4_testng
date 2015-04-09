package home.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileCreationTests extends FileCreationBase {
	
	@DataProvider
	public static Iterator<Object[]> FileNamesGenerator() throws IOException {
		return loadContactsFromCsvFile(new File("fileNames1.txt")).iterator();
	}
	
	@DataProvider
	public static Iterator<Object[]> FileNamesGenerator2() {
		List<Object[]> fileNames = new ArrayList<Object[]>();
		fileNames.add(new Object[]{"adminFile1.txt"});
		fileNames.add(new Object[]{"adminFile2.txt"});
		return fileNames.iterator();
	}
			 
	@Test (dataProvider = "FileNamesGenerator")
	@ReadOnlyDir
	public void test1(String fileName) {
		String path = basedir + tmp_dir_prefix + "/" + fileName;
		File file1 = new File(path);
		
		try {
			if (file1.createNewFile()) {
				System.out.println("File " + file1 + " is created");
			}
		} catch (IOException e) {e.printStackTrace();}
		
		Assert.assertTrue(file1.exists(), "file1 exists");
	}
	
	//@Test (dataProvider = "FileNamesGenerator2")
	public void test2(String fileName) {
		String path = basedir + tmp_dir_prefix + "/" + fileName;
		File file1 = new File(path);
		
		try {
			if (file1.createNewFile()) {
				System.out.println("File " + file1 + " is created");
			}
		} catch (IOException e) {e.printStackTrace();}
		
		Assert.assertTrue(file1.exists(), "file1 exists");
	} 
	

}
