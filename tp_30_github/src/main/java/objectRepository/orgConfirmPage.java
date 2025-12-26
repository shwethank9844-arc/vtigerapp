package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class orgConfirmPage {
//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgConfirm;
	
	//initialization
	
	public orgConfirmPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getOrgConfirm() {
		return orgConfirm;
	}
	
	//business logic
	public void orgConfirmMsg(String exp) {
		String actual=orgConfirm.getText();
		Assert.assertTrue(actual.contains(exp),"organization not created sucessfully");
		System.out.println("organization created sucessfully");
		
	}
		
}
