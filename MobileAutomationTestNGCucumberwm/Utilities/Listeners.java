package com.json.Utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.relevantcodes.extentreports.LogStatus;

public class Listeners extends TestListenerAdapter {

	public void onStart(ITestContext testContext) {

		System.out.println("Test Cases Started");

	}

	public void onTestSuccess(ITestResult result) {
		ReportUtilities.test.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		ReportUtilities.test.log(LogStatus.FAIL, "Test case FAILED IS " + result.getName());
		ReportUtilities.test.log(LogStatus.FAIL, "Test case FAILED IS " + result.getThrowable());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case skipped"+result.getName());
		ReportUtilities.test.log(LogStatus.SKIP, "Test case SKIPPED IS " + result.getName());
	}

	public void onTestFinish(ITestResult result) {
		System.out.println("Rental Car Project Ended");
	}

}
