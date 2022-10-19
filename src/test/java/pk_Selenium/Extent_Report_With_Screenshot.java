package pk_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent_Report_With_Screenshot extends Base_Class{
//	ChromeDriver driver;

	@Test(priority = 1)
	public void OrangeHRM_Login() throws Exception {
		test = extent.createTest("Test Case 1", "login to application");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		Thread.sleep(2000);
		// Verify that user has logged in
		driver.findElement(By.linkText("Logout")).isDisplayed();
	}

	@Test(priority = 2)
	public void OrangeHRM_Logout() throws Exception {
		test = extent.createTest("Test Case 2", "logout from application");
		driver.findElement(By.linkText("Logout")).click();
	}

	@BeforeTest
	public void LaunchBrowser()

	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
	
	@BeforeClass
	public void getReport() {
		Base_Class.startReport();
	}
//	@AfterMethod
//	public void takeScreenshot() {
//		Base_Class.getResult(driver,result.getName);
//	}
}
