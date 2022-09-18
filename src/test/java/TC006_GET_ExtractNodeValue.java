
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_ExtractNodeValue 
{
	@Test
	public void getEveryValueofNode()
	{
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET, "/api/users/2");
		
		
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		//Extracting every node value of JSON
		JsonPath jsonpath=response.jsonPath();
		
//		System.out.println(jsonpath.get("first_name"));
//		System.out.println(jsonpath.get("email"));
	
		
	}

}
