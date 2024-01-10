package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.ADD_NEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.ADD_NEW_TITLE_TEXTBOX, postTitle);

	}

	public void enterPostBody(String postBody) {
		waitForElementsClickable(driver, AdminPostAddNewPageUI.ADD_NEW_BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.ADD_NEW_BODY_BUTTON);

		waitForElementVisible(driver, AdminPostAddNewPageUI.ADD_NEW_BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.ADD_NEW_BODY_TEXTBOX, postBody);

	}

	public void enterToEditPostBody(String postBody) {
		waitForElementsClickable(driver, AdminPostAddNewPageUI.ADD_NEW_BODY_TEXTBOX);
		clickToElement(driver, AdminPostAddNewPageUI.ADD_NEW_BODY_TEXTBOX);

		waitForElementVisible(driver, AdminPostAddNewPageUI.ADD_NEW_BODY_TEXTBOX);
		clearValueInElementByDeleteKey(driver, AdminPostAddNewPageUI.ADD_NEW_BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.ADD_NEW_BODY_TEXTBOX, postBody);

	}

	public void clickToPrePublishButton() {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);

	}

	public void clickToPublishButton() {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);

	}

	public boolean isPostPublishMessageDisplayed(String postPublishedMessage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishedMessage);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishedMessage);
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openPageUrl(driver, searchPostUrl);
		return PageGeneraterManager.getAdminPostSearchPage(driver);
	}

}
