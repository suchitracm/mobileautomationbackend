package com.json.Utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners2 extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public ExtentReports report;
	
	public void onStart(ITestContext testContext)
	{
		htmlReporter = new ExtentHtmlReporter("D:\\TechArch\\InterviewQuestions\\SeleniumAssignment\\ListenersReports\\myReport.html");//specify location
		
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Rental Car Rest API Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","Suchitra");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS,"Test case PASSED IS "+result.getName());
		
	}

	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL,"Test case FAILED IS "+result.getName());
		test.log(Status.FAIL,"Test case FAILED IS "+result.getThrowable());
	}

	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.SKIP,"Test case SKIPPED IS "+result.getName());
	}
	
	public void onTestFinish(ITestResult result)
	{
		extent.flush();
	}
	
	
	
	
}
