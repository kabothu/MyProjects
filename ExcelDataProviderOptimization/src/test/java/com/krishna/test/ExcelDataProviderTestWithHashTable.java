package com.krishna.test;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.krishna.dataproviders.DataProviders;
import com.krishna.model.BeanClassData;



public class ExcelDataProviderTestWithHashTable {
	
	@Test(dataProvider = "hashTableExample", dataProviderClass = DataProviders.class)
	public void testDataProviderUsingHashTableExample(Hashtable<String, String> data) {

		System.out.println(data.get("name"));
	}

	@Test(dataProvider = "usingAllArguments", dataProviderClass = DataProviders.class)
	public void testDataProviderUsingAllArgumentsExample(String name, String address, String email) {

		System.out.println(name);
	}
	
	@Test(dataProvider = "newJson", dataProviderClass = DataProviders.class)
	public void testDataProviderUsingJsonExample(BeanClassData data) {

		System.out.println(data.getName());
	}
}
