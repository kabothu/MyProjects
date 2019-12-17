package com.krishna.uiframework.pagecomponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.krishna.uiframework.pagelocators.FaceBookFooterLocator;
import com.krishna.uiframework.utils.LoggerHelper;

public class FaceBookFooterComponent extends FaceBookFooterLocator {

	private Logger log = LoggerHelper.getLogger(FaceBookFooterComponent.class);

	public FaceBookFooterComponent(WebDriver driver) {
		super(driver);
	}

	public boolean isFooterComponentDisplayed(WebDriver driver, By locator) {

		boolean footComponentDisplayed = false;
		try {
			footComponentDisplayed = driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return footComponentDisplayed;

	}

}
