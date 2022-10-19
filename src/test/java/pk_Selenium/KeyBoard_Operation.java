package pk_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoard_Operation {
	ChromeDriver driver;

	@Test
	public void PressEnterKey() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().window().fullscreen();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
		String ReturnText = driver.findElement(By.xpath("//span[text()='Selenium']")).getText();
		Assert.assertEquals("Selenium", ReturnText);
		// driver.findElement(By.xpath("//span[contains(text(),'Dummy PDF
		// file')]")).click();
		driver.quit();
	}

}
