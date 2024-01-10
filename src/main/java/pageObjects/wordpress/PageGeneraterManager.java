package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneraterManager {

	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}

	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}

	public static AdminPostAddNewPO getAdminPostAddNewPage(WebDriver driver) {
		return new AdminPostAddNewPO(driver);
	}

	public static AdminPostCatagoriesPO getAdminPostCatagoriesPage(WebDriver driver) {
		return new AdminPostCatagoriesPO(driver);
	}

	public static AdminPostSearchPO getAdminPostSearchPage(WebDriver driver) {
		return new AdminPostSearchPO(driver);
	}

	public static AdminPostTagPO getAdminPostTagPage(WebDriver driver) {
		return new AdminPostTagPO(driver);
	}

	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}

	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}

	public static UserPostSearchPO getUserPostSearchPage(WebDriver driver) {
		return new UserPostSearchPO(driver);
	}

	public static UserPostDetailsPO getUserPostDetailsPage(WebDriver driver) {
		return new UserPostDetailsPO(driver);
	}

}
