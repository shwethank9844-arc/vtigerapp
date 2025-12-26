package GEneric_Utils;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDRiverUtiles {
	
	 
	/**
	 * this is maximize window
	 * @author Supriya
	 * @param driver
	 */
     public void maximizeWindow(WebDriver driver ) 
    {
	driver.manage().window().maximize();
    }
    
     /**
      * this is implicitwait the window,	
      * @author Supriya
      * @param driver
      * @param seconds
      */
     public void waitForPageLoad(WebDriver driver,int seconds) {
    	
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
     }
    
     /**
      * this is explicit the window
      * @author Supriya
      * @param driver
      * @param seconds
      * @param element
      */
     public void waitUntilEleToBeVisible(WebDriver driver,int seconds,WebElement element) {
    	 
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    	wait.until(ExpectedConditions.visibilityOf(element));
    	 
     }
     //explicit wait elementtobe clickable method
     /**
      * this is  explicit wait method element tobe clickable 
      * @author Supriya
      * @param driver
      * @param seconds
      * @param element
      */
     public void waitUntilEleToBeclickable(WebDriver driver,int seconds,WebElement element) {
    	 
     	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
     	wait.until(ExpectedConditions.elementToBeClickable(element));
     	 
      }
     //select dropdown
     /**
      * @this is select dropdown
      * @author Supriya
      * @param element
      * @return
      */
     public Select dropdown(WebElement element) {
    	 Select sel = new Select(element);
    	 return sel;
     }
     
     /**
      * this is select selectbyvalue method
      * @author Supriya
      * @param element
      * @param value
      */
     public void dropdownUsingValue(WebElement element,String value) {
//    	 Select sel = new Select(element);
//    	 sel.selectByValue(value);
    	 dropdown(element).selectByValue(value);
     }
     /**
      * this is select selectbyvalue method
      * @author Supriya
      * @param element
      * @param index
      */
     public void dropdownUsingIndex(WebElement element,int index) {
//    	 Select sel = new Select(element);
//    	 sel.selectByIndex(index);
    	 dropdown(element).selectByIndex(index);
     }
     /**
      * this is select method visibletext
      * @author Supriya
      * @param element
      * @param text
      */
     public void dropdownUsingVisibletext(WebElement element,String text) {
//    	 Select sel = new Select(element);
//    	 sel.selectByVisibleText(text);
    	 dropdown(element).selectByVisibleText(text);
     }
     /**
      * this is select method ContainsVisibleText
      * @author Supriya
      * @param element
      * @param text
      */
     public void dropdownUsingContainsVisibleText(WebElement element,String text) {

    	 dropdown(element).selectByContainsVisibleText(text);
     }
     
     //actions method
     /**
      * THIS IS actions class
      * @author Supriya
      * @param driver
      * @return
      */
     public Actions actions(WebDriver driver) {
    	 Actions act=new Actions(driver);
    	 return act;
     }
     /**
      * this actions method mouseHover
      * @author Supriya
      * @param driver
      * @param element
      */
     public void mouseHover(WebDriver driver,WebElement element) {
    	 actions(driver).moveToElement(element).perform();
     }
     /**
      * 
      * @param driver
      * @param element
      */
     public void movetoElementclick(WebDriver driver,WebElement element ) {
     	actions(driver).moveToElement(element).click().perform();
     }
     /**
      * this is actions method mouseHoverAndClick
      * @author Supriya
      * @param driver
      * @param element
      */
     public void mouseHoverAndClick(WebDriver driver,WebElement element) {
    	 actions(driver).moveToElement(element).click(element).perform();
     }
     
     /**
      * this is actions method ClickAndHold
      * @author Supriya
      * @param driver
      * @param element
      */
     public void ClickAndHold(WebDriver driver,WebElement element) {
    	 actions(driver).clickAndHold(element).perform();
     }
     /**
      * this is actions method rightClickOnWebpage
      * @author Supriya
      * @param driver
      */
     public void rightClickOnWebpage(WebDriver driver) {
    	 actions(driver).contextClick().perform();
     }
     /**
      * this is actions method  rightClickOnEle
      * @author Supriya
      * @param driver
      * @param element
      */
     public void rightClickOnEle(WebDriver driver,WebElement element) {
    	 actions(driver).contextClick(element).perform();
     }
     /**
      *  this is actions method release 
      * @author Supriya
      * @param driver
      * @param element
      */
     public void release(WebDriver driver,WebElement element) {
    	 actions(driver).release(element).perform();
     }
     /**
      * this is actions method scrolToElement
      * @author Supriya
      * @param driver
      * @param element
      */
     public void scrolToElement(WebDriver driver,WebElement element) {
    	 actions(driver).scrollToElement(element).perform();
     }
     /**
      *  this is actions method scrolToAmount
      * @author Supriya
      * @param driver
      * @param x
      * @param y
      */
     public void scrolToAmount(WebDriver driver,int x,int y) {
    	 actions(driver).scrollByAmount(x, y).perform();
    	  }
     /**
      *  this is actions method doubleclick
      * @author Supriya
      * @param driver
      */
     public void doubleclick(WebDriver driver) {
    	 actions(driver).doubleClick().perform();
    	  }
     /**
      * this is actions method doubleclickOnElement
      * @author Supriya
      * @param driver
      * @param element
      */
     public void doubleclickOnElement(WebDriver driver,WebElement element) {
    	 actions(driver).doubleClick(element).perform();
    	  }
   
   
     
     //windowhandles
     /**
      * this is handlewindows
      * @author Supriya
      * @param driver
      * @param expTitle
      */
     public void handlewindows(WebDriver driver,String expTitle) {
    	 String parentId = driver.getWindowHandle();
    	 Set<String> windows = driver.getWindowHandles();
    	 Iterator<String> it = windows.iterator();
    	 
    	 while(it.hasNext()) {
    		 String currentWin = it.next();
    		
	String actualTitle = driver.switchTo().window(currentWin).getTitle();
    		
	if(actualTitle.contains(expTitle)) 
	{
		break;
	}
    		
   } 
 }
    
     public void  parentWindowId(WebDriver driver,String parentId) {
    	
    	 driver.switchTo().window(parentId);
     }
     /**
      * this is switchToParentWindow
      * @author Supriya
      * @param driver
      * @param parentId
      */
//  public void switchToParentWindow(WebDriver driver,String expTitle) 
//  {
//	  String parentId = driver.getWindowHandle();
// 	 Set<String> windows = driver.getWindowHandles();
// 	 Iterator<String> it = windows.iterator();
// 	 
// 	 while(it.hasNext()) {
// 		 String currentWin = it.next();
// 		
//	String actualTitle = driver.switchTo().window(currentWin).getTitle();
// 		
//	if(!(actualTitle.contains(expTitle))) 
//	{
//		break;
//	}
// 		
//} 
//}
	 
  
  
  //popup
  /**
   * this is alertPOpUp
   * @author Supriya
   * @param driver
   */
  public void alertPOpUp(WebDriver driver)
  {
	driver.switchTo().alert().accept();
  }
  /**
   * cancelPopUp
   * @author Supriya
   * @param driver
   */
  public void cancelPopUp(WebDriver driver)
  {
	 
	driver.switchTo().alert().dismiss();
  }
  /**
   * enterValuePopUp
   * @author Supriya
   * @param driver
   * @param value
   */
  public void enterValuePopUp(WebDriver driver,String value)
  {
	driver.switchTo().alert().sendKeys(value);
	
	
  }
  /**
   * getTextPopUp
   * @author Supriya
   * @param driver
   * @return
   */
  public String getTextPopUp(WebDriver driver)
  {
	 String text=driver.switchTo().alert().getText();
	return text;
  }
  //frames
  /**
   * childframes
   * @author Supriya
   * @param driver
   * @param index
   */
  public void childframes(WebDriver driver,int index) {
	 driver.switchTo().frame(index);
  }
  /**
   * this is frames using string name
   * @author Supriya
   * @param driver
   * @param name
   */
  public void childframes(WebDriver driver,String name) {
		 driver.switchTo().frame(name);
	  }
  /**
   * this is frames using webelement
   * @author Supriya
   * @param driver
   * @param element
   */
  public void childframes(WebDriver driver,WebElement element) {
		 driver.switchTo().frame(element);
	  }
  /**
   * this is parentframe
   * @author Supriya
   * @param driver
   */
  public void parentframes(WebDriver driver) {
		 driver.switchTo().parentFrame();
	  }
  /**
   * this is main frame
   * @author Supriya
   * @param driver
   */
  public void mainframes(WebDriver driver) {
		 driver.switchTo().defaultContent();
	  }
  //javascript executor methods
  /**
   * this is javascriptExecutor
   * @author Supriya
   * @param driver
   * @return
   */
  public JavascriptExecutor javascriptExecutor(WebDriver driver) 
  {
  JavascriptExecutor js=(JavascriptExecutor)driver;
  return js;
     
  }
  /**
   * this is clickOnElementUsing javascriptExecutor
   * @author Supriya
   * @param driver
   * @param element
   */
  public void clickOnElementUsingJSE(WebDriver driver,WebElement element)
  {
	  javascriptExecutor(driver).executeScript("arguments[0].click()", element);
  }
  /**
   * scrollHeight
   * @author Supriya
   * @param driver
   */
  public void scrollHeight(WebDriver driver)
  {
	  javascriptExecutor(driver).executeScript("window.scrollby(0,document.body.scrollHeight)");
  }
  /**
   * this is scrollUNtilVisibleUsing javascript executor
   * @author Supriya
   * @param driver
   * @param element
   */
  public void scrollUNtilVisibleUsingJSE(WebDriver driver,WebElement element)
  {
	  javascriptExecutor(driver).executeScript("arguments[0].scrollIntoView()",element);
  }
  //sendkey
  /**
   * this is enterTheValueIntoTextFieldUsing javascript executor
   * @author Supriya
   * @param driver
   * @param element
   * @param value
   */
  public void enterTheValueIntoTextFieldUsingJSE(WebDriver driver,WebElement element,String value)
  {
	  javascriptExecutor(driver).executeScript("arguments[0].value=arguments[1]", element,value);
  }
  /**
   *this is scrollToEleUsingXYCoOrdinate
   * @author Supriya
   * @param driver
   * @param element
   */
  public void scrollToEleUsingXYCoOrdinate(WebDriver driver,WebElement element)
  {
	  Point loc=element.getLocation();
	  int x = loc.getX();
	 int y = loc.getY();
	  javascriptExecutor(driver).executeScript("window.scrollBy("+x+","+y+")");
  }
  
//takescreenshot
  /**
   * this is takescreenshotmethods
   * @author Supriya
   * @param driver
   * @return
   */
  public TakesScreenshot takescreenshotmethods(WebDriver driver) {
	 TakesScreenshot ts = (TakesScreenshot)driver;
	  return ts;
  }
  /**
   * this is takescreenshotOfPage
   * @author Supriya
   * @param driver
   * @param path
 * @throws IOException 
   */
  public void takescreenshotOfPage(WebDriver driver,String path) throws IOException {
	 File file = takescreenshotmethods(driver).getScreenshotAs(OutputType.FILE);
	File F1 = new File(path);
	FileHandler.copy(file, F1);
	
  }
  /**
   * this is takescreenshotOfWebElement
   * @author Supriya
   * @param driver
   * @param path
 * @throws IOException 
   */
  public void takescreenshotOfWebElement(WebDriver driver,WebElement element ,String path) throws IOException {
		 File file = element.getScreenshotAs(OutputType.FILE);
		File F1 = new File(path);
		FileHandler.copy(file, F1);
		
	  }
}
