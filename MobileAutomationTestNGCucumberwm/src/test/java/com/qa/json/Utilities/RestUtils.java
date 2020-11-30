package com.qa.json.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getUserId() {
		String generatedString =RandomStringUtils.randomNumeric(3);
		return("211"+generatedString);
	}
	
	public static String getUserName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Jack"+generatedString);
	}
	
	public static String getPassword(){
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("Jack"+generatedString);
	}

}
