package Practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Traversing {
public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver=new ChromeDriver();
		driver.get("https://olympics.com/en/paris-2024/medals");
		driver.manage().window().maximize();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[text()='Yes, I am happy']")).click();
//		Thread.sleep(2000);
//		String gold = driver.findElement(By.xpath("//span[text()='Japan']/../..//span[@class='e1oix8v91 emotion-srm-81g9w1'][1]")).getText();
//		System.out.println(gold);
		
		
		
		//flipkart application using traversing concept
		//driver.findElement(By.xpath(""));
		
		
		driver.quit();

}
}
