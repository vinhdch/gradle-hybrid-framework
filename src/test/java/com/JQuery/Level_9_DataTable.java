package com.JQuery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.IQuery.HomePageObject;
import pageObject.IQuery.PageGeneraterManager;

public class Level_9_DataTable extends BaseTest {

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

	protected void TC_01_Paging() {
		homePage.openPagingByPageNumber("8");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberSelected("8"));
		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberSelected("18"));

	}

	protected void TC_02_Search_On_Header() {
		homePage.refreshCurrentPage(driverTestClass);
		homePage.enterToHeaderByLabel("Country", "Angola");
		homePage.sleepInSecond(3);
		homePage.enterToHeaderByLabel("Females", "777");
	}

	protected void TC_03_Switch_each_page() {
		// doc du lieu file country.txt
		// luu vao 1 list<string> = actual = expected

		actualAllCountryValue = homePage.getValueEachRowAtAllPage();

		Assert.assertEquals(actualAllCountryValue, expectedAllCountryValue);
	}

	@Test
	protected void TC_04_Enter_to_textbox_any_row() {

		homePage.enterToTextboxByRowNumber("Company", "1", "Adnovum");
		homePage.sleepInSecond(1);

		homePage.enterToTextboxByRowNumber("Order Placed", "2", "Adnovum");

		homePage.enterToTextboxByRowNumber("Contact Person", "1", "Adnovum");

		homePage.selectDropdownByColumnNameAtRowNumber("Country", "3", "Malaysia");
		homePage.sleepInSecond(1);

		homePage.checkToCheckboxByCloumnNameByRowNumber("NPO?", "2");
		homePage.sleepInSecond(1);

		homePage.uncheckToCheckboxByCloumnNameByRowNumber("NPO?", "2");
		homePage.sleepInSecond(1);

		// remove a row
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(1);

		// add a row
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.sleepInSecond(1);

		// move up a row
		homePage.clickToIconByRowNumber("3", "Move Up");
		homePage.sleepInSecond(1);

		// move down a row
		homePage.clickToIconByRowNumber("2", "Move Down");
		homePage.sleepInSecond(1);
	}

	@AfterClass
	protected void afterClass() {
		driverTestClass.quit();
	}

}
