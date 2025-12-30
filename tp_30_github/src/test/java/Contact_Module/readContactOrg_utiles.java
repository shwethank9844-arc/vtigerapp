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
import objectRepository.createContactChildPage;
import objectRepository.homePage;
import objectRepository.orgConfirmPage;

//@Listeners(GEneric_Utils.ListenerImplementedClass.class)
public class readContactOrg_utiles extends baseClass{
	  @Test(groups="regression",retryAnalyzer = GEneric_Utils.retryAnalyzer.class)
		public void readContactWithOrganizationDataProvider() throws IOException, InterruptedException {
			
			
			//WebDriver driver=null;
			String expOrg="devasena";
			String expContact="bhahubali";
			
//		propetiesUtile pLib = new propetiesUtile();
//		excelUtiles eLib=new excelUtiles();
//		javaUtiles jLib=new javaUtiles();
//		WebDRiverUtiles wlib=new WebDRiverUtiles();
		
//	    String BROWSER = pLib.readDataproprty("browser");
//		String URL = pLib.readDataproprty("url");
//		String USERNAME = pLib.readDataproprty("username");
//		String PASSWORD = pLib.readDataproprty("password");
		
//		System.out.println(BROWSER);
//		 System.out.println(URL);
//		 System.out.println(USERNAME);
//		 System.out.println(PASSWORD);
		 
		//excel

	     String orgName=eLib.readSingleDataFromEXcel("Contacts", 1, 1)+jLib.getRandomNo();
		 String ContName= eLib.readSingleDataFromEXcel("Contacts", 2, 1)+jLib.getRandomNo();
//			       System.out.println(orgName);
//			       System.out.println(ContName);
			       

				   //launch the browser 
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
			
		//maximize window
//		 wlib.maximizeWindow(driver);
		
		//enter url
//	       	driver.get(URL);
	       	//handle parent window
	       //	String parentId = driver.getWindowHandle();
		
	         //wait for page load
//	      	wlib.waitForPageLoad(driver, 10);
		
		//step1:login to application
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//	       	LoginPage login = new LoginPage(driver);
//			login.logintoHome(USERNAME, PASSWORD);
		
		
//		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		driver.findElement(By.name("accountname")).sendKeys(expOrg);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		//driver.findElement(By.xpath("//a[@class=\"hdrLink\"]")).click();
		
			//step2:click on contact link
//		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		homePage hm = new homePage(driver);
		hm.clickContactsLink();
		
		//step3:click contact lookup image
//		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		    Contactpage cont = new Contactpage(driver);
		         cont.clickOnContactLookUpImg();
		         
		//step4:enter lastename
//		driver.findElement(By.name("lastname")).sendKeys(ContName);
		       createContactChildPage c = new createContactChildPage(driver);
		      
		       c.createonContactNameOrg(ContName, driver, ContName, expContact);
		//step5:click on oraganization lookup image
//		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		       
	     
		       //windowhandle
		//wlib.handlewindows(driver, "devasena");
		
		//step 5:search the name
//		driver.findElement(By.name("search_text")).click();
//		driver.findElement(By.name("search_text")).sendKeys(ContName);
		//driver.findElement(By.xpath("//input[@type='button']")).click();
		
		
		
	     //handle the pAarent window
		
		//wlib.parentWindowId(driver, parentId);
		
	     //step:6 click on save button
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//validate
//		String actual=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	//	
//		if(!(actual.equals(ContName))) {
//			System.out.println("expected contact is matching");
//		}
//		else {
//			System.out.println("expected contact is not matching");
//		}
		       //orgConfirmPage confirm = new orgConfirmPage(driver);
	           //confirm.orgConfirmMsg(expContact);
	       
	//	 Thread.sleep(2000);
		 //sign out
//			wlib.mouseHover(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//			wlib.movetoElementclick(driver,driver.findElement(By.linkText("Sign Out")));
//		    hm.clickAdminstratorLink();
//			hm.ClickSignOutbtn(driver);
//			driver.quit();
		
		       
		 
	}

}
