package com.uiautomation.pagecomponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.uiautomation.pagelocators.HomePageLocators;

public class HomePageActions extends HomePageLocators {

    private Logger log = Logger.getLogger(HomePageActions.class);

    public HomePageActions listOfTShirts() {

	try {
	    listOfTShirts.get(1).click();
	} catch (Exception e) {
	    log.info(e.getMessage());
	}
	return new HomePageActions();
    }

    public HomePageActions fadedShortSleeveTShirt() {

	try {
	    fadedShortSleeveTShirt.click();
	} catch (Exception e) {
	    log.info(e.getMessage());
	}
	return new HomePageActions();
    }

    public HomePageActions addToCart() {

	try {
	    addToCart.click();
	} catch (Exception e) {
	    log.info(e.getMessage());
	}
	return new HomePageActions();
    }

}
