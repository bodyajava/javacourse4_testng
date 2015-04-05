package home.pages;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

@Test
public class CreateFilesTests extends CreateFilesFixture {
	
	
	public void test1() {
		File file1 = new File("/Users/bogdanlaukhin/Documents/Temp/file1.txt");
		
		try {
			if (file1.createNewFile()) {
				System.out.println("File + " + file1 + " is created");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	} 

	
	public void test2() {
		File file2 = new File("/Users/bogdanlaukhin/Documents/Temp/file2.txt");
		
		try {
			if (file2.createNewFile()) {
				System.out.println("File + " + file2 + " is created");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	} 
	
	public void test3() {
		File file2 = new File("/Users/bogdanlaukhin/Documents/Temp/file2.txt");
		
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
	} 
	
}
