package com.krishna.service.requestbuilder;

import java.util.HashMap;
import java.util.Map;

import com.sun.jersey.api.client.Client;

public class TestServiceRequestBuilder {

	public String CONTENT_TYPE = "application/json";
	private Client client;
	private Map<String, String> requestHeaders = new HashMap<String, String>();
	private String url;

	public TestServiceRequestBuilder(String url) {
		this.url = url;
		this.client = new Client();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Map<String, String> getRequestHeaders() {
		return requestHeaders;
	}

	public void setRequestHeaders(Map<String, String> requestHeaders) {
		this.requestHeaders = requestHeaders;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
