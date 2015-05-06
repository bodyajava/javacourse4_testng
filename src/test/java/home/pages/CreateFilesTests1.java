package home.pages;

import java.io.File;
import java.io.IOException;
import org.testng.annotations.Test;

public class CreateFilesTests1 extends CreateFilesBase1 {
	
	@Test (groups = {"positive1"}, priority = 1)
	public void test1() {
		System.out.println("Executing base1 - test1");
		File file1 = new File("/Users/bogdanlaukhin/Documents/Temp1/file1.txt");
		
		try {
			if (file1.createNewFile()) {
				System.out.println("File + " + file1 + " is created");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println(">>>>>>>>>>>>>>> GROUP 'positive1', TEST #1: was executed <<<<<");
	} 

	@Test (groups = {"positive2"}, priority = 1)
	public void test2() {
		System.out.println("Executing base1 - test2");
		File file2 = new File("/Users/bogdanlaukhin/Documents/Temp1/file2.txt");
		
		try {
			if (file2.createNewFile()) {
				System.out.println("File + " + file2 + " is created");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println(">>>>>>>>>>>>>>> GROUP 'positive2', TEST #2: was executed <<<<<");
	} 
	
	@Test (groups = {"negative1"}, priority = 10)
	public void test3() {
		System.out.println("Executing base1 - test3");
		File file2 = new File("/Users/bogdanlaukhin/Documents/Temp1/file2.txt");
		
		if (file2.exists()) {
				System.out.println("File + " + file2 + " exists");
			} else {
				try {
					if (file2.createNewFile()) {
						System.out.println("File + " + file2 + " is created");
					}
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		System.out.println(">>>>>>>>>>>>>>> GROUP 'negative1', TEST #3: was executed <<<<<");
	} 
	
}
