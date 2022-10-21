package com.qa.core;

import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseSetup {
	public static WebDriver driver;

	public static WebDriver setDriver(String browserType, String appURL) throws MalformedURLException {

		switch (browserType) {
		case "Chrome":
			driver = initChromeDriver(appURL);
			break;
		case "Firefox":
			driver = initFirefoxDriver(appURL);
			break;
		case "IE":
			driver = initIEDriver(appURL);
			break;
		case "Safari":
			driver = initSafariDriver(appURL);
			break;
		default:
			driver = initFirefoxDriver(appURL);
		}
		return driver;
	}

	public static WebDriver initChromeDriver(String appURL) {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	public static WebDriver initIEDriver(String appURL) {
		driver = WebDriverManager.iedriver().create();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	public static WebDriver initFirefoxDriver(String appURL) {
		driver = WebDriverManager.firefoxdriver().create();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	public static WebDriver initSafariDriver(String appURL) {
		driver = WebDriverManager.safaridriver().create();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	public static void failedscreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			byte[] screenShotPath = UIActions.capture(driver);
			scenario.attach(screenShotPath, "image/png", "ErrorOccurred");

		}
	}

	public static void tearDown() {
		driver.quit();
	}

}
