package com.qa.stepdefinition;

import java.io.IOException;
import java.net.MalformedURLException;
import com.qa.core.*;
import com.qa.pagefactory.RestAssured;
import com.qa.pagefactory.VerifyWebPage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefination extends com.qa.core.BaseSetup {
	public VerifyWebPage VerifyWebPage;
	public RestAssured restAssured;

	@Given("Launch Browser {string} and enter Url {string}")
	public void user_is_on_homepage(String appurl, String Browser) throws InterruptedException, MalformedURLException {
		driver = BaseSetup.setDriver(appurl, Browser);
		System.out.println("driver is" + driver);
	}

	@Then("Verify current date on homepage")
	public void verify_current_date_on_homepage() {
		VerifyWebPage = new VerifyWebPage(driver);
		VerifyWebPage.verifyCurrentDate();
	}

	@Then("Verify primary and Secondry navigation colour")
	public void verify_primary_and_secondry_navigation_colour() {
		VerifyWebPage = new VerifyWebPage(driver);
		VerifyWebPage.verifyNavigationColor();
	}

	@Then("Verify previous and next arrow on gallary image")
	public void verify_previous_and_next_arrow_on_gallary_image() {
		VerifyWebPage = new VerifyWebPage(driver);
		VerifyWebPage.verifyGallaryImages();
	}

	@Then("Verify Facebook icon on image")
	public void verify_facebook_icon_on_image() {
		VerifyWebPage.verifyFacebookPopup();
	}
	
	@Given("^launch \"([^\"]*)\"$")
	public void launch(String endpoint) {
		restAssured = new RestAssured(BaseSetup.driver);
		restAssured.setUrl(endpoint);

	}

	@Then("^verify post api status code as \"([^\"]*)\"$")
	public void verifyPostApiStatusCodeAs(int statuscode) {
		restAssured.postApiStatusCode(statuscode);
	}
	
	@Then("^Get the pet and verify statuscode \"([^\"]*)\"$")
	public void getPetDetails(int statuscode ) {
		restAssured.getVerifyStatusCode(statuscode);
	}

	
	@AfterStep
	public void failedcasescreenshot(Scenario scenario) throws IOException {
		BaseSetup.failedscreenshot(scenario);
	}

}
