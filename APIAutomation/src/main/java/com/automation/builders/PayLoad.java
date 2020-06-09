package com.automation.builders;

import com.automation.model.PayLoadDataModel;
import com.google.gson.Gson;

public class PayLoad {

    private String finalPayLoad;
    private String payLoad;

    public String populatePayLoad(PayLoadDataModel beanData) {
	PayLoadBuilder payloadBuilder = new PayLoadBuilder.Builder()
		.externalId(beanData.getExternal_id())
		.name(beanData.getName())
		.latitude(beanData.getLatitude())
		.longitude(beanData.getLongitude())
		.altitude(beanData.getAltitude()).build();

	Gson gson = new Gson();
	payLoad = gson.toJson(payloadBuilder);
	try {
	    if (payLoad != null || payLoad.length() != 0)
		finalPayLoad = payLoad;
	} catch (Exception e) {
	    finalPayLoad = e.getMessage();
	}
	return finalPayLoad;
    }

}
