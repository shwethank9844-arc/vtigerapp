package GEneric_Utils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import com.beust.jcommander.Parameter;

import objectRepository.LoginPage;
import objectRepository.homePage;

public class baseClass {
	
	public  databaseUtiles db=new databaseUtiles();
	public  WebDRiverUtiles wLib=new WebDRiverUtiles();
	public  propetiesUtile pLib = new propetiesUtile();
	public  javaUtiles jLib=new javaUtiles();
	public  excelUtiles eLib=new excelUtiles();
		
	    public  WebDriver driver=null;
	//    public static WebDriver sdriver;
		
	    
	    public static ThreadLocal<WebDriver> wdriver=new ThreadLocal<WebDriver>();//DRIVERS
	     
   //  @BeforeSuite(groups={"smoke","regession"})
	    @BeforeSuite(alwaysRun = true)
     public void connectDB() throws SQLException {
    	 db.createDBRegister();
    	 System.out.println("---connected db----");
     }
	    
	    
    @Parameters("BROWSER")//NO WHERE NOT NOT MENTIONSING PARAMETER @OPTIONAL WILL WORK
     
    // @BeforeClass(groups={"smoke","regession"})
    @BeforeClass(alwaysRun = true)
     public void launchBrowser(@Optional("chrome")String BROWSER) throws IOException {         //String BROWSER
    //	 String BROWSER = pLib.readDataproprty("browser");                                    //@Optional("chrome")
    	 String URL = pLib.readDataproprty("url");
    	 
         if(BROWSER.equalsIgnoreCase("chrome"))
		   	{
		   		driver = new ChromeDriver();
		   	}
		   	else if (BROWSER.equalsIgnoreCase("firefox"))
		   	{
		   		driver =new FirefoxDriver();
		   	}
		   	else if (BROWSER.equalsIgnoreCase("edge")) 
		   	{
		   		driver =new EdgeDriver();
		   	}
         
         wdriver.set(driver);
      //   sdriver = driver;
         
       //maximize window
		 wLib.maximizeWindow(driver);
		
		//enter url
	       	driver.get(URL);
	       	
	        //wait for page load
	      	wLib.waitForPageLoad(driver, 10);
         System.out.println("----launch browser sucessfull----");
     }
     
    
    
    // @BeforeMethod(groups={"smoke","regession"})
    @BeforeMethod(alwaysRun = true)
     public void logintoApplication() throws IOException {
   	 String USERNAME = pLib.readDataproprty("username");
    	 String PASSWORD = pLib.readDataproprty("password");
    	 LoginPage login = new LoginPage(driver);
    	 login.logintoHome(USERNAME, PASSWORD);
    	 System.out.println("--login application ---");
     }
     
     
     
    // @AfterMethod(groups={"smoke","regession"})
    @AfterMethod(alwaysRun = true)
     public void logoutApplication() throws InterruptedException {
    	 homePage hm = new homePage(driver);
    	 Thread.sleep(2000);
    	 hm.ClickSignOutbtn(driver);
    	 System.out.println("---logout application---");
     }
     
     
    // @AfterClass(groups={"smoke","regession"})
    @AfterClass(alwaysRun = true)
     public void closeBrowser() {
    	 driver.quit();
    	 System.out.println("---close browser sucessfull---");
     }
    
    
    // @AfterSuite(groups={"smoke","regession"})
    @AfterSuite(alwaysRun = true)
     public void disconnectdb() throws SQLException {
   //  db.disconnectionDB();
     System.out.println("---disconnect db---");
   }
}
