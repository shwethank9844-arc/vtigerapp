package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class allConnfirmationPage {
	//declaration
		@FindBy(xpath="//span[@class='lvtHeaderText']")
		private WebElement Confirm;
		
		//initialization
		
		public allConnfirmationPage (WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		//utilization
		public WebElement getOrgConfirm() {
			return Confirm;
		}
		
		//business logic
		public void ConfirmMsg(String exp) {
			String actual=Confirm.getText();
			
			Assert.assertTrue(actual.contains(exp), "confirmation message is not matching");
			System.out.println("confirmation message is matching");
			
//			if(actual.contains(exp)) {
//				System.out.println("organization created");
//			}
//			else {
//				System.out.println("organization not created");
//		       }
		}
			
	}

