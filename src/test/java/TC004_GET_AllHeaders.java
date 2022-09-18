import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_AllHeaders
{

	@Test
	public void getAllHeader()
	{
		RestAssured.baseURI="https://reqres.in/api";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET, "/users?page=2");
	
		//get Response body
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :"+responseBody);
		
		long time=response.time();
		System.out.println("Response Time is :"+time);
		
		// to get all Header
		Headers allHeader=response.headers();// capture all the header from response
		for(Header header:allHeader)
		{
			System.out.println(header.getName()+"         "+header.getValue());
		}
		
		
	}

}
