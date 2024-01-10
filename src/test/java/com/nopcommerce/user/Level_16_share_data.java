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

public class Level_16_share_data extends BaseTest {

	private WebDriver driverTestClass;

	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private String email, password;

	@Parameters("browser")
	@BeforeClass
	@Description("Login account")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC01_Login(String browserName) {
		driverTestClass = getBrowserDriver(browserName);

		homePage = PageGeneraterManager.getUserHomePageObject(driverTestClass);

		email = Common_register_new_account.email;
		password = Common_register_new_account.password;

		// homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.clickTologinLink();

		loginPage.inputToEmailTextbox(email);

		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

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

	@AfterClass
	protected void afterClass() {
		driverTestClass.quit();
	}

}
