package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {
//declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement contlookImg;
	
	//initialization
	public Contactpage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getlookUP() {
		return contlookImg;
	}
	//business logic
	public void clickOnContactLookUpImg() {
		contlookImg.click();
		
	}
}
