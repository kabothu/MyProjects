package com.krishna.services.util;

import com.krishna.service.model.TestService;


public class TestServiceURLBuilder {

	@SuppressWarnings("unused")
	private String url;
	private StringBuilder urlBuilder = new StringBuilder();
	private static final String PROPERTY_FILE_NAME = "/src/main/resources/com/krishna/services/testservice/content/testService.properties";
	private TestServiceConfigFileUtil testServiceConfigFileUtil = new TestServiceConfigFileUtil();

	public TestServiceURLBuilder(String url) {
		this.url = url;
		urlBuilder.append(url);
	}

	public String buildGetURLBasedOnParams(
			TestService testService, String params) {
		urlBuilder.append(testServiceConfigFileUtil.getPropertyValue(PROPERTY_FILE_NAME,params));
		urlBuilder.append("?q=");
		urlBuilder.append(testService.getName());
		return urlBuilder.toString();
	}
	
	public String buildGetURLBasedOnCount(
			TestService testService, String params) {
		urlBuilder.append(testServiceConfigFileUtil.getPropertyValue(PROPERTY_FILE_NAME,params));
		urlBuilder.append("?q=");
		urlBuilder.append(testService.getName());
		urlBuilder.append("&count=");
		urlBuilder.append(testService.getCount());
		return urlBuilder.toString();
	}
}