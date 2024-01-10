package pageUI.wordpress;

public class UserHomePageUI {

	public static final String TITLE_POST_TEXT = "xpath=//article//h2/a[text() ='%s']";
	public static final String POST_CURRENT_DATE = "xpath=//article//a[text() ='%s']/parent::h2/following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_TEXT = "xpath=//article//a[text() ='%s']/ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String POST_AUTHOR_TEXT = "xpath=//article//a[text() ='%s']/parent::h2/following-sibling::div//a[text()='%s']";
}
