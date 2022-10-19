package pk_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Upload_File {

	ChromeDriver driver;
  @SuppressWarnings("deprecation")
@Test
  public void UploadFile() {

      String url ="https://the-internet.herokuapp.com/upload";
      driver.get(url);
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      // identify element
      WebElement uploadfile=driver.findElement(By.id("file-upload"));
      // file selection field with file path
      String projectpath = System.getProperty("user.dir");
      String ExpPath =  projectpath+"\\DataFile\\test.png";
      uploadfile.sendKeys(ExpPath);
      String ExpFile = "test.png";
      driver.findElement(By.id("file-submit")).click();
      String ActFile = driver.findElement(By.id("uploaded-files")).getText();
      Assert.assertEquals(ActFile,ExpFile);
      }
  
	@BeforeTest
	public void LaunchBrowser() {
		// Launch the Browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void CloseBrowser() {
//		driver.quit();
	}

}
