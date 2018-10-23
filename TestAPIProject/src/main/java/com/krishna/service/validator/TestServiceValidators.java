package com.krishna.service.validator;

import org.testng.asserts.Assertion;
import com.google.gson.Gson;
import com.krishna.service.model.ResponsePojoBuilder;
import com.krishna.service.model.TestService;
import com.sun.jersey.api.client.ClientResponse;

public class TestServiceValidators {

	public static class Validator {

		ClientResponse response;
		Assertion assertChain;
		ResponsePojoBuilder responsePojo;
		TestService testService;

		public Validator(ClientResponse response) {
			assertChain = new Assertion();
			this.response = response;
		}

		// Validates the response code
		public Validator responseCode(String responseCode) {
			assertChain.assertEquals(responseCode, String.valueOf(response.getStatus()),
					"Expected response is not matching with actual Response");
			return this;
		}

		// Validates results count from response
		public Validator validateResultsCount(TestService testService, String responseBody) {
			int count;
			ResponsePojoBuilder results = new Gson().fromJson(responseBody, ResponsePojoBuilder.class);
			int resultsCount = results.getResults().length;
			try {
				count = Integer.parseInt(testService.getCount());
				//To Check if the count is greater than 0
				if (count > 0) {
					assertChain.assertEquals(resultsCount, testService.getCount(),
							"Result count from the response is not matching with the count from params");
				//To check if the count is equal to 0
				} else if(count == 0) {
					assertChain.assertEquals(resultsCount, 16,
							"Service is not returning all the results");
				//To check if the count is less than 0
				}else {
					assertChain.fail("count values are negative but still we got the response from service");
				}
			} catch (IllegalArgumentException e) {
				assertChain.fail("Deserialization of response is not working");
			}
			return this;
		}
	}
}