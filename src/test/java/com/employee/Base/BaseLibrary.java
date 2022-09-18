package com.employee.Base;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseLibrary
{
	public static RequestSpecification httpRequest;
	
	public static Response response;
	
	public String id="2";
	
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		logger=Logger.getLogger("EmployeeRestAPI");//added logger
		PropertyConfigurator.configure("Log4j.properties");//added logger
		logger.setLevel(Level.DEBUG);
	}

}
