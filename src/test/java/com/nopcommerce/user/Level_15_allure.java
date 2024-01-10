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

public class Level_15_allure extends BaseTest {

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

		registerPage.inputToFirstnameTextbox(firstName);

		registerPage.inputToLastnameTextbox(lastName);

		registerPage.inputToEmailTextbox(email);

		registerPage.inputToPasswordTextbox(password);

		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(), "Your registration completed");
	}

	@Description("Login account")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_02_Login() {
		// homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.clickTologinLink();

		loginPage.inputToEmailTextbox(email);

		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

	}

	protected int generateRandomEmail() {
		Random rand = new Random();

		return rand.nextInt(99999);
	}

	@AfterClass
	protected void afterClass() {
		driverTestClass.quit();
	}

}
