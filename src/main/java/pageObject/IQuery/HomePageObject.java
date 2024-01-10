package pageObject.IQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.JQuery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementsClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER_STRING, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER_STRING, pageNumber);

	}

	public void enterToHeaderByLabel(String headerLabel, String input) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, input, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);

	}

	public boolean isPageNumberSelected(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_NUMBER_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGE_NUMBER_ACTIVE, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {

		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);

		List<String> allRowValueAllPage = new ArrayList<String>();

		// get unique value
		// Set<String> allRowUniqueValueAllPage = new HashSet<String>();

		for (int i = 1; i <= totalPage; i++) {

			clickToElement(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(i));

			List<WebElement> allRowEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowEachPage) {
				allRowValueAllPage.add(eachRow.getText());
				// allRowUniqueValueAllPage.add(eachRow.getText());
			}

		}
		for (String value : allRowValueAllPage) {
			System.out.println(value);
		}
		return allRowValueAllPage;
	}

	public void enterToTextboxByRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, HomePageUI.TEXTBOX_BASE_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BASE_COLUMN_INDEX, value, rowNumber, String.valueOf(columnIndex));

	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementsClickable(driver, HomePageUI.DROPDOWN_BASE_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BASE_COLUMN_INDEX, value, rowNumber, String.valueOf(columnIndex));

	}

	public void checkToCheckboxByCloumnNameByRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementsClickable(driver, HomePageUI.CHECK_BASE_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUI.CHECK_BASE_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));

	}

	public void uncheckToCheckboxByCloumnNameByRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementsClickable(driver, HomePageUI.UNCHECK_BASE_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver, HomePageUI.UNCHECK_BASE_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));

	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementsClickable(driver, HomePageUI.ICON_BY_ROW_NUMBER, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_BY_ROW_NUMBER, rowNumber, iconName);

	}

	public boolean isFileUploadByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_LOADED, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElement(driver, HomePageUI.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
	}

	public boolean isFileUploadSuccessfulLink(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_UPLOADED_SUCCESSFUL_LINK, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_UPLOADED_SUCCESSFUL_LINK, fileName);
	}

	public boolean isFileUploadSuccessfulImg(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_UPLOADED_SUCCESSFUL_IMG, fileName);
		return isImageLoaded(driver, HomePageUI.FILE_UPLOADED_SUCCESSFUL_IMG, fileName);
	}

}
