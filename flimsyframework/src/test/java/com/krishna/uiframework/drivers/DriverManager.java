package com.krishna.uiframework.drivers;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class DriverManager {

	public static ThreadLocal<WebDriver> localDriver = new ThreadLocal<WebDriver>();

	@Step("Close Get Driver")
	public static WebDriver getDriver() {

		return localDriver.get();

	}

	public static void setWebDriver(WebDriver driver) {

		localDriver.set(driver);
	}

}
