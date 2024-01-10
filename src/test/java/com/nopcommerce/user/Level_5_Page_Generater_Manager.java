package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneraterManager;
import pageObjects.nop.user.UserHomePageObject;
import pageObjects.nop.user.UserLoginPageObject;
import pageObjects.nop.user.UserRegisterPageObject;

public class Level_5_Page_Generater_Manager extends BaseTest {

	private WebDriver driverTestClass;
	private String firstName, lastName, existingEmail, password, invalidEmail, notFoundEmail;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	protected void beforeClass(String browserName) {
		driverTestClass = getBrowserDriver(browserName);

		homePage = PageGeneraterManager.getUserHomePageObject(driverTestClass);

		firstName = "vinh";
		lastName = "dong";
		existingEmail = "vinh" + generateRandomEmail() + "@gmail.com";
		password = "vinh123";
		invalidEmail = "afc@gmail@vn.net";
		notFoundEmail = "vinh" + generateRandomEmail() + "@gmail.vn";

		// Precondition:
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		// homePage = registerPage.clickToLogoutLink();
	}

	@Test
	protected void Login_01_with_empty_data() {

		loginPage = homePage.clickTologinLink();

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	protected void Login_02_with_invalid_email() {

		loginPage = homePage.clickTologinLink();

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	protected void Login_03_with_not_register_email() {

		loginPage = homePage.clickTologinLink();

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	protected void Login_04_with_enrolled_email_and_empty_password() {

		loginPage = homePage.clickTologinLink();

		loginPage.inputToEmailTextbox(existingEmail);

		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	protected void Login_05_with_enrolled_email_and_invalid_password() {

		loginPage = homePage.clickTologinLink();

		loginPage.inputToEmailTextbox(existingEmail);

		loginPage.inputToPasswordTextbox("654321");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	protected void Login_06_with_enrolled_email_and_valid_password() {

		loginPage = homePage.clickTologinLink();

		loginPage.inputToEmailTextbox(existingEmail);

		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	protected void afterClass() {

		driverTestClass.quit();
	}

	protected int generateRandomEmail() {
		Random rand = new Random();

		return rand.nextInt(99999);
	}
}
