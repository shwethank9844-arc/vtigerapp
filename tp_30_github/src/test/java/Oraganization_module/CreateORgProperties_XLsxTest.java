package Oraganization_module;

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

public class CreateORgProperties_XLsxTest {
	public static void main(String[] args) throws IOException {
		
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
		//step2:click on ORGANIZTIONS link
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		
		//click on 'Create Oraganization ' lookup Image 
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Enter mandatory  fields with valid data
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(expOrg);
		//click on 'Save' button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//dont want to duplicate value
		//random is class we have set upper count create object for random cleass class contain multiple methods 
		//upper count 1-100 it will repeate 100 time same number
		
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
