import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC003_GET_Header 
{
	@Test
	void getHeader()
	{
		RestAssured.baseURI="https://reqres.in/api";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET, "/users?page=2");
		
		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :"+responseBody);
		
		//validating content type header
		String contentType=response.header("Content-Type");//capture details of content-type from header
		System.out.println("Content Type header detail is :"+contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
		//validating Content-Encoding type header
		String TransferEncoding=response.header("Transfer-Encoding");
		System.out.println("Counter Encoding header detail is :"+TransferEncoding);
		Assert.assertEquals(TransferEncoding, "chunked");
	}

}
