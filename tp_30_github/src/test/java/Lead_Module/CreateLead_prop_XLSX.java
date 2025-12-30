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

public class CreateLead_prop_XLSX {
	public static void main(String[] args) throws IOException {
		
		WebDriver driver=null;
		Random ran=new Random();
		int random = ran.nextInt(500);
		
		String expLead="team devid";
		String expCom="RCB";
		//launch the browser
	//	WebDriver	driver=new ChromeDriver();
		
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
			       Sheet sh = wb.getSheet("Leads");
			       
			       String LeadName = sh.getRow(0).getCell(1).getStringCellValue()+random;
			       String ComName = sh.getRow(1).getCell(1).getStringCellValue()+random;
			       System.out.println(LeadName);
			       System.out.println(ComName);
		
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
			       
		//maximize
		driver.manage().window().maximize();
		
		//enter the url
	//	driver.get("http://localhost:8888/");
		driver.get(URL);
		
		//implicitwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		Login to Application
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	
	
//	Click on 'Leads' link
	
	driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']")).click();
	//click on create leads lookup 
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		
		//enter mandatory field
		driver.findElement(By.name("lastname")).sendKeys(expLead);
		driver.findElement(By.name("company")).sendKeys(expCom);
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(!(actual.equals(expLead)))
		{
			System.out.println("lastname matching");
		}
		else {
			System.out.println("lastname not matching");
		}
		
		Actions act=new Actions(driver);
	     //singnout
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		WebElement ele=driver.findElement(By.linkText("Sign Out"));
		
		act.moveToElement(ele).click().perform();
		
		driver.quit();
	}

}
