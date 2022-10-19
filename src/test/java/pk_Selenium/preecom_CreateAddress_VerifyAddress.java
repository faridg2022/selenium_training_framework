package pk_Selenium;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class preecom_CreateAddress_VerifyAddress  {
	
	
	
Spreecom_Login spreecom_login = new Spreecom_Login();
	
	
  @Test
  public void CreateAddress() throws InterruptedException {
	  WebDriver driver;
	  driver = spreecom_login.driver;
	  

	  
	  driver.findElement(By.xpath("//*[text()='Add new address']")).click();
	  Thread.sleep(2000);
	  Assert.assertEquals(driver.getTitle(), "Spree Demo Site");
	  Assert.assertEquals(driver.getCurrentUrl(), "https://demo.spreecommerce.org/addresses/new");
	  driver.findElement(By.xpath("//*[@id='address_firstname']")).sendKeys("farid");
	  driver.findElement(By.xpath("//*[@id='address_lastname']")).sendKeys("gr");
	  driver.findElement(By.xpath("//*[@id='address_address1']")).sendKeys("10 john street");
	  driver.findElement(By.xpath("//*[@id='address_city']")).sendKeys("brooklyn");
	  driver.findElement(By.xpath("//*[@id='address_state_id']")).sendKeys("New York");
	  driver.findElement(By.xpath("//*[@id='address_zipcode']")).sendKeys("10012");
	  driver.findElement(By.xpath("//*[@id='address_phone']")).sendKeys("211-111-1111");
	  driver.findElement(By.xpath("//*[@name='commit']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//*[text()='New address has been successfully created']")).getText(),"New address has been successfully created");
	  
	  
//	  logOut();
  }
  
  
  
  
  
  @BeforeTest
  public void beforeTest() throws InterruptedException    {
	  
	spreecom_login.lunchBrowser();
	spreecom_login.login();

	  
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	 spreecom_login.logOut();
	 spreecom_login.closeBrwoser();

	  
	  
  }
  

}
