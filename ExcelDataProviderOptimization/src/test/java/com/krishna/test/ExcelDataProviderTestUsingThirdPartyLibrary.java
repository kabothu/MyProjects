package com.krishna.test;

import java.util.Map;

import org.testng.annotations.Test;

import com.krishna.utils.BeanClass;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;

public class ExcelDataProviderTestUsingThirdPartyLibrary {

	@QAFDataProvider(dataFile = "src/test/resources/excelfile.xls", sheetName = "excelreader")
	@Test
	public void testDataProviderUsingMapWithThirdParty(Map<String, Object> data) {

		System.out.println(data.get("name"));
	}

	
	@QAFDataProvider(dataFile = "src/test/resources/excelfile.xls", sheetName = "excelreader")
	@Test
	public void testWithBeanClass(BeanClass data) {

		System.out.println(data.getName());
	}
}
