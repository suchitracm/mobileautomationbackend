package com.qa.wiremockproject;

import org.junit.runner.RunWith;
import cucumber.api.junit.*;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature",
					glue= {"com.qa.wiremockproject.Steps"},
					tags={"@Userdetails"},
					format= {"pretty","html:test-output","json:json.cucumber.json","junit:junit_report.cucumber.xml"})
public class TestRunner extends AbstractTestNGCucumberTests {
	
	

}
