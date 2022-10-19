package pk_Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Spree_CaptureAllLinks {
	WebDriver driver;
	
	
	@Test
	public void captureLinks() {
	List<WebElement> allLinks =	driver.findElements(By.tagName("a"));
	int linksCount = allLinks.size();
	System.out.println("number of links = " + linksCount);
	
	String[] links = new String[linksCount];
	for (int i = 0; i < linksCount; i++) {

		links[i] = allLinks.get(i).getAttribute("href");
		System.out.println(allLinks.get(i).getAttribute("href"));
	}
	for (int i = 0; i < linksCount; i++) {
		driver.navigate().to(links[i]);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

	}
	
	}
	
	

	@BeforeTest
	public void lunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.spreecommerce.org/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeBrwoser() {
		driver.close();
	}
	
}
