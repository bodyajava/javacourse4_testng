package home.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class FileCreationBase {
	
	String basedir = ("/Users/bogdanlaukhin/Documents/");
	String tmp_dir_prefix = "Temp3";	
	File dir = new File(basedir + tmp_dir_prefix);
	
	@BeforeClass
	public void setUp(Method m) {
		
		if (!dir.exists()) {
			if (dir.mkdir()) {
				System.out.println("Temp directory is created.");
			}
		} else {
			try { FileUtils.cleanDirectory(dir); }
			catch (IOException e) { e.printStackTrace(); }
		}
		
		if (m.getAnnotation(ReadOnlyDir.class) !=null) {
			dir.setReadOnly();
		}
		
		/*Annotation[][] parameters = m.getParameterAnnotations();
		for (Annotation[] parameter : parameters) {
			System.out.println(parameter);
				//dir.setReadOnly();
				
			}
		*/
		
	}
	
	//@AfterClass
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
	
	@DataProvider
	public static Iterator<Object[]> FileNamesGeneratorXLS(Method m) throws IOException {
		if (m.isAnnotationPresent(XlsDataSource.class)) {
			//int lenght = m.getParameterTypes().length;
			XlsDataSource dataSource = m.getAnnotation(XlsDataSource.class);
			File xlsFile = new File(dataSource.value());
			
			return loadFileNamesFromXlsFile(xlsFile).iterator();
		}
		
		return null;
	}
	
	public static List<Object[]> loadFileNamesFromXlsFile(File fileName) throws IOException {
		List<Object[]> list = new ArrayList<Object[]>();
		
		FileInputStream xlsfile = new FileInputStream(fileName);
		HSSFWorkbook workbook = new HSSFWorkbook(xlsfile);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch(cell.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    break;
                case Cell.CELL_TYPE_STRING:
                	list.add(new Object[] {cell.getStringCellValue()});
                    break;
				}
			}
			
		}	
		return list;
	}

}
