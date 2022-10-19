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

public class Create_Six_User_And_Verify extends TestData {
	WebDriver driver;

	@Test(priority = 1)
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 2, dataProvider = "create_address")
	public void createAddress(String userName, String passWord, String name, String address, String city, String zip)
			throws InterruptedException {

//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
//		
//		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys(userName);
//		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys(passWord);
//		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
//		Thread.sleep(2000);

		driver.findElement(By.linkText("Order")).click();
		Thread.sleep(2000);

		// to select value from the dropdown
		Select selectProduct = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
		selectProduct.selectByVisibleText("ScreenSaver");
		Thread.sleep(3000);

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("5");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).sendKeys("100");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys("10");
		driver.findElement(By.xpath("//input[@class='btn_dark']")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(address);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("StateName");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);
		driver.findElement(By.xpath("//input[@value='MasterCard']")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("1234123412341234");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("09/25");
		driver.findElement(By.linkText("Process")).click();

		String ActOutput = driver.findElement(By.tagName("strong")).getText();
		String ExpOutput = "New order has been successfully added.";
		Assert.assertEquals(ExpOutput, ActOutput);

		String ActUrl = driver.getCurrentUrl();
		String ExpUrl = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Process.aspx";
		Assert.assertEquals(ExpUrl, ActUrl);
		
		driver.findElement(By.xpath("//a[text()='View all orders']")).click();
		//user verification 

//		driver.quit();

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

	public void afterTest() throws InterruptedException {
		// to close the browser
		
		Thread.sleep(2000);
		driver.quit();

	}

}
