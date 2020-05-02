package com.krishna.test;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.krishna.utils.BeanClassData;
import com.krishna.utils.DataProviders;

public class DataProviderExampleUsingJson {

	@Test(dataProvider = "newJson", dataProviderClass = DataProviders.class)
	public void testDataProviderUsingJsonExample(BeanClassData data) {

		System.out.println(data.getName());
	}
}
