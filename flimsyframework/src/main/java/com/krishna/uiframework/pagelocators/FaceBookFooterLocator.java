package com.krishna.uiframework.pagelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.krishna.uiframework.baseconfig.BaseConfig;

public class FaceBookFooterLocator extends BaseConfig{

	public FaceBookFooterLocator(WebDriver driver) {
		super(driver);
	}
	
	public final By footerComponent = By.id("pageFooter");

}
