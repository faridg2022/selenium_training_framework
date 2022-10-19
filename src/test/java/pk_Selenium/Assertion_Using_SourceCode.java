package pk_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion_Using_SourceCode {

	ChromeDriver driver;

	@BeforeTest
	public void Login_HRM() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		// create Edge instance and maximize it
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
		// Browser . Object Identifcation. Action
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		Thread.sleep(2000);
		// Verify that user has logged in
		driver.findElement(By.linkText("Logout")).isDisplayed();
		String ActElement = driver.findElement(By.linkText("Order")).getText();
		String ExpElement = "Order";
		Assert.assertEquals(ActElement, ExpElement);
		System.out.println(ActElement);
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

	@Test(priority = 1)
	public void Employeelist() throws InterruptedException {

		driver.findElement(By.linkText("Order")).click();
		// Check whether user has landed to Orders page or not
		boolean page_source = driver.getPageSource().contains("Zip");
		// System.out.println(page_source);
		Assert.assertTrue(page_source);
	}
}
