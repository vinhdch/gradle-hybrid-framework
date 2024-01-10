package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneraterManager;
import pageObjects.nop.user.UserCustomerInforPageObject;
import pageObjects.nop.user.UserHomePageObject;
import pageObjects.nop.user.UserLoginPageObject;
import pageObjects.nop.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_14_extendReport5 extends BaseTest {

	private WebDriver driverTestClass;

	private String firstName, lastName, email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;

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

	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email textbox with value is '" + email + "'");
		registerPage.inputToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(), "Your registration completed");
	}

	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login to system successfully");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.clickTologinLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to Email textbox with value is '" + email + "'");
		loginPage.inputToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to Password textbox with value is '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Navigate to 'My Account' page");
		customerInforPage = homePage.clickToMyAccountLink();

		// ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Verify 'Customer Infor' page is displayed");
		// Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
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
