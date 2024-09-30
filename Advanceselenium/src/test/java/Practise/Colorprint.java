package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Colorprint {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     Actions act = new Actions(driver);
	     act.moveByOffset(10, 20).click().perform();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		String month = driver.findElement(By.xpath("//div[text()='September 2024']")).getText();
		System.out.println(month);
		

	}

}
