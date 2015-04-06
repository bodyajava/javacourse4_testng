package home.pages;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;

public class CreateFilesBase1 {
	
	File dir = new File("/Users/bogdanlaukhin/Documents/Temp1");
	
	@BeforeGroups (groups = {"positive1"})
	public void setUp() {		
		if (!dir.exists()) {
			if (dir.mkdir()) {
				System.out.println("Directory is created");
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
				System.out.println("Directory is deleted");
			}
		}
		
	}
	

}
