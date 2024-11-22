package Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomforHome_Page{
	
	public PomforHome_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
    public WebDriver driver;
	Actions act=new Actions(driver);
	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement productlink;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreoption;
	
	@FindBy(css="[src='themes/softed/images/user.PNG']")
	private WebElement movetosignout;
	
	@FindBy(css="[href='index.php?module=Users&action=Logout']")
	private WebElement signout;
	
	

	public WebElement getMoreoption() {
		return moreoption;
	}

	public WebElement getMovetosignout() {
		return movetosignout;
	}

	public WebElement getProductlink() {
		return productlink;
	}
	
	public WebElement getmoreoption() {
		return moreoption;
	}

	public void clickproduct() {
		productlink.click();
	}

	public void clickmoreoption() {
		moreoption.click();
	}
	
	public WebElement getSignout() {
		return signout;
	}

	public void logout()
	{
		act.moveToElement(moreoption).click();
		act.moveToElement(signout).click();
	}
	
}
