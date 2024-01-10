package com.JQuery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.IQuery.HomePageObject;
import pageObject.IQuery.PageGeneraterManager;

public class Level_10_UploadFile extends BaseTest {

	private WebDriver driverTestClass;
	HomePageObject homePage;
	String javaFileName = "java.png";
	String pythonFileName = "python.png";
	String seleniumFileName = "selenium.png";
	String[] multipleFileStrings = { javaFileName, pythonFileName, seleniumFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	protected void beforeClass(String browserName, String url) {
		driverTestClass = getBrowserDriverUrl(browserName, url);
		homePage = PageGeneraterManager.getHomePage(driverTestClass);

	}

	@Test
	protected void TC_01_Upload_1_file() {

		homePage.uploadMulipleFiles(driverTestClass, javaFileName);

		Assert.assertTrue(homePage.isFileUploadByName(javaFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileUploadSuccessfulLink(javaFileName));

		Assert.assertTrue(homePage.isFileUploadSuccessfulImg(javaFileName));
	}

	@Test
	protected void TC_02_Upload_multiple_files() {
		homePage.refreshCurrentPage(driverTestClass);
		homePage.uploadMulipleFiles(driverTestClass, multipleFileStrings);

		Assert.assertTrue(homePage.isFileUploadByName(javaFileName));
		Assert.assertTrue(homePage.isFileUploadByName(pythonFileName));
		Assert.assertTrue(homePage.isFileUploadByName(seleniumFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileUploadSuccessfulLink(javaFileName));
		Assert.assertTrue(homePage.isFileUploadSuccessfulLink(pythonFileName));
		Assert.assertTrue(homePage.isFileUploadSuccessfulLink(seleniumFileName));

		Assert.assertTrue(homePage.isFileUploadSuccessfulImg(javaFileName));
		Assert.assertTrue(homePage.isFileUploadSuccessfulImg(pythonFileName));
		Assert.assertTrue(homePage.isFileUploadSuccessfulImg(seleniumFileName));
	}

	@AfterClass
	protected void afterClass() {
		driverTestClass.quit();
	}

}
