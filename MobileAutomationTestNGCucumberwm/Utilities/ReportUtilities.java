package com.json.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.json.Base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class ReportUtilities  extends TestBase{
	
	public static ExtentReports report;
	public static ExtentTest test;
	public static String fpath;
	public static String path;

	/*Method Name: initializeReports
	  Method Description : Allows to take screenshot
	  Date Created:
	 */	
public static void initializeReports()
{
	 fpath = new SimpleDateFormat("'Currentdate_'MMddYYYY'.html'").format(new Date());
	 path = "D:\\TechArch\\InterviewQuestions\\SeleniumAssignment\\RentalCarJsonDataRESTWireMockServerReports\\Report" +fpath;
	report = new ExtentReports(path);	
	test = report.startTest("Rental Cars Test Cases Started");
	report.addSystemInfo("HostName","localhost");
	report.addSystemInfo("Environment","QA");
	report.addSystemInfo("User","Suchitra");
	
	
	
}






	
	

}
