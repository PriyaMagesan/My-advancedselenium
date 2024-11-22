package Generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Repository.PomforHome_Page;
import Repository.pomforloginpage;

@Test
public class Base_class {

	static ThreadLocal<WebDriver> thread = new ThreadLocal<>();

	protected static WebDriver driver;
	File_Utilities file = new File_Utilities();
	Webdriver_Utilities webutils = new Webdriver_Utilities();
	PomforHome_Page home = new PomforHome_Page(driver);

	@BeforeSuite
	public void beforesuit() {

		System.out.println("DataBAse COnnection");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Parallel Execution");
	}

	@BeforeClass
	public void beforeClass() throws Throwable {

		String BROWSER = file.getKeyAndValueData("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		thread.set(driver);

	}

	@BeforeMethod
	public void beforemethod() throws Throwable {

		String url = file.getKeyAndValueData("URL");
		String UserName = file.getKeyAndValueData("Username");
		String Password = file.getKeyAndValueData("Password");
		driver.get(url);
		webutils.implicitwait(driver);
		webutils.MaximizeWindow(driver);

		pomforloginpage login = new pomforloginpage(driver);
		login.logintoapplication(UserName, Password);

	}

	@AfterMethod
	public void afterMethod() {
	
		home.logout();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@AfterTest
	public void aftertest()
	{
		System.out.println("Parallel Execution");

	}
	
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("connection closed");
	}

}
