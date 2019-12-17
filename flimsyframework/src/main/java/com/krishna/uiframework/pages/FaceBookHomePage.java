package com.krishna.uiframework.pages;

import org.openqa.selenium.WebDriver;

import com.krishna.uiframework.pagecomponents.FaceBookFooterComponent;
import com.krishna.uiframework.pagelocators.FaceBookHomePageLocators;
import com.krishna.uiframework.utils.LoggerHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class FaceBookHomePage extends FaceBookHomePageLocators {
	
	private Logger log = LoggerHelper.getLogger(FaceBookHomePage.class);

	public FaceBookHomePage(WebDriver driver) {
		super(driver);
	}

	public LoginPage clickLoginLin(WebDriver driver, By locator) {
		try {
			driver.findElement(locator).click();
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return new LoginPage(driver);

	}

	public FaceBookFooterComponent getFooterComponent(WebDriver driver) {
		return new FaceBookFooterComponent(driver);
	}
}
