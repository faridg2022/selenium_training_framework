package pk_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Weborder_create_order_delete_verify_using_sourcePage {
	WebDriver driver;
	
	
	@Test(priority = 1)
	public void ValidLogin() {
		
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		driver.findElement(By.linkText("View all orders")).isDisplayed();
	}

	@Test(priority = 2)
	public void CreateOrder() throws InterruptedException {
		
		driver.findElement(By.linkText("Order")).click();
		Select selectProduct = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
		selectProduct.selectByVisibleText("ScreenSaver");
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("5");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).sendKeys("100");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys("10");
		driver.findElement(By.xpath("//input[@class='btn_dark']")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Dixit");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("Add line1");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("CityName");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("StateName");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("098765");
		driver.findElement(By.xpath("//input[@value='MasterCard']")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("1234123412341234");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("09/25");
		driver.findElement(By.linkText("Process")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='View all orders']")).click();

	
	}
	
	@Test(priority = 3)
	public void deleteUser() throws InterruptedException {
		driver.findElement(By.xpath("//td[text()='Dixit']//preceding::td/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		boolean page_source = driver.getPageSource().contains("Dixit");
		Assert.assertFalse(page_source);
	}
	
	
	@BeforeTest
	public void LaunchBrowser() {
		// to launch browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
	}

	@AfterTest

	public void afterTest() {
		// to close the browser
		driver.quit();

	}

}
