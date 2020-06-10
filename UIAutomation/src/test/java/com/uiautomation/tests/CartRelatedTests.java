package com.uiautomation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.uiautomation.basetest.BaseTest;

public class CartRelatedTests extends BaseTest {
    
    SoftAssert softAssertion = new SoftAssert();

    @Test
    public void testToVerifyDetailsInAddToCart() throws Exception {

	// 1. Login to the application
	loginPage.clickSignInButton()
	         .enterUserName(propFile.getPropertyValue("USERNAME"))
	         .enterPassword(propFile.getPropertyValue("PASSWORD"))
	         .submitLogin();

	// 2. Selecting category and adding to cart
	homePage.listOfTShirts()
	        .fadedShortSleeveTShirt()
	        .addToCart();

	// Let the pop-up pane open
	addToCartPage.popupPane();
	

	// 3. Perform all the assertions on the page
	softAssertion.assertEquals(propFile.getPropertyValue("PRODUCT_SUCCESSFUL_MESSAGE"),
		addToCartPage.productSuccessfulMessage());
	softAssertion.assertEquals(propFile.getPropertyValue("DRESS_TITLE"), addToCartPage.dressTitle());
	softAssertion.assertEquals(propFile.getPropertyValue("DRESS_COLOR"), addToCartPage.color());
	softAssertion.assertEquals(propFile.getPropertyValue("QUANTITY"), addToCartPage.quantity());
	softAssertion.assertEquals(propFile.getPropertyValue("PRICE"), addToCartPage.price());
	
	// 4. Proceed to checkout
	
	addToCartPage.proceedToCheckout();
	
	softAssertion.assertAll();

    }

}
