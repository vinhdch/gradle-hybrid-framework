package pageObject.Undisplayed;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.Undisplayed.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isEmailAddressDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);

	}

	public void clicCreateNewAccountButton() {
		waitForElementVisible(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);

	}

	public boolean isConfirmEmailAddressDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void clickCloseForm() {
		waitForElementVisible(driver, LoginPageUI.CLICK_X_TO_CLOSE_FORM);
		clickToElement(driver, LoginPageUI.CLICK_X_TO_CLOSE_FORM);

	}

	public boolean isConfirmEmailTextboxUndisplayedOnDOM() {
		waitForElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

}
