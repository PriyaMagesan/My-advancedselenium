package Genericutilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utilities {
	
	public String getKeyAndValueData(String key) throws Throwable
	{
	 FileInputStream fis = new FileInputStream("./src/test/resources/logindata4vtiger.properties.txt");
	 Properties pro = new Properties();
	 pro.load(fis);
	 String value = pro.getProperty(key);
	 System.out.println(value);
	 return value;
	}

    
}


