package TrubleTicket_Module;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GEneric_Utils.baseClass;
import objectRepository.CreateTrubleTicketPage;
import objectRepository.homePage;
import objectRepository.trubleTicketPage;

//@Listeners(GEneric_Utils.ListenerImplementedClass.class)
public class readData_tickettest_utiles extends baseClass{
	 @Test(groups="regression",retryAnalyzer = GEneric_Utils.retryAnalyzer.class)
		public void ticketDeletDataProvider() throws IOException, InterruptedException {
			
		
		
//			WebDriver driver=null;
//			
//			 propetiesUtile pLib = new propetiesUtile();
//				excelUtiles eLib=new excelUtiles();
//				javaUtiles jLib=new javaUtiles();
//				WebDRiverUtiles wlib=new WebDRiverUtiles();
				
				String expTitle="godsaveme";
				
				
//				String BROWSER = pLib.readDataproprty("browser");
//				String URL = pLib.readDataproprty("url");
//				String USERNAME = pLib.readDataproprty("username");
//				String PASSWORD = pLib.readDataproprty("password");
//				
//				System.out.println(BROWSER);
//				 System.out.println(URL);
//				 System.out.println(USERNAME);
//				 System.out.println(PASSWORD);
				 
				//excel

					 String troble =eLib.readSingleDataFromEXcel("Trouble Tickets",0,1)+jLib.getRandomNo();
					 
				   //    System.out.println(title);
			
			  //launch the browser 
//		       if(BROWSER.equalsIgnoreCase("chrome"))
//		   	{
//		   		driver = new ChromeDriver();
//		   	}
//		   	else if (BROWSER.equalsIgnoreCase("edge"))
//		   	{
//		   		driver =new EdgeDriver();
//		   	}
//		   	else if (BROWSER.equalsIgnoreCase("firefox")) 
//		   	{
//		   		driver =new FirefoxDriver();
//		   	}
			//maximize window
//			wlib.maximizeWindow(driver);
//			
//			//enter url
//			driver.get(URL);
//			
//			//wait for page load
//			wlib.waitForPageLoad(driver, 10);
			
			//step1:login to application
//			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//			driver.findElement(By.id("submitButton")).click();
//			LoginPage login = new LoginPage(driver);
//	     	login.logintoHome(USERNAME, PASSWORD);
			
//			driver.findElement(By.xpath("//a[@href='index.php?module=HelpDesk&action=index']")).click();
			homePage hm = new homePage(driver);
			hm.clickTicketsLink();
			
			
		//	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			              trubleTicketPage tickect = new trubleTicketPage(driver);
			              tickect.clickOnticketLoopup();
			              
			              
//			driver.findElement(By.name("ticket_title")).sendKeys(expTitle);
//			  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")) .click();           
//			driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
			              
			
//			List<WebElement> eles = driver.findElements(By.xpath("//a[@title='Trouble Tickets']"));
//			
//			for(WebElement win:eles) {
//				System.out.println(win.getText());
//				if(win.equals(expTitle)) {
//					System.out.println("title is matching");
//					break;
//				}
//				
//				driver.findElement(By.xpath("//input[@name='selected_id']")).click();
//				driver.findElement(By.xpath("//input[@name='selected_id']/../following-sibling::td[7]")).click();
//				driver.findElement(By.xpath("//a[text()='del']")).click();
//				
//	             
//				
//				//handle the popup
//				// driver.switchTo().alert().accept();
//				  
//				wlib.alertPOpUp(driver);
			              
			              CreateTrubleTicketPage trob = new CreateTrubleTicketPage(driver);
				        trob.createDEletTicket(expTitle, driver);
				        
				// Thread.sleep(3000);
//					wlib.mouseHover(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//					wlib.movetoElementclick(driver,driver.findElement(By.linkText("Sign Out")));
//					driver.quit();
//				 hm.ClickSignOutbtn(driver);
//				 driver.quit();
				        
				         
			}
			
			
}
