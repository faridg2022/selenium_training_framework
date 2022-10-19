package pk_Selenium;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class WebOrder_Pre_Post_TestNG {
	
	WebDriver driver;
	
  @Test (priority =1)
  public void login() {
	  	driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");
		driver.findElement(By.cssSelector("input[id='ctl00_MainContent_password']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
		driver.findElement(By.linkText("Logout")).isDisplayed();
  }
  
  @Test (priority =2)
  public void logOut() {
	  driver.findElement(By.xpath("//a[@id='ctl00_logout']")).click();
	  String Actual = driver.findElement(By.xpath("//label[normalize-space()='Username:']")).getText();
	  String Expected = "Username:";
	  Assert.assertEquals(Expected, Actual);
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
