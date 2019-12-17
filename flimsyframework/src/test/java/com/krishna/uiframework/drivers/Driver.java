package com.krishna.uiframework.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.krishna.uiframework.utils.Constants;
import com.krishna.uiframework.utils.PropertyFileUtility;

public class Driver {

	public WebDriver driver = null;
	public DesiredCapabilities capability;

	private Driver() throws MalformedURLException {
		if (PropertyFileUtility.getPropertyValue("RunMode").equalsIgnoreCase("local")) {
			startBrowserForLocal();
		} else if (PropertyFileUtility.getPropertyValue("RunMode").equalsIgnoreCase("Remote")) {
			startBrowserForRemote();
		} else {
			try {
				throw new Exception("Please set up the run mode properly in TestRunDetails.properties");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyFileUtility.getPropertyValue("WaitTime")),
				TimeUnit.SECONDS);
		driver.get(PropertyFileUtility.getPropertyValue("url"));
		//driver.manage().deleteAllCookies();
		DriverManager.setWebDriver(driver);
	}

	private void startBrowserForLocal() {
		String browser = PropertyFileUtility.getPropertyValue("Browser");
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", Constants.GECKODRIVER_PATH);
				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
		}
	}

	private void startBrowserForRemote() throws MalformedURLException {
		String browser = PropertyFileUtility.getPropertyValue("Browser");
		switch (browser) {

		case "chrome":
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.ANY);
			driver = new RemoteWebDriver(new URL(PropertyFileUtility.getPropertyValue("RemoteURL")), capability);
			break;
		case "firefox":
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.ANY);
			driver = new RemoteWebDriver(new URL(PropertyFileUtility.getPropertyValue("RemoteURL")), capability);
			break;
		default:
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.ANY);
			driver = new RemoteWebDriver(new URL(PropertyFileUtility.getPropertyValue("RemoteURL")), capability);
			break;
		}
	}

	public static void initialize() {
		if (DriverManager.getDriver() == null)
			try {
				new Driver();
			} catch (Exception e) {

			}
	}

	public static void quit() {
		if (DriverManager.getDriver() != null) {
			DriverManager.getDriver().quit();
		}
	}

}
