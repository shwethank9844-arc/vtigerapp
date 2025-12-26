package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GEneric_Utils.WebDRiverUtiles;

public class LeadLookUpImage  extends WebDRiverUtiles{
	//declaration
		@FindBy(xpath="//input[@name='lastname']")
		private WebElement lName;
		@FindBy(name="company")
		private WebElement comp;
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement save;
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement leadConfirm;
		
		//initialization
		public LeadLookUpImage(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		//utilization
		
		public WebElement getLName() {
			return lName;
		}
		
		public WebElement getComp() {
			return comp;
		}
		public WebElement getSave() {
			return save;
		}
		public WebElement getLConfirm() {
			return leadConfirm;
		}
		//basiness logic
		public void createLeadsName(String name,String cname,String exp) {
			lName.sendKeys(name);
			comp.sendKeys(cname);
			save.click();
			String actual=leadConfirm.getText();
			Assert.assertTrue(actual.contains(exp),"organization not created sucessfully");
			System.out.println("organization created sucessfully");
		}
		
}
