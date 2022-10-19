package pk_Selenium;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name = "Mobile_Devices")
	public Object[][] getDeviceDimension() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{768, 1024 },
				{390, 844 },
				{412, 914 },
				{360, 740 }
				};

	}
	
	@DataProvider(name = "Customer_Name")
	public Object[][] getName() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"Abhi"},
				{"Farid"},
				{"Vandana"},
				{"Kawal"},
				{"Elena"}
				};

	}

	
	@DataProvider(name = "multiple Scenarios")
	public Object[][] getAddress() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"","farid","100 john","brooklyn","10012","Quantity must be greater than zero."},
				{"5","","200 john","manhattan","10011","Field 'Customer name' cannot be empty"},
				{"10","farid","","queens","10014","Field 'Street' cannot be empty."},
				{"13","farid","100 1st ave","","10014","Field 'City' cannot be empty."},
				{"12","farid","100 south street","jersey","","Field 'Zip' cannot be empty"}
				
				};

	}
	
	
	@DataProvider(name = "Weborder_Login_Scenario")
	public Object[][] LoginTcs() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"Tester","test","List of All Orders"},
				{"Tester1","test","Invalid Login or Password."},
				{"Tester","test1","Invalid Login or Password."},
				{"","test","Invalid Login or Password."},
				{"Farid","","Invalid Login or Password."},
				};

	}
	
	@DataProvider(name = "CreateOrder_TCs_Scenario")
	public Object[][] OrderTcs() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {
//Quantity,Customer Name, Street, City, Zip, CardType, CardNumber, Date, ExpResult
				{"","Dixit","ABC","Bangalore","56006","Visa","1234567891","12/22","Quantity must be greater than zero."},
				{"","Dixit","ABC","Bangalore","56006","Visa","1234567891","12/22","Quantity must be greater than zero."},
				{"Tester","test1","Invalid Login or Password."},
				{"","test","Invalid Login or Password."},
				{"Tester","","Invalid Login or Password."},
				};

	}
	

	@DataProvider(name = "LoginExcelData")
	public Object[][] ReadDataFromExcel() throws Exception{
		Base_Class excel = new Base_Class();
		String RelativePath = System.getProperty("user.dir");
		//Object[][] testObjArray = excel.getExcelData("C:\\Users\\adixit\\git\\abhikdixit-Maven_Selenium_WebDriver_4\\Maven_Selenium_WebDriver_4\\OrangeHRM_TestData.xls","Login");
		Object[][] testObjArray = excel.getExcelData(RelativePath+"\\Weborder.xls","Login");
		System.out.println(testObjArray);
		return testObjArray;

	}

}
