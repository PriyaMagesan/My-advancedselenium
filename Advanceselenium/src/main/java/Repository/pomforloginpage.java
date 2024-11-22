package Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class pomforloginpage{
	
	 public pomforloginpage(WebDriver driver)
     {
    	 PageFactory.initElements(driver,this);
     }
 
	    @FindBy(xpath="//input[@name='user_name']")
		private WebElement usertextfield;
	

		@FindBy(xpath="//input[@name='user_password']")
		private WebElement passwordtextfield;
		
		@FindBy(id="submitButton")
		private WebElement submitbutton;
		
		public WebElement getUsertextfield() {
			return usertextfield;
		}

		public WebElement getPasswordtextfield() {
			return passwordtextfield;
		}

		public WebElement getSubmitbutton() {
			return submitbutton;
		}
		
	 public void logintoapplication(String username,String password)
		    {
		    	usertextfield.sendKeys(username);
		    	passwordtextfield.sendKeys(password);
		    	submitbutton.click();
		    }
	  
	 
}
