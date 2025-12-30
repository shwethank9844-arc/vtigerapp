package ReadDataFrom;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readDataFromxlsx {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream file = new FileInputStream(".\\src\\test\\resources\\TP30.xlsx");
	
	Workbook wb = WorkbookFactory.create(file);
	String data = wb.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
	System.out.println(data);
	
}
}
