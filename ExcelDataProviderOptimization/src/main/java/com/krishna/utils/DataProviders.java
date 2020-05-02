package com.krishna.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class DataProviders {

	@DataProvider(name = "hashTableExample")
	public static Object[][] testData() throws Exception {
		String filePath = "src/test/resources/excelfile.xls";
		return DataUtil.getData("excelreader", filePath);
	}

	@DataProvider(name = "usingAllArguments")
	public static Object[][] testData1() throws Exception {
		String filePath = "src/test/resources/excelfile.xls";
		return new ExcelUtilsCommon().getExcelData(filePath, "excelreader");
	}

	@DataProvider(name = "newJson")
	public Object[][] getData() throws FileNotFoundException {
		JsonElement jsonData = new JsonParser().parse(new FileReader("src/main/resources/data/testdata.json"));
		JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
		List<BeanClassData> testData = new Gson().fromJson(dataSet, new TypeToken<List<BeanClassData>>() {
		}.getType());
		Object[][] returnValue = new Object[testData.size()][1];
		int index = 0;
		for (Object[] each : returnValue) {
			each[0] = testData.get(index++);
		}
		return returnValue;
	}
}
