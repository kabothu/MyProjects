package com.krishna.uiframework.pagelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.krishna.uiframework.baseconfig.BaseConfig;

public class FaceBookHomePageLocators extends BaseConfig{

	public FaceBookHomePageLocators(WebDriver driver) {
		super(driver);
	}
	
	public final By loginLinkAtFooterSection = By.cssSelector("a[title='Log into Facebook']");
	

}
