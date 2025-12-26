package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //declaration
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	//Initialization
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	//utilization

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

    public WebElement getPasswordEdt() {
		return passwordEdt;
	}
    public WebElement getLoginbtn() {
		return loginbtn;
	}

	//business logic
		public void logintoHome(String USERNAME,String PASSWORD) {
			
			usernameEdt.sendKeys(USERNAME);
			passwordEdt.sendKeys(PASSWORD);
			loginbtn.click();
		}

	
	
}
