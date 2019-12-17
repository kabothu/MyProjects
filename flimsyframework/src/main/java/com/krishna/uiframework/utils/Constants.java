package com.krishna.uiframework.utils;

public class Constants {

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String CHROMEDRIVER_PATH = (PROJECT_PATH
			+ "/src/main/resources/com/krishna/testData/chromedriver").replace('\\', '/');
	public static final String GECKODRIVER_PATH = (PROJECT_PATH
			+ "/src/main/resources/com/krishna/testData/geckodriver").replace('\\', '/');

}