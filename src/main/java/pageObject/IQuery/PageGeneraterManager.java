package pageObject.IQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneraterManager {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

}
