package pk_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lets_Codeit_Alerts {
	
	// Global Variable
			WebDriver driver;

			@Test
			public void Alert() throws InterruptedException {
//				driver.findElement(By.id("name")).sendKeys("Abhi");
				
				JavascriptExecutor js = ((JavascriptExecutor)driver);
				js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//input[@id='alertbtn']")));
				Thread.sleep(4000);
//				
				driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
				Thread.sleep(4000);

			}

			@SuppressWarnings("deprecation")
			@BeforeTest
			public void LaunchBrowser() {
				// Launch the Browser
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.setHeadless(true);
				driver = new ChromeDriver(options);
				// ChromeDriver driver = new ChromeDriver();
				// WebDriver driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get("https://courses.letskodeit.com/practice");
				driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
				
			}

			@AfterTest
			public void CloseBrowser() {
				// driver.close(); // Close will close the current browser opened by Selenium
				driver.quit(); // Quit will close all the browser opened by Selenium
			}


}
