package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_register_cookies;

import commons.BaseTest;
import commons.PageGeneraterManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nop.user.UserHomePageObject;
import pageObjects.nop.user.UserLoginPageObject;

public class Level_16_share_data_B extends BaseTest {

	private WebDriver driverTestClass;

	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	@Description("Login account")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void beforeClass(String browserName) {

		driverTestClass = getBrowserDriver(browserName);

		homePage = PageGeneraterManager.getUserHomePageObject(driverTestClass);

		loginPage = homePage.clickTologinLink();

		loginPage.setCookies(driverTestClass, Common_register_cookies.loggedCookies);

		loginPage.refreshCurrentPage(driverTestClass);

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
