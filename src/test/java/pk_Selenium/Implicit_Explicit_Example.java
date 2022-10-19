package pk_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Implicit_Explicit_Example {
	
	ChromeDriver driver;

	@BeforeTest
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
	}

	@Test
	public void Explicit_Wait() throws InterruptedException

	{
		// Browser . Object Identifcation. Action
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();

		// -----------------ImplicitWait Example-------------
	
		// driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click(); 
		 //Thread.sleep(10000);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.findElement(By.linkText("Logout")).click();
		// driver.findElement(By.id("logInPanelHeading")).isDisplayed();
		//driver.findElement(By.linkText("Logout")).click();

		// ----------------ExplicitWait Example--------------
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
		System.out.println(element.getText());
		element.click();

		
	}
	

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}