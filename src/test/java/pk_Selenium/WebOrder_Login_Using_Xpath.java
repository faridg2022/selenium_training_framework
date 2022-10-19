package pk_Selenium;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class WebOrder_Login_Using_Xpath {
	
	WebDriver driver;
	
  @Test
  public void login() {
	  driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		driver.findElement(By.linkText("Logout")).isDisplayed();
  }
  
  @BeforeTest
  public void lunchBrowser() {
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
		driver.manage().window().maximize();

  }

  @AfterTest
  public void closeBrwoser() {
	  driver.close();
  }

}
