package objectRepository;

import java.awt.print.PageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GEneric_Utils.WebDRiverUtiles;

public class homePage extends WebDRiverUtiles{
//declaration
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement home;
	@FindBy(linkText = "Calendar")
	private WebElement calendar;
	@FindBy(linkText = "Leads")
	private WebElement lead;
	@FindBy(linkText ="Organizations")
	private WebElement organizations;
	@FindBy(linkText = "Contacts")
	private WebElement contacts;
	@FindBy(linkText = "Opportunities")
	private WebElement opportunities;
	@FindBy(linkText = "Products")
	private WebElement products;
	@FindBy(linkText = "Documents")
	private WebElement documents;
	@FindBy(linkText = "Email")
	private WebElement email;
	@FindBy(linkText = "Trouble Tickets")
	private WebElement Tickets;
	@FindBy(linkText = "Dashboard")
	private WebElement dashboard;
	@FindBy(linkText = "More")
	private WebElement more;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstrator;
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	//initialization
	public homePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getHome() {
		return home;
	}

	public WebElement getCalendar() {
		return calendar;
	}

	public WebElement getLead() {
		return lead;
	}

	public WebElement getOrganizations() {
		return organizations;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getOpportunities() {
		return opportunities;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getDocuments() {
		return documents;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getTickets() {
		return Tickets;
	}

	public WebElement getDashboard() {
		return dashboard;
	}

	public WebElement getMore() {
		return more;
	}
	public WebElement getAdminstrator() {
		return adminstrator;
	}
	public WebElement getSignOut() {
		return signOut;
	}
	
	//bussiness logic
	public void clickHomeLink() {
		home.click();
		}
	public void clickCalendarLink() {
		calendar.click();
	}
	public void clickLeadLink() {
		lead.click();
		}
	public void clickOrganizationsLink() {
		organizations.click();
	}
	
	public void clickContactsLink() {
		contacts.click();
	}
	public void clickOpportunitiesLink() {
		opportunities.click();
	}
	public void clickProductsLink() {
		products.click();
		}
	public void clickDocumentsLink() {
		documents.click();
		}
	public void clickEmailLink() {
		email.click();
	}
	public void clickTicketsLink() {
		Tickets.click();
	}
	public void clickDashboardLink() {
		dashboard.click();
	}
	public void clickMoreLink() {
		more.click();
	}
	
	
	public void ClickSignOutbtn(WebDriver driver) {
		mouseHover(driver, adminstrator);
		mouseHoverAndClick(driver, signOut );
	}
	
	
}
