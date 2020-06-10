package com.uiautomation.basetest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.uiautomation.basepages.BasePage;
import com.uiautomation.pagecomponents.AddToCartActions;
import com.uiautomation.pagecomponents.HomePageActions;
import com.uiautomation.pagecomponents.LoginPageActions;
import com.uiautomation.utils.PropertyFileUtility;


public class BaseTest extends BasePage {

    protected HomePageActions homePage;
    protected LoginPageActions loginPage;
    protected AddToCartActions addToCartPage;
    protected PropertyFileUtility propFile;
    
    @BeforeTest
    public void launchBrowser() {
	intialize();
	loginPage = new LoginPageActions();
	homePage = new HomePageActions();
	addToCartPage = new AddToCartActions();
	propFile = new PropertyFileUtility();
    }

    @AfterTest
    public void closeBrowser() {
	tearDown();
    }

}
