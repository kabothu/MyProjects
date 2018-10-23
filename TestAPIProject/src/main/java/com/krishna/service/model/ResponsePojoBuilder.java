package com.krishna.service.model;

public class ResponsePojoBuilder {

	private Results[] results;

	public Results[] getResults() {

		return results;

	}

	public void setResults(Results[] results) {

		this.results = results;

	}

	@Override
	public String toString() {

		return "ResponsePojoBuilder [results = " + results + "]";

	}

}