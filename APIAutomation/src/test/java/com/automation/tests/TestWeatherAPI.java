package com.automation.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.builders.PayLoad;
import com.automation.dataproviders.DataProviders;
import com.automation.model.PayLoadDataModel;
import com.automation.utils.PropertyFileUtility;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestWeatherAPI {

    protected final PayLoad populatePayLoadInfo = new PayLoad();
    private String responseOutput;
    private String stationId;
    private String uri;
    protected final PropertyFileUtility propFile = new PropertyFileUtility();

    @Test(priority = 1)
    public void weatherStationWithoutAPIKey() {

	uri = propFile.getPropertyValue("URI");
	SoftAssert softAssertion = new SoftAssert();
	Response response = given()
		.header("Content-Type", "application/json")
		.accept(ContentType.JSON)
		.when()
		.get(uri);
	int actualResponseCode = response.getStatusCode();
	if (actualResponseCode != 0) {
	    softAssertion.assertEquals(actualResponseCode, Integer.parseInt(propFile.getPropertyValue("EXPECTED_RESPONSE_CODE")), "Response Code Should be 401");
	}
	responseOutput = response.asString();
	if (responseOutput != null || responseOutput.length() != 0) {

	    String actualMessage = JsonPath.parse(responseOutput).read("message");
	    String expectedMessage = propFile.getPropertyValue("EXPECTED_MESSAGE");
	    softAssertion.assertEquals(expectedMessage, actualMessage, "Expected and Actual Messages are not equal");

	}
	softAssertion.assertAll();

    }

    @Test(priority = 2, dataProvider = "RegisterWeatherStations", dataProviderClass = DataProviders.class)
    public void registerWeatherStationThroughPostCall(PayLoadDataModel beanData) {

	uri = propFile.getPropertyValue("URI");
	SoftAssert softAssertion = new SoftAssert();
	String payLoad = populatePayLoadInfo.populatePayLoad(beanData);
	Response response = given().header("Content-Type", "application/json")
		.queryParam("APPID", propFile.getPropertyValue("APIKEY"))
		.body(payLoad)
		.when()
		.post(uri);

	int actualResponseCode = response.getStatusCode();
	if (actualResponseCode != 0) {
	    softAssertion.assertEquals(actualResponseCode, Integer.parseInt(propFile.getPropertyValue("POST_EXPECTED_RESPONSE_CODE")), "Response Code Should be 201");
	}

	softAssertion.assertAll();
    }

    @Test(priority = 3)
    public void getStationsAPI() {

	uri = propFile.getPropertyValue("URI");
	SoftAssert softAssertion = new SoftAssert();
	Response response = given().header("Content-Type", "application/json")
		.queryParam("APPID", propFile.getPropertyValue("APIKEY"))
		.when()
		.get(uri);

	int actualResponseCode = response.getStatusCode();
	if (actualResponseCode != 0) {
	    softAssertion.assertEquals(actualResponseCode, Integer.parseInt(propFile.getPropertyValue("GET_STATIONS_EXPECTED_RESPONSE_CODE")), "Response Code Should be 200");
	}

	responseOutput = response.asString();

	if (responseOutput != null || responseOutput.length() != 0) {
	    Gson gson = new Gson();
	    PayLoadDataModel[] responseToPojo = gson.fromJson(responseOutput, PayLoadDataModel[].class);
	    softAssertion.assertEquals(responseToPojo[0].getExternal_id(), "DemoTest10");
	    softAssertion.assertEquals(responseToPojo[0].getName(), "Bangalore");
	    softAssertion.assertEquals(responseToPojo[0].getLatitude(), 33.33);
	    softAssertion.assertEquals(responseToPojo[0].getLongitude(), -111.43);
	    softAssertion.assertEquals(Math.round(responseToPojo[0].getAltitude()), 444);
	    
	    softAssertion.assertEquals(responseToPojo[1].getExternal_id(), "DemoTest11");
	    softAssertion.assertEquals(responseToPojo[1].getName(), "Mumbai");
	    softAssertion.assertEquals(responseToPojo[1].getLatitude(), 33.44);
	    softAssertion.assertEquals(responseToPojo[1].getLongitude(), -12.44);
	    softAssertion.assertEquals(Math.round(responseToPojo[0].getAltitude()), 444);
	}
	softAssertion.assertAll();

    }
    
    @Test(priority = 4)
    public void deleteBothStations() {

	uri = propFile.getPropertyValue("URI");
	SoftAssert softAssertion = new SoftAssert();
	Response response = given().header("Content-Type", "application/json")
		.queryParam("APPID", "db110689dd2ea6ed8494855ce47c490c")
		.when()
		.get(uri);

	int actualResponseCode = response.getStatusCode();
	if (actualResponseCode != 0) {
	    softAssertion.assertEquals(actualResponseCode, 200, "Response Code Should be 200");
	}

	responseOutput = response.asString();

	if(responseOutput!=null || responseOutput.length()!=0) {
	    Gson gson = new Gson();
	    PayLoadDataModel[] responseToPojo = gson.fromJson(responseOutput, PayLoadDataModel[].class);
	    
	    for(int i=0; i<responseToPojo.length; i++) {
		stationId = responseToPojo[i].getId();
		uri = propFile.getPropertyValue("URI")+"/"+stationId+"";
		Response deleteResponse = given()
			.queryParam("APPID", propFile.getPropertyValue("APIKEY")).when().delete(uri);
		int actualResponseCodeAfterDeleteCall = deleteResponse.getStatusCode();
		if (actualResponseCodeAfterDeleteCall != 0) {
		    softAssertion.assertEquals(actualResponseCodeAfterDeleteCall, Integer.parseInt(propFile.getPropertyValue("DELETE_STATIONS_EXPECTED_RESPONSE_CODE")), "Response Code Should be 204");
		}
	    }
	}
	softAssertion.assertAll();

    }
    
    @Test(priority = 5)
    public void testMessageAfterDeletion() {
	SoftAssert softAssertion = new SoftAssert();
	uri = propFile.getPropertyValue("URI")+"/"+stationId+"";
	Response deleteResponse = given()
		.queryParam("APPID", "db110689dd2ea6ed8494855ce47c490c")
		.when()
		.delete(uri);
	responseOutput = deleteResponse.asString();
	String actualMessage = JsonPath.parse(responseOutput).read("message");
	String expectedMessage = propFile.getPropertyValue("EXPECTED_MESSAGE_AFTER_DELETION");
	softAssertion.assertEquals(expectedMessage, actualMessage, "Delete Response Message is not matching");
	softAssertion.assertAll();

    }

}
