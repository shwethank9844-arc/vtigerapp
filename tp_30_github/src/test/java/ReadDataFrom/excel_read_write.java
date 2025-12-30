package ReadDataFrom;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class excel_read_write {
public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.findElement(By.xpath("//div[@id='nav-fill-search']")).clear();
	
	
	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TP30.xlsx");
             Workbook wb = WorkbookFactory.create(fi);
	               Sheet sh = wb.createSheet("sheet3");
	                Row row = sh.createRow(0);
	                		 Cell cel = row.createCell(1);
	                		   cel.setCellValue("mobile");
	                		 
	Thread.sleep(3000);
	
	
	
	
	
	
}
}
