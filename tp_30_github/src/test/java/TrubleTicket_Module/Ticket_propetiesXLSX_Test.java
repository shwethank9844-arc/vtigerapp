package TrubleTicket_Module;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
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

public class Ticket_propetiesXLSX_Test {
	public static void main(String[] args) throws IOException {
		
		WebDriver driver=null;
		
		Random ran=new Random();
		int random = ran.nextInt(500);

		String expTitle="godsaveme";
		
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
			       Sheet sh = wb.getSheet("Trouble Tickets");
			       
			       String title = sh.getRow(0).getCell(1).getStringCellValue()+random;
			        System.out.println(title);
		
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
		
		driver.findElement(By.xpath("//a[@href='index.php?module=HelpDesk&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("ticket_title")).sendKeys(expTitle);
		driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
		
		List<WebElement> eles = driver.findElements(By.xpath("(//a[contains(text(),'godsaveme')])[1]"));
		
		for(WebElement win:eles) {
			System.out.println(win.getText());
			if(win.equals(expTitle)) {
				System.out.println("title is matching");
				break;
			}
			
			driver.findElement(By.xpath("//input[@name='selected_id']")).click();
			driver.findElement(By.xpath("//input[@name='selected_id']/../following-sibling::td[7]")).click();
			driver.findElement(By.xpath("//a[text()='del']")).click();
			
			//handle the popup
			 driver.switchTo().alert().accept();
			
			
		}
		Actions act=new Actions(driver);
	     //singnout
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		WebElement ele=driver.findElement(By.linkText("Sign Out"));
		
		act.moveToElement(ele).click().perform();
		
	}
}
