package Product_Module;

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

public class CreateProduct_propertiesXLXS_Test {
public static void main(String[] args) throws IOException {
		
	WebDriver driver=null;
		
		Random ran=new Random();
		int random = ran.nextInt(500);
		String expVendor="pagar"+random;
		String expProduct="laptop"+random;
		
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
			       Sheet sh = wb.getSheet("Products");
			       
			       String vendName = sh.getRow(0).getCell(1).getStringCellValue()+random;
			       String prodName = sh.getRow(1).getCell(1).getStringCellValue()+random;
			       System.out.println(vendName);
			       System.out.println(prodName);
		
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
		
		
		
		//product
		driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("productname")).sendKeys(expProduct);
		driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
		
	  String	 parentWinId=driver.getWindowHandle();
	  Set<String> allWinId = driver.getWindowHandles();
	  for(String win:allWinId) {
		  driver.switchTo().window(win);
		  String currentWinTitle = driver.getWindowHandle();
		  if(!(currentWinTitle.equals(parentWinId))) {
			  break;
		  }
	  }
	  driver.findElement(By.name("search_text")).click();
	  driver.findElement(By.name("search_text")).sendKeys(expVendor);
	  driver.findElement(By.xpath("//input[@type='button']")).click();
	  driver.findElement(By.xpath("//a[text()='pagar']")).click();
	  
	  driver.switchTo().window(parentWinId);
	  
	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	  String actual = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	  if(actual.contains(expProduct)) {
		  System.out.println("product is matching");
	  }
	  else {
		  System.out.println("product not matching");
	  }
	  
	  
	  Actions act=new Actions(driver);
	  //singnout
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		WebElement ele=driver.findElement(By.linkText("Sign Out"));
		
		act.moveToElement(ele).click().perform();
	}

}
