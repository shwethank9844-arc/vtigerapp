package Oraganization_module;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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
import org.openqa.selenium.support.ui.Select;

public class CreateOrgIndustry_PropertyCmm_Xlsx_Test {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
	
	WebDriver driver=null;
	Random ran=new Random();
	int random=ran.nextInt(500);
	
	String expOrg="testyantra"+random;
	
	//property
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
	       Sheet sh = wb.getSheet("Organizations");
	       
	       String orgName = sh.getRow(0).getCell(1).getStringCellValue()+random;
	       System.out.println(orgName);
	       String indDD=sh.getRow(1).getCell(1).getStringCellValue();
	       System.out.println(indDD);
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
	       
	driver.manage().window().maximize();
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	//organization
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.name("accountname")).sendKeys(expOrg);
	
	WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
	Select s=new Select(industry);
	s.selectByVisibleText("Healthcare");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
String actual=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	if(actual.contains(expOrg)) {
		System.out.println("matching");
	}
	
	else {
		System.out.println("not matching");
	}
	
	Actions act=new Actions(driver);
    //singnout
	act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	WebElement ele=driver.findElement(By.linkText("Sign Out"));
	
	act.moveToElement(ele).click().perform();
	
}
}
