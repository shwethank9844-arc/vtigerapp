package testNG_Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GEneric_Utils.IPathConstants;
import GEneric_Utils.excelUtiles;

public class storeSetOfDate {
	
	@Test(dataProvider = "stre_products")
//	public void getData(String username,String password) {
//		System.out.println(username+"---->"+password);
//	}
//	public void getData(String pName,int price) {
//		System.out.println(pName+"---->"+price);
//	}
	
	
    @DataProvider(name="credencial")
	public Object[][] storeData() {
	Object[][]	obj=new Object[2][2];
	obj[0][0]="admin";
	obj[0][1]="admin";
	
	obj[1][0]="admin";
	obj[1][1]="password";
	return obj;
		
    }
	@DataProvider(name="stre_products")
	public Object[][] products() {
		Object[][]	obj=new Object[2][2];
		obj[0][0]="mobile";
		obj[0][1]=10000;
		
		obj[1][0]="laptop";
		obj[1][1]=50000;
		return obj;
	}
	
	@DataProvider
	public Object[][] excelData() throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Test30_data.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("DataProvider");
		int rowCount = sh.getLastRowNum()+1;
		int celCount = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowCount][celCount];
		
		for(int i=0;i<rowCount;i++) 
		{
			for(int j=0;j<celCount;j++) 
			{
				
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	
	   
	
	
}
