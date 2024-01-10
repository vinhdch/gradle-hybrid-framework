package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.nop.user.UserHomePageObject;
import pageObjects.nop.user.UserLoginPageObject;
import pageObjects.nop.user.UserRegisterPageObject;

public class Level_2_POM_Login extends BasePage {

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String firstName, lastName, existingEmail, password, invalidEmail, notFoundEmail;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@BeforeClass
	protected void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://demo.nopcommerce.com/");

		homePage = new UserHomePageObject(driver);

		firstName = "vinh";
		lastName = "dong";
		existingEmail = "vinh" + generateRandomEmail() + "@gmail.com";
		password = "vinh123";
		invalidEmail = "afc@gmail@vn.net";
		notFoundEmail = "vinh" + generateRandomEmail() + "@gmail.vn";

		// Precondition:
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		registerPage.clickToLogoutLink();
	}

	@Test
	protected void Login_01_with_empty_data() {

		homePage.clickTologinLink();

		loginPage = new UserLoginPageObject(driver);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	protected void Login_02_with_invalid_email() {

		homePage.clickTologinLink();

		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	protected void Login_03_with_not_register_email() {

		homePage.clickTologinLink();

		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	protected void Login_04_with_enrolled_email_and_empty_password() {

		homePage.clickTologinLink();

		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);

		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	protected void Login_05_with_enrolled_email_and_invalid_password() {

		homePage.clickTologinLink();

		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);

		loginPage.inputToPasswordTextbox("654321");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	protected void Login_06_with_enrolled_email_and_valid_password() {

		homePage.clickTologinLink();

		loginPage = new UserLoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);

		loginPage.inputToPasswordTextbox(password);

		loginPage.clickToLoginButton();

		homePage = new UserHomePageObject(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	protected void afterClass() {

		driver.quit();
	}

	protected int generateRandomEmail() {
		Random rand = new Random();

		return rand.nextInt(99999);
	}
}
