package com.krishna.dev.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.krishna.dev.pagelocators.XDeleteOrCloseLocators;
import com.krishna.dev.utils.ActionUtility;


public class XDeleteOrClose extends XDeleteOrCloseLocators{
	

	public XDeleteOrClose(WebDriver driver, String url) {
		super(driver, url);
	}
	public XDeleteOrClose(WebDriver driver) {
		super(driver);
	}
	
	public void clickX(By locator) {	
	    try {
	    		ActionUtility.getElement(driver, locator).click();

	    } catch (Exception e) {
		      throw new RuntimeException("GetElement"+ locator.toString() +" failed: " 
		          + e.getMessage());
		    }   
		}
}
