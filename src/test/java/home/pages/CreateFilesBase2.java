package home.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;

public class CreateFilesBase2 {
	
	String basedir = ("/Users/bogdanlaukhin/Documents/");
	String tmp_dir_prefix = "Temp2";	
	
	File dir = new File(basedir + tmp_dir_prefix);
	
	@BeforeGroups (groups = "positive2")
	public void setUp() {		
		if (!dir.exists()) {
			if (dir.mkdir()) {
				System.out.println("Directory " + dir + " is created");
			}
		}
	}
	
	//@AfterClass
	public void tearDown() {
		
		try {
			FileUtils.cleanDirectory(dir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if (dir.exists()) {
			if (dir.delete()) {
				System.out.println("Directory " + dir + " is deleted");
			}
		}
		
	}
	

}
