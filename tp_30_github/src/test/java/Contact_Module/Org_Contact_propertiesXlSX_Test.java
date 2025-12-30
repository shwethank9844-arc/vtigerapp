package Contact_Module;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.openqa.selenium.support.locators.RelativeLocator;

public class Org_Contact_propertiesXlSX_Test {
	public static void main(String[] args) throws IOException {
		
		WebDriver driver=null;
		
	Random ran=new Random();
	int random = ran.nextInt(500);
	
	String expOrg="devasena";
	String expContact="bhahubali";
	
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commandata.properties");
	Properties pOje = new Properties();
	pOje.load(fis);
	String BROWSER = pOje.getProperty("browser");
	String URL = pOje.getProperty("url");
	String USERNAME = pOje.getProperty("username");
	String PASSWORD = pOje.getProperty("password");
	
	System.out.println(BROWSER);
	 System.out.println(URL);
	 System.out.println(USERNAME);
	 System.out.println(PASSWORD);
	 
	//excel
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Test30_data.xlsx");
			Workbook wb = WorkbookFactory.create(fi);
		       Sheet sh = wb.getSheet("Contacts");
		       
		       String orgName = sh.getRow(1).getCell(1).getStringCellValue()+random;
		       String ContName = sh.getRow(2).getCell(1).getStringCellValue()+random;
		       System.out.println(orgName);
		       System.out.println(ContName);
		       

			   //launch the browser 
		       if(BROWSER.equalsIgnoreCase("chrome"))
		   	{
		   		driver = new ChromeDriver();
		   	}
		   	else if (BROWSER.equalsIgnoreCase("edge"))
		   	{
		   		driver =new EdgeDriver();
		   	}
		   	else if (BROWSER.equalsIgnoreCase("firefox")) 
		   	{
		   		driver =new FirefoxDriver();
		   	}
		
	//maximize window
		       driver.manage().window().maximize();
	
	//enter url
       	driver.get(URL);
	
	//wait for page load
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//step1:login to application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
//	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
//	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//	driver.findElement(By.name("accountname")).sendKeys(expOrg);
//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//	//driver.findElement(By.xpath("//a[@class=\"hdrLink\"]")).click();
	
	driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(expContact);
	
	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
	String parent = driver.getWindowHandle();
	 Set<String> allwinId = driver.getWindowHandles();
	 
	 for(String win:allwinId) {

		 driver.switchTo().window(win);
		 String currentTi=driver.getTitle();
		 
		 if(currentTi.equals(expOrg)) {
			 break;
		 }
		 
	 }
	driver.findElement(By.name("search_text")).click();
	driver.findElement(By.name("search_text")).sendKeys(expContact);
	driver.findElement(By.xpath("//input[@type='button']")).click();
	driver.findElement(By.xpath("//a[text()='devasena']")).click();
	
	driver.switchTo().window(parent);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	String actual=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	if(!(actual.equals(expContact))) {
		System.out.println("expected contact is matching");
	}
	else {
		System.out.println("expected contact is not matching");
	}
	
	Actions act=new Actions(driver);
    //singnout
	act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	WebElement ele=driver.findElement(By.linkText("Sign Out"));
	
	act.moveToElement(ele).click().perform();
	
	
}
}
