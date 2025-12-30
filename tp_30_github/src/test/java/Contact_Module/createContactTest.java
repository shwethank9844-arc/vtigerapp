package Contact_Module;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class createContactTest {

	public static void main(String[] args) {
		
		
		Random ran=new Random();
		int random = ran.nextInt(500);
		String contactName="sagar"+random;
		
		//launch the browser
	WebDriver	driver=new ChromeDriver();
	
	//maximize
	driver.manage().window().maximize();
	
	//enter the url
	driver.get("http://localhost:8888/");
	
	//implicitwait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	
//		Login to Application
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
//		Click on 'Contacts' link
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	
	//click on create contact lookup 
	driver.findElement(By.xpath("//img[@title='Create Contact...']"))	.click();
	
	//enter mandatory field
	driver.findElement(By.name("lastname")).sendKeys(contactName);
	
	//save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(!(actual.equals(contactName)))
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
	

	}

}
