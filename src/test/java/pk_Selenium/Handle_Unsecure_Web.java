package pk_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_Unsecure_Web {
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void LaunchBrowserChrome() {
		// Create object of DesiredCapabilities class
//		DesiredCapabilities capabilities = new DesiredCapabilities();
		// other way to handle ACCEPT_SSL_CERTS or any insecure website.
		
//		capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		options.addArguments("incognito");
		options.setHeadless(false);
//		options.merge(capabilities); // this will merge the capabilities to the
										// ChromeOptions
		// setting system property for Chrome browser
		WebDriverManager.chromedriver().setup();
		// create Chrome Object and maximize it
		driver = new ChromeDriver(options);
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
	}	

	@Test
	public void openApplication() {
		System.out.println("Navigating to application");
		driver.get("https://expired.badssl.com/");
		String ActTitle = driver.getTitle();
		String ExpTitle = "expired.badssl.com";
		Assert.assertEquals(ActTitle, ExpTitle);
	}

	@AfterTest
	public void tearDown() {
		
		  if (driver != null) driver.quit();
		 
	}

}
