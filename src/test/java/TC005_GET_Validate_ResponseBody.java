import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Validate_ResponseBody
{
	@Test
	public void getValidateResponseBody()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET, "/2");
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :"+responseBody);
		
		Assert.assertEquals(responseBody.contains("janet.weaver@reqres.in"), true);
	}
	
	

}
