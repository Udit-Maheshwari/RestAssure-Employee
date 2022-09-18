import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_POST_Request 
{
	@Test
	void createUser()
	{
		RestAssured.baseURI="https://reqres.in/api";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		//create Body to send data because this is a Post Request
		//Request payload  sending along with post request
		JSONObject requestParams=new JSONObject();// firest create JSON object
		requestParams.put("name", "Udit");// this is JSON Parameter
		requestParams.put("job", "Software Engineer"); // this is JSON Parameter
		
		httpRequest.header("Content-Type", "application/json");// create header with the help of this
		
		//convert data into an JSON formatrequestParams & attach data in request
		httpRequest.body(requestParams.toJSONString());
		
		//sending a request
		
		Response response= httpRequest.request(Method.POST, "/users");
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :"+responseBody);
		
		//verify status code
		int responseCode=response.getStatusCode();
		System.out.println("Response code is :"+responseCode);
		Assert.assertEquals(responseCode, 201);
		
		//verify sucess code validation
		String sucessCode=response.jsonPath().get("name");
		System.out.println("Sucess Code is :"+sucessCode);
		Assert.assertEquals(sucessCode, "Udit");
	}

}
