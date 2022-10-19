package pk_Selenium;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Spreecom_Login {
	public WebDriver driver;

	@Test(priority = 1)
	public void login() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='account-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='LOGIN']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Login - Spree Demo Site");
		driver.findElement(By.xpath("//*[@id='spree_user_email']")).sendKeys("farid@spree.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='spree_user[password]']")).sendKeys("selenium");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='commit']")).click();
		Assert.assertEquals(driver.getTitle(), "My Account - Spree Demo Site");
		Thread.sleep(2000);

		Assert.assertEquals(driver.findElement(By.xpath("//*[text()='My Account']")).getText(), "MY ACCOUNT");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Logged in successfully']")).isDisplayed();

	}

	@Test(priority = 2)
	public void logOut() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='account-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='LOGOUT']")).click();
		Thread.sleep(2000);

		Assert.assertEquals(driver.findElement(By.xpath("//*[text()='Signed out successfully.']")).getText(),
				"Signed out successfully.");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='spree-mb-large spree-mt-large spree-header'])[1]")).isDisplayed();

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
