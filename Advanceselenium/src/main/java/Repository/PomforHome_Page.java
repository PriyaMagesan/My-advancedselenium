package Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomforHome_Page{
	public PomforHome_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement productlink;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreoption;

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
}
