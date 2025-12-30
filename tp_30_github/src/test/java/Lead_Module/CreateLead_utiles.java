package Lead_Module;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GEneric_Utils.WebDRiverUtiles;
import GEneric_Utils.baseClass;
import GEneric_Utils.excelUtiles;
import GEneric_Utils.javaUtiles;
import GEneric_Utils.propetiesUtile;
import objectRepository.Contactpage;
import objectRepository.LeadLookUpImage;
import objectRepository.LeadsLookup;
import objectRepository.createContactChildPage;
import objectRepository.homePage;
import objectRepository.orgConfirmPage;

//@Listeners(GEneric_Utils.ListenerImplementedClass.class)
public class CreateLead_utiles extends baseClass {
	@Test(groups="smoke",retryAnalyzer = GEneric_Utils.retryAnalyzer.class)
	public void readLeadsDataprovider() throws IOException, InterruptedException {
			
		
//		WebDriver driver=null;
//		
//		propetiesUtile pLib = new propetiesUtile();
//		excelUtiles eLib=new excelUtiles();
//		javaUtiles jLib=new javaUtiles();
//		WebDRiverUtiles wlib=new WebDRiverUtiles();
		
		
		String expLead="team devid";
		String expCom="RCB";
		//launch the browser
	//	WebDriver	driver=new ChromeDriver();
		
//		String BROWSER = pLib.readDataproprty("browser");
//		String URL = pLib.readDataproprty("url");
//		String USERNAME = pLib.readDataproprty("username");
//		String PASSWORD = pLib.readDataproprty("password");
		
		
//		System.out.println(BROWSER);
//		 System.out.println(URL);
//		 System.out.println(USERNAME);
//		 System.out.println(PASSWORD);
		 
		//excel
		
			       
			       String LeadName = eLib.readSingleDataFromEXcel("Leads",0,1)+jLib.getRandomNo();
			       String ComName = eLib.readSingleDataFromEXcel("Leads",1,1)+jLib.getRandomNo();
			       
			       
//			       System.out.println(LeadName);
//			       System.out.println(ComName);
		
//				   //launch the browser 
//			       if(BROWSER.equalsIgnoreCase("chrome"))
//			   	{
//			   		driver = new ChromeDriver();
//			   	}
//			   	else if (BROWSER.equalsIgnoreCase("edge"))
//			   	{
//			   		driver =new EdgeDriver();
//			   	}
//			   	else if (BROWSER.equalsIgnoreCase("firefox")) 
//			   	{
//			   		driver =new FirefoxDriver();
//			   	}	       
			       
		//maximize
	//		       wlib.maximizeWindow(driver);
		
		//enter the url
	//	driver.get("http://localhost:8888/");
//		driver.get(URL);
		
		//implicitwait
//		wlib.waitForPageLoad(driver, 10);
		
//		Login to Application
//	driver.findElement(By.name("user_name")).sendKeys("admin");
//	driver.findElement(By.name("user_password")).sendKeys("admin");
//	driver.findElement(By.id("submitButton")).click();
			     //LoginPage login = new LoginPage(driver);
			   	//login.logintoHome(USERNAME, PASSWORD);
	
	
//	Click on 'Leads' link
	
//	driver.findElement(By.xpath("//a[text()='Leads']")).click();
			       homePage hm = new homePage(driver);
			       hm.clickLeadLink();      
			       
	//click on create leads lookup 
	//	driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
			       
		
			   	LeadsLookup lead = new LeadsLookup(driver);
			    lead.clickonLeadLookup();
			    
			    
		//enter mandatory field
//		driver.findElement(By.name("lastname")).sendKeys(expLead);
//		driver.findElement(By.name("company")).sendKeys(expCom);
//		//save
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
			    LeadLookUpImage img = new LeadLookUpImage(driver);
			    img.createLeadsName(LeadName, ComName, expLead);
			    
			    
//		String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if(!(actual.equals(expLead)))
//		{
//			System.out.println("lastname matching");
//		}
//		else {
//			System.out.println("lastname not matching");
//		}
//		
//			    orgConfirmPage confirm = new orgConfirmPage(driver);
//			    confirm.orgConfirmMsg(expLead);  
			    
			    
//		Actions act=new Actions(driver);
//	     //singnout
//		wlib.mouseHover(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//		wlib.movetoElementclick(driver,driver.findElement(By.linkText("Sign Out")));

		
	//	driver.quit();
		//Assert.fail();
	}

}
