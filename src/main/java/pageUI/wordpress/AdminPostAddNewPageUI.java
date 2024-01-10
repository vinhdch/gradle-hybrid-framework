package pageUI.wordpress;

public class AdminPostAddNewPageUI {
	public static final String ADD_NEW_TITLE_TEXTBOX = "css=h1.wp-block-post-title";
	public static final String ADD_NEW_BODY_BUTTON = "css=p.block-editor-default-block-appender__content";
	public static final String ADD_NEW_BODY_TEXTBOX = "css=p.block-editor-rich-text__editable";
	public static final String PUBLISH_BUTTON = "css=div[aria-label='Editor top bar'] button[class*='editor-post-publish-button__button']";
	public static final String PRE_PUBLISH_BUTTON = "css=div[aria-label='Editor publish'] button[class*='editor-post-publish-button__button']";
	public static final String PUBLISHED_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
}
