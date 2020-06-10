package com.uiautomation.pagecomponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiautomation.pagelocators.AddToCartLocators;

public class AddToCartActions extends AddToCartLocators {

    private Logger log = Logger.getLogger(AddToCartActions.class);
    String productMessage;
    String titleOfDress;
    String colorWithSize;
    String quantityOfItems;
    String totalPrice;

    public AddToCartActions popupPane() {

	try {
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.visibilityOf(popupPane));
	} catch (Exception e) {
	    log.info(e.getMessage());
	}
	return new AddToCartActions();
    }

    public String productSuccessfulMessage() {

	try {
	    productMessage = productSuccessfulMessage.getText();
	} catch (Exception e) {
	    log.info(e.getMessage());
	}
	return productMessage;
    }

    public String dressTitle() {

	try {
	    titleOfDress = dressTitle.getText();
	} catch (Exception e) {
	    log.info(e.getMessage());
	}
	return titleOfDress;
    }

    public String color() {

	try {
	    colorWithSize = colorSize.getText();
	} catch (Exception e) {
	    log.info(e.getMessage());
	}
	return colorWithSize;
    }

    public String quantity() {

	try {
	    quantityOfItems = quantity.getText();
	} catch (Exception e) {
	    log.info(e.getMessage());
	}
	return quantityOfItems;
    }

    public String price() {

	try {
	    totalPrice = price.getText();
	} catch (Exception e) {
	    log.info(e.getMessage());
	}
	return totalPrice;
    }

    public AddToCartActions proceedToCheckout() {

	try {
	    proceedToCheckout.click();
	} catch (Exception e) {
	    log.info(e.getMessage());
	}
	return new AddToCartActions();
    }
}
