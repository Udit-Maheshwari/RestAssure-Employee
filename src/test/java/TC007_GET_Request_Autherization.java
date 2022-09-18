import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC007_GET_Request_Autherization 
{

	@Test
	void getSingleUserDetail()
	{
		//Specify base URI
		RestAssured.baseURI="https://reqres.in/api/users";
		
		//Basic Authenication used for provide password & username
		PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
		authscheme.setUserName("Udit");
		authscheme.setPassword("Udit123");
		
		RestAssured.authentication=authscheme;
		
		
		//Request Object(send request to server)
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object
		Response response=httpRequest.request(Method.GET,"/2");
		
		

}
}
