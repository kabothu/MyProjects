package com.cucumber.stepdefinition.simplecucumberframework;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyApplicationStepDefinition {

    private WebDriver driver;

    // This is a Hook and hooks are used to use from Prerequisites for tests
    // We can also run hooks in an order using order =0
    @Before(order = 0)
    public void firstHook() {
	System.out.println("FirstHook");
    }

    @Before(order = 1)
    public void secondHook() {
	System.out.println("Second Hook");
    }

    @Given("^Open Chrome Browser$")
    public void open_Chrome_Browser() throws Throwable {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();

    }

    @When("^User Navigates to url$")
    public void user_Navigates_to_url() throws Throwable {
	driver.get("http://www.google.com");
    }

    @And("^User Searches In Google$")
    public void user_Searches_In_Google(DataTable dataTable) throws Throwable {
	List<List<String>> data = dataTable.raw();
	driver.findElement(By.cssSelector(".gLFyf.gsfi")).sendKeys(data.get(0).get(0));// It gives Ed Sheeran
	driver.findElement(By.xpath("//*[@class='FPdoLc VlcLAe']//input[@value='Google Search']")).click();
    }

    @Then("^Simple Say Page Title is not Null$")
    public void simple_Say_Page_Title_is_not_Null() throws Throwable {
	String expectedTitle = driver.getTitle();
	Assert.assertNotNull(expectedTitle, "Title is not null");
    }

    // This is a Hook and hooks are used to use from Post-requisites for tests
    @After(order = 1)
    public void quitBrowser() {
	if (driver != null) {
	    driver.quit();
	}
    }

}
