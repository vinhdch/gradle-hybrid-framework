package pageObjects.nop.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import io.qameta.allure.Step;
import pageUIs.nop.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("getErrorMessageAtFirstnameTextbox")
	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
	}

	@Step("getErrorMessageAtLastnameTextbox")
	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
	}

	@Step("getErrorMessageAtEmailTextbox")
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	@Step("getErrorMessageAtPasswordeTextbox")
	public String getErrorMessageAtPasswordeTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	@Step("getErrorMessageAtConfirmPasswordTextbox")
	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	@Step("clickToRegisterButton")
	public void clickToRegisterButton() {
		waitForElementsClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	@Step("inputToFirstnameTextbox is {0}")
	public void inputToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	@Step("inputToLastnameTextbox is {0}")
	public void inputToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	// cho nhieu param
	// @Step("getErrorMessageAtFirstnameTextbox is {0} and {1}")

	@Step("inputToEmailTextbox is {0}")
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	@Step("inputToPasswordTextbox is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("inputToConfirmPasswordTextbox is {0}")
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	@Step("getRegisterSuccessfulMessage")
	public String getRegisterSuccessfulMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	@Step("getErrorExistingEmailMessage")
	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, RegisterPageUI.EXIST_EMAIL_MESSAGE);
		return getElementText(driver, RegisterPageUI.EXIST_EMAIL_MESSAGE);
	}

	@Step("clickToLogoutLink")
	public UserHomePageObject clickToLogoutLink() {
		waitForElementsClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return new PageGeneraterManager().getUserHomePageObject(driver);
	}

}
