package pk_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Blaze_Demo {
	WebDriver driver;

	@Test
	public void selectFlight() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();

		Select From = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		From.selectByVisibleText("Boston");

		Select To = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		To.selectByVisibleText("New York");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actual = driver.findElement(By.xpath("//h3[text()='Flights from Boston to New York: ']")).getText();
		System.out.println(actual);
		String Expected = "Flights from Boston to New York:";
		Assert.assertEquals(Expected, actual);
		driver.findElement(By.xpath("//table[@class='table']/tbody/tr[3]/td[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("farid");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='address']")).clear();
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("100 john street");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("brooklyn");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("NY");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='zipCode']")).clear();
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("10012");
		Thread.sleep(2000);
		Select cartType = new Select(driver.findElement(By.xpath("//select[@id='cardType']")));
		cartType.selectByVisibleText("Visa");
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("1342452521");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).clear();
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("03");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).clear();
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2023");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).clear();
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("farid");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Thank you for your purchase today!']")).getText(),
				"Thank you for your purchase today!");
		

		driver.quit();

	}

	
	
}
