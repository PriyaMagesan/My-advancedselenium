package databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import org.testng.annotations.Test;
import com.mysql.jdbc.Driver;

public class database {
	@Test
	public void create() throws SQLException {
		
		// register/load the driver
		Driver driveref = new Driver();
		DriverManager.registerDriver(driveref);
		
		// establish connection to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/priya", "root", "joel27");
		
		//create statement
		Statement state = con.createStatement();
		Random ran= new Random();
		int nextInt = ran.nextInt(1000);
		
		String query="CREATE TABLE PARENT"+nextInt
				+ "    (CustomerID INT PRIMARY KEY,"
				+ "    CustomerName VARCHAR(50),"
				+ "    LastName VARCHAR(50),"
				+ "    Country VARCHAR(50),"
				+ "    Age INT CHECK (Age >= 0 AND Age <= 99),"
				+ "    Phone int(10)); ";
		
		int update = state.executeUpdate(query);
		System.out.println(update);
		
		con.close();
		
	}
	
	@Test
	public void insert() throws Throwable {
		// register/load the driver
				Driver driveref = new Driver();
				DriverManager.registerDriver(driveref);
				
				// establish connection to database
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "joel27");
				
				//create statement
				Statement state = con.createStatement();
				
				String query="SELECT * FROM SELENIUM";
				
				ResultSet result = state.executeQuery(query);
				 while(result.next())
				    {
				    	System.out.println(result.getInt(1)+"\t"+ result.getString(2)+"\t"+ result.getString(3)+"\t"+result.getString(4));
				    }
				
				con.close();
	}


}
