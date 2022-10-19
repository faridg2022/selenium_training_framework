package pk_Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IllegalFormatException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static WebDriver driver;
	
	
	
	
	static String filePath = System.getProperty("user.dir");

	static String Relativepath_failure = filePath + "\\Screenshot_Failure";
	static String Relativepath_success = filePath + "\\Screenshot_Success";
	

	// launch browser
	public void LaunchBrowser(String browser) throws Exception {

		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		}

		else {

			throw new Exception("Browser is not correct");
		}

	}

	public void CloseBrowser() {

		driver.quit();
	}
	
	
	// connect excel
	
	private static Sheet ExcelWSheet;
	private static Workbook ExcelWBook;

	// This method is to read the test data from the Excel
	public String[][] getExcelData(String fileName, String sheetName)
			throws EncryptedDocumentException, IOException, IllegalFormatException {
		String[][] arrayExcelData = null;
		FileInputStream ExcelFile = new FileInputStream(fileName);
		ExcelWBook = WorkbookFactory.create(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		// System.out.println(ExcelWSheet);	
		int totalNoOfRows = ExcelWSheet.getLastRowNum();
		int totalNoOfCols_0 = ExcelWSheet.getRow(0).getLastCellNum();
		arrayExcelData = new String[totalNoOfRows][totalNoOfCols_0];
		for (int i = 0; i < totalNoOfRows; i++) {
			int totalNoOfCols = ExcelWSheet.getRow(i).getLastCellNum();
			// arrayExcelData = new String [totalNoOfRows][totalNoOfCols];
			for (int j = 0; j < totalNoOfCols; j++) {
				arrayExcelData[i][j] = ExcelWSheet.getRow(i + 1).getCell(j).getStringCellValue();
				// System.out.println(arrayExcelData[i][j]);
			}
		}
		System.out.println(arrayExcelData);
		return arrayExcelData;
	}
	
	
	//connect DB
	
	public void ConnectSQLDB(String url, String uName, String pWord,String Query,String DBConnector,String fValue,String sValue ) throws ClassNotFoundException, SQLException {
		// Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String dbUrl = url;
		// Database Username
		String username = uName;
		// Database Password
		String password = pWord;
		// Query to Execute
		String query = Query;
		// Step1 : Load mysql jdbc driver
		Class.forName(DBConnector);
		// Step2: Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		// Step3 : Create Statement Object
		Statement stmt = con.createStatement();
		// Step4 : Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(query);

		// While Loop to iterate through all data and print results
		while (rs.next()) {
			String Username = rs.getString(fValue);
			String Password = rs.getString(sValue);
			System.out.println(Username + "  " + Password);

		}
		// Step5 : closing DB Connection
		con.close();
	}


	// Read DB Function
		// Connection objectmy
		static Connection con = null;
		// Statement object
		private static Statement stmt;

		public ArrayList<String> ConnectMySQLDatabase(String DB_URL, String DB_USER, String DB_PASSWORD, String DB_QUERY)
				throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

			String dbClass = "com.mysql.jdbc.Driver";
			Class.forName(dbClass);
			// Get connection to DB
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// Statement object to send the SQL statement to the Database
			stmt = con.createStatement();
			String query = DB_QUERY;
			// Get the contents of userinfo table from DB
			ResultSet res = stmt.executeQuery(query);
			// Print the result untill all the records are printed
			// res.next() returns true if there is any next record else returns
			// false

			ArrayList<String> sqlData = new ArrayList<String>();
			while (res.next()) {
				System.out.print("\t" + res.getString("uname"));
				System.out.println("\t" + res.getString("upass"));
				sqlData.add(res.getString("uname") + "~" + res.getString("upass"));
				// Adminadmin123
			}

			// Close DB connection
			if (con != null) {
				con.close();
			}
			return sqlData;
		}

		// TAKE SREENSHOT
		
		
		public static String getScreenshotfailure(WebDriver driver, String screenshotName) throws Exception {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
	                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
			String destination = Relativepath_failure + "//"+screenshotName+dateName+".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}
		
		public static String getScreenshotSuccess(WebDriver driver, String screenshotName) throws Exception {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
	                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
			String destination = Relativepath_success + "//"+screenshotName+dateName+".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}
		
		
		
		
		// EXTENT REPOTS
		
//		static ExtentSparkReporter htmlReporter;
//		static ExtentReports extent;
//		static ExtentTest test;
//		
//		
//		public static ExtentReports startReport() {
//			// initialize the HtmlReporter
//			htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/ExtentReport_base.html");
//			//initialize ExtentReports and attach the HtmlReporter
//			extent = new ExtentReports();
//			extent.attachReporter(htmlReporter);
//			//To add system or environment info by using the setSystemInfo method.
//			extent.setSystemInfo("OS", System.getProperty("os.name"));
//			extent.setSystemInfo("Browser", "Chrome Latest");
//			extent.setSystemInfo("QA Name", "farid");
//
//			//configuration items to change the look and feel
//			//add content, manage tests etc
//			//htmlReporter.config().setChartVisibilityOnOpen(true);
//			htmlReporter.config().setDocumentTitle("WebOrder - Extent Report");
//			htmlReporter.config().setReportName("Smoke Test Report");
//			//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
//			htmlReporter.config().setTheme(Theme.DARK);
//			htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
//			
//			return extent;
		
		
		
		static ExtentSparkReporter htmlReporter;
		static ExtentReports extent;
		//helps to generate the logs in test report.
		static ExtentTest test;
		
		public static ExtentTest startReport() {
		
			// initialize the HtmlReporter
			htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/ExtentReport_baseclass.html");
			//initialize ExtentReports and attach the HtmlReporter
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			//To add system or environment info by using the setSystemInfo method.
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Browser", "Chrome Latest");
			extent.setSystemInfo("QA Name", "Vandana");

			//configuration items to change the look and feel
			//add content, manage tests etc
			//htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setDocumentTitle("WebOrder - Extent Report");
			htmlReporter.config().setReportName("Smoke Test Report");
			//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			return test;
		}
		
		

		}/*
		public static String getResult(ITestResult result) throws Exception {
			if(result.getStatus() == ITestResult.FAILURE) {
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
				test.fail(result.getThrowable());
				String screenshotPath = Base_Class.getScreenshotfailure(driver, result.getName());
				//To add it in the extent report 
				test.addScreenCaptureFromPath(screenshotPath);//This is for Screenshot
				
			}
			else if(result.getStatus() == ITestResult.SUCCESS) {
				test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
				String screenshotPath = Base_Class.getScreenshotSuccess(driver, result.getName());
//				To add it in the extent report 
				test.addScreenCaptureFromPath(screenshotPath);//This is for Screenshot
			}
			else {
				test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
				test.skip(result.getThrowable());
			}
			return screenshotPath;
		}*/
		
//}
