package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "Email")
	private WebElement emailTextbox;

	@FindBy(id = "Password")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;

	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;

	@FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]")
	private WebElement unsuccessfullErrorMessage;

	public void clickToLoginButton() {
		waitForAllElementsClickable(driver, loginButton);
		clickToElement(driver, loginButton);

	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, invalidEmail);

	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver, unsuccessfullErrorMessage);
		return getElementText(driver, unsuccessfullErrorMessage);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);

	}
}
