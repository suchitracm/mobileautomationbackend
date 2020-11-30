package com.qa.wiremockproject.Steps;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.parser.ParseException;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.qa.wiremockproject.Base.TestBase;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends TestBase {

	public Hooks() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Before
	public void setup() throws IOException, ParseException {
		logger = Logger.getLogger("User Details");// added Logger
		PropertyConfigurator.configure("Log4j.properties");// added Logger
		logger.setLevel(Level.DEBUG);
		wireMockServer = new WireMockServer(8090);
		wireMockServer.start();
		setupStub();

	}

	@After
	public void teardown() {

		wireMockServer.stop();
	}

}
