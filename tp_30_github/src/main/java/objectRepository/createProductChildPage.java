package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GEneric_Utils.WebDRiverUtiles;

public class createProductChildPage extends WebDRiverUtiles {
//declaration
	@FindBy(name="productname")
	private WebElement productName;
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement vendorLookUpImg;
	@FindBy(name="search_text")
	private WebElement seachtext;
	@FindBy (name="search")
	private WebElement search;
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private List<WebElement> allvend;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement Confirm;
	
	//initialization
	 public createProductChildPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getVendorImage() {
		return vendorLookUpImg;
	}
	public WebElement getSeachText() {
		return seachtext;
	}

	public WebElement getSearch() {
		return search;
	}
	public List<WebElement> getAllvend() {
		return allvend;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getOrgConfirm() {
		return Confirm;
	}
	
	//business logic
	public void createProduct(String proName,String exp) {
		productName.sendKeys(proName);
		savebtn.click();
		String actual=Confirm.getText();
		
		Assert.assertTrue(actual.contains(exp), "confirmation message is not matching");
		System.out.println("confirmation message is matching");
	}
	
	
	
	//business logic
	public void createproductNameVendor(String pName,WebDriver driver,String text,String exp) {
		productName.sendKeys(pName);
	
		vendorLookUpImg.click();
		
		 String parent=driver.getWindowHandle();
		handlewindows(driver,"Vendors&action");
	
		seachtext.sendKeys(text);
	
		search.click();
		 for(WebElement win:allvend) {
		    String vendname = win.getText();
		    if(vendname.equals(text)) {
		    	win.click();
		    	break;
		    }
		     }
	 parentWindowId(driver, parent);
	savebtn.click();
		String actual=Confirm.getText();
		Assert.assertTrue(actual.contains(exp), "confirmation message is not matching");
		System.out.println("confirmation message is matching");
	}
	
}


	