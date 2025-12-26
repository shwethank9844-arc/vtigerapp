package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GEneric_Utils.WebDRiverUtiles;

public class createContactChildPage extends WebDRiverUtiles{
//declaration
	@FindBy(name="lastname")
	private WebElement lastName;
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement orgLookupImg;
	@FindBy(name="search_text")
	private WebElement searchText;
	@FindBy(name="search")
	private WebElement search;
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private List<WebElement> allOrg;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgConfirm;
	
	//initialization
	public createContactChildPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getorgLookup() {
		return orgLookupImg;
	}

	public WebElement getSearchText() {
		return searchText;
	}
	public WebElement getSearch() {
		return search;
	}
	
    public List<WebElement> getAllOrg() {
		return allOrg;
	}

	public WebElement getSave() {
		return save;
	}
	
	public WebElement getOrgConfirm() {
		return orgConfirm;
	}

	

	//business logic
	public void createOnContact(String contname,String exp) {
		lastName.sendKeys(contname);
		
		save.click();
		String actual=orgConfirm.getText();
		Assert.assertTrue(actual.contains(exp),"organization not created sucessfully");
		System.out.println("organization created sucessfully");
		
		
	}
	
	
	
	
	//business logic
	public void createonContactNameOrg(String contName,WebDriver driver,String text,String exp) {
		lastName.sendKeys(contName);
	    
		orgLookupImg.click();
		
		String parentId = driver.getWindowHandle();
		handlewindows(driver,"Accounts&action");
	
		searchText.sendKeys(text);
	
		search.click();
//		for(WebElement win:allOrg)
//		{
//			String actualOrg = win.getText();
//			if(actualOrg.equals(text)) {
//				win.click();
//				break;
//			}
//		}
	
		
		
		parentWindowId(driver, parentId); 
	
		save.click();
		String actual=orgConfirm.getText();
		Assert.assertTrue(actual.contains(exp),"organization not created sucessfully");
		System.out.println("organization created sucessfully");
	}

	
}
