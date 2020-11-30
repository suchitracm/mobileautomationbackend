package com.qa.wiremockproject.Base;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.qa.json.Utilities.ReportUtilities;

public class TestBase {
	public WireMockServer wireMockServer;
	public static Logger logger;
	public static Properties prop;
	public static String singleUser;
	public static String newUserjson;
	public static Long newuserid;
	public static String newusername;
	public static String newpassword;
	
	
	public void setupStub() throws IOException, ParseException {
		wireMockServer.stubFor(get(urlEqualTo("/an/users")).willReturn(aResponse()
				.withHeader("Content-Type", "text/plain").withStatus(200).withBodyFile("json/userdetails2.json")));
		prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\TechArch\\InterviewQuestions\\SeleniumAssignment\\MobileAutomationTestNGCucumberwm\\src\\test\\java\\com\\qa\\wiremockproject\\Config\\userdetails.properties");
		prop.load(ip);
		singleUser = prop.getProperty("UserName");
		System.out.println("singleUser "+singleUser);
		
		readNewUser_jsonfile();
			
	}

	
	public static void readNewUser_jsonfile() throws IOException, ParseException
	{
		String jfile = "\\src\\test\\resources\\__files\\json\\newuser.json";
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.dir")+jfile);
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(System.getProperty("user.dir")+jfile);
		Object obj = parser.parse(reader);
		JSONObject userobject = (JSONObject)obj;
		newuserid = (Long)userobject.get("id");
		newusername = (String)userobject.get("username");
		newpassword = (String)userobject.get("password");
		System.out.println(newuserid+" "+newusername+" "+newpassword);
	
	}
	
	
	
	public static void init_report()
	{
		ReportUtilities.initializeReports();

	}
	
	public static void logout()
	{
		ReportUtilities.report.endTest(ReportUtilities.test);
		ReportUtilities.report.flush();
	}

	
	
}
