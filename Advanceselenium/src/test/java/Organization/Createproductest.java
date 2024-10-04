package Organization;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Genericutilities.Excel_Utilities;

public class Createproductest {

	@Test
		public static void main() throws Throwable {

			WebDriver driver = new ChromeDriver();
		
			
			FileInputStream fin = new FileInputStream("C:\\Users\\priya\\OneDrive\\Desktop\\Advanced Selenium\\logindata4vtiger.properties.txt");
			Properties p = new Properties();
			p.load(fin);

			String URL = p.getProperty("URL");
			String UserName = p.getProperty("Username");
			String Password = p.getProperty("Password");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(URL);
			driver.manage().window().maximize();
			driver.findElement(By.name("user_name")).sendKeys(UserName);
			driver.findElement(By.name("user_password")).sendKeys(Password);
			driver.findElement(By.id("submitButton")).click();

			// create a product
			driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click(); //click product
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();//click plus symbol
			
			Excel_Utilities excelutils=new Excel_Utilities();
			String newproductname=excelutils.getproductname("Organization",3,1);
	         System.out.println(newproductname);
	         
			driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(newproductname);
			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

			// logout actions
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			element.click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

			Thread.sleep(2000);
			driver.quit();

		}

	}



