package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createProductPage {
	//declaration
	@FindBy(name="productname")
	private WebElement productName;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	//initialization
	createProductPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getProductName() {
		return productName;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	//business logic
	
}
