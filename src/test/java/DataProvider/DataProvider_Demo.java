package DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProvider_Demo 
{
	String path="C:\\Users\\Asus\\eclipse-workspace\\RestAssured\\Test Data\\TestDataofRestAPI.xlsx";
	
	@DataProvider(name="fillEmployyeDetail")
	
	public Object[][] getData() throws IOException
	{
		Object[][] data=exceldata(path, "Sheet1");
		return data;
		
	}

	public static Object[][] exceldata(String path, String excelSheet) throws IOException
	{
		FileInputStream fls= new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fls);
		XSSFSheet sheet=workbook.getSheet(excelSheet);
		
		int totalrow=sheet.getLastRowNum()+1;
		int totalcol=sheet.getRow(0).getLastCellNum();
		
		Object[][] data= new Object[totalrow-1][totalcol];
		for(int row=1; row<totalrow; row++)
		{
			for(int col=0; col<totalcol; col++)
			{
				data[row-1][col]=sheet.getRow(row).getCell(col).getStringCellValue();
			}
		}
		workbook.close();
	
	return data;
		
		
		
		
		
	}
}
