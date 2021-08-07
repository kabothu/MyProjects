package com.krishna.autogenerate.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJsonDynamically {

	List<String> inputKey = new ArrayList<String>();

	List<String> listOfAllKeys = new ArrayList<String>();
	String eachKeyOutput = null;

	public String parseObject(JSONObject json, String key) {

		return json.get(key).toString();
	}

	public List<String> parseJsonDynamicallyUtility(String inputJSON, String key) {

		listOfAllKeys.clear();

		if (inputJSON.startsWith("[")) {
			JSONArray jsonArray = new JSONArray(inputJSON);
			for (int i = 0; i < jsonArray.length(); i++) {
				if (jsonArray.get(i) instanceof JSONObject) {
					JSONObject jsnObj = (JSONObject) jsonArray.get(i);
					inputKey = getKey(jsnObj, key);
				}
			}
		} else {
			JSONObject inputObject = new JSONObject(inputJSON);
			inputKey = getKey(inputObject, key);
		}
		return inputKey;
	}

	public List<String> getKey(JSONObject json, String key) {

		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;

		if (!exists) {
			keys = json.keys();
			while (keys.hasNext()) {
				nextKeys = (String) keys.next();
				try {

					if (json.get(nextKeys) instanceof JSONObject) {

						if (exists == false) {
							getKey(json.getJSONObject(nextKeys), key);
						}

					} else if (json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonarray = json.getJSONArray(nextKeys);
						for (int i = 0; i < jsonarray.length(); i++) {
							String jsonarrayString = jsonarray.get(i).toString();
							JSONObject innerJSOn = new JSONObject(jsonarrayString);

							if (exists == false) {
								getKey(innerJSOn, key);
							}

						}

					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}

		} else {
			eachKeyOutput = parseObject(json, key);
			listOfAllKeys.add(eachKeyOutput);
		}

		return listOfAllKeys;

	}

}