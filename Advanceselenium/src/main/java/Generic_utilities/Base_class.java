package Generic_utilities;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Base_class {
	
	 public static WebDriver Sdriver;

	 public WebDriver driver;
	 File_Utilities file=new File_Utilities();
	 
	 public void beforesuit()
	 {
		 
				System.out.println("DataBAse COnnection");
					
	}
	 public void beforeTest()
	 {
	 	System.out.println("Parallel Execution");
	 }
	 
	 public void beforeClass() throws Throwable
		{
		    
			String BROWSER = file.getKeyAndValueData("browser");
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				//WebDriver.chromedriver().setup();
				 driver=new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				//WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else if(BROWSER.equalsIgnoreCase("edge"))
			{
				//WebDriverManager.edgedriver().setup();
				 driver=new EdgeDriver();
			}
			else
			{
				 driver=new ChromeDriver();
			}
			
			Sdriver=driver;
		}

	 
	 
}
