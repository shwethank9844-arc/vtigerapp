package Product_Module;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkbox_productTest {
public static void main(String[] args) {
	WebDriver driver =new ChromeDriver();
	Random ran=new Random();
	int random = ran.nextInt(500);
	String expVendor="zepto"+random;
	String expProduct="book"+random;
	//maximize window
	driver.manage().window().maximize();
	
	//enter url
	driver.get("http://localhost:8888");
	
	//wait for page load
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//step1:login to application
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.xpath("//a[text()='More']")).click();
	driver.findElement(By.xpath("//a[text()='Vendors']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.name("vendorname")).sendKeys(expVendor);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
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
 driver.findElement(By.xpath("//input[@name='search']")).click();
 driver.findElement(By.xpath("//a[text()='zepto113']")).click();
  
  
 driver.switchTo().window(parentWinId);
	
  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
  String actual=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
  
  if(!(actual.equals(expProduct))) {
	  System.out.println("expproduct selected");
	  
  }
  else {
	  System.out.println("expproduct not select");
  }
 
  
}

}


