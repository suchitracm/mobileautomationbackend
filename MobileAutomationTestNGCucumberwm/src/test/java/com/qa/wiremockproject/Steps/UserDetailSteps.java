package com.qa.wiremockproject.Steps;

import com.qa.wiremockproject.WireMockTest;
import com.qa.wiremockproject.Base.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class UserDetailSteps{
	Response response;
	public static WireMockTest wiremockTest = new WireMockTest();
	
	

@Given("^I start wiremock server$")
public void i_start_wiremock_server() throws Throwable {
   System.out.println("Given Message");
   wiremockTest.testStatusCodePositive();
   wiremockTest.testStatusCodeNegative();
}

@When("^I send get request$")
public void i_send_get_request() throws Throwable {
	System.out.println("When Message");
	wiremockTest.getRequest();
}

@Then("^I should be able to get response of all users$")
public void i_should_be_able_to_get_response_of_all_users() throws Throwable {
	System.out.println("Then Message");
	wiremockTest.testResponseContents();
	WireMockTest.t1_AllUserResponse();

}

	
	
	@Then("^I should get response with a single user$")
	public void i_should_get_response_with_a_single_user() throws Throwable {
		wiremockTest.t2_SingleUserResponse();

	}

	@When("^I send post request$")
	public void i_send_post_request() throws Throwable {

	}

	@Then("^I should be able to create a new user detail$")
	public void i_should_be_able_to_create_a_new_user_detail() throws Throwable {

	}

	@When("^I send put request$")
	public void i_send_put_request() throws Throwable {

	}

	@Then("^I should be able to update an user detail$")
	public void i_should_be_able_to_update_an_user_detail() throws Throwable {

	}

	@When("^I send delete request$")
	public void i_send_delete_request() throws Throwable {

	}

	@Then("^I should be able to delete an user detail$")
	public void i_should_be_able_to_delete_an_user_detail() throws Throwable {

	}


}
