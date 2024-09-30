package DDT;

import java.io.FileOutputStream;
import java.util.Properties;

public class insertdatatopropertyfile {

	public static void main(String[] args) throws Throwable {
		
	       
		Properties p=new Properties();
		p.setProperty("url", "https://www.saucedemo.com/v1/");
		p.setProperty("username", "standard_user");
		p.setProperty("password", "secret_sauce");
		
		FileOutputStream fout=new FileOutputStream("C:\\Users\\priya\\OneDrive\\Desktop\\Advanced Selenium\\emptyfile to setdata.properties.txt");
		 p.store(fout,"INSERTED DATA");
		 
		 System.out.println("data inserted successfully");		
}
}
