package ReadDataFrom;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadNumericDataTest {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
	
	Workbook wb = WorkbookFactory.create(fi);
	
	Sheet sh = wb.getSheet("data1");
	
	         Row row = sh.getRow(1);
			 Cell cel = row.getCell(0);
	   
	 DataFormatter format = new DataFormatter();//get number value
	String value = format.formatCellValue(cel);
	
	System.out.println(value);
	
	
}
}
