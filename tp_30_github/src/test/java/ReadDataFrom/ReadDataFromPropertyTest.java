package ReadDataFrom;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDataFromPropertyTest {

	public static void main(String[] args) throws IOException {
		
		//step1:create object for physical representation of file
				FileInputStream file = new FileInputStream(".\\src\\test\\resources\\commandata.properties");
			
				//step2:object for properties class
				Properties pObj = new Properties();
				
				//step3:load all the keys
				pObj.load(file);
				
				//step4:fetch the value using "getproperty"method
				 String BROWSER = pObj.getProperty("browser");//Browser holds only value
				 String URL=pObj.getProperty("url");
				 String USERNAME=pObj.getProperty("username");
				 String PASSWORD=pObj.getProperty("password");
				 
				 System.out.println(BROWSER);
				 System.out.println(URL);
				 System.out.println(USERNAME);
				 System.out.println(PASSWORD);
				 
				 WebDriver driver=null;
				 //launch the browser
				 if(BROWSER.equalsIgnoreCase("chrome"))
				 {
				   driver=new ChromeDriver();
					 
				 }
				 else if(BROWSER.equalsIgnoreCase("firefox")) 
				 {
					 driver=new FirefoxDriver();
				 }
				 else if(BROWSER.equalsIgnoreCase("edge"))
				 {
					 driver=new EdgeDriver();
				 }
				 
				 //maximize the window
				 driver.manage().window().maximize();
				 
				 
				 //enter the url
				driver.get(URL);
				
				 //enter valid username and password and click on login button
				 
				 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				 driver.findElement(By.id("submitButton")).click();

	}

}
