package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTrubleTicketPage {
//declaration
	@FindBy(name="ticket_title")
	private WebElement title;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;
	@FindBy(xpath="//a[@href='index.php?module=HelpDesk&action=index']")
	private WebElement link;
	@FindBy (xpath="//input[@name='selectall']")
	private WebElement seletticket;
//	@FindBy (xpath="//a[@title='Trouble Tickets']")
//	private List<WebElement> seletEle;
//	@FindBy (xpath="//input[@name='selected_id']")
//	private WebElement checkbox;
//	@FindBy (xpath="//input[@name='selected_id']/../following-sibling::td[7]")
//	private WebElement seletDelet;
	@FindBy(xpath="//input[@value='Delete']")
	private  WebElement delet;
	
	
	//initialization
	public CreateTrubleTicketPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
		}
	//utilization
	public WebElement getTitle() {
		return title;
	}
	public WebElement getSave() {
		return save;
	}

	public WebElement getLink() {
		return link;
	}
	
	public WebElement getSeletTicket() {
		return seletticket;
	}
	
	
//	public List<WebElement> getSeletEle() {
//		return seletEle;
//	}
//	
//	public WebElement getCheckbox() {
//		return checkbox;
//	}
//	
//	public WebElement getSeletDelet() {
//		return seletDelet;
//	}
	
	public WebElement getDelet() {
		return delet;
	}
	
	
	//business logic
	public void createTicketName(String Title) {
		title.sendKeys(Title);
		
		save.click();
	}
	public void createDEletTicket(String Title,WebDriver driver) {
       title.sendKeys(Title);
       save.click();
       link.click();
       
       seletticket.click();
			
				delet.click();
				
				driver.switchTo().alert().accept();
				
				
			}
//	public void createTicketCheckBox(String Title,WebDriver driver,String expTitle) {
//	       title.sendKeys(Title);
//	       save.click();
//	       link.click();
//	       
//	       
//	       for(WebElement win:seletEle) {
//				System.out.println(win.getText());
//				if(win.equals(expTitle)) {
//					System.out.println("title is matching");
//					break;
//				}
//				seletticket.click();
//				checkbox.click();
//				seletDelet.click();
//					delet.click();
//					
//					driver.switchTo().alert().accept();
//					
//					
//				}
//       
//	}
		
	}
	


