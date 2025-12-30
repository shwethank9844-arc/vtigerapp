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

public class write_The_Data_xlsx {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TP30.xlsx");
	
	Workbook wb = WorkbookFactory.create(fi);
	    Sheet sh = wb.getSheet("data1");
	   Row row = sh.createRow(1);
	   Cell cel = row.createCell(0);
	   cel.setCellValue("tekpyramid");
	   
	   FileOutputStream fo = new FileOutputStream(".\\src\\test\\resources\\TP30.xlsx");
	   wb.write(fo);
	   wb.close();
}


}
