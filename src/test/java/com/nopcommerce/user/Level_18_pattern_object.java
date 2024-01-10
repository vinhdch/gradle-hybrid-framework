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
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nop.user.UserHomePageObject;
import pageObjects.nop.user.UserLoginPageObject;
import pageObjects.nop.user.UserRegisterPageObject;

public class Level_18_pattern_object extends BaseTest {

	private WebDriver driverTestClass;

	private String firstName, lastName, email, password;
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
		email = "vinh" + generateRandomEmail() + "@gmail.com";
		password = "vinh123";

	}

	@Description("Register account")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register() {

		registerPage = homePage.clickToRegisterLink();

		// registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToTextboxById(driverTestClass, "FirstName", firstName);

		Assert.assertEquals(registerPage.getTextboxValueById(driverTestClass, "FirstName"), firstName);

		// registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToTextboxById(driverTestClass, "LastName", lastName);

		Assert.assertEquals(registerPage.getTextboxValueById(driverTestClass, "LastName"), lastName);

		// registerPage.inputToEmailTextbox(email);
		registerPage.inputToTextboxById(driverTestClass, "Email", email);

		// registerPage.inputToPasswordTextbox(password);
		registerPage.inputToTextboxById(driverTestClass, "Password", password);

		// registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.inputToTextboxById(driverTestClass, "ConfirmPassword", password);

		// registerPage.clickToRegisterButton();
		registerPage.clickToButtonByText(driverTestClass, "Register");

		Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(), "Your registration completed");
	}

	@Description("Login account")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_02_Login() {
		// homePage = registerPage.clickToLogoutLink();
		// loginPage = homePage.clickTologinLink();
		homePage.clickToButtonByText(driverTestClass, "Log in");
		homePage = PageGeneraterManager.getUserHomePageObject(driverTestClass);

		// loginPage.inputToEmailTextbox(email);
		loginPage.inputToTextboxById(driverTestClass, "Email", email);

		// loginPage.inputToPasswordTextbox(password);
		loginPage.inputToTextboxById(driverTestClass, "Password", password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	protected int generateRandomEmail() {
		Random rand = new Random();

		return rand.nextInt(99999);
	}

	@AfterClass
	protected void afterClass() {
		closeBrowserDriver();
	}

}
