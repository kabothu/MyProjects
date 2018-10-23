package com.krishna.service.model;

public class TestServiceMock {

	private TestService[] testService;
	private TestService[] testServiceWithCount;

	public TestService[] getTestService() {
		return testService;
	}

	public void setTestService(TestService[] testService) {
		this.testService = testService;
	}

	public TestService[] getTestServiceWithCount() {
		return testServiceWithCount;
	}

	public void setTestServiceWithCount(TestService[] testServiceWithCount) {
		this.testServiceWithCount = testServiceWithCount;
	}

	@Override
	public String toString() {
		return "ClassPojo [testService = " + testService + "]";
	}
}