package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsLookup {
	 //declaration
		@FindBy(xpath="//img[@title='Create Lead...']")
		private WebElement Leadlookupbtn;
		
		
		//initialization
		public LeadsLookup(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		
		//utilization
		public WebElement getlook() {
			return Leadlookupbtn;
		}
		
		//business logic
		public void clickonLeadLookup() {
			Leadlookupbtn.click();
			
		}
}
