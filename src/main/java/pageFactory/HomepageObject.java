package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomepageObject extends BasePageFactory {

	private WebDriver driver;

	public HomepageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page UI

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;

	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;

	@FindBy(css = "a[class='ico-account']")
	private WebElement myAccountLink;

	// page Object

	public void clickToRegisterLink() {
		waitForAllElementsClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickTologinLink() {
		waitForAllElementsClickable(driver, loginLink);
		clickToElement(driver, loginLink);

	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, myAccountLink);
		;
		return isElementDisplayed(driver, myAccountLink);
	}
}
