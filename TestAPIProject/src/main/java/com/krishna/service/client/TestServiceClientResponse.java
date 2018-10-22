package com.krishna.service.client;

import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;
import com.krishna.service.requestbuilder.TestServiceRequestBuilder;
import com.krishna.services.util.LoggerHelper;
import com.sun.jersey.api.client.ClientResponse;

public class TestServiceClientResponse {

	private Logger logger;
	ClientResponse response;

	public TestServiceClientResponse() {
		if (logger == null) {
			logger = LoggerHelper.getLogger(TestServiceClientResponse.class);
		}
	}

	public ClientResponse getResponse(TestServiceRequestBuilder request) {
		logger.info("Get http Request: " + request.getUrl());
		this.response = request.getClient().resource(request.getUrl()).accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		getLoggerInfo();
		return response;
	}

	public ClientResponse getPostResponse(String payload, TestServiceRequestBuilder request) {
		logger.info("Get http Request: " + request.getUrl());
		this.response = request.getClient().resource(request.getUrl()).accept(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, payload);
		getLoggerInfo();
		return response;
	}

	public ClientResponse getPutResponse(String payload, TestServiceRequestBuilder request) {
		logger.info("Get http Request: " + request.getUrl());
		this.response = request.getClient().resource(request.getUrl()).accept(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, payload);
		getLoggerInfo();
		return response;
	}

	public ClientResponse getDeleteResponse(TestServiceRequestBuilder request) {
		logger.info("Get http Request: " + request.getUrl());
		this.response = request.getClient().resource(request.getUrl()).accept(MediaType.APPLICATION_JSON)
				.delete(ClientResponse.class);
		getLoggerInfo();
		return response;
	}

	public void getLoggerInfo() {
		logger.info("Response Headers: " + response.getHeaders());
		logger.info("Response Status: " + response.getStatus());
		logger.info("Response Returned: " + response.getEntity(String.class));
	}
}
