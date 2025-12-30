package ReadDataFrom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class write_multiple_data_xlsx {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TP30.xlsx");
	 Workbook wb = WorkbookFactory.create(fi);
	  Sheet sh = wb.createSheet("data2");
	 Row row1 = sh.createRow(0);
	  row1.createCell(0).setCellValue("Qspider");
	  row1.createCell(1).setCellValue("rajajinagr");
	  row1.createCell(2).setCellValue(1234);
	  
	  
	  Row row2 = sh.createRow(1);
	  row2.createCell(0).setCellValue("pyspider");
	  row2.createCell(1).setCellValue("jpnagar");
	  row2.createCell(2).setCellValue(5647);
	  
	  Row row3 = sh.createRow(2);
	  row3.createCell(0).setCellValue("jpider");
	  row3.createCell(1).setCellValue("hebbal");
	  row3.createCell(2).setCellValue(9868);
	  
	  FileOutputStream fo = new FileOutputStream(".\\src\\test\\resources\\TP30.xlsx");
	  
	  wb.write(fo);
	  wb.close();
	  
}
}
