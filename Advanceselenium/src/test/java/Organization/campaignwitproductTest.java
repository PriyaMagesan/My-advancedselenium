package Organization;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_utilities.*;
import Repository.PomforHome_Page;
import Repository.pomforcreatecampaign;
import Repository.pomforcreateproduct;
import Repository.pomforloginpage;

public class campaignwitproductTest {

	@Test
	public  void main() throws Throwable  {
		
		WebDriver driver=new ChromeDriver();
		Webdriver_Utilities webutils=new Webdriver_Utilities();
		Excel_Utilities excel=new Excel_Utilities();
		File_Utilities file=new File_Utilities();
		webutils.MaximizeWindow(driver);
		webutils.implicitwait(driver);
		
		String url=file.getKeyAndValueData("URL");
		String Username=file.getKeyAndValueData("Username");
		String Password=file.getKeyAndValueData("Password");
		driver.get(url);
		pomforloginpage createcampaign=new pomforloginpage(driver);
		createcampaign.logintoapplication(Username, Password);
		
		//creating product
		pomforcreateproduct product=new pomforcreateproduct(driver);
		PomforHome_Page home=new PomforHome_Page(driver);
		home.clickproduct();
		product.clickplusicon();
		
		String newproductname=excel.getproductname("Organization",3,1);
        System.out.println("successfully got a product name");
        product.productnameTF(newproductname);
        product.clicksave();
		
		//go to more option and click campaign option
		WebElement element = driver.findElement(By.xpath("//a[text()='More']"));
		home.clickmoreoption();
		webutils.Actionsmethod(driver, element);
		
		pomforcreatecampaign campaign=new pomforcreatecampaign(driver);
		campaign.clickcampaignoption();
		campaign.clickcampaignplusicon();
		String campaignname = excel.getcampaignname("Organization",4,1);
		System.out.println("successfully got a campaign name");
		campaign.campaignTF(campaignname);
		campaign.productplusicon();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		Iterator<String> iterator = windowHandles.iterator();
		while(iterator.hasNext())
		{
			String next = iterator.next();
			//System.out.println(next);
			driver.switchTo().window(next);
			String currenttitle = driver.getTitle();
			if(currenttitle.contains("Products&action"))
			{
				break;
			}
		}
		
		product.clickproductplusicon(newproductname);
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+newproductname+"']")).click();
		
		//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("newproductname");
		//product.clickproductplusicon(newproductname);
		//driver.findElement(By.name("search")).click();
		
		
		
      Set<String> windowHandles1 = driver.getWindowHandles();
		
		Iterator<String> iterator1 = windowHandles1.iterator();
		while(iterator1.hasNext())
		{
			String next = iterator1.next();
			System.out.println(next);
			driver.switchTo().window(next);
			String currenttitle = driver.getTitle();
			if(currenttitle.contains("Campaigns&action"))
			{
				break;
			}
		}
		
		
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(3000);
		System.out.println("Successfully created a campaign with product");
		
		//logout
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		element1.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(2000);
		System.out.println("loggedout successfully");
		driver.quit();
		
		//logout
//		driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.cssSelector("[href='index.php?module=Users&action=Logout']")).click();
	}

}
