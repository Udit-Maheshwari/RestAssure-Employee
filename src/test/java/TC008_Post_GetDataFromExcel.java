import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataProvider.DataProvider_Demo;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC008_Post_GetDataFromExcel 
{

	@Test(dataProvider="fillEmployyeDetail", dataProviderClass=DataProvider_Demo.class)
	public void getupdateData(String emailId, String efirstname, String elastname)
	{
		RestAssured.baseURI="https://reqres.in/api";
		
		RequestSpecification httpRequest= RestAssured.given();
		
		JSONObject jsonOb= new JSONObject();
		jsonOb.put("email", emailId);
		jsonOb.put("first_name", efirstname);
		jsonOb.put("last_name", elastname);
		
		httpRequest.header("Content-Type", "application/json");// create header with the help of this
		
		httpRequest.body(jsonOb.toJSONString());
		
		Response response= httpRequest.request(Method.POST, "/users");
		
		String jsonBody=response.getBody().asString();
		System.out.println("Json Body is :"+jsonBody);
		
		int statuscode=response.getStatusCode();
		System.out.println("Status code is :"+statuscode);
		Assert.assertEquals(statuscode, 201);
		
		
		
	}

//	static String path="C:\\Users\\Asus\\eclipse-workspace\\RestAssured\\Test Data\\TestDataofRestAPI.xlsx";
//		
//		@DataProvider(name="fillEmployyeDetail")
//		
//		public Object[][] getData() throws IOException
//		{
//			Object[][] data=exceldata(path, "Sheet1");
//			return data;
//			
//		}
//
//		public static Object[][] exceldata(String path, String excelSheet) throws IOException
//		{
//			FileInputStream fls= new FileInputStream(path);
//			XSSFWorkbook workbook = new XSSFWorkbook(fls);
//			XSSFSheet sheet=workbook.getSheet(excelSheet);
//			
//			int totalrow=sheet.getLastRowNum()+1;
//			int totalcol=sheet.getRow(0).getLastCellNum();
//			
//			Object[][] data= new Object[totalrow-1][totalcol];
//			for(int row=1; row<totalrow; row++)
//			{
//				for(int col=0; col<totalcol; col++)
//				{
//					data[row-1][col]=sheet.getRow(row).getCell(col).getStringCellValue();
//				}
//			}
//			workbook.close();
//		
//		return data;
//			
//			
//			
//			
//			
//		}
	}


