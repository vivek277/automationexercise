package utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static Object[][] readExcelData(){
		
		Object[][] data = null;
		
	try {
		FileInputStream fis = new FileInputStream("src/test/resources/data.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Sheet1");
		
		int Row = sh.getPhysicalNumberOfRows();
		int Col = sh.getRow(0).getLastCellNum();
		
		data = new Object[Row - 1][Col];
		
		for(int i =1;i<Row;i++) 
		   {
			for(int j=0;j<Col;j++)
			{
				data[i-1][j]= sh.getRow(i).getCell(j).toString();
			}
		   }
		wb.close();
		fis.close();
	    } catch(Exception e) {
		e.printStackTrace();
	    }
		return data;	
	}
}
