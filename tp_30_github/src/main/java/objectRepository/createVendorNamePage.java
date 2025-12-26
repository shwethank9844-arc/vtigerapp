package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createVendorNamePage {
//declaration
	@FindBy(name="vendorname")
	private WebElement vendorName;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	//initialization
	public createVendorNamePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	
	
	//utilization
	public WebElement getVendorName() {
		return vendorName;
	}

	public WebElement getSave() {
		return save;
	}
	//business logic
	public void createVendorName(String vName) {
		vendorName.sendKeys(vName);
		save.click();
	}
}
