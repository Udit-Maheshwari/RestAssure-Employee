package com.employee.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils 
{
	public static String emailId()
	{
		String generatingEmail=RandomStringUtils.randomAlphabetic(1);
		return("udit"+generatingEmail+"@gmail.com");
	}
	
	public static String firstName()
	{
		String generatingFirstName=RandomStringUtils.randomAlphabetic(1);
		return("Udit"+generatingFirstName);
	}
	
	public static String lastName()
	{
		String generatingastName=RandomStringUtils.randomAlphabetic(1);
		return("Maheshwari"+generatingastName);
	}
	
	public static String jobDetail()
	{
		String generatingJobDetail=RandomStringUtils.randomAlphabetic(1);
		return("Software Engineer"+generatingJobDetail);
	}

}
