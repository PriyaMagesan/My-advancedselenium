package Organization;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_utilities.*;
import Repository.pomforcreatecampaign;
import Repository.pomforloginpage;

public class CreatecampaignTest {
     @Test
	public  void main() throws Throwable {
			WebDriver driver = new ChromeDriver();

			FileInputStream fin = new FileInputStream("C:\\Users\\priya\\OneDrive\\Desktop\\Advanced Selenium\\logindata4vtiger.properties.txt");

			Properties p = new Properties();
			p.load(fin);

			String URL = p.getProperty("URL");
			String UserName = p.getProperty("Username");
			String Password = p.getProperty("Password");

			driver.get(URL);

			// getting a username and password
			pomforloginpage pom = new pomforloginpage(driver);
			Thread.sleep(2000);
			pom.logintoapplication(UserName, Password);

			// from the webdriver utilities getting a maximize and implicit waits
			Webdriver_Utilities webutils = new Webdriver_Utilities();
			webutils.implicitwait(driver);
			webutils.MaximizeWindow(driver);

			FileInputStream finput = new FileInputStream("C:\\Users\\\\priya\\\\OneDrive\\\\Desktop\\\\Advanced Selenium\\\\VtigerDatas.xlsx");
			Workbook book = WorkbookFactory.create(finput);
			
			
			//first create a product and then handling the window for product
			
			driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click(); //click product
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click(); //click plus symbol
			

			Excel_Utilities excelutils=new Excel_Utilities();
			String productname = excelutils.getproductname("Organization",3,1);
			System.out.println(productname);
			driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productname);
			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

			// go to more option
			WebElement movetomore = driver.findElement(By.xpath("//a[text()='More']"));
			webutils.Actionsmethod(driver, movetomore);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Campaigns']")).click();

			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			driver.findElement(By.xpath("//img[@alt='Select']")).click();

			// using excel utilities get a campaign name from the excel sheet
			String campaignname = excelutils.getcampaignname("Organization",4,1);
			System.out.println(campaignname);
			driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaignname);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//img[@style='cursor:hand;cursor:pointer']")).click(); //click the product plus symbol
			
			String mainwindow = driver.getWindowHandle();
	    	Set<String> windowHandles = driver.getWindowHandles();
	    	Iterator<String> iterator = windowHandles.iterator();
			while(iterator.hasNext())
			{ 
				String next = iterator.next();
				driver.switchTo().window(next);
				String currenttitle = driver.getTitle();
				if(currenttitle.contains("Products&action"))
				{
					break;
				}	
			}
			 Thread.sleep(2000);
			driver.findElement(By.id("search_txt")).sendKeys(productname); //pass a product
			driver.findElement(By.xpath("//input[@type='button']")).click(); //search now
		    Thread.sleep(2000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			try {
				driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
				
			}
			
			catch (Exception e) 
			{
				js.executeScript("window.scrollBy(0 ,1000)");
				
				driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
			}
			Thread.sleep(1000);
			//click a product
//			JavascriptExecutor js=(JavascriptExecutor)driver;
//			js.executeScript("arguments[0].scrollintoView()",scroll);
//			scroll.click();
			
			driver.switchTo().window(mainwindow);

			Thread.sleep(1000);
		
			//save
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			Thread.sleep(3000);

			
			
			// logout actions
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			element.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			Thread.sleep(2000);
			driver.quit();
			

		}
     
     

	

	}


