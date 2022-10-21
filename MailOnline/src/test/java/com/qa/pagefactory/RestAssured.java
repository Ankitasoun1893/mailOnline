package com.qa.pagefactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssured extends com.qa.core.BaseSetup {
	public String url = null;
	private String Id;
	public RestAssured(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void setUrl(String url) {
		io.restassured.RestAssured.useRelaxedHTTPSValidation();
		this.url = url;
	}

	public void getVerifyStatusCode(int statcode) {
		io.restassured.RestAssured.useRelaxedHTTPSValidation();
		url=url+Id;
		System.out.println("Getting the pet detail"+url);
		int statuscode = given().when().get(url).getStatusCode();
		System.out.println("status code is " + statuscode);
		Assert.assertTrue(statuscode == statcode);
	}

	public void postApiStatusCode(int statcode) {
		io.restassured.RestAssured.useRelaxedHTTPSValidation();
		String payload = "{\r\n" + "  \"id\": 0,\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n" + "  },\r\n" + "  \"name\": \"doggie\",\r\n" + "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n" + "    {\r\n" + "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n" + "    }\r\n" + "  ],\r\n" + "  \"status\": \"available\"\r\n" + "}";

		int statuscode = given().contentType(ContentType.JSON).body(payload).post(url).getStatusCode();
		Response response = (Response) given().contentType(ContentType.JSON).body(payload).when().post(url).getBody();
		Assert.assertTrue(statuscode == statcode);
		JsonPath CSJson = new JsonPath(response.asString());
		System.out.println("Response  ---> " + response.asString());
		 Id = CSJson.getString("id");
		System.out.println("Pet is getting created with ID: " +Id);
		
		 
		          
	}
	}



