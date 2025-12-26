package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vendorClick {
@FindBy(xpath="//a[text()='Vendors']")
private WebElement vendor;

//initialization
public vendorClick(WebDriver driver) {
	PageFactory.initElements(driver, this);

}
//initilization 
public WebElement getVendor() {
	return vendor;
}

public void vendor() {
	vendor.click();
}



}
