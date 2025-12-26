package Oraganization_module;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GEneric_Utils.WebDRiverUtiles;
import GEneric_Utils.baseClass;
import GEneric_Utils.excelUtiles;
import GEneric_Utils.javaUtiles;
import GEneric_Utils.propetiesUtile;
import objectRepository.LoginPage;
import objectRepository.OganizationPage;
import objectRepository.OrgLookImagePage;
import objectRepository.homePage;
import objectRepository.orgConfirmPage;

//@Listeners(GEneric_Utils.ListenerImplementedClass.class)
public class readData_mandatory_proTest_utiles extends baseClass {
	
	@Test(groups="regression",retryAnalyzer = GEneric_Utils.retryAnalyzer.class)
public void readMandatoryDataprovider() throws IOException, InterruptedException {
	
		  
		//WebDriver driver=null;
		
//		propetiesUtile pLib = new propetiesUtile();
//		excelUtiles eLib=new excelUtiles();
//		javaUtiles jLib=new javaUtiles();
//		WebDRiverUtiles wlib=new WebDRiverUtiles();
		
		String expOrg="testyantra";
		
//		String BROWSER = pLib.readDataproprty("browser");
//		String URL = pLib.readDataproprty("url");
//		String USERNAME = pLib.readDataproprty("username");
//		String PASSWORD = pLib.readDataproprty("password");
		
		
     	String OrgName = eLib.readSingleDataFromEXcel("Organizations", 0, 1) + jLib.getRandomNo();
		
		
		
//		 if(BROWSER.equalsIgnoreCase("chrome"))
//		 {
//			 driver=new ChromeDriver();
//			 
//		 }
//		 else if(BROWSER.equalsIgnoreCase("edge"))
//		 {
//			 driver=new EdgeDriver();
//		 }
//		 else if(BROWSER.equalsIgnoreCase("firefox"))
//		 {driver=new FirefoxDriver();
//			 
//		 }
			
	//	      wlib.maximizeWindow(driver);
			
			//enter url
	//		driver.get(URL);
			
			
	//		wlib.waitForPageLoad(driver, 10);
			
			//step1:login to application
//			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//			driver.findElement(By.id("submitButton")).click();
			
//			LoginPage login = new LoginPage(driver);
//			login.logintoHome(USERNAME, PASSWORD);
			
			//step2:click on ORGANIZTIONS link
			//driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
			homePage hm = new homePage(driver);
			hm.clickOrganizationsLink();
			
			//click on 'Create Oraganization ' lookup Image 
			//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			OganizationPage org = new OganizationPage(driver);
			org.clickonOrgLookup();
			//Enter mandatory  fields with valid data
			//driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(expOrg);
			OrgLookImagePage name= new OrgLookImagePage(driver);
			name.createOrgMand(OrgName);
			
			//click on 'Save' button
			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
      //validate
//			String actual=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//			
//			if(actual.contains(expOrg)) {
//				System.out.println("matching");
//			}
//			
//			else {
//				System.out.println("not matching");
//			}
		  //orgConfirmPage msg = new orgConfirmPage(driver);
			//msg.orgConfirmMsg(expOrg);
			
			//Thread.sleep(2000);
			//signout
//			wlib.mouseHover(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//			wlib.movetoElementclick(driver,driver.findElement(By.linkText("Sign Out")));
//			hm.clickAdminstratorLink();
//			hm.ClickSignOutbtn(driver);
//			driver.quit();
		}
	@Test
	
	public void impact() {
		System.out.println("---------region area--------");
	}
}
