package pageUIs.nop.user;

public class BasePageUI {

	public static final String ADDRESS_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Addresses']";
	public static final String CUSTOMER_INFOR_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Customer info']";
	public static final String REWARD_POINT_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Reward points']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='My product reviews']";
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='%s']";
	public static final String LOGOUT_LINK_AT_USER = "class=ico-logout";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";

	// dynamic object
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String DYNCMIC_BUTTON_TEXT = "xpath=//button[text()='%s']";
}
