package com.krishna.dev.pagelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.krishna.dev.baseconfig.BaseConfig;

public class ToggleLocators extends BaseConfig {
	
	public ToggleLocators(WebDriver driver) {
		super(driver);
	}
	public ToggleLocators(WebDriver driver, String url) {
		super(driver, url);
	}
	public final By NAME = By.name("username");
	public final By PASSWORD = By.name("pwd");
	public final By LOGIN_BUTTON = By.id("loginButton");

}
