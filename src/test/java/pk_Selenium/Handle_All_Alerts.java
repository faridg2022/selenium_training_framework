package pk_Selenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_All_Alerts {
	WebDriver driver;

	@Test(priority = 1)
	public void acceptAlert() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Alert");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),
				"You successfully clicked an alert");

	}

	@Test(priority = 2)
	public void dismissAlert() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked: Cancel");

	}

	@Test(priority = 3)
	public void alertSendText() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("selenium");
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: selenium");

	}

	@BeforeTest
	public void LaunchBrowser() {
		// to launch browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}

	@AfterTest

	public void afterTest() {
		// to close the browser
		driver.quit();

	}
}
