package pk_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Weborder_Login_Using_Keyboard {
	WebDriver driver;
	
	@Test
	public void logingUsingKeyboard() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester",Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test",Keys.ENTER);
		
		 driver.findElement(By.linkText("Logout")).isDisplayed();
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
