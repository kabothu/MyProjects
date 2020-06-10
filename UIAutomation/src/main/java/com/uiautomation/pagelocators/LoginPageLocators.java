package com.uiautomation.pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.basepages.BasePage;

//All Login Page Related Locators goes here
public class LoginPageLocators extends BasePage {
    
    @FindBy(how = How.CSS, using = ".login")
    public static WebElement signInButton;
    
    @FindBy(how = How.ID, using = "email")
    public static WebElement userName;
    
    @FindBy(how = How.ID, using = "passwd")
    public static WebElement passWord;
    
    @FindBy(how = How.ID, using = "SubmitLogin")
    public static WebElement submitLogin;
    
    public LoginPageLocators() {
	
	PageFactory.initElements(driver, this);
    }
    
    

}
