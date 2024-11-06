package Organization;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import Generic_utilities.*;

@Listeners(Generic_utilities.extentreport.class)
public class CreateorganizationTest {
	
    public static WebDriver Sdriver;
	
@Test
public  void orgcreation() throws Throwable {
		
		Webdriver_Utilities webutils=new Webdriver_Utilities();
		File_Utilities fileutils=new File_Utilities();
		//Excel_Utilities exutils=new Excel_Utilities();
		Java_utilities fu=new Java_utilities();
	
		String BROWSER=fileutils.getKeyAndValueData("browser");
		System.out.println(BROWSER);
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("CHROME"))
		 {
			 driver=new ChromeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("fireFox"))
		 {
			//  driver=new GeckoDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("edge"))
		 {
			  driver=new EdgeDriver();
		 }
		 else 
			 
		 {
			  driver=new ChromeDriver();
		 }
		
		Sdriver=driver;
		
		//here we using Webdriver_utilities
		//Webdriver_utilities webutils=new Webdriver_utilities();
		webutils.MaximizeWindow(driver);
		webutils.implicitwait(driver);
		 
		//webutils.logintoapplication();
		
		//File_utilities fileutils=new File_utilities();
		String url = fileutils.getKeyAndValueData("URL");
		String username = fileutils.getKeyAndValueData("Username");
		String password = fileutils.getKeyAndValueData("Password");
	
		
		
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		 
		//here, we using java utilities
		//Java_utilities fu=new Java_utilities();
		int randNum = fu.getJavadata();
	
		
		//Here, we using excel utilities
		
		Excel_Utilities exutils=new Excel_Utilities();
		String orgname = exutils.getorganizationname("Organization",0,1)+randNum; //getting organization name
		
		//Here, we using excel utilities for the data formatter value 
		String  phnumber=exutils.getphonenum("Organization",1,1);
		
		//fetch the email id from excel sheet
		String emailid=exutils.getemailid("Organization",2,1);
		
		
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.id("phone")).sendKeys(phnumber);
		driver.findElement(By.id("email1")).sendKeys(emailid);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		System.out.println("New Organization created");
		
		
		
		//To logout from the application using WebDriver utilities
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		webutils.Actionsmethod(driver,signout);
	
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		element.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("user successfully loggedout");
		
		
		Thread.sleep(2000);
		driver.quit();	
	}

}

