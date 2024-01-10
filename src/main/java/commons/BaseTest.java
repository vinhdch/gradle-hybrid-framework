package commons;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driverBaseTest;

	public WebDriver getDriver() {
		return driverBaseTest;
	}

	@BeforeSuite
	public void initBeforeSuit() {
		deleteAllureReport();
	}

	protected WebDriver getBrowserDriver(String browserName) {
		// System.out.println("Run on " + browserName);
		if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();
			options.setAcceptInsecureCerts(false);

			driverBaseTest = new FirefoxDriver(options);

		} else if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();

			// disable consolve log
			System.setProperty("webdriver.chrome.args", "--disable-logging");
			System.setProperty("webdriver,chrome.slientOutput", "true");

			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);

			driverBaseTest = new ChromeDriver(options);

		} else if (browserName.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();

		} else if (browserName.equals("headChrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();

			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");

			driverBaseTest = new ChromeDriver(options);

		} else if (browserName.equals("headFirefox")) {

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");

			driverBaseTest = new FirefoxDriver(options);

		} else {
			throw new BrowserNotSupport(browserName);
		}
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driverBaseTest.manage().window().maximize();
		driverBaseTest.get(GlobalConstants.PORTAL_PAGE_URL);
		return driverBaseTest;
	}

	protected WebDriver getBrowserDriverUrl(String browserName, String url) {

		System.out.println("Run on " + browserName);

		if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			// disable browser log
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + "\\browserLogs\\FirefoxLogs.log");

			// add extension to firefox
			FirefoxProfile profile = new FirefoxProfile();
			File translateFile = new File(GlobalConstants.PROJECT_PATH + "\\browserExtension\\to_google_translate-4.2.0.xpi");
			profile.addExtension(translateFile);

			// ignore SSL crtificate (unstrust page)
			// profile.setAcceptUntrustedCertificates(true);
			// profile.setAssumeUntrustedCertificateIssuer(false);

			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
			driverBaseTest = new FirefoxDriver(options);

		} else if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();

			// // disable consolve log
			// System.setProperty("webdriver.chrome.args", "--disable-logging");
			// System.setProperty("webdriver,chrome.slientOutput", "true");

			// add extension to chrome
			File file = new File(GlobalConstants.PROJECT_PATH + "\\browserExtension\\google_translate.crx");

			ChromeOptions options = new ChromeOptions();

			// skip secure option
			options.setAcceptInsecureCerts(true);

			// config language of browser
			options.addArguments("--lang=vi");
			// config noti of browser
			options.addArguments("--disable-notifications");
			// config turn off auto line during running
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			// choose folder to save downloaded files
			HashMap<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_settings,popups", 0);
			prefs.put("download.default_directory", GlobalConstants.PROJECT_PATH + "\\downloadFiles");
			options.setExperimentalOption("prefs", prefs);

			options.addExtensions(file);

			driverBaseTest = new ChromeDriver(options);

		} else if (browserName.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();

		} else if (browserName.equals("headChrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();

			// options.addArguments("--headless");
			// options.addArguments("window-size=1920x1080");
			options.setHeadless(true);

			driverBaseTest = new ChromeDriver(options);

		} else if (browserName.equals("headFirefox")) {

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");

			driverBaseTest = new FirefoxDriver(options);

		} else {
			throw new BrowserNotSupport(browserName);
		}

		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);

		driverBaseTest.manage().window().maximize();

		driverBaseTest.get(url);

		return driverBaseTest;
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {

			Assert.assertTrue(condition);
		} catch (Throwable e) {

			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {

			Assert.assertFalse(condition);
		} catch (Throwable e) {

			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);

		} catch (Throwable e) {

			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public void deleteAllureReport() {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-results";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			if (listOfFiles.length != 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
						new File(listOfFiles[i].toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}

	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			// log.info("OS name = " + osName);

			String driverInstanceName = driverBaseTest.toString().toLowerCase();
			// log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driverBaseTest != null) {
				driverBaseTest.manage().deleteAllCookies();
				driverBaseTest.quit();
			}
		} catch (Exception e) {
			// log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected int generateRandomNumber() {
		Random rand = new Random();

		return rand.nextInt(99999);
	}

	protected String getCurrentDate() {
		// DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		DateTime nowUTC = new DateTime();
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return String.valueOf(month);
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime();
		return now.getYear() + "";
	}

	protected String getToday() {
		return getCurrentDate() + "/" + getCurrentMonth() + "/" + getCurrentYear();
	}

	// protected String getCurrentTimeZone() {
	// Date currentDate = new Date();
	//
	// SimpleDateFormat dateFormat = new SimpleDateFormat("D Month, Yr");
	//
	// String currentDateTime = dateFormat.format(currentDate);
	//
	// return currentDateTime;
	// }
}
