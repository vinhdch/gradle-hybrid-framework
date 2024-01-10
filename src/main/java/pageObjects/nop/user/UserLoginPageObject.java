package pageObjects.nop.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import io.qameta.allure.Step;
import pageUIs.nop.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("clickToLoginButton")
	public UserHomePageObject clickToLoginButton() {
		waitForElementsClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new PageGeneraterManager().getUserHomePageObject(driver);
	}

	@Step("getErrorMessageAtEmailTextbox")
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	@Step("inputToEmailTextbox is {0}")
	public void inputToEmailTextbox(String validEmail) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, validEmail);

	}

	@Step("getErrorMessageUnsuccessful")
	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
	}

	@Step("inputToPasswordTextbox is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("loginAsUser is {0} and {1}")
	public UserHomePageObject loginAsUser(String validEmail, String password) {
		inputToEmailTextbox(validEmail);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

}
