package DDT;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReaddatafromjsoTest {
@Test
public static void main() throws IOException, InterruptedException {
		
		File file = new File("./src\\test\\resources\\json data.txt");
		
		ObjectMapper obj=new ObjectMapper();
		JsonNode tree = obj.readTree(file);
		WebDriver driver=new ChromeDriver();
		
		String URL = tree.get("url").asText();
		String Username = tree.get("username").asText();
		String password = tree.get("password").asText();
        
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(Username);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		driver.quit();
		
	// json data with array
		
//		String asText = tree.get("support.text").asText();
//		System.out.println(asText);


	}

}
