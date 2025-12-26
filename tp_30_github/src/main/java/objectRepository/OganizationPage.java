package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OganizationPage {
	
    //declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement orglookupbtn;
	
	
	//initialization
	public OganizationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	//utilization
	public WebElement getlook() {
		return orglookupbtn;
	}
	
	//business logic
	public void clickonOrgLookup() {
		orglookupbtn.click();
		
	}
}
