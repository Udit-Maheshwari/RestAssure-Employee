import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request 
{
	@Test
	void getSingleUserDetail()
	{
		//Specify base URI
		RestAssured.baseURI="https://reqres.in/api/users";
		
		//Request Object(send request to server)
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object
		Response response=httpRequest.request(Method.GET,"/2");
		
		//print response in console window
		String responseBody=response.body().asString();
		System.out.println("Response Body is:"+responseBody);
		
		//status code validation
		int statuscode=response.getStatusCode();
		System.out.println("Status code is :"+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//if status line is there so how to verify
//		String statusLine=response.getStatusLine();
//		System.out.println("Status Line code is:"+statusLine);
	}

}
