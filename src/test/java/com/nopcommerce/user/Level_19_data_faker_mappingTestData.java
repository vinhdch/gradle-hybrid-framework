package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import commons.BaseTest;
import commons.PageGeneraterManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nop.user.UserHomePageObject;
import pageObjects.nop.user.UserLoginPageObject;
import pageObjects.nop.user.UserRegisterPageObject;
import util.DataHelpers;

public class Level_19_data_faker_mappingTestData extends BaseTest {

	private WebDriver driverTestClass;

	private String firstName, lastName, email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private DataHelpers dataHelpers;

	@Parameters("browser")
	@BeforeClass
	protected void beforeClass(String browserName) {
		driverTestClass = getBrowserDriver(browserName);

		homePage = PageGeneraterManager.getUserHomePageObject(driverTestClass);

		dataHelpers = DataHelpers.getDataHelpers();

		// call test data from helper class
		firstName = dataHelpers.getFirstName();
		lastName = dataHelpers.getLastName();
		email = dataHelpers.getEmail();
		password = dataHelpers.getPassword();

		// firstName = UserData.Register.FIRST_NAME;
		// lastName = UserData.Register.LAST_NAME;
		email = UserData.Register.EMAIL + generateRandomNumber() + "@fakeemail.com";
		// password = UserData.Register.PASSWORD;

	}

	@Description("Register account")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register() {

		registerPage = homePage.clickToRegisterLink();

		// registerPage.inputToFirstnameTextbox(firstName);
		// call test data directly from other class
		registerPage.inputToTextboxById(driverTestClass, "FirstName", UserData.Register.FIRST_NAME);

		Assert.assertEquals(registerPage.getTextboxValueById(driverTestClass, "FirstName"), UserData.Register.FIRST_NAME);

		// registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToTextboxById(driverTestClass, "LastName", UserData.Register.LAST_NAME);

		Assert.assertEquals(registerPage.getTextboxValueById(driverTestClass, "LastName"), UserData.Register.LAST_NAME);

		// registerPage.inputToEmailTextbox(email);
		registerPage.inputToTextboxById(driverTestClass, "Email", email);

		// registerPage.inputToPasswordTextbox(password);
		registerPage.inputToTextboxById(driverTestClass, "Password", UserData.Register.PASSWORD);

		// registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.inputToTextboxById(driverTestClass, "ConfirmPassword", UserData.Register.PASSWORD);

		// registerPage.clickToRegisterButton();
		registerPage.clickToButtonByText(driverTestClass, "Register");

		Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(), "Your registration completed");
	}

	protected int generateRandomEmail() {
		Random rand = new Random();

		return rand.nextInt(99999);
	}

	@AfterClass
	protected void afterClass() {
		closeBrowserDriver();
	}

}
