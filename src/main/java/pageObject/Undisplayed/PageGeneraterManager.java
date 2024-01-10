package pageObject.Undisplayed;

import org.openqa.selenium.WebDriver;

public class PageGeneraterManager {

	public static LoginPageObject getHomePage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

}
