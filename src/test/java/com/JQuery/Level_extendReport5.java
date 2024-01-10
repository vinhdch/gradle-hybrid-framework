package com.JQuery;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObject.IQuery.HomePageObject;
import pageObject.IQuery.PageGeneraterManager;
import reportConfig.ExtentTestManager;

public class Level_extendReport5 extends BaseTest {

	private WebDriver driverTestClass;
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	protected void beforeClass(String browserName, String url) {
		driverTestClass = getBrowserDriverUrl(browserName, url);
		homePage = PageGeneraterManager.getHomePage(driverTestClass);

	}

	@Test
	protected void TC_01_Paging(Method method) {
		ExtentTestManager.startTest(method.getName(), "navigate to page 8");
		ExtentTestManager.getTest().log(Status.INFO, "navigate to page 8");
		homePage.openPagingByPageNumber("8");
		homePage.sleepInSecond(3);

		ExtentTestManager.startTest(method.getName(), "verify to page 8");
		ExtentTestManager.getTest().log(Status.INFO, "verify to page 8");
		verifyTrue(homePage.isPageNumberSelected("8"));

		ExtentTestManager.startTest(method.getName(), "navigate to page 18");
		ExtentTestManager.getTest().log(Status.INFO, "navigate to page 18");
		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(3);

		ExtentTestManager.startTest(method.getName(), "verify to page 18");
		ExtentTestManager.getTest().log(Status.INFO, "verify to page 18");
		verifyTrue(homePage.isPageNumberSelected("18"));

	}

	@AfterClass
	protected void afterClass() {
		driverTestClass.quit();
	}

}
