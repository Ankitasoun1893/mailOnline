package com.qa.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.qa.core.UIActions;

public class VerifyWebPage extends com.qa.core.BaseSetup {

	WebDriver driver;

	@FindBy(xpath = "//div[@class='weather']/strong")
	WebElement CurrentDate;

	@FindBy(xpath = "//*[@id='page-container']/div[2]//li[4]/span/a")
	WebElement SportLink;

	@FindBy(xpath = "//a[@href='/sport/football/index.html']")
	WebElement FootballLink;

	@FindBy(xpath = "//*[@class='gamma']//div/a")
	WebElement ImageLink;

	@FindBy(xpath = "//div[@itemprop='articleBody']/div[@style='style'][1]//button")
	WebElement ViewGallaryButton;

	@FindBy(xpath = "*//button[@class='nextButton-3SUcS']")
	WebElement nextButton;

	@FindBy(xpath = "*//button[@class='previousButton-1MRE_']")
	WebElement backButton;

	@FindBy(xpath = "//div[@class='counter-1RYOX']")
	WebElement imageCount;

	@FindBy(xpath = "//div[@itemprop='articleBody']/div[4]//li[1]")
	WebElement FacebookIcon;

	@FindBy(xpath = "//tbody/tr[4]/td[@class='pos_3b93p']")
	WebElement countryScore;
	
	@FindBy(xpath="//div[@class='nav-secondary wocc link-lccox cleared bdrgr3']")
	WebElement secondaryLink;

	public VerifyWebPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyCurrentDate() {
		UIActions.HighlightElement(CurrentDate, driver);
		String Date = CurrentDate.getText();
		System.out.print("Current date:" + Date);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM d'th' yyyy");
		String str = formatter.format(date);
		System.out.print("Current date: " + str);

		if (Date.equalsIgnoreCase(str)) {
			System.out.println("Date is matching with expected");
		}

		else {
			System.out.println("Date is not matching with expected");
		}
	}

	public void verifyNavigationColor() {
		UIActions.fluentWait(SportLink, driver);
		SportLink.click();
		String bckgclr = SportLink.getCssValue("background-color");
		String Sbckgclr = Color.fromString(bckgclr).asHex();
		System.out.println(Sbckgclr);
		UIActions.fluentWait(secondaryLink, driver);
		String Fbckgclr = secondaryLink.getCssValue("background-color");
		String AFbckgclr = Color.fromString(Fbckgclr).asHex();
		System.out.println(AFbckgclr);
	//	Sbckgclr.equalsIgnoreCase(AFbckgclr);
		UIActions.assertion(Sbckgclr,AFbckgclr);
	}

	public boolean verifyFacebookPopup() {
		UIActions.fluentWait(FootballLink, driver);
		FootballLink.click();
		UIActions.fluentWait(ImageLink, driver);
		ImageLink.click();
		UIActions.fluentWait(ViewGallaryButton, driver);
		Actions action = new Actions(driver);
		action.moveToElement(ViewGallaryButton).perform();
		action.moveToElement(FacebookIcon).perform();
		action.click().build().perform();
		String currentWindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		if (!allWindowHandles.isEmpty()) {
			for (String windowId : allWindowHandles) {
				if (driver.switchTo().window(windowId).getTitle().equals("Facebook")) {
					driver.close();
					driver.switchTo().window(currentWindow);
					return true;
				}
			}

		}
		return false;
	}

	public void verifyGallaryImages() {
		UIActions.fluentWait(FootballLink, driver);
		FootballLink.click();
		UIActions.fluentWait(ImageLink, driver);
		ImageLink.click();
		UIActions.fluentWait(ViewGallaryButton, driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ViewGallaryButton);
		List<WebElement> allSearchElements = driver
				.findElements(By.xpath("//div[@class='scrollingElement-kUNHH']/div"));
		int totalImages = allSearchElements.size();
		for (char i = 1; i < (totalImages - 1); i++) {

			if (i == 1) {
				Boolean nn = backButton.isEnabled();
				if (nn) {
					System.out.println("Yes ! Element is enabled");
				} else {
					System.out.println("Element is disabled");

				}
				nextButton.click();
			}

			else {

				String imgText1 = imageCount.getText();
				nextButton.click();
				String imgText2 = imageCount.getText();
				if (!imgText1.equals(imgText2)) {
					System.out.println("Old and new image are different");
				}
			}
		}
	}
}
