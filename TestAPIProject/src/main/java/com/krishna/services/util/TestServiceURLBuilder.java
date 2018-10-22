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

	public String buildURLBasedOnName(
			TestService testService) {
		urlBuilder.append(testServiceConfigFileUtil.getPropertyValue(PROPERTY_FILE_NAME,"URI_GET_PARAMS"));
		urlBuilder.append("?name=");
		urlBuilder.append(testService.getName());
		urlBuilder.append("?description=");
		urlBuilder.append(testService.getDescription());
		
		return urlBuilder.toString();
	}
}