// package com.nopcommerce.user;
//
// import java.util.Random;
// import java.util.concurrent.TimeUnit;
//
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.testng.Assert;
// import org.testng.annotations.AfterClass;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Test;
//
// public class Level_0_User_01_Register {
//
// WebDriver driver;
// String projectPath = System.getProperty("user.dir");
// String emailAddress;
//
// @BeforeClass
// protected void beforeClass() {
// System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//
// driver = new FirefoxDriver();
//
// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
// driver.manage().window().maximize();
//
// driver.get("https://demo.nopcommerce.com/");
//
// emailAddress = "vinh" + generateRandomEmail() + "@gmail.com";
//
// }
//
// @Test
// protected void TC_01_Register_with_empty_data() {
// driver.findElement(By.cssSelector("a.ico-register")).click();
//
// driver.findElement(By.cssSelector("button#register-button")).click();
//
// Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
// Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");
// Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
// Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required.");
// Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");
// }
//
// @Test
// protected void TC_02_Register_with_invalid_email() {
// driver.findElement(By.cssSelector("a.ico-register")).click();
//
// driver.findElement(By.cssSelector("input#FirstName")).sendKeys("vinh1234");
// driver.findElement(By.cssSelector("input#LastName")).sendKeys("dong");
// driver.findElement(By.cssSelector("input#Email")).sendKeys("vinh1234");
// driver.findElement(By.cssSelector("input#Password")).sendKeys("vinh1234@!");
// driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("vinh1234@!");
//
// driver.findElement(By.cssSelector("button#register-button")).click();
//
// Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
// }
//
// @Test
// protected void TC_03_Register_success() {
// driver.findElement(By.cssSelector("a.ico-register")).click();
//
// driver.findElement(By.cssSelector("input#FirstName")).sendKeys("vinh1234");
// driver.findElement(By.cssSelector("input#LastName")).sendKeys("dong");
// driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
// driver.findElement(By.cssSelector("input#Password")).sendKeys("vinh1234@!");
// driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("vinh1234@!");
//
// driver.findElement(By.cssSelector("button#register-button")).click();
//
// Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
//
// }
//
// @Test
// protected void TC_04_Register_with_exist_email() {
// driver.findElement(By.cssSelector("a.ico-register")).click();
//
// driver.findElement(By.cssSelector("input#FirstName")).sendKeys("vinh1234");
// driver.findElement(By.cssSelector("input#LastName")).sendKeys("dong");
// driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
// driver.findElement(By.cssSelector("input#Password")).sendKeys("vinh1234@!");
// driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("vinh1234@!");
//
// driver.findElement(By.cssSelector("button#register-button")).click();
//
// Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error li")).getText(), "The specified email already exists");
//
// }
//
// @Test
// protected void TC_05_Register_with_pw_less_than_6chars() {
// driver.findElement(By.cssSelector("a.ico-register")).click();
//
// driver.findElement(By.cssSelector("input#FirstName")).sendKeys("vinh1234");
// driver.findElement(By.cssSelector("input#LastName")).sendKeys("dong");
// driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
// driver.findElement(By.cssSelector("input#Password")).sendKeys("vin");
// driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("vin");
//
// driver.findElement(By.cssSelector("button#register-button")).click();
//
// Assert.assertEquals(driver.findElement(By.cssSelector("#Password-error")).getText(), "Password must meet the following rules:\nmust have at least 6
// characters");
//
// }
//
// @Test
// protected void TC_06_Register_with_invalid_confirm_pw() {
// driver.findElement(By.cssSelector("a.ico-register")).click();
//
// driver.findElement(By.cssSelector("input#FirstName")).sendKeys("vinh1234");
// driver.findElement(By.cssSelector("input#LastName")).sendKeys("dong");
// driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
// driver.findElement(By.cssSelector("input#Password")).sendKeys("vin1234");
// driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("vin12345");
//
// driver.findElement(By.cssSelector("button#register-button")).click();
//
// Assert.assertEquals(driver.findElement(By.cssSelector("#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");
//
// }
//
// @AfterClass
// protected void afterClass() {
//
// driver.quit();
// }
//
// protected int generateRandomEmail() {
// Random rand = new Random();
//
// return rand.nextInt(99999);
// }
// }
