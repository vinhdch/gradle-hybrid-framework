package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.UserHomePageUI;

public class UserHomePO extends BasePage {
	WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public UserPostDetailsPO clickToPostTitle(String postTitle) {
		waitForElementsClickable(driver, UserHomePageUI.TITLE_POST_TEXT, postTitle);
		clickToElement(driver, UserHomePageUI.TITLE_POST_TEXT, postTitle);
		return PageGeneraterManager.getUserPostDetailsPage(driver);
	}

	public boolean isPostInfoDisplayedWithPostDate(String postTitle, String currentDate) {
		waitForElementVisible(driver, UserHomePageUI.POST_CURRENT_DATE, postTitle, currentDate);
		return isElementDisplayed(driver, UserHomePageUI.POST_CURRENT_DATE, postTitle, currentDate);
	}

	public boolean isPostInfoDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.TITLE_POST_TEXT, postTitle);
		return isElementDisplayed(driver, UserHomePageUI.TITLE_POST_TEXT, postTitle);
	}

	public boolean isPostInfoDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POST_BODY_TEXT, postTitle, postBody);
		return isElementDisplayed(driver, UserHomePageUI.POST_BODY_TEXT, postTitle, postBody);
	}

	public boolean isPostInfoDisplayedWithPostAuthor(String postTitle, String authorName) {
		waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_TEXT, postTitle, authorName);
		return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR_TEXT, postTitle, authorName);
	}

}
