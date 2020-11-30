package com.qa.wiremockproject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.json.Utilities.ReportUtilities;
import com.qa.json.Utilities.RestUtils;
import com.qa.wiremockproject.Base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WireMockTest extends TestBase {

	

	

	static Response response;
	static String responseBodystr;
	
	static HashMap map = new HashMap();
	static String post_userid;
	static String post_username;
	static String post_password;
	
	static HashMap putRequestMap = new HashMap();
	static String put_userid;
	static String put_username;
	static String put_password;
	
	
	
	public void testStatusCodePositive() {
		System.out.println("testStatucCodePositive Message");
		given().when().get("http://localhost:8090/an/users").then().assertThat().statusCode(200);
	}

	public void testStatusCodeNegative() {
		given().when().get("http://localhost:8090/another/users").then().assertThat().statusCode(404);
	}

	public static void getRequest() {
		response = given().when().get("http://localhost:8090/an/users");
		responseBodystr = response.getBody().asString();

	}

	public static void responseBodyString() {
		// Printing response as string
		Assert.assertTrue(responseBodystr != null);
		logger.info(responseBodystr);
		ReportUtilities.test.log(LogStatus.PASS, "Response Body successfully verified");

	}

	public static void testResponseContents() {
		ArrayList userList = (ArrayList) response.jsonPath().getList("username");
		System.out.println(userList.size());
		Assert.assertTrue(responseBodystr.contains(singleUser));
	}
	
	public static void testResponseContents(String validating_username) {
		ArrayList userList = (ArrayList) response.jsonPath().getList("username");
		System.out.println(userList.size());
		Assert.assertTrue(responseBodystr.contains(validating_username));
	}

	public static void validateDeleteUser(String validating_username) {
		ArrayList userList = (ArrayList) response.jsonPath().getList("username");
		System.out.println(userList.size());
		Assert.assertFalse(responseBodystr.contains(validating_username));
	}
	public static void t1_AllUserResponse() {
		logger.info("**************** Test Case 1 Started ****************");
		logger.info("**************** Checking All User Response Body ****************");
		ReportUtilities.initializeReports();
		ReportUtilities.test.log(LogStatus.INFO, "T1_AllUserResponse Test case started");

		// Creating json array for the json response
		JSONArray jarray = new JSONArray(responseBodystr);
		System.out.println(responseBodystr);
		System.out.println(jarray.length());
		
		ReportUtilities.test.log(LogStatus.PASS, "List of all Users listed successfully");
		logger.info("**************** Test Case 1 completed successfully ****************");

	}
	
	public static void t2_SingleUserResponse() {
		logger.info("**************** Test Case 2 Started ****************");
		logger.info("**************** Checking A Single User Response Body ****************");
		ReportUtilities.test.log(LogStatus.INFO, "t2_SingleUserResponse Test case started");

		// Creating json array for the json response
		ArrayList userList = (ArrayList) response.jsonPath().getList("username");
		System.out.println(userList.size());
		Assert.assertTrue(responseBodystr.contains(singleUser));
		
		for (int i=0;i<userList.size();i++){
			System.out.println(userList.get(i));
			
		}
		
		//To print the response with the username
		JSONArray jarray = new JSONArray(responseBodystr);
		System.out.println(jarray.length());
		for(int i=0;i<jarray.length();i++)
		{
		JSONObject jusername = (JSONObject) jarray.get(i);
		String juser = jusername.getString("username");
		if(juser.equals(singleUser))
				{
			System.out.println(jusername);
				}
//		System.out.println(juser);
		}
		 
			
		ReportUtilities.test.log(LogStatus.PASS, "TestCase 2 Validating single User completed successfully");
		logger.info("**************** Test Case 2 completed successfully ****************");

	}
	
	public static void postNewUser() {
		post_userid = RestUtils.getUserId();
		post_username = RestUtils.getUserName();
		post_password = RestUtils.getPassword();
		map.put("id",Integer.parseInt(post_userid));
		map.put("username",post_username);
		map.put("password",post_password);
		RestAssured.baseURI="http://localhost:8090/an/users";
		RestAssured.basePath="/create";
	
	}
	
	public static void putUserDetail() {
		put_userid = post_userid;
		put_username = RestUtils.getUserName();
		put_password = RestUtils.getPassword();
		putRequestMap.put("id",put_userid);
		putRequestMap.put("username",put_username);
		putRequestMap.put("password",put_password);
		
		RestAssured.baseURI="http://localhost:8090/an/users";
		RestAssured.basePath="/update/"+put_userid;
	}
	
	
	
	
	
	
	public static void t3_CreateNewUser() {
		logger.info("**************** Test Case 3 Started ****************");
		logger.info("**************** Creating New User ****************");
		ReportUtilities.test.log(LogStatus.INFO, "t3_CreateNewUser Test case started");
		
		postNewUser();
		// Creating new user using http post request
		given().contentType("application/json").body(map).when().post().then().statusCode(201);
		
		//Asserting new username
		getRequest();
		responseBodyString();
		testResponseContents(post_username);
		
			
		ReportUtilities.test.log(LogStatus.PASS, "TestCase 3 Create New User completed successfully");
		logger.info("**************** Test Case 3 completed successfully ****************");

	}
	
	public static void t4_UpdateUserName() {
		logger.info("**************** Test Case 4 Started ****************");
		logger.info("**************** Updating UserName ****************");
		ReportUtilities.test.log(LogStatus.INFO, "t4_UpdateUserName Test case started");
		
		putUserDetail();
		// Creating new user using http post request
		given().contentType("application/json").body(putRequestMap).when().put().then().statusCode(201);
		
		//Asserting new username
		getRequest();
		responseBodyString();
		testResponseContents(put_username);
		
			
		ReportUtilities.test.log(LogStatus.PASS, "TestCase 4 Update User Detail completed successfully");
		logger.info("**************** Test Case 3 completed successfully ****************");

	}
	
	public static void t5_DeleteUserName() {
		logger.info("**************** Test Case 5 Started ****************");
		logger.info("**************** Delete User Name ****************");
		ReportUtilities.test.log(LogStatus.INFO, "t5_DeleteUserName Test case started");
		
		RestAssured.baseURI="http://localhost:8090/an/users";
		RestAssured.basePath="/delete/"+put_userid;
		
		// Delete user using http post request
		given().when().delete().then().statusCode(200);
		
		//Asserting new username
		getRequest();
		responseBodyString();
		validateDeleteUser(put_username);
		
			
		ReportUtilities.test.log(LogStatus.PASS, "TestCase 5 Delete User completed successfully");
		logger.info("**************** Test Case 5 completed successfully ****************");

	}
}