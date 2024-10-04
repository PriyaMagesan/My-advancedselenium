package Assignment;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Genericutilities.Excel_Utilities;
import Genericutilities.Java_utilities;

public class ContactandwindowhandlingTest {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		FileInputStream finput = new FileInputStream(
				"C:\\Users\\priya\\OneDrive\\Desktop\\Advanced Selenium\\logindata4vtiger.properties.txt");
		Properties data = new Properties();
		data.load(finput);

		String Url = data.getProperty("URL");
		String username = data.getProperty("Username");
		String password = data.getProperty("Password");

		driver.get(Url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		// here javautils for creating a random number
		Java_utilities javauti = new Java_utilities();
		Excel_Utilities exceluti = new Excel_Utilities();
		int randumnum = javauti.getJavadata();

		// here using excel utils for creating a org name
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Thread.sleep(2000);
		String forcontactorgname = exceluti.getorganizationname("Organization", 0, 1) + randumnum;
		System.out.println(forcontactorgname);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(forcontactorgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);

		// creating contacts

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// using utilities for contacts last name
		String contactlastname = exceluti.contactlastname("Contacts", 0, 1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contactlastname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click(); // plus symbol click

		String mainwindow = driver.getWindowHandle();
		System.out.println(mainwindow);

		Set<String> windowHandles = driver.getWindowHandles();

		for (String windows : windowHandles) {

			if (!mainwindow.equals(windows)) // !mainwwindow=windows and !mainwindow=mainwindow
			{
				driver.switchTo().window(windows);
				driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(forcontactorgname);
				driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
				driver.findElement(By.xpath("//a[text()='"+forcontactorgname+"']")).click();
				driver.switchTo().window(mainwindow);
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Select'])[2]")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();

		for (String windows : windowHandles1) {

			if (!mainwindow.equals(windows)) // !mainwwindow=windows and !mainwindow=mainwindow
			{
				driver.switchTo().window(windows);
				driver.findElement(By.xpath("//a[text()=' priya']")).click();
				driver.switchTo().window(mainwindow);
			}
		}
		
		driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		
		
		Thread.sleep(8000);
		driver.quit();


	}

}
