package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class readXLS {
	
	@Test
	public void dataReadTest() throws Exception {
		File src = new File("\\src\\\\test\\\\resources\\\\testdata\\\\testdata.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook xsf = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = xsf.getSheetAt(0);
		
		String Browser=sheet.getRow(1).getCell(1).getStringCellValue();
				
		System.out.println("The Browser in the box is " + Browser);
		
		xsf.close();
		
		
		
	}

}
