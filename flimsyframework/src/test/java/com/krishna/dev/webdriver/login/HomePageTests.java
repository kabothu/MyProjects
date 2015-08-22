package com.krishna.dev.webdriver.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.krishna.dev.pagecomponents.LoginPage;
import com.krishna.dev.pagecomponents.TextField;
import com.krishna.dev.utils.TesterInfo;
import com.krishna.dev.webdriver.basetest.BaseTest;

/**
 * @author KrishnaChaitanya
 *
 */
public class HomePageTests extends BaseTest {
	protected TextField textField = new TextField(driver);
	protected LoginPage loginPage = new LoginPage(driver);

	@TesterInfo(OWNER="kabothu")
	@Test()
	public void testHomePage() {

		String Actual = driver.findElement(By.cssSelector("a.item.active")).getText();
		String Expected = "Enter Time-Track";
		Assert.assertEquals(Expected, Actual);

	}

}
