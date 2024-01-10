package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nop.user.UserHomePageObject;
import pageObjects.nop.user.UserLoginPageObject;

public class Level_3_Multiple_browser extends BaseTest {

	private WebDriver driverTestClass;

	private UserHomePageObject homePage;

	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	protected void beforeClass(String browserName) {

		driverTestClass = getBrowserDriver(browserName);

	}

	@Test
	protected void Login_01_with_empty_data() {
		homePage = new UserHomePageObject(driverTestClass);

		homePage.clickTologinLink();

		loginPage = new UserLoginPageObject(driverTestClass);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@AfterClass
	protected void afterClass() {

		driverTestClass.quit();
	}
}