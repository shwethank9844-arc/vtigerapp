package testNG_Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.LoginPage;


public class login_DataProvider  {
	@Test(dataProvider = "storeData")
public void getData(String USERNAME,String PASSWORD) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://localhost:8888/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	LoginPage login = new LoginPage(driver);
	login.logintoHome(USERNAME, PASSWORD);
	
}
    
	
	@DataProvider
	public Object[][] storeData() {
		Object[][] obj = new Object[2][2];
		obj[0][0]="admin";
		obj[0][1]="admin";
		
		obj[1][0]="admin";
		obj[1][1]="password";
		
		return obj;
	}
	
	
}
