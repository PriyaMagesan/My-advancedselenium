package DDT;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Readdatafromjson {
	
public static void main(String[] args) throws IOException, InterruptedException {
		
		File file = new File("./src/test/resources/jsondata.json");
		
		ObjectMapper obj=new ObjectMapper();
		JsonNode tree = obj.readTree(file);
		
		String URL = tree.get("url").asText();
		String Username = tree.get("username").asText();
		String password = tree.get("password").asText();
       WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(Username);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		driver.quit();
		
		// json data with array
		
//		String asText = tree.get("support.text").asText();
//		System.out.println(asText);


	}

}
