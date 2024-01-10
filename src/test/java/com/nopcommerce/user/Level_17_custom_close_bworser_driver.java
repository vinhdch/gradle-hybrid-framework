package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_register_new_account;

import commons.BaseTest;
import commons.PageGeneraterManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nop.user.UserHomePageObject;
import pageObjects.nop.user.UserLoginPageObject;
import pageObjects.nop.user.UserRegisterPageObject;

public class Level_17_custom_close_bworser_driver extends BaseTest {

	private WebDriver driverTestClass;

	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;

	private String email, password;

	@Parameters("browser")
	@BeforeClass
	@Description("Login account")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void beforeClass(String browserName) {

		driverTestClass = getBrowserDriver(browserName);

		homePage = PageGeneraterManager.getUserHomePageObject(driverTestClass);

		email = Common_register_new_account.email;
		password = Common_register_new_account.password;

		homePage = registerPage.clickToLogoutLink();

		loginPage = homePage.clickTologinLink();

		loginPage.inputToEmailTextbox(email);

		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void TC02_Search() {

	}

	@Test
	public void TC03_Filter() {

	}

	protected int generateRandomEmail() {
		Random rand = new Random();

		return rand.nextInt(99999);
	}

	// @AfterClass(alwaysRun = true)
	@AfterClass()
	protected void afterClass() {
		closeBrowserDriver();
	}

}
