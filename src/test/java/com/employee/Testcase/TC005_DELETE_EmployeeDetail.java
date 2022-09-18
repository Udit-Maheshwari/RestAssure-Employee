package com.employee.Testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.Base.BaseLibrary;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TC005_DELETE_EmployeeDetail extends BaseLibrary
{
	@BeforeClass
	public void deleteEmployeeDetail() throws InterruptedException
	{
		logger.info("*****Started TC005_DELETE_EmployeeDetail*****");
		RestAssured.baseURI="https://reqres.in/api";
		
		httpRequest=RestAssured.given();
		
		response=httpRequest.request(Method.GET, "/users");
		
		//First get the HsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator=response.jsonPath();
		
		//capture id
		//String employeeId=jsonPathEvaluator.get("[0].id");
		response=httpRequest.request(Method.DELETE, "/users/" +id);
		Thread.sleep(5000);
		
	}
	
	@Test
	public void getresponseBody()
	{
		logger.info("*****Checking Response Body*****");
		String responseBody=response.getBody().asString();
		logger.info("Response Body is==>"+responseBody);
		
		
	}
	
	@Test
	public void checkStatusCode()
	{
		logger.info("*****Checking Status code*****");
		int statuscode=response.getStatusCode();
		logger.info("Status code is==>"+statuscode);
		Assert.assertEquals(statuscode, 204);
	}
	
	@Test
	public void getResponseTime()
	{
		logger.info("**********Checking Response Time**********");
		long responseTime=response.getTime();
		logger.info("Response Time is==>:"+responseTime);
		if(responseTime>2000)
		{
			logger.warn("Response Time is Greater Than 2000");
		}
		Assert.assertTrue(responseTime<2000);
	}
	
	@Test
	public void checkContentType()
	{
		logger.info("**********Checking Content Type**********");
		String contentType=response.header("Content-Type");
		logger.info("Content Type is==> :"+contentType);
		Assert.assertEquals(contentType, null);
	}
	
	@Test
	public void checkServerType()
	{
		logger.info("**********Checking Server Type**********");
		String Server=response.header("Server");
		logger.info("Server Type is==>:"+Server);
		Assert.assertEquals(Server, "cloudflare");
	}
	
	@AfterClass
	public void tearDown()
	{
		logger.info("*****Finished TC005_DELETE_EmployeeDetai*****");
	}

}
