package com.employee.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener_demo  implements ITestListener
{
	ExtentSparkReporter htmlReports;
	ExtentReports reports;
	ExtentTest test;
	
	public void configData()
	{
		htmlReports= new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/EmployeeDataBaseReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReports);
		
		reports.setSystemInfo("OS", "Window 10");
		reports.setSystemInfo("User-Name", "Udit");
		reports.setSystemInfo("Browser", "chrome");
		reports.setSystemInfo("Project Name", "Employee DataBase API");
		
		htmlReports.config().setDocumentTitle("Extent Report of Rest Assured");
		htmlReports.config().setReportName("This is First Report of Rest Assured");
		htmlReports.config().setTheme(Theme.DARK);
	}

	public void onStart(ITestContext context) 
	{
		configData();
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("This test case is Pass "+result.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("This test case is Fail "+result.getName(), ExtentColor.RED));
		
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("This test case is skip "+result.getName(), ExtentColor.YELLOW));
	}
	
	public void onFinish(ITestContext context)
	{
		reports.flush();
	}
	
	
}
