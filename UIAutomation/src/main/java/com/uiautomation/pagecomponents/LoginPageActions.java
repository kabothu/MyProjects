package com.uiautomation.pagecomponents;

import org.apache.log4j.Logger;

import com.uiautomation.pagelocators.LoginPageLocators;

public class LoginPageActions extends LoginPageLocators {

    private Logger log = Logger.getLogger(LoginPageActions.class);

    public LoginPageActions clickSignInButton() {

	try {
	    signInButton.click();
	} catch (Exception e) {
	    log.info(e.getMessage());
	}
	return new LoginPageActions();
    }

    public LoginPageActions enterUserName(String username) {

	try {
	    userName.sendKeys(username);
	} catch (Exception e) {
	    log.info(e.getMessage());
	}
	return new LoginPageActions();
    }

    public LoginPageActions enterPassword(String password) {

	try {
	    passWord.sendKeys(password);
	} catch (Exception e) {
	    log.info(e.getMessage());
	}

	return new LoginPageActions();
    }

    public LoginPageActions submitLogin() {

	try {
	    submitLogin.click();
	} catch (Exception e) {
	    log.info(e.getMessage());
	}

	return new LoginPageActions();

    }
}
