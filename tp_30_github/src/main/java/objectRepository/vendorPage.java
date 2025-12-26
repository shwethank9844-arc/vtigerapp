package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vendorPage {
//declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement look;
	
	//initialization
	public vendorPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getLook() {
		return look;
	}
	//business logic
	public void clickVendorLookUpImage() {
		look.click();
	}
	
}
