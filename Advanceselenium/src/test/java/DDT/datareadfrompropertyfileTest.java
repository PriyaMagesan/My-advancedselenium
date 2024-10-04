package DDT;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class datareadfrompropertyfileTest {

	@Test
	public  void main() throws Throwable {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().minimize();
		// BASIC METHOD
		/*driver.get("https://www.saucedemo.com/v1/");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();*/
        
        //till basic method
        
        System.out.println("****************************************************************************************************");
        
        
        // data taken from the property file(using this approach)
        FileInputStream file = new FileInputStream("C:\\Users\\priya\\OneDrive\\Desktop\\Advanced Selenium\\selenium.properties.txt");
        
		Properties mn=new Properties();
		mn.load(file);
		String URL = mn.getProperty("url");
		String USERNAME = mn.getProperty("username");
		String PASSWORD=mn.getProperty("password");
		
		//read the url,username,password from the command prompt
		
		
		driver.get(URL);
		 driver.findElement(By.name("user-name")).sendKeys(USERNAME);
	    driver.findElement(By.id("password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("login-button")).click();
	    
	    System.out.println("login done and data taken from the property file");
	    
	    Thread.sleep(2000);
	    
	    driver.quit();
		
		
		
	}

}


