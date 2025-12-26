package Oraganization_module;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateIndustrywithFieldTest {
public static void main(String[] args) {
	
	//String exp="Ey";
	String exp="testyantra";
	Random ran = new Random();
	int random = ran.nextInt(500);
	//launch the browser
	WebDriver driver=new ChromeDriver();
	
	//maximize
	driver.manage().window().maximize();
	
	//enter the url
	driver.get("http://localhost:8888/");
	
	//need time
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//Click on 'ORGANIZATIONs' link
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	//click on 'Create Oraganization ' lookup Image 
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	
	//Click and Enter Name into 'Organization Name'text field .
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//enter the fields with valid data
	driver.findElement(By.name("accountname")).sendKeys("exp"+random);
	
	WebElement ele = driver.findElement(By.xpath("//select[@name='industry']"));
	Select sel=new Select(ele);
	 sel.selectByVisibleText("Healthcare");
	//click on 'Save' button
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String actual=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	if(actual.contains(exp)) {
		System.out.println("matching");
	}
	
	else {
		System.out.println("not matching");
	}
	
	Actions act=new Actions(driver);
    //singnout
	act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	WebElement sign=driver.findElement(By.linkText("Sign Out"));
	
	act.moveToElement(sign).click().perform();
	
}
}
