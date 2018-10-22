package com.krishna.services.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class TestServiceConfigFileUtil {

	String result = "";
	InputStream inputStream = null;
	
	// Properties file name
	//private static final String PROPERTY_FILE_NAME = "/src/main/resources/com/krishna/service/testservice/config/config.properties";
		
	public String getPropertyValue(String propFile, String key) {

		String currentDir = System.getProperty("user.dir");
		String filePath = (currentDir + propFile).replace('\\','/');
		File file = new File(filePath);

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(key);
	}
}