package com.krishna.dev.webdriver.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.krishna.dev.dataproviders.LoginPageDataProviders;
import com.krishna.dev.pagecomponents.LoginPage;
import com.krishna.dev.pagecomponents.TextField;
import com.krishna.dev.utils.ActionUtility;
import com.krishna.dev.utils.ExcelFileUtility;
import com.krishna.dev.webdriver.basetest.BaseTest;

public class HomePageTests extends BaseTest {
	protected TextField textField = new TextField(driver);
	protected LoginPage loginPage = new LoginPage(driver);

	@Test(dataProvider = "empLogin", dataProviderClass = com.krishna.dev.dataproviders.LoginPageDataProviders.class)
	public void testHomePage() {

		String Actual = driver.findElement(By.cssSelector("a.item.active")).getText();
		String Expected = "Enter Time-Track";
		Assert.assertEquals(Expected, Actual);

	}

}
