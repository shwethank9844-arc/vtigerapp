package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productPage {
//declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement productlookimg;
	
	//initialization
	public productPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getLook() {
		return productlookimg;
	}
	//business logic
	public void clickonprodLookUpImg() {
		productlookimg.click();
	}
}
