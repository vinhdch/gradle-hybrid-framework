package com.nopcommerce.common;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneraterManager;
import pageObjects.nop.user.UserHomePageObject;
import pageObjects.nop.user.UserRegisterPageObject;

public class Common_register_new_account extends BaseTest {

	private WebDriver driverTestClass;

	private String firstName, lastName;
	public static String email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeTest(description = "Pre-condition: create new account for all classes test")
	public void User_01_Register_New_Account(String browserName) {
		driverTestClass = getBrowserDriver(browserName);

		homePage = PageGeneraterManager.getUserHomePageObject(driverTestClass);

		firstName = "vinh";
		lastName = "dong";
		email = "vinh" + generateRandomEmail() + "@gmail.com";
		password = "vinh123";

		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstnameTextbox(firstName);

		registerPage.inputToLastnameTextbox(lastName);

		registerPage.inputToEmailTextbox(email);

		registerPage.inputToPasswordTextbox(password);

		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(), "Your registration completed");

		driverTestClass.quit();

	}

	protected int generateRandomEmail() {
		Random rand = new Random();

		return rand.nextInt(99999);
	}

	// @AfterTest
	// protected void afterClass() {
	//
	// }

}
