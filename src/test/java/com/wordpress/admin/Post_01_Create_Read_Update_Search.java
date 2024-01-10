package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostCatagoriesPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.AdminPostTagPO;
import pageObjects.wordpress.PageGeneraterManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailsPO;

public class Post_01_Create_Read_Update_Search extends BaseTest {

	private WebDriver driverTestClass;
	AdminLoginPO adminLoginPO;
	AdminDashboardPO adminDashboardPO;
	AdminPostAddNewPO adminPostAddNewPO;
	AdminPostCatagoriesPO adminPostCatagoriesPO;
	AdminPostTagPO adminPostTagPO;
	AdminPostSearchPO adminPostSearchPO;
	UserHomePO userHomePO;
	UserPostDetailsPO userPostDetailsPO;

	String adminUrl, endUserUrl;
	String adminUsername = "automationfc";
	String adminPassword = "Hello121996@!";
	String searchPostUrl;
	int randomNumber = generateRandomNumber();
	String postTitle = "Live Coding Title " + randomNumber;
	String postBody = "Live Coding Body " + randomNumber;
	String editPostTitle = "Edit Live Coding Title " + randomNumber;
	String editPostBody = "Edit Live Coding Body " + randomNumber;
	String authorName = "automationfc";
	String currentDate = getToday();

	@Parameters({ "browser", "adminUrl", "endUserUrl" })
	@BeforeClass
	@Description("Create,read, update, delete Post")
	@Severity(SeverityLevel.NORMAL)
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;

		driverTestClass = getBrowserDriverUrl(browserName, this.adminUrl);

		adminLoginPO = PageGeneraterManager.getAdminLoginPage(driverTestClass);

		adminLoginPO.enterToUserNameTextbox(adminUsername);
		adminLoginPO.enterToPasswordTextbox(adminPassword);

		adminDashboardPO = adminLoginPO.clickToLoginButton();

	}

	@Test
	public void TC01_Create_Post() {

		adminPostSearchPO = adminDashboardPO.clickToPostMenuLink();

		searchPostUrl = adminPostSearchPO.getPageUrl(driverTestClass);

		adminPostAddNewPO = adminPostSearchPO.clickToAddNewButton();

		adminPostAddNewPO.enterPostTitle(postTitle);
		adminPostAddNewPO.enterPostBody(postBody);

		adminPostAddNewPO.clickToPublishButton();
		adminPostAddNewPO.clickToPrePublishButton();

		verifyTrue(adminPostAddNewPO.isPostPublishMessageDisplayed("Post published."));
	}

	public void TC01_Search_Post() {

		adminPostSearchPO = adminPostAddNewPO.openSearchPostPageUrl(searchPostUrl);

		// enter to search textbox
		adminPostSearchPO.enterToSearchBox(postTitle);

		// click to search post button
		adminPostSearchPO.clickToSearchPostButton();

		// verify search title/author contain post
		verifyTrue(adminPostSearchPO.isPostSearchTableDisplayed("title", postTitle));
		verifyTrue(adminPostSearchPO.isPostSearchTableDisplayed("author", authorName));

		// open end user site
		userHomePO = adminPostSearchPO.openEndUserSite(driverTestClass, this.endUserUrl);

		// verify post displayed
		verifyTrue(userHomePO.isPostInfoDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePO.isPostInfoDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userHomePO.isPostInfoDisplayedWithPostAuthor(postTitle, authorName));
		// verifyTrue(userHomePO.isPostInfoDisplayedWithPostDate(postTitle, currentDate));

		// click on post title
		userPostDetailsPO = userHomePO.clickToPostTitle(postTitle);

		// verify posted info
		verifyTrue(userPostDetailsPO.isPostInfoDisplayedWithPostTitle(postTitle));
		verifyTrue(userPostDetailsPO.isPostInfoDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userPostDetailsPO.isPostInfoDisplayedWithPostAuthor(postTitle, authorName));
		// verifyTrue(userPostDetailsPO.isPostInfoDisplayedWithPostDate(postTitle, currentDate));
	}

	public void TC01_Update_Post() {

		// open admin site
		adminDashboardPO = userPostDetailsPO.openAdminSite(driverTestClass, this.adminUrl);

		// click Post menu link
		adminPostSearchPO = adminDashboardPO.clickToPostMenuLink();

		// enter to search textbox
		adminPostSearchPO.enterToSearchBox(editPostTitle);

		// click to search post button
		adminPostSearchPO.clickToSearchPostButton();

		// click to Edit
		adminPostAddNewPO = adminPostSearchPO.clickToPostTitle(editPostTitle);

		// edit post title
		adminPostAddNewPO.enterPostTitle(editPostTitle);

		// edit post body
		adminPostAddNewPO.enterToEditPostBody(editPostBody);

		// click publish button
		adminPostAddNewPO.clickToPublishButton();

		// verify success update message
		verifyTrue(adminPostAddNewPO.isPostPublishMessageDisplayed("Post updated."));

		// open user search page
		adminPostSearchPO = adminPostAddNewPO.openSearchPostPageUrl(searchPostUrl);

		// enter to search textbox
		adminPostSearchPO.enterToSearchBox(editPostTitle);

		// click to search post button
		adminPostSearchPO.clickToSearchPostButton();

		// verify search title/author contain post
		verifyTrue(adminPostSearchPO.isPostSearchTableDisplayed("title", editPostTitle));
		verifyTrue(adminPostSearchPO.isPostSearchTableDisplayed("author", authorName));

		// open end user site
		userHomePO = adminPostSearchPO.openEndUserSite(driverTestClass, this.endUserUrl);

		// verify post displayed
		verifyTrue(userHomePO.isPostInfoDisplayedWithPostTitle(editPostTitle));
		verifyTrue(userHomePO.isPostInfoDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userHomePO.isPostInfoDisplayedWithPostAuthor(editPostTitle, authorName));

		// click on post title
		userPostDetailsPO = userHomePO.clickToPostTitle(editPostTitle);

		// verify posted info
		verifyTrue(userPostDetailsPO.isPostInfoDisplayedWithPostTitle(editPostTitle));
		verifyTrue(userPostDetailsPO.isPostInfoDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userPostDetailsPO.isPostInfoDisplayedWithPostAuthor(editPostTitle, authorName));

	}

	public void TC01_Delete_Post() {

		// open admin site
		adminDashboardPO = userPostDetailsPO.openAdminSite(driverTestClass, this.adminUrl);

		// click Post menu link
		adminPostSearchPO = adminDashboardPO.clickToPostMenuLink();

		// enter to search textbox
		adminPostSearchPO.enterToSearchBox(editPostTitle);

		// click to search post button
		adminPostSearchPO.clickToSearchPostButton();

		// select post detail checkbox
		adminPostSearchPO.selectCheckboxByTitle(editPostTitle);

		// select Move to trash on Bulk action button
		adminPostSearchPO.selectItemOnDropdown("Move to Trash");

		// click Apply post deleted
		adminPostSearchPO.clickApplyButton();

		// verify the message
		verifyTrue(adminPostSearchPO.isMoveToTrashMessageDisplayed("1 post moved to the Trash."));

		// enter to search textbox
		adminPostSearchPO.enterToSearchBox(editPostTitle);

		// click to search post button
		adminPostSearchPO.clickToSearchPostButton();

		// verify post not found
		verifyTrue(adminPostSearchPO.isNoPostFoundMessageDisplayed("No posts found."));
	}

	// @AfterClass(alwaysRun = true)
	@AfterClass()
	protected void afterClass() {
		closeBrowserDriver();
	}

}
