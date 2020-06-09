package com.automation.dataproviders;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.automation.model.PayLoadDataModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class DataProviders {

    @DataProvider(name = "RegisterWeatherStations")
    public static Object[][] getData() throws FileNotFoundException {

	JsonElement jsonData = new JsonParser().parse(new FileReader("src/main/resources/data/testdata.json"));
	JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
	List<PayLoadDataModel> testData = new Gson().fromJson(dataSet, new TypeToken<List<PayLoadDataModel>>() {
	}.getType());
	Object[][] returnValue = new Object[testData.size()][1];
	int index = 0;
	for (Object[] each : returnValue) {
		each[0] = testData.get(index++);
	}
	return returnValue;
    }

}
