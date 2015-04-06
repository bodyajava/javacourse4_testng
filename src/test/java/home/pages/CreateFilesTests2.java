package home.pages;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateFilesTests2 extends CreateFilesBase2 {
	
	String path = basedir + tmp_dir_prefix + "/" + "file1.txt";
	File file1 = new File(path);
	
	String path2 = basedir + tmp_dir_prefix + "/" + "file2.txt";
	File file2 = new File(path2);
	
	@Test (groups = {"positive2"})
	public void test1() {
		System.out.println("Executing base2 - test1");
		System.out.println(file1);
		
		try {
			if (file1.createNewFile()) {
				System.out.println("File " + file1 + " is created");
			}
		} catch (IOException e) {e.printStackTrace();}
		
		Assert.assertTrue(file1.exists(), "file1 exists");
	} 

	@Test (groups = {"positive2"})
	public void test2() {
		System.out.println("Executing base2 - test2");
		System.out.println(file2);
		
		try {
			if (file2.createNewFile()) {
				System.out.println("File " + file2 + " is created");
			}
		} catch (IOException e) {e.printStackTrace();}
		
		Assert.assertTrue(file2.exists(), "file2 exists");
		Assert.assertFalse(file1.exists(), "file1 not exists");
	} 
	
	@Test (groups = {"negative2"})
	public void test3() {
		System.out.println("Executing base2 - test3");
		String path = basedir + tmp_dir_prefix + "/" + "file2.txt";
		File file2 = new File(path);
		
		SoftAssert s = new SoftAssert();
		s.assertTrue(file1.exists());
		s.assertTrue(file2.exists());
		
		if (file2.delete()) {
			System.out.println("File " + file2 + " has been deleted");
		} else {
				System.out.println("File + " + file2 + " is absent");
		}
		
		s.assertTrue(file1.exists(), "file1 exists");
		s.assertTrue(file2.exists(), "file2 exists");
		s.assertAll();		
	} 
	
}
