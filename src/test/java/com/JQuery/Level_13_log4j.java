package com.JQuery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.IQuery.HomePageObject;
import pageObject.IQuery.PageGeneraterManager;

public class Level_13_log4j extends BaseTest {

	private WebDriver driverTestClass;
	HomePageObject homePage;
	List<String> actualAllCountryValue;
	List<String> expectedAllCountryValue;

	@Parameters({ "browser", "url" })
	@BeforeClass
	protected void beforeClass(String browserName, String url) {
		driverTestClass = getBrowserDriverUrl(browserName, url);
		homePage = PageGeneraterManager.getHomePage(driverTestClass);

	}

	@Test
	protected void TC_01_Paging() {
		// log.info("Paging: step 1 - click page 8");
		homePage.openPagingByPageNumber("8");
		homePage.sleepInSecond(3);

		// log.info("Paging: step 1 - verify page 8");
		verifyTrue(homePage.isPageNumberSelected("8"));

		// log.info("Paging: step 1 - click page 18");
		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(3);

		// log.info("Paging: step 1 - verify page 18");
		verifyTrue(homePage.isPageNumberSelected("18"));

	}

	@AfterClass
	protected void afterClass() {
		driverTestClass.quit();
	}

}
