package com.uiautomation.pagelocators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.basepages.BasePage;

//All HomePage related Locators goes here
public class HomePageLocators extends BasePage {

    @FindBy(how = How.CSS, using = "[title='T-shirts']")

    public static List<WebElement> listOfTShirts;

    @FindBy(how = How.CSS, using = "img[title='Faded Short Sleeve T-shirts']")

    public static WebElement fadedShortSleeveTShirt;

    @FindBy(how = How.NAME, using = "Submit")

    public static WebElement addToCart;

    public HomePageLocators() {

	PageFactory.initElements(driver, this);
    }

}
