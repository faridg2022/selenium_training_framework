package pk_Selenium;



import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mobile_testing_with_DataProvider {

	
	ChromeDriver driver;
	  @Test
	  public void SignOn() {
		  
	      	driver.get("https://demo.spreecommerce.org/t/categories/women");


	  }
	  @BeforeTest
	  public void LaunchBrowser() {
		    WebDriverManager.chromedriver().setup();
		    	
	        //ChromeOptions iPhoneOption = new ChromeOptions();

	        driver = new ChromeDriver();
	        //Iphone Pro
	        Dimension d = new Dimension(768, 1024);
	        //driver.manage().window().maximize();
	        driver.manage().window().setSize(d);

	  }

	  @AfterTest
	  public void CloseBrowser() {
		//	driver.quit();
	  }

}
