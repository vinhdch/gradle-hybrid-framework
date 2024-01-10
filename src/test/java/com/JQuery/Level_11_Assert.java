package com.JQuery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.IQuery.HomePageObject;
import pageObject.IQuery.PageGeneraterManager;

// gan truc tiep listeners vao TC cu the or gan vao file runX.xml
@Listeners(commons.MethodListener.class)
public class Level_11_Assert extends BaseTest {

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
		homePage.openPagingByPageNumber("8");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberSelected("8"));
		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(3);

		// verify FAIL
		// assertTrue(homePage.isPageNumberSelected("19"));
		verifyTrue(homePage.isPageNumberSelected("19"));

	}

	@Test
	protected void TC_03_Switch_each_page() {

		actualAllCountryValue = homePage.getValueEachRowAtAllPage();

		// assertEquals(actualAllCountryValue, expectedAllCountryValue);
	}

	@AfterClass
	protected void afterClass() {
		driverTestClass.quit();
	}

}
