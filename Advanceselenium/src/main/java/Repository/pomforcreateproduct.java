package Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomforcreateproduct {
	public pomforcreateproduct(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement productlink;

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusicon;

	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productnameTF;

	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement savebutton; 
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement plusiconforproduct;


	public WebElement getProductlink() {
		return productlink;
	}

	public WebElement getPlusicon() {
		return plusicon;
	}

	public WebElement getProductnameTF() {
		return productnameTF;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getPlusiconforproduct() {
		return plusiconforproduct;
	}
	
    public void clickproduct()
    {
    	productlink.click();
    }

     public void clickplusicon()
     {
    	 plusicon.click();
     }
     public void productnameTF(String productname)
     {
    	 productnameTF.sendKeys(productname);
     }
     
     public void clicksave()
     {
    	 savebutton.click();
     }
     
     public void clickproductplusicon(String productname)
     {
    	 plusiconforproduct.sendKeys(productname);
     }
     
     
}

