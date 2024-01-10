package com.swagLabs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.swagLabs.LoginPO;
import pageObjects.swagLabs.PageGeneraterManager;
import pageObjects.swagLabs.ProductPO;

public class TC_01_Sorting extends BaseTest {

	private WebDriver driverTestClass;
	LoginPO loginPO;
	ProductPO productPO;

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	@Description("Create,read, update, delete Post")
	@Severity(SeverityLevel.NORMAL)
	public void beforeClass(String browserName, String appUrl) {

		driverTestClass = getBrowserDriverUrl(browserName, appUrl);

		loginPO = PageGeneraterManager.getLoginPage(driverTestClass);

		loginPO.enterUsername("standard_user");
		loginPO.enterPassword("secret_sauce");
		productPO = loginPO.PressLoginButton();
	}

	@Test
	public void Sort_01_name() {

		// ascending
		productPO.selectItemOnSortDropdown("Name (A to Z)");
		productPO.sleepInSecond(1);
		Assert.assertTrue(productPO.isNameSortAscending());

		// descending
		productPO.selectItemOnSortDropdown("Name (Z to A)");
		productPO.sleepInSecond(1);
		Assert.assertTrue(productPO.isNameSortDescending());
	}

	@Test
	public void Sort_01_price() {

		// ascending
		productPO.selectItemOnSortDropdown("Price (low to high)");
		productPO.sleepInSecond(1);
		Assert.assertTrue(productPO.isPriceSortAscending());

		// descending
		productPO.selectItemOnSortDropdown("Price (high to low)");
		Assert.assertTrue(productPO.isPriceSortDescending());
		productPO.sleepInSecond(1);
	}

	@AfterClass(alwaysRun = true)
	protected void afterClass() {
		closeBrowserDriver();
	}

}
