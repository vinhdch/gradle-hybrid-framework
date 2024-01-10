package pageUI.wordpress;

public class UserDetailsPageUI {

	public static final String TITLE_POST_TEXT = "xpath=//article//h1[text() ='%s']";
	public static final String POST_CURRENT_DATE = "xpath=//article//h1[text() ='%s']/following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_TEXT = "xpath=//article//h1[text() ='%s']/ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String POST_AUTHOR_TEXT = "xpath=//article//h1[text() ='%s']/following-sibling::div//a[text()='%s']";
}
