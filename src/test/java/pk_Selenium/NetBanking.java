package pk_Selenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetBanking {
	
	WebDriver driver;

	@Test(priority = 1)
	public void login() throws InterruptedException {
		//Go Inside the Frame
		driver.switchTo().frame("login_page");
		driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("1000");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[normalize-space()='CONTINUE']")).click();

		String ExpText = driver.findElement(By.xpath(("//span[normalize-space()='Password/ IPIN']"))).getText();

		String ActText = "Password/ IPIN";
		// String = driver.getCurrentUrl();
		Assert.assertEquals(ActText, ExpText);
		Thread.sleep(2000);
		//It will take you out of the frame
		driver.switchTo().defaultContent();

	}

	@BeforeTest
	public void lunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeBrwoser() {
		driver.close();
	}

}
