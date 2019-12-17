package com.krishna.uiframework.basetest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.krishna.uiframework.drivers.Driver;
import com.krishna.uiframework.drivers.DriverManager;
import io.qameta.allure.*;

public class BaseTest {

	@BeforeMethod
	public void setUp() {
		try {
			Driver.initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	@Step("Close Driver")
	public void tearDown() {
		DriverManager.getDriver().quit();
	}

}
