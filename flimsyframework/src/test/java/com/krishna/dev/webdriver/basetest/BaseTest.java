package com.krishna.dev.webdriver.basetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.krishna.dev.pagecomponents.LoginPage;
import com.krishna.dev.pagecomponents.TextField;
import com.krishna.dev.pagelocators.LoginPageLocators;
import com.krishna.dev.utils.ActionUtility;
import com.krishna.dev.utils.WaitForUtility;

public class BaseTest {
	
	protected static WebDriver driver;
	protected TextField textField = new TextField(driver);
	protected LoginPage loginPage= new LoginPage(driver);

	@BeforeClass
	public void launchApplication() {
		driver = new FirefoxDriver();
		String url="http://demo.actitime.com/login.do";
		LoginPage.open(driver, url);
		WaitForUtility.waitForSeconds(driver, 20);
	}

	@BeforeMethod
	public void loginPage() {
		textField.enterText(driver,loginPage.NAME, "admin");
		textField.enterText(driver,loginPage.PASSWORD, "manager");
		ActionUtility.waitAndClick(driver, loginPage.LOGIN_BUTTON);

	}

	@AfterMethod
	public void logoutApplication() {
		ActionUtility.waitAndClick(driver, loginPage.LOGOUT_BUTTON);
	}

	@AfterClass
	public void exitBrowser() {
		driver.quit();
	}

}
