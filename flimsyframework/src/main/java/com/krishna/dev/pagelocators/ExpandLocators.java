package com.krishna.dev.pagelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.krishna.dev.baseconfig.BaseConfig;

public class ExpandLocators extends BaseConfig {
	
	public ExpandLocators(WebDriver driver) {
		super(driver);
	}
	public ExpandLocators(WebDriver driver, String url) {
		super(driver, url);
	}
	public final By NAME = By.name("username");
	public final By PASSWORD = By.name("pwd");
	public final By LOGIN_BUTTON = By.id("loginButton");

}
