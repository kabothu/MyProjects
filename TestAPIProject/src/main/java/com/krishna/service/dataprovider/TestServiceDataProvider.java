package com.krishna.service.dataprovider;

import org.testng.annotations.DataProvider;

import com.krishna.service.model.TestService;
import com.krishna.service.model.TestServiceMock;
import com.krishna.services.util.TestServiceConfigFileUtil;
import com.krishna.services.util.TestServiceDataReaderUtil;
import com.krishna.services.util.TestServiceDataUtils;

public class TestServiceDataProvider {
	
	private static final String PROPERTY_FILE_NAME = "/src/main/resources/com/krishna/services/testservice/content/testService.properties";
	private static TestServiceConfigFileUtil testServiceConfigFileUtil = new TestServiceConfigFileUtil(); 
	
	
	
	@DataProvider(name = "testURI")
	public static Object[][] getTestURI() {
		Object[] urlsToBeLocalized = {testServiceConfigFileUtil.getPropertyValue(PROPERTY_FILE_NAME,"TEST_URI") };
		return new Object[][] {urlsToBeLocalized};
	}
		
	@DataProvider(name = "getTestService")
	public static Object[][] getTestService() throws Exception {
		int itr = 0;
		TestServiceMock testServiceMock = TestServiceDataReaderUtil.getDataObject(
				TestServiceMock.class, "test_servicedata.json");
		TestService[] getTestServicesObject = testServiceMock
				.getTestService();
		Object[][] result = new Object[getTestServicesObject.length][];
		for (TestService getTestService : getTestServicesObject) {
			result[itr] = new Object[] { getTestService };
			itr++;
		}
		return result;
	}

	@DataProvider(name = "getTestService_dataProvider")
	public static Object[][] getTestService_dataProvider() throws Exception {
		return TestServiceDataUtils.combine(getTestURI(), getTestService());
	}
	
	@DataProvider(name = "getTestServiceWithCount")
	public static Object[][] getTestServiceWithCount() throws Exception {
		int itr = 0;
		TestServiceMock testServiceMock = TestServiceDataReaderUtil.getDataObject(
				TestServiceMock.class, "test_servicedata.json");
		TestService[] getTestServicesObject = testServiceMock
				.getTestServiceWithCount();
		Object[][] result = new Object[getTestServicesObject.length][];
		for (TestService getTestService : getTestServicesObject) {
			result[itr] = new Object[] { getTestService };
			itr++;
		}
		return result;
	}

	@DataProvider(name = "getTestServiceWithCount_dataProvider")
	public static Object[][] getTestServiceWithCount_dataProvider() throws Exception {
		return TestServiceDataUtils.combine(getTestURI(), getTestServiceWithCount());
	}

}
