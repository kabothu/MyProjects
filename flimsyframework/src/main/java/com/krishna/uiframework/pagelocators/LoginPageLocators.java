package com.krishna.uiframework.pagelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.krishna.uiframework.baseconfig.BaseConfig;

public class LoginPageLocators extends BaseConfig{

	public LoginPageLocators(WebDriver driver) {
		super(driver);
	}
	
	public final By loginToFaceBook = By.xpath("Log Into Facebook");

}
