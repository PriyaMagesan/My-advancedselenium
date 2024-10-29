package Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomforcreatecampaignTest {
	
	 WebDriver driver;

		public pomforcreatecampaignTest(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		
		
		@FindBy(linkText = "Campaigns")
		private WebElement campaignoption;
		
		@FindBy(xpath="//input[@name='campaignname']")
		private WebElement campaignTF;
		
		@FindBy(xpath="//img[@title='Select']")
		private WebElement productplusicon;
		
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement campaignplusicon;
		
		
		public WebElement getProductplusicon() {
			return productplusicon;
		}

		public WebDriver getDriver() {
			return driver;
		}
		
		public WebElement getCampaignoption() {
			return campaignoption;
		}
		
		public WebElement getCampaignTF() {
			return campaignTF;
		}
		
		public WebElement getCampaignplusicon() {
			return campaignplusicon;
		}

		
	    public void clickcampaignoption()
	    {
	    	campaignoption.click();
	    }
	    
	    public void campaignTF(String campaignname)
	    {
	    	campaignTF.sendKeys(campaignname);
	    }
	    
	    public void productplusicon()
	    {
	    	productplusicon.click();
	    }
	    

		public void clickcampaignplusicon() {
			campaignplusicon.click();
			
		}

}
