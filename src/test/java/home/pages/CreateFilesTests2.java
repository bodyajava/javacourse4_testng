package home.pages;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;


public class CreateFilesTests2 extends CreateFilesBase2 {
	
	@Test (groups = {"positive2"})
	public void test1() {
		System.out.println("Executing base2 - test1");
		String path = basedir + tmp_dir_prefix + "/" + "file1.txt";
		File file1 = new File(path);
		System.out.println(file1);
		
		try {
			if (file1.createNewFile()) {
				System.out.println("File + " + file1 + " is created");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	} 

	@Test (groups = {"positive2"})
	public void test2() {
		System.out.println("Executing base2 - test2");
		String path = basedir + tmp_dir_prefix + "/" + "file2.txt";
		File file2 = new File(path);
		System.out.println(file2);
		
		try {
			if (file2.createNewFile()) {
				System.out.println("File + " + file2 + " is created");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	} 
	
	@Test (groups = {"negative2"})
	public void test3() {
		System.out.println("Executing base2 - test3");
		String path = basedir + tmp_dir_prefix + "/" + "file2.txt";
		File file2 = new File(path);
		
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
