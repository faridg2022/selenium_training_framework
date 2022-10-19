package pk_Selenium;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Weborder_Login extends Base_Class {

	@Test
	public void Login_Scenario() throws IOException  {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
	    driver.manage().window().maximize();
	    
	    
	    driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
	    driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
	    driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	    driver.findElement(By.linkText("Logout")).isDisplayed();
	    
	    
	    driver.close();
	}

	
	
}
