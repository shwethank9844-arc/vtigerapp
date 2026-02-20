package basicscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class minimizeMaximize {
public static void main(String[] args) {
	WebDriver driver= new ChromeDriver();
	driver.get("hppts://www.fb.com");
	driver.manage().window().minimize();
	driver.manage().window().maximize();
	String Url=driver.getCurrentUrl();
	System.out.println(Url);
	driver.quit();
}
}
