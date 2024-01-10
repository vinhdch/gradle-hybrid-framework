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
import pageObjects.nop.user.UserAddressPageObject;
import pageObjects.nop.user.UserCustomerInforPageObject;
import pageObjects.nop.user.UserHomePageObject;
import pageObjects.nop.user.UserLoginPageObject;
import pageObjects.nop.user.UserMyProductReviewPageObject;
import pageObjects.nop.user.UserRegisterPageObject;
import pageObjects.nop.user.UserRewardPointPageObject;

public class Level_6_Switch_Page extends BaseTest {

	private WebDriver driverTestClass;
	private String firstName, lastName, email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductReviewPageObject myProductReviewPage;
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

		// Precondition:
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		// homePage = registerPage.clickToLogoutLink();
	}

	@Test
	protected void TC_Login() {

		loginPage = homePage.clickTologinLink();

		loginPage.inputToEmailTextbox(email);

		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	protected void TC_SwitchPage() {

		customerInforPage = homePage.clickToMyAccountLink();

		// customer infor => Address
		addressPage = customerInforPage.openAddressPage(driverTestClass);

		// adddress => my product view
		myProductReviewPage = addressPage.openMyProductReviewPage(driverTestClass);

		// my product view => reward point
		rewardPointPage = myProductReviewPage.openRewardPointPage(driverTestClass);

		// reward point => customer infor
		customerInforPage = rewardPointPage.openCustomerInforPage(driverTestClass);
	}

	@Test
	protected void TC_SwitchRole() {

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
