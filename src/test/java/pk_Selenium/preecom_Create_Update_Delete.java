package pk_Selenium;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class preecom_Create_Update_Delete  {
	
	
	
Spreecom_Login spreecom_login = new Spreecom_Login();
	
	
  @Test
  public void CreateAddress() throws InterruptedException {
	  
	  WebDriver driver = spreecom_login.driver;
	  

	  
	  driver.findElement(By.xpath("//*[text()='Add new address']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='address_firstname']")).sendKeys("farid");
	  driver.findElement(By.xpath("//*[@id='address_lastname']")).sendKeys("gr");
	  driver.findElement(By.xpath("//*[@id='address_address1']")).sendKeys("10 john street");
	  driver.findElement(By.xpath("//*[@id='address_city']")).sendKeys("brooklyn");
	  driver.findElement(By.xpath("//*[@id='address_state_id']")).sendKeys("New York");
	  driver.findElement(By.xpath("//*[@id='address_zipcode']")).sendKeys("10012");
	  driver.findElement(By.xpath("//*[@id='address_phone']")).sendKeys("211-111-1111");
	  driver.findElement(By.xpath("//*[@name='commit']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//*[text()='New address has been successfully created']")).getText(),"New address has been successfully created");
	  
	  
  }
  
  @Test(priority = 1)
  
  public void updateAddress() throws InterruptedException {
	  WebDriver driver = spreecom_login.driver;
	  
	  
	  
	  driver.findElement(By.xpath("//a[@class='ml-1 d-inline-block']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='address_firstname']")).clear();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='address_firstname']")).sendKeys("update");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='address_lastname']")).clear();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='address_lastname']")).sendKeys("address");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='address_address1']")).clear();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='address_address1']")).sendKeys("100 john street");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='address_city']")).clear();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='address_city']")).sendKeys("manhattan");
	  Thread.sleep(2000);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='address_state_id']")).sendKeys("New York");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='address_zipcode']")).clear();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='address_zipcode']")).sendKeys("10013");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='address_phone']")).clear();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='address_phone']")).sendKeys("211-111-1111");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Updated successfully']")).getText(), "Updated successfully");
	  Assert.assertEquals(driver.getCurrentUrl(), "https://demo.spreecommerce.org/account");
	  
	  
	  
  }
  
  @Test (priority = 2)
  public void deleteAddress() {
	  WebDriver driver = spreecom_login.driver;
	  
	  driver.findElement(By.xpath("//a[@data-hook='remove_address']")).click();
	  driver.findElement(By.xpath("//a[@id='delete-address-popup-confirm']")).click();
	  Assert.assertEquals(driver.getCurrentUrl(), "https://demo.spreecommerce.org/account");
	  Assert.assertEquals(driver.getTitle(), "My Account - Spree Demo Site");
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
