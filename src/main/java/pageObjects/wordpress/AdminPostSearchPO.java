package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage {
	WebDriver driver;

	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementsClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneraterManager.getAdminPostAddNewPage(driver);

	}

	public void enterToSearchBox(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_POST_TEXTBOX);
		sendkeyToElement(driver, AdminPostSearchPageUI.SEARCH_POST_TEXTBOX, postTitle);
	}

	public void clickToSearchPostButton() {
		waitForElementsClickable(driver, AdminPostSearchPageUI.SEARCH_POST_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_POST_BUTTON);

	}

	// public boolean isPostTitleDisplayed(String cellValue, String headerID) {
	// int headerIndex = getElementSize(driver, AdminPostSearchPageUI.HEADER_INDEX_BY_HEADER_NAME, headerID) + 1;
	// waitForElementVisible(driver, AdminPostSearchPageUI.ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
	// return isElementDisplayed(driver, AdminPostSearchPageUI.ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
	// }

	public boolean isPostSearchTableDisplayed(String cellValue, String headerID) {
		int headerIndex = getElementSize(driver, AdminPostSearchPageUI.HEADER_INDEX_BY_HEADER_NAME, headerID) + 1;
		waitForElementVisible(driver, AdminPostSearchPageUI.ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
		return isElementDisplayed(driver, AdminPostSearchPageUI.ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
	}

	public AdminPostAddNewPO clickToPostTitle(String postTitle) {
		waitForElementsClickable(driver, AdminPostSearchPageUI.ROW_VALUE_BY_TITLE_INDEX, postTitle);
		clickToElement(driver, AdminPostSearchPageUI.ROW_VALUE_BY_TITLE_INDEX, postTitle);
		return PageGeneraterManager.getAdminPostAddNewPage(driver);
	}

	public void selectCheckboxByTitle(String editPostTitle) {
		waitForElementsClickable(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_INDEX, editPostTitle);
		checkToDefaultCheckboxOrRadio(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_INDEX, editPostTitle);

	}

	public void selectItemOnDropdown(String dropdownItem) {
		waitForElementsClickable(driver, AdminPostSearchPageUI.ACTION_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminPostSearchPageUI.ACTION_DROPDOWN, dropdownItem);

	}

	public void clickApplyButton() {
		waitForElementsClickable(driver, AdminPostSearchPageUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.APPLY_BUTTON);

	}

	public boolean isMoveToTrashMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
	}

	public boolean isNoPostFoundMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.NO_POTS_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.NO_POTS_FOUND_MESSAGE, message);
	}

}
