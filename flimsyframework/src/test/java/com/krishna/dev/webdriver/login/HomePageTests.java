package com.krishna.dev.webdriver.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.krishna.dev.webdriver.basetest.BaseTest;

public class HomePageTests extends BaseTest {

	@Test
	public void testHomePage(){

		String Actual = driver.findElement(By.cssSelector("a.item.active"))
				.getText();
		String Expected = "Enter Time-Track";
		Assert.assertEquals(Expected, Actual);

	}

}
