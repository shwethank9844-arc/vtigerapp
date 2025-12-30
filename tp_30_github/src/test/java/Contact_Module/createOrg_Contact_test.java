package Contact_Module;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

public class createOrg_Contact_test {
public static void main(String[] args) {
	
	WebDriver driver =new ChromeDriver();
	Random ran=new Random();
	int random = ran.nextInt(500);
	
	String expOrg="devasena"+random;
	String expContact="bhahubali"+random;
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
	
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(expOrg);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//driver.findElement(By.xpath("//a[@class=\"hdrLink\"]")).click();
	
	driver.findElement(RelativeLocator.with(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).toLeftOf(By.xpath("//a[@href='index.php?module=Accounts&action=index']"))).click();
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
