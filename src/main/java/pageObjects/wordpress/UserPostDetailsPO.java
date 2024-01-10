package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.UserDetailsPageUI;

public class UserPostDetailsPO extends BasePage {
	WebDriver driver;

	public UserPostDetailsPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInfoDisplayedWithPostDate(String postTitle, String currentDate) {
		waitForElementVisible(driver, UserDetailsPageUI.POST_CURRENT_DATE, postTitle, currentDate);
		return isElementDisplayed(driver, UserDetailsPageUI.POST_CURRENT_DATE, postTitle, currentDate);
	}

	public boolean isPostInfoDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserDetailsPageUI.TITLE_POST_TEXT, postTitle);
		return isElementDisplayed(driver, UserDetailsPageUI.TITLE_POST_TEXT, postTitle);
	}

	public boolean isPostInfoDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserDetailsPageUI.POST_BODY_TEXT, postTitle, postBody);
		return isElementDisplayed(driver, UserDetailsPageUI.POST_BODY_TEXT, postTitle, postBody);
	}

	public boolean isPostInfoDisplayedWithPostAuthor(String postTitle, String authorName) {
		waitForElementVisible(driver, UserDetailsPageUI.POST_AUTHOR_TEXT, postTitle, authorName);
		return isElementDisplayed(driver, UserDetailsPageUI.POST_AUTHOR_TEXT, postTitle, authorName);
	}

}
