package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nop.admin.AdminDashboardPageObject;
import pageObjects.nop.admin.AdminLoginPageObject;
import pageObjects.nop.user.UserAddressPageObject;
import pageObjects.nop.user.UserCustomerInforPageObject;
import pageObjects.nop.user.UserHomePageObject;
import pageObjects.nop.user.UserLoginPageObject;
import pageObjects.nop.user.UserMyProductReviewPageObject;
import pageObjects.nop.user.UserRegisterPageObject;
import pageObjects.nop.user.UserRewardPointPageObject;

public class PageGeneraterManager {

	public static UserHomePageObject getUserHomePageObject(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPageObject(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPageObject(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserAddressPageObject getUserAddressPageObject(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}

	public static UserCustomerInforPageObject getUserCustomerInforPageObject(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}

	public static UserRewardPointPageObject getUserRewardPointPageObject(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}

	public static UserMyProductReviewPageObject getUserMyProductReviewPageObject(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPageObject(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
}
