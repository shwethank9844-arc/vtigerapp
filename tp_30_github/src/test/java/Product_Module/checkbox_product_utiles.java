package Product_Module;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GEneric_Utils.baseClass;
import objectRepository.allConnfirmationPage;
import objectRepository.createProductChildPage;
import objectRepository.createVendorNamePage;
import objectRepository.homePage;
import objectRepository.productPage;
import objectRepository.vendorClick;
import objectRepository.vendorPage;

//@Listeners(GEneric_Utils.ListenerImplementedClass.class)
public class checkbox_product_utiles extends baseClass{
	@Test(groups="smoke",retryAnalyzer = GEneric_Utils.retryAnalyzer.class)
	public void productheckboxDataProvider() throws IOException {
		
	
		//WebDriver driver=null;
//		Random ran=new Random();
//		int random = ran.nextInt(500);
//		String expVendor="zepto"+random;
//		String expProduct="book"+random;
		
//		 propetiesUtile pLib = new propetiesUtile();
//			excelUtiles eLib=new excelUtiles();
//			javaUtiles jLib=new javaUtiles();
//			WebDRiverUtiles wlib=new WebDRiverUtiles();
			
			String expVendor="zepto";
			String expProduct="book";
			
			
//			String BROWSER = pLib.readDataproprty("browser");
//			String URL = pLib.readDataproprty("url");
//			String USERNAME = pLib.readDataproprty("username");
//			String PASSWORD = pLib.readDataproprty("password");
		
//		System.out.println(BROWSER);
//		 System.out.println(URL);
//		 System.out.println(USERNAME);
//		 System.out.println(PASSWORD);
		 
		//excel

		 String vendName=eLib.readSingleDataFromEXcel("Products", 3, 1)+jLib.getRandomNo();
		 String prodName= eLib.readSingleDataFromEXcel("Products", 4, 1)+jLib.getRandomNo();
//			       System.out.println(vendName);
//			       System.out.println(prodName);
		
//		  //launch the browser 
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
		//maximize window
		
//		wlib.maximizeWindow(driver);
//		//enter url
//		driver.get(URL);
//		
//		String parentId = driver.getWindowHandle();
//		
//		//wait for page load
//		
//		wlib.waitForPageLoad(driver, 15);
		
		//step1:login to application
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		LoginPage lgn = new LoginPage(driver);
//		lgn.logintoHome(USERNAME, PASSWORD);
		
		//step2:click on more link
//		driver.findElement(By.xpath("//a[text()='More']")).click();
		homePage hm = new homePage(driver);
		hm.clickMoreLink();
		
		//step3:click on vendors link
//		driver.findElement(By.xpath("//a[text()='Vendors']")).click();
		vendorClick v = new vendorClick(driver);
		v.vendor();
		//step4:click on vendor lookup image
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		vendorPage vendor = new vendorPage(driver);
		vendor.clickVendorLookUpImage();
		
		//step4:enter the vendor name
//		driver.findElement(By.name("vendorname")).sendKeys(expVendor);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		createVendorNamePage vp = new createVendorNamePage(driver);
		vp.createVendorName(vendName);
		
		//step5:click on product link
	//	driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
		homePage hp = new homePage(driver);
		hp.clickProductsLink();
		
		//step6:click on product lookup image
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		productPage p=new productPage(driver);
		p.clickonprodLookUpImg();
		
		//step7:enter the product name
//		driver.findElement(By.name("productname")).sendKeys(expProduct);
//		driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
		
//		wlib.handlewindows(driver,"Vendors&action");
//		 
//	  driver.findElement(By.name("search_text")).click();
//	  driver.findElement(By.name("search_text")).sendKeys(expVendor);
//	 driver.findElement(By.xpath("//input[@name='search']")).click();
//	 driver.findElement(By.xpath("//a[text()='zepto113']")).click();
//	  
//	  
//	
//	
//		wlib.parentWindowId(driver, parentId);
//		
//	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//	  
	  createProductChildPage pro = new createProductChildPage(driver);
	  pro.createproductNameVendor(prodName, driver, vendName, expProduct);
	  
	  
	  //validate
// String actual=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
//	  
//	  if(!(actual.equals(expProduct))) {
//		  System.out.println("expproduct selected");
//		  
//	  }
//	  else {
//		  System.out.println("expproduct not select");
//	  }
	  
	  
	  
		// Thread.sleep(5000);
		 //allConnfirmationPage confirm = new allConnfirmationPage(driver);
		 // confirm.ConfirmMsg(expProduct);

		 

	  
	//  Thread.sleep(2000);
	  //sign out
//		wlib.mouseHover(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//		wlib.movetoElementclick(driver,driver.findElement(By.linkText("Sign Out")));
//		driver.quit();
	
//		hm.ClickSignOutbtn(driver);
//	  
//		driver.quit();
	  
	  
	  
	}
}
