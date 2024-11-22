package Organization;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import Generic_utilities.*;




public class CreateProductanddeleteTest extends Base_class{
   @Test
	public static void main() throws Throwable {

		WebDriver driver = new EdgeDriver();
		File_Utilities file = new File_Utilities();
		Webdriver_Utilities webutils=new Webdriver_Utilities();
		webutils.MaximizeWindow(driver);
		webutils.implicitwait(driver);
		
		String url = file.getKeyAndValueData("URL");
		String Username = file.getKeyAndValueData("Username");
		String password = file.getKeyAndValueData("Password");

		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		Excel_Utilities excel=new Excel_Utilities();
		String productname = excel.getproductname("Organization", 3, 1);
		System.out.println(productname);
		
		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		JavascriptExecutor scroll=(JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,5000)");
		
         WebElement element = driver.findElement(By.xpath("(//img[@src='themes/images/end.gif'])[2]")); //click next button to move the next page
//        Point location = element.getLocation();
//        System.out.println(location.getX());
//        System.out.println(location.getY());
//        
        Actions act=new Actions(driver);
        act.moveToElement(element, 1452, 840);
        element.click();

        Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+productname+"']/../preceding-sibling::td//input[@type='checkbox']"));
		element1.click();
		
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		//handling alter for accept 
		driver.switchTo().alert().accept();
		
		List<WebElement> allproductlist = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		int size = allproductlist.size();
		System.out.println(size);
		for (WebElement allproducts : allproductlist) {
			String allproductsname = allproducts.getText();
			
			
			if(productname.contains(allproductsname))
			{
				System.out.println("Product is deleted successfully");
			}
			else
			{
				System.out.println("product is not deleted");
			}
			
		}
//		//logout
//		Thread.sleep(3000);
//		WebElement element1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		element1.click();
//		Thread.sleep(500);
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//
//		Thread.sleep(2000);
//		driver.quit();

		
		
	}

}
