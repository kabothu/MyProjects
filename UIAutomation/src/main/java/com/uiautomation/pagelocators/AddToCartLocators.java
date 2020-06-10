package com.uiautomation.pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.basepages.BasePage;

//All Add To Cart Page related locators goes here
public class AddToCartLocators extends BasePage {

    @FindBy(how = How.CSS, using = "#layer_cart .clearfix")
    public static WebElement popupPane;

    @FindBy(how = How.CSS, using = "#layer_cart .clearfix  h2:nth-child(2)")
    public static WebElement productSuccessfulMessage;

    @FindBy(how = How.CSS, using = "#layer_cart_product_title")
    public static WebElement dressTitle;

    @FindBy(how = How.CSS, using = "#layer_cart_product_attributes")
    public static WebElement colorSize;

    @FindBy(how = How.CSS, using = "#layer_cart_product_quantity")
    public static WebElement quantity;

    @FindBy(how = How.CSS, using = "#layer_cart_product_price")
    public static WebElement price;
    
    @FindBy(how = How.CSS, using = "[title='Proceed to checkout']")
    public static WebElement proceedToCheckout;
    

    public AddToCartLocators() {

	PageFactory.initElements(driver, this);
    }

}
