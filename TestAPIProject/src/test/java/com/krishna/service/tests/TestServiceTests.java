package com.krishna.service.tests;

import org.testng.annotations.Test;

import com.krishna.service.client.TestServiceClientResponse;
import com.krishna.service.dataprovider.TestServiceDataProvider;
import com.krishna.service.model.TestService;
import com.krishna.service.requestbuilder.TestServiceRequestBuilder;
import com.krishna.services.util.TestServiceURLBuilder;



public class TestServiceTests extends BaseTest {
	
	protected final TestServiceClientResponse getServiceClientResponse = new TestServiceClientResponse();

	@Test(dataProvider = "getTestService_dataProvider", dataProviderClass = TestServiceDataProvider.class)
	public void testService(String url,TestService getTestService)throws Exception {
		
        //Get the URL
		String testServiceUrl = new TestServiceURLBuilder(url).buildURLBasedOnName(getTestService);
		
		//Request Builder
		TestServiceRequestBuilder testServiceRequest = new TestServiceRequestBuilder(testServiceUrl);
		
		//Get Response
		getServiceClientResponse.getResponse(testServiceRequest);
		
	}
}