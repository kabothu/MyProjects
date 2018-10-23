package com.krishna.service.tests;

import org.testng.annotations.Test;
import com.krishna.service.client.TestServiceClientResponse;
import com.krishna.service.dataprovider.TestServiceDataProvider;
import com.krishna.service.model.TestService;
import com.krishna.service.requestbuilder.TestServiceRequestBuilder;
import com.krishna.service.validator.TestServiceValidators;
import com.krishna.services.util.TestServiceURLBuilder;
import com.sun.jersey.api.client.ClientResponse;



public class TestServiceTests extends BaseTest {
	
	protected final TestServiceClientResponse getServiceClientResponse = new TestServiceClientResponse();

	@Test(dataProvider = "getTestService_dataProvider", dataProviderClass = TestServiceDataProvider.class)

	public void testGetServiceCallWithMovieName(String url, TestService getTestService) throws Exception {

		// Get the URL
		String testServiceUrl = new TestServiceURLBuilder(url).buildGetURLBasedOnParams(getTestService,
				"URI_GET_PARAMS");

		// Request Builder
		TestServiceRequestBuilder testServiceRequest = new TestServiceRequestBuilder(testServiceUrl);

		// Get Response
		ClientResponse response = getServiceClientResponse.getResponse(testServiceRequest);

		// Logging Info
		getServiceClientResponse.loggerInfo(response.getHeaders(), response.getStatus(),
				response.getEntity(String.class));

		// Check if the Get Service is working with different movie names
		new TestServiceValidators.Validator(response).responseCode(getTestService.getExpectedResponseCode());
	}

	@Test(dataProvider = "getTestServiceWithCount_dataProvider", dataProviderClass = TestServiceDataProvider.class)
	public void testGetServiceCallWithCount(String url, TestService getTestService) throws Exception {

		// Get the URL
		String testServiceUrl = new TestServiceURLBuilder(url).buildGetURLBasedOnCount(getTestService,
				"URI_GET_PARAMS");

		// Request Builder
		TestServiceRequestBuilder testServiceRequest = new TestServiceRequestBuilder(testServiceUrl);

		// Get Response
		ClientResponse response = getServiceClientResponse.getResponse(testServiceRequest);

		String responseBody = response.getEntity(String.class);

		// Logging Info
		getServiceClientResponse.loggerInfo(response.getHeaders(), response.getStatus(), responseBody);

		// a.Check if the Get Service is working with different count values
		// b.Check if the results count is matching with the values passed through params

		new TestServiceValidators.Validator(response)
								 .responseCode(getTestService.getExpectedResponseCode())
								 .validateResultsCount(getTestService, responseBody);
	}
}