package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class trubleTicketPage {
//declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement look;
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement delete;
	
	
	//intilization
	
	public trubleTicketPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getLook() {
		return look;
	}
	public WebElement getDelete() {
		return delete;
	}
	//business logic
	
	public void clickOnticketLoopup() {
		look.click();
	}
	public void clickondelete() {
		delete.click();
	}
}
