package Practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ProkabadisTest {
         @Test
		public static void main() throws Throwable {
			String[] str=new String[6];
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.prokabaddi.com/");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,2000)");
			Thread.sleep(2000);
			System.out.printf("%-30S%10s%10s%10s%10s%15s%15s\n","Team","P","W","L","T","Score Diff","Pts");
					
			List<WebElement> country = driver.findElements(By.xpath("//p[@class='name']"));
		    for (WebElement allcountries : country) {
		    	String names = allcountries.getText();
		    	str[0] = driver.findElement(By.xpath("//p[text()='"+names+"']/../../../..//div[@class='table-data matches-play']")).getText();
		    	str[1] = driver.findElement(By.xpath("//p[text()='"+names+"']/../../../..//div[@class='table-data matches-won']")).getText();
		    	str[2]= driver.findElement(By.xpath("//p[text()='"+names+"']/../../../..//div[@class='table-data matches-lost']")).getText();
		    	str[3] = driver.findElement(By.xpath("//p[text()='"+names+"']/../../../..//div[@class='table-data matches-draw']")).getText();
		    	str[4] = driver.findElement(By.xpath("//p[text()='"+names+"']/../../../..//div[@class='table-data score-diff']")).getText();
		    	str[5]= driver.findElement(By.xpath("//p[text()='"+names+"']/../../../..//div[@class='table-data points']")).getText();
		        
		    	System.out.printf("%-30S%10s%10s%10s%10s%10s%10s\n",names,str[0],str[1],str[2],str[3],str[4],str[5]);
		    	
		    	

	}

}
}
