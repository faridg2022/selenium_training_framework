package pk_Selenium;

import java.sql.SQLException;

import org.testng.annotations.Test;

public class CallingFromDB extends Base_Class{
	@Test
	public void readDB() throws ClassNotFoundException, SQLException {
//		ConnectSQLDB("jdbc:mysql://localhost:3306/weborder","root","root","select * from login","com.mysql.jdbc.Driver");
		ConnectSQLDB("jdbc:mysql://localhost:3306/weborder","root","root","select * from create_order","com.mysql.jdbc.Driver","city","");
		
	}
}
