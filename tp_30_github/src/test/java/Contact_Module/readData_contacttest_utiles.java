package Contact_Module;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GEneric_Utils.WebDRiverUtiles;
import GEneric_Utils.baseClass;
import GEneric_Utils.excelUtiles;
import GEneric_Utils.javaUtiles;
import GEneric_Utils.propetiesUtile;
import objectRepository.Contactpage;
import objectRepository.LoginPage;
import objectRepository.allConnfirmationPage;
import objectRepository.createContactChildPage;
import objectRepository.homePage;
import objectRepository.orgConfirmPage;

//@Listeners(GEneric_Utils.ListenerImplementedClass.class)
public class readData_contacttest_utiles extends baseClass {

	@Test(groups="smoke",retryAnalyzer = GEneric_Utils.retryAnalyzer.class)
public void readContactDataprovider() throws IOException, InterruptedException {
		
//		WebDriver driver=null;
//		
//		 propetiesUtile pLib = new propetiesUtile();
//			excelUtiles eLib=new excelUtiles();
//			javaUtiles jLib=new javaUtiles();
//			WebDRiverUtiles wlib=new WebDRiverUtiles();
//			
			String EXPcontact = "sagar";
//			
//			
//			String BROWSER = pLib.readDataproprty("browser");
//			String URL = pLib.readDataproprty("url");
//			String USERNAME = pLib.readDataproprty("username");
//			String PASSWORD = pLib.readDataproprty("password");
//			
//			System.out.println(BROWSER);
//			 System.out.println(URL);
//			 System.out.println(USERNAME);
//			 System.out.println(PASSWORD);
			 
			//excel

				 String conName =eLib.readSingleDataFromEXcel("Contacts",0,1)+jLib.getRandomNo();
				 
	//		       System.out.println(conName);
			       
		
		   //launch the browser 
//	       if(BROWSER.equalsIgnoreCase("chrome"))
//	   	{
//	   		driver = new ChromeDriver();
//	   	}
//	   	else if (BROWSER.equalsIgnoreCase("edge"))
//	   	{
//	   		driver =new EdgeDriver();
//	   	}
//	   	else if (BROWSER.equalsIgnoreCase("firefox")) 
//	   	{
//	   		driver =new FirefoxDriver();
//	   	}
	
	//maximize
//	       wlib.maximizeWindow(driver);
	
	//enter the url
//	driver.get(URL);
	
	//implicitwait
//	wlib.waitForPageLoad(driver, 10);
	
	
//		Step1:Login to Application
//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
	//LoginPage login = new LoginPage(driver);
	//login.logintoHome(USERNAME, PASSWORD);
	
	
//		Step2:Click on 'Contacts' link
//	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	homePage hm = new homePage(driver);
	hm.clickContactsLink();
	
	//Step3:click on create contact lookup 
//	driver.findElement(By.xpath("//img[@title='Create Contact...']"))	.click();
	Contactpage cont = new Contactpage(driver);
    cont.clickOnContactLookUpImg();
    
	//Step4:enter mandatory field
//	driver.findElement(By.name("lastname")).sendKeys(EXPcontact);
    
    
	//Step5:save
//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    
    createContactChildPage c = new createContactChildPage(driver);
    c.createOnContact(conName, EXPcontact);
    
    
    //confirm meaasge
//	String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    
//    if(actual.equals(EXPcontact)) {
//		System.out.println("created contact sucessful");
//	}
//	else {
//		System.out.println("created contact unsucessful");
//	}
         
	//Assert.assertTrue(actual.equals(EXPcontact));
	
    //orgConfirmPage confirm = new orgConfirmPage(driver);
    //confirm.orgConfirmMsg(EXPcontact);

//	Thread.sleep(2000);
	
	//signout
//	wlib.mouseHover(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//	wlib.movetoElementclick(driver,driver.findElement(By.linkText("Sign Out")));
	
//	hm.ClickSignOutbtn(driver);
//	
//	driver.quit();

	}
}
