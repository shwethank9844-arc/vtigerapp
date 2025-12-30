package TrubleTicket_Module;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreateTicket_Checkbox_Test {
public static void main(String[] args) {
	
//	ChromeOptions co = new ChromeOptions();
//	co.addArguments("--disable-notifications");
	WebDriver driver =new ChromeDriver();
	Random ran=new Random();
	int random = ran.nextInt(500);

	String expTitle="godsaveme"+random;
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
