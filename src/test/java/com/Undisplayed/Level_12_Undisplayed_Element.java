package com.Undisplayed;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.Undisplayed.LoginPageObject;
import pageObject.Undisplayed.PageGeneraterManager;

public class Level_12_Undisplayed_Element extends BaseTest {

	private WebDriver driverTestClass;
	LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	protected void beforeClass(String browserName, String url) {
		driverTestClass = getBrowserDriverUrl(browserName, url);
		loginPage = PageGeneraterManager.getHomePage(driverTestClass);

	}

	@Test
	protected void TC_01_Displayed() {
		loginPage.clicCreateNewAccountButton();
		verifyTrue(loginPage.isEmailAddressDisplayed());

	}

	@Test
	protected void TC_02_Undisplayed_Exist_In_DOM() {
		loginPage.enterToEmailTextbox("vinhdong@gmail.com");
		loginPage.sleepInSecond(1);
		verifyTrue(loginPage.isConfirmEmailAddressDisplayed());

		loginPage.enterToEmailTextbox("");
		loginPage.sleepInSecond(1);
		verifyFalse(loginPage.isConfirmEmailAddressDisplayed());

	}

	@Test
	protected void TC_03_Undisplayed__Not_Exist_In_DOM() {

		loginPage.clickCloseForm();
		loginPage.sleepInSecond(1);

		verifyTrue(loginPage.isConfirmEmailTextboxUndisplayedOnDOM());
	}

	@AfterClass
	protected void afterClass() {
		driverTestClass.quit();
	}

}
