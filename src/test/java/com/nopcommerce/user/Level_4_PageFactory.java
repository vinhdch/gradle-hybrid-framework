package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.HomepageObject;
import pageFactory.LoginPageObject;

public class Level_4_PageFactory extends BaseTest {

	private WebDriver driverTestClass;

	private HomepageObject homePage;

	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	protected void beforeClass(String browserName) {

		driverTestClass = getBrowserDriver(browserName);

	}

	@Test
	protected void Login_01_with_empty_data() {
		homePage = new HomepageObject(driverTestClass);

		homePage.clickTologinLink();

		loginPage = new LoginPageObject(driverTestClass);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@AfterClass
	protected void afterClass() {

		driverTestClass.quit();
	}
}