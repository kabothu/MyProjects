package com.uiautomation.basepages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uiautomation.utils.PropertyFileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    public static WebDriver driver;
    public static PropertyFileUtility propertiesFile = new PropertyFileUtility();

    public static void intialize() {
	String browserName = propertiesFile.getPropertyValue("BROWSER");
	if (browserName.equals("chrome")) {

	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	} else if (browserName.equals("firefox")) {

	    WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	}

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.get(propertiesFile.getPropertyValue("URL"));
    }

    public static void tearDown() {
	driver.quit();
    }
}
