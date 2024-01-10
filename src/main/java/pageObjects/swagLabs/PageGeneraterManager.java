package pageObjects.swagLabs;

import org.openqa.selenium.WebDriver;

public class PageGeneraterManager {

	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}

	public static ProductPO getProductPage(WebDriver driver) {
		return new ProductPO(driver);
	}

}
