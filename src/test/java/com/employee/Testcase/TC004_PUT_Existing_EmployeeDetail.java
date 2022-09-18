package com.employee.Testcase;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.Base.BaseLibrary;
import com.employee.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC004_PUT_Existing_EmployeeDetail extends BaseLibrary
{
	String name=RestUtils.firstName();
	String job=RestUtils.jobDetail();
	@BeforeClass
	public void getUpdateEmployeeData() throws InterruptedException
	{
		logger.info("*****Started TC004_PUT_Existing_EmployeeDetail*****");
		RestAssured.baseURI="https://reqres.in/api";
		httpRequest=RestAssured.given();
		JSONObject requestparams=new JSONObject();
		requestparams.put("name", name);
		requestparams.put("job", job);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestparams.toJSONString());
	
		response=httpRequest.request(Method.PUT,"/users/"+id);
		Thread.sleep(5000);
	}
	
	@Test
	public void getresponseBody()
	{
		logger.info("*****Checking Response Body*****");
		String responseBody=response.getBody().asString();
		logger.info("Response Body is==>"+responseBody);
		Assert.assertEquals(responseBody.contains(name), true);
		Assert.assertEquals(responseBody.contains(job), true);
		
	}
	
	@Test
	public void checkStatusCode()
	{
		logger.info("*****Checking Status code*****");
		int statuscode=response.getStatusCode();
		logger.info("Status code is==>"+statuscode);
		Assert.assertEquals(statuscode, 200);
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
		logger.info("*****Finished TC004_PUT_Existing_EmployeeDetaill*****");
	}


}
