package testNG_Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GEneric_Utils.excelUtiles;

public class Dp_genericTest {

	@Test(dataProvider = "getData")
	
	public void execute(String trainer,String teacher) {
		System.out.println(trainer+"---->"+teacher);
	}
	
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		excelUtiles eLib = new excelUtiles();
		Object[][] value=eLib.excelData("DataProvider");
		return value;
	}
	
}
