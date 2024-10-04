package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ReadingdatafromdatabaseTest {
	@Test
public static void main() throws SQLException {
        
		// step1:register/ load the driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//step2: get the connection of database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancedselenium","root","Priya@123");
		
		//
		Statement statement = connection.createStatement();
		
		String query = "select * from selenium";
		
		ResultSet result = statement.executeQuery(query);
		
		
		// next() it means verify whether the data is 
		while(result.next())
		{
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getString(4));
		}
		connection.close();
		
	}

}
