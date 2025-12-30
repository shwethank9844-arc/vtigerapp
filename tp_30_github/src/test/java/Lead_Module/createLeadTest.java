package Lead_Module;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class createLeadTest {

	public static void main(String[] args) {
		Random ran=new Random();
		int random = ran.nextInt(500);
		
		String expLead="team devid";
		String expCom="RCB";
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
