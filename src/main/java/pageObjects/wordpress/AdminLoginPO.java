package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
	WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserNameTextbox(String userNameAdmin) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, userNameAdmin);
	}

	public void enterToPasswordTextbox(String passwordAdmin) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, passwordAdmin);

	}

	public AdminDashboardPO clickToLoginButton() {
		waitForElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneraterManager.getAdminDashboardPage(driver);
	}

}
