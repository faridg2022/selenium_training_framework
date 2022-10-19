package pk_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Create_Orders_Positive_Negative_Scenario extends Base_Class {

	@BeforeTest
	@Parameters("browser")
	public void preCondition(String browser) throws Exception {
		LaunchBrowser(browser);

	}

	@AfterTest
	public void postCondition() {
		CloseBrowser();
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Order")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 2, dataProvider = "multiple Scenarios", dataProviderClass = TestData.class)

	public void createAddress(String Quantity, String name, String address, String city, String zip, String expected)
			throws InterruptedException {

		Select selectProduct = new Select(
				driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
		selectProduct.selectByVisibleText("ScreenSaver");

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Quantity);

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).sendKeys("100");

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys("10");

		driver.findElement(By.xpath("//input[@class='btn_dark']")).click();

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(address);

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("StateName");

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);

		driver.findElement(By.xpath("//input[@value='MasterCard']")).click();

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("1234123412341234");

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("09/25");

		driver.findElement(By.linkText("Process")).click();

		if (expected.equalsIgnoreCase("Quantity must be greater than zero.")) {
			Assert.assertEquals(
					driver.findElement(By.xpath("//span[@id='ctl00_MainContent_fmwOrder_RegularExpressionValidator1']"))
							.getText(),
					expected);
		} else if (expected.equalsIgnoreCase("Customer name' cannot be empty")) {
			Assert.assertEquals(
					driver.findElement(By.xpath("//span[@id='ctl00_MainContent_fmwOrder_RequiredFieldValidator2']"))
							.getText(),
					expected);
		} else if (expected.equalsIgnoreCase("Field 'Street' cannot be empty.")) {
			Assert.assertEquals(
					driver.findElement(By.xpath("//span[@id='ctl00_MainContent_fmwOrder_RequiredFieldValidator3']"))
							.getText(),
					expected);
		} else if (expected.equalsIgnoreCase("Field 'City' cannot be empty.")) {
			Assert.assertEquals(
					driver.findElement(By.xpath("//span[@id='ctl00_MainContent_fmwOrder_RequiredFieldValidator4']"))
							.getText(),
					expected);
		} else if (expected.equalsIgnoreCase("Field 'Zip' cannot be empty.")) {
			Assert.assertEquals(
					driver.findElement(By.xpath("//span[@id='ctl00_MainContent_fmwOrder_RequiredFieldValidator5']"))
							.getText(),
					expected);
		}

	}

}
