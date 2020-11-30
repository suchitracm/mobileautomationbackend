package com.qa.json.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class ReportUtilities{
	
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
	 path=System.getProperty("user.dir")+"\\MobileAutomationReport\\Report"+fpath;
	report = new ExtentReports(path);	
	test = report.startTest("MobileAutomation Test Cases Started");
	report.addSystemInfo("HostName","localhost");
	report.addSystemInfo("Environment","QA");
	report.addSystemInfo("User","Suchitra");
	
	
	
}






	
	

}
