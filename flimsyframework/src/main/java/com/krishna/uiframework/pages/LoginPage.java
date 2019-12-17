package com.krishna.uiframework.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.krishna.uiframework.pagelocators.LoginPageLocators;
import com.krishna.uiframework.utils.LoggerHelper;

public class LoginPage extends LoginPageLocators {
	
	private Logger log = LoggerHelper.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public String getTextLoginToFaceBook(WebDriver driver, By locator) {
		String textMessage = " ";
		try {
			textMessage = driver.findElement(locator).getText();
		}catch(Exception e) {
			log.info(e.getMessage());
		}
		return textMessage;
	}

}
