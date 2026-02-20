package basicscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tc_Launch_Quit {
public static void main(String[] args) throws InterruptedException{
	WebDriver driver=new ChromeDriver();
	Thread.sleep(2000);
	driver.quit();
}

}
