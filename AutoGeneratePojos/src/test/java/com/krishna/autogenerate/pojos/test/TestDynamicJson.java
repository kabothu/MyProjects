package com.krishna.autogenerate.pojos.test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.krishna.autogenerate.utility.ParseJsonDynamically;

public class TestDynamicJson {

	public static void main(String[] args) throws IOException {

		ParseJsonDynamically parseUtil = new ParseJsonDynamically();

		String filePath = "/Users/kabothu/Documents/Workspace/AutomationWorkspace/AutoGeneratePojos/src/main/resources/schema/demo.json";
		String inputJson = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		List<String> list = parseUtil.parseJsonDynamicallyUtility(inputJson, "latitude");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		String filePathForSecondFile = "/Users/kabothu/Documents/Workspace/AutomationWorkspace/AutoGeneratePojos/src/main/resources/schema/demo.json";
		String inputJsonForSecondFile = FileUtils.readFileToString(new File(filePathForSecondFile),
				StandardCharsets.UTF_8);
		List<String> listOfSecondFileValues = parseUtil.parseJsonDynamicallyUtility(inputJsonForSecondFile, "name");

		for (int i = 0; i < listOfSecondFileValues.size(); i++) {
			System.out.println(listOfSecondFileValues.get(i));
		}
		
		String filePathForThirdFile = "/Users/kabothu/Documents/Workspace/AutomationWorkspace/AutoGeneratePojos/src/main/resources/schema/employee.json";
		String inputJsonForThirdFile = FileUtils.readFileToString(new File(filePathForThirdFile),
				StandardCharsets.UTF_8);
		List<String> listOfThirdFileValues = parseUtil.parseJsonDynamicallyUtility(inputJsonForThirdFile, "employee");

		for (int i = 0; i < listOfThirdFileValues.size(); i++) {
			System.out.println(listOfThirdFileValues.get(i));
		}

	}

}
