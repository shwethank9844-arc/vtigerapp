package testNG_Practice;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class vtiger_hardAssert {
@Test
public void vtiger() {
	String exp="vtiger";
	  WebDriver driver=new ChromeDriver();
	  driver.get("http://localhost:8888/");
	  @Nullable
	String title = driver.getTitle();
	 // Assert.assertEquals(title.startsWith(exp),exp);
	  
	  System.out.println(title);
	  
}

}
