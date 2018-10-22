package com.krishna.service.model;

public class TestServiceMock {

	private TestService[] testService;

	public TestService[] getTestService() {
		return testService;
	}

	public void setTestService(TestService[] testService) {
		this.testService = testService;
	}

	@Override
	public String toString() {
		return "ClassPojo [testService = " + testService + "]";
	}
}