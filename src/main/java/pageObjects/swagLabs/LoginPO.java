package pageObjects.swagLabs;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class LoginPO extends BasePage {

	WebDriver driver;

	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		waitForAllElementsVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, username);

	}

	public void enterPassword(String password) {
		waitForAllElementsVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public ProductPO PressLoginButton() {
		waitForAllElementsClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneraterManager.getProductPage(driver);
	}
}
