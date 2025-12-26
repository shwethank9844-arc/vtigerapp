package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GEneric_Utils.WebDRiverUtiles;

public class OrgLookImagePage extends WebDRiverUtiles {
//declaration
	@FindBy(name="accountname")
	private WebElement orgName;
	@FindBy(name="industry")
	private WebElement industry;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	//initialization
	public OrgLookImagePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//utilization
	
	public WebElement getOrgName() {
		return orgName;
	}
	
	public WebElement getInDD() {
		return industry;
	}
	public WebElement getSave() {
		return save;
	}
	//basiness logic
	public void createOrgMand(String org) {
		orgName.sendKeys(org);
		
//		if(actual.contains(expOrg)) {
//			System.out.println("matching");
//		}
//		
//		else {
//			System.out.println("not matching");
//		}
		
		
		save.click();
	}
	//business logic
	public void createOrgName(String org,String induDD) {
		orgName.sendKeys(org);
		
	
		dropdownUsingContainsVisibleText(industry, induDD);
	
         save.click();
	}
}
