package Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomforcreateproduct {
public pomforcreateproduct(WebDriver driver) {
		
		PageFactory.initElements(driver, this);	
		
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement productclick;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusicon;
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productnameTF;
	
	@FindBy(xpath="//input[@title=\\\"Save [Alt+S]\\\"]")
	private WebElement savebutton;

	public WebElement getProductclick() {
		return productclick;
	}

	public WebElement getPlusicon() {
		return plusicon;
	}           

	public WebElement getProductnameTF() {
		return productnameTF;
	}

	
	
	public void createproduct(String prodname)
	{
		productclick.click();
	}
	
	public void plusicon()
	{
		plusicon.click();

	}
	
	public void productname(String prodname)
	{
		productnameTF.sendKeys(prodname);
	}
	
    
	
	
		

}


