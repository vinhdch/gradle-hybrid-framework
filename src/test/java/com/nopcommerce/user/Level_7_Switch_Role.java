package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneraterManager;
import pageObjects.nop.admin.AdminDashboardPageObject;
import pageObjects.nop.admin.AdminLoginPageObject;
import pageObjects.nop.user.UserCustomerInforPageObject;
import pageObjects.nop.user.UserHomePageObject;
import pageObjects.nop.user.UserLoginPageObject;
import pageObjects.nop.user.UserRegisterPageObject;

public class Level_7_Switch_Role extends BaseTest {

	private WebDriver driverTestClass;
	private String firstName, lastName, userEmail, userPassword, adminEmail, adminPassword;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;

	private UserCustomerInforPageObject userCustomerInforPage;

	@Parameters("browser")
	@BeforeClass
	protected void beforeClass(String browserName) {
		driverTestClass = getBrowserDriver(browserName);

		userHomePage = PageGeneraterManager.getUserHomePageObject(driverTestClass);

		firstName = "vinh";
		lastName = "dong";
		userEmail = "vinh" + generateRandomEmail() + "@gmail.com";
		userPassword = "vinh123";
		adminEmail = "admin@yourstore.com";
		adminPassword = "admin";

		// Precondition:
		userRegisterPage = userHomePage.clickToRegisterLink();
		userRegisterPage.inputToFirstnameTextbox(firstName);
		userRegisterPage.inputToLastnameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(userEmail);
		userRegisterPage.inputToPasswordTextbox(userPassword);
		userRegisterPage.inputToConfirmPasswordTextbox(userPassword);
		userRegisterPage.clickToRegisterButton();
		// userHomePage = userRegisterPage.clickToLogoutLink();
	}

	@Test
	protected void TC01_User_To_Admin() {

		// login as user role
		userLoginPage = userHomePage.clickTologinLink();

		userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

		// homepage => cus_infor
		userCustomerInforPage = userHomePage.clickToMyAccountLink();

		// cus_infor click logout link => homepage
		userHomePage = userCustomerInforPage.clickToLogoutLinkAtUser(driverTestClass);

		// user homepage => open admin page
		userHomePage.openPageUrl(driverTestClass, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneraterManager.getAdminLoginPageObject(driverTestClass);

		// login as admin role
		adminDashboardPage = adminLoginPage.loginAsAsmin(adminEmail, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed(driverTestClass));

		// dashboard click logout => admin login page
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdmin(driverTestClass);
	}

	@Test
	protected void TC02_Admin_To_User() {
		// login page of admin => login page of user
		userHomePage.openPageUrl(driverTestClass, GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneraterManager.getUserHomePageObject(driverTestClass);

		// user homepage => user login page
		userLoginPage = userHomePage.clickTologinLink();

		// login as user role
		userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	protected void afterClass() {

		driverTestClass.quit();
	}

	protected int generateRandomEmail() {
		Random rand = new Random();

		return rand.nextInt(99999);
	}
}
