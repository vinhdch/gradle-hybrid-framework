package pageUI.JQuery;

public class HomePageUI {

	// data table
	public static final String PAGINATION_PAGE_BY_NUMBER_STRING = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String DATA_TABLE_URL = "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String PAGE_NUMBER_ACTIVE = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String TOTAL_PAGINATION = "css=ul.qgrd-pagination-ul li";
	public static final String PAGINATION_PAGE_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
	public static final String ALL_ROW_COUNTRY_EACH_PAGE = "xpath=//tbody/tr/td[@data-key='country']";

	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BASE_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BASE_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]//select";
	public static final String CHECK_BASE_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input[@type='checkbox']";
	public static final String UNCHECK_BASE_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input[@type='checkbox']";
	public static final String ICON_BY_ROW_NUMBER = "xpath=//tbody/tr[%s]//button[@title='%s']";

	// upload file
	public static final String FILE_LOADED = "xpath=//p[@class='name' and text()='%s']";
	public static final String START_BUTTON = "css=table button.start";
	public static final String FILE_UPLOADED_SUCCESSFUL_LINK = "xpath=//a[text()='%s']";
	public static final String FILE_UPLOADED_SUCCESSFUL_IMG = "xpath=//a[@title='%s']/img";

}
