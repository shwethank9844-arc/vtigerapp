package Product_Module;

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
import objectRepository.LoginPage;
import objectRepository.allConnfirmationPage;
import objectRepository.createProductChildPage;
import objectRepository.homePage;
import objectRepository.productPage;

//@Listeners(GEneric_Utils.ListenerImplementedClass.class)
public class createproduct_utiles extends baseClass {

	@Test(groups="regression",retryAnalyzer = GEneric_Utils.retryAnalyzer.class)
	public void readProductDataProvider() throws IOException, InterruptedException {
//		WebDriver driver=null;
//		
//			
//			propetiesUtile pLib = new propetiesUtile();
//			excelUtiles eLib=new excelUtiles();
//			javaUtiles jLib=new javaUtiles();
//			WebDRiverUtiles wlib=new WebDRiverUtiles();
			
			String expVendor="pagar";
			String expProduct="laptop";
			
//			String BROWSER = pLib.readDataproprty("browser");
//			String URL = pLib.readDataproprty("url");
//			String USERNAME = pLib.readDataproprty("username");
//			String PASSWORD = pLib.readDataproprty("password");
//			
//			System.out.println(BROWSER);
//			 System.out.println(URL);
//			 System.out.println(USERNAME);
//			 System.out.println(PASSWORD);
//			 
			//excel

				 String vendName =eLib.readSingleDataFromEXcel("Products",0,1)+jLib.getRandomNo();
				 String prodName =eLib.readSingleDataFromEXcel("Products",1,1)+jLib.getRandomNo();
				      
//				       System.out.println(vendName);
//				       System.out.println(prodName);
			
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
//			//maximize window
//			wlib.maximizeWindow(driver);
//			
//			//enter url
//			driver.get(URL);
//			
//			//handle parent window
//		//	String parentId=driver.getWindowHandle();
//			
//			//wait for page load
//			wlib.waitForPageLoad(driver, 10);
//			
			//step1:login to application
//			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//			driver.findElement(By.id("submitButton")).click();
//			LoginPage login = new LoginPage(driver);
//			login.logintoHome(USERNAME, PASSWORD);
//			
			
	//step2:click on product link
//	driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
				 homePage hp = new homePage(driver);
					hp.clickProductsLink();
			
	  //step3:click on product lookup image
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			productPage p=new productPage(driver);
			p.clickonprodLookUpImg();
			
		//step4:enter the product name
//	driver.findElement(By.name("productname")).sendKeys(expProduct);
				createProductChildPage pro = new createProductChildPage(driver);
				pro.createProduct(prodName, expProduct);
				
			//step5:click on vendor lookup image
	//		driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
			   
			
			
			//child window
		//	wlib.handlewindows(driver, "Vendors&action");
			
			
			
			//step6:clcik on search button
	//	  driver.findElement(By.name("search_text")).click();
			
		  //step7:enter the vendor name
	//	  driver.findElement(By.name("search_text")).sendKeys(expVendor);
			
		  //step7:click on search now button
	//	  driver.findElement(By.xpath("//input[@type='button']")).click();
			
		  
		 // driver.findElement(By.xpath("//a[text()='pagar']")).click();
		  
		//parent window  
		//wlib.parentWindowId(driver, parentId);
		 
		  
		//  wlib.switchToParentWindow(driver, "Products&action");
		  
//		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//confirmation
//		  String actual = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
//		  if(actual.contains(expProduct)) {
//			  System.out.println("product is matching");
//		  }
//		  else {
//			  System.out.println("product not matching");
//		  }
				 //Thread.sleep(5000);
		// allConnfirmationPage confirm = new allConnfirmationPage(driver);
		//  confirm.ConfirmMsg(expProduct);
//
		//  Thread.sleep(5000);
		  //signup
//			wlib.mouseHover(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//			wlib.movetoElementclick(driver,driver.findElement(By.linkText("Sign Out")));
		 // Thread.sleep(3000);
		  
//			hp.ClickSignOutbtn(driver);
		  
			//driver.quit();
				
				 
		}
}
