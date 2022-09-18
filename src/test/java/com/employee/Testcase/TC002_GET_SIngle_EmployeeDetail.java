package com.employee.Testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.Base.BaseLibrary;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC002_GET_SIngle_EmployeeDetail extends BaseLibrary
{
	@BeforeClass
	public void getEmployeeData()
	{
		logger.info("*****Started TC002_GET_SIngle_EmployeeDetail*****");
		RestAssured.baseURI="https://reqres.in/api";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/users/"+id);
	}
	
	@Test
	public void getResponseBody()
	{
		logger.info("*****Checking Response Body*****");
		String responsBody=response.getBody().asString();
		logger.info("Response Body is==>"+responsBody);
		Assert.assertEquals(responsBody.contains(id), true);
	}

	@Test
	public void checkStatuscode()
	{
		logger.info("**********Check Status Code**********");
		int responseCode=response.getStatusCode();
		logger.info("Resonse code is ==>"+responseCode);
		Assert.assertEquals(responseCode, 200);
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
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
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
		logger.info("********** Finished TC001_GET_All_EmployeeDetail**********");
	}

}
