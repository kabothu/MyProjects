package com.krishna.uiframework.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.krishna.uiframework.utils.LoggerHelper;

public class JavaScriptHelpers {

	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(JavaScriptHelpers.class);

	public JavaScriptHelpers(WebDriver driver) {
		this.driver = driver;
		log.info("*****JavaScriptHelper Has Been Initialized*****");
	}

	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}

	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script, args);
	}

	public void scrollToElement(WebElement element) {
		log.info("*****Scroll To WebElement*****");
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
	}

	public void scrollToElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
		log.info("*****Element Is Clicked*****: " + element.toString());
	}

	public void scrollIntoView(WebElement element) {
		log.info("*****Scroll Till WebElement*****");
		executeScript("arguments[0].scrollIntoView()", element);
	}

	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info("*****Element Is Clicked*****: " + element.toString());
	}

	public void scrollDownVertically() {
		log.info("*****Scrolling Down Vertically*****");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scrollUpVertically() {
		log.info("*****Scrolling Up Vertically*****");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}

	public void scrollDownByPixel(int pixel) {
		executeScript("window.scrollBY(0," + pixel + ")");
	}

	public void scrollUpByPixel(int pixel) {
		executeScript("window.scrollBY(0,-" + pixel + ")");
	}

	public void zoomInBy100Percentage() {
		executeScript("document.body.style.zoom='100%'");
	}

	public void zoomInBy60Percentage() {
		executeScript("document.body.style.zoom='40%'");
	}

	public void clickElement(WebElement element) {
		executeScript("arguments[0].click();", element);
	}

}
