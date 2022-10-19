package pk_Selenium;



import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mobile_testing_with_Selenium extends TestData{

	
	WebDriver driver;
	 @Test(dataProvider="Mobile_Devices")
	  public void LaunchBrowser(int heigt, int width) {
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
	        //Iphone Pro
	        Dimension d = new Dimension(heigt, width);
	        //driver.manage().window().maximize();
	        driver.manage().window().setSize(d);
	        driver.get("https://demo.spreecommerce.org/t/categories/women");
	        driver.quit();
	  }

}
