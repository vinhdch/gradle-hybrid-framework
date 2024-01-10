package pageUI.wordpress;

public class AdminPostSearchPageUI {
	public static final String ADD_NEW_BUTTON = "css=a.page-title-action";
	public static final String SEARCH_POST_TEXTBOX = "css=#post-search-input";
	public static final String SEARCH_POST_BUTTON = "css=#search-submit";
	public static final String HEADER_INDEX_BY_HEADER_NAME = "xpath=//table[contains(@class,'table-view-list posts')]/thead//th[@id='%s']/preceding-sibling::*";
	public static final String ROW_VALUE_BY_HEADER_INDEX = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/*[%s]";
	public static final String ROW_VALUE_BY_TITLE_INDEX = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr//a[@class='row-title' and text()='%s']";
	public static final String ROW_CHECKBOX_BY_TITLE_INDEX = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/th/label/span[contains(text(),'%s')]/ancestor::label";
	public static final String ACTION_DROPDOWN = "css=select#bulk-action-selector-top";
	public static final String APPLY_BUTTON = "css=input#doaction";
	public static final String MOVE_TO_TRASH_MESSAGE = "xpath=//div/p[text()='%s']";
	public static final String NO_POTS_FOUND_MESSAGE = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr[@class='no-items']/td[text()='%s']";
}
