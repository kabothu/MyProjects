package com.krishna.test;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.krishna.dataproviders.DataProviders;
import com.krishna.model.BeanClassData;


public class DataProviderExampleUsingJson {

	@Test(dataProvider = "newJson", dataProviderClass = DataProviders.class)
	public void testDataProviderUsingJsonExample(BeanClassData data) {

		System.out.println(data.getName());
	}
}
