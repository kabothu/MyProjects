package com.krishna.service.model;

public class TestService {
	private String description;

	private String name;
	
	private String count;
	
	private String expectedResponseCode;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getExpectedResponseCode() {
		return expectedResponseCode;
	}

	public void setExpectedResponseCode(String expectedResponseCode) {
		this.expectedResponseCode = expectedResponseCode;
	}

	@Override
	public String toString() {
		return "[description = " + description + ", name = " + name + "]";
	}
}
