package com.krishna.uiframework.facebook.homepage.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.krishna.uiframework.basetest.BaseTest;
import com.krishna.uiframework.drivers.DriverManager;
import com.krishna.uiframework.pagecomponents.FaceBookFooterComponent;
import com.krishna.uiframework.pages.FaceBookHomePage;

import io.qameta.allure.Owner;
import io.qameta.allure.Description;

/**
 * @author KrishnaChaitanya
 *
 */
public class HomePageTests extends BaseTest {
	
	protected static final FaceBookHomePage facebookHomePage = new FaceBookHomePage(DriverManager.getDriver());
	protected static final FaceBookFooterComponent facebookFooterComponent = new FaceBookFooterComponent(DriverManager.getDriver());

	@Owner("Krishna")
	@Description("Test Method")
	@Test
	public void testHomePageFooter() {
        boolean componentDisplayed = facebookHomePage.getFooterComponent(DriverManager.getDriver())
				.isFooterComponentDisplayed(DriverManager.getDriver(), facebookFooterComponent.footerComponent);
		Assert.assertTrue(componentDisplayed, "Component is not displayed");

	}

}
