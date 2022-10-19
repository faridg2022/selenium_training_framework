package pk_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Hoverover_Sport_Wear {
	WebDriver driver;

	@Test
	public void sport_waar_hover() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.spreecommerce.org/");
		driver.manage().window().maximize();

		WebElement sportWear = driver.findElement(By.xpath(
				"//a[@class='nav-link main-nav-bar-item main-nav-bar-category-button dropdown-toggle' and text()='Sportswear']"));
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(sportWear).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Pants']")).click();
		Thread.sleep(2000);
//		Assert.assertEquals(driver.getTitle(), "Homepage (English) - Spree Demo Site");
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.spreecommerce.org/t/categories/sportswear/pants");
	Assert.assertEquals(driver.findElement(By.xpath("//div[normalize-space()='Pants']")).getText(), "PANTS") ;
//		System.out.println(pants);
		
		driver.quit();
	}

}
