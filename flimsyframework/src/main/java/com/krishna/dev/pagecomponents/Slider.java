package com.krishna.dev.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.krishna.dev.pagelocators.SliderLocators;
import com.krishna.dev.utils.ActionUtility;


public class Slider extends SliderLocators{
	

	public Slider(WebDriver driver, String url) {
		super(driver, url);
	}
	public Slider(WebDriver driver) {
		super(driver);
	}	


	public void ClickSliderComponent(By locator) {
		try{
			ActionUtility.waitAndClick(driver,locator);
		}catch (Exception e) {
		      throw new RuntimeException("Failed Setting click on a slider component : " + locator.toString()
			          + e.getMessage());
		}   
	}
	
}
