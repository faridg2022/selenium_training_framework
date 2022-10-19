package pk_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lets_Code_Hide_And_Show {
WebDriver driver;
	
	@Test
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://courses.letskodeit.com/practice");

//		JavascriptExecutor js = new (JavascriptExecutor,driver);
		
		driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();
		boolean hideDesable = driver.getPageSource().contains("Hide/Show Example");
		Assert.assertFalse(hideDesable);
		
		driver.quit();
		
	}
	
	
}
