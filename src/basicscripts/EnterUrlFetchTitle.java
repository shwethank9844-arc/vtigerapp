package basicscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterUrlFetchTitle {
	public static void main(String[] args)throws InterruptedException {
		 WebDriver driver=new ChromeDriver();
		
	     driver.get("https://www.fb.com");
	     
	     String title=driver.getTitle();
	
	     System.out.println(title);
	
	     Thread.sleep(2000);
	
	     driver.quit();
	
	
	}


}
