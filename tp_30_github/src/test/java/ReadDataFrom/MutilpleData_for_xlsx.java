package ReadDataFrom;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MutilpleData_for_xlsx {

	public static void main(String[] args) throws Exception {
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		int row = wb.getSheet("data1").getLastRowNum();


		for(int i=0;i<=row;i++) {       //row=0(<=)
			int cel = wb.getSheet("data1").getRow(row).getLastCellNum();

			for(int j=0;j<cel;j++) {          //cell=+1 value(<)
				String data = wb.getSheet("data1").getRow(i).getCell(j).getStringCellValue();
				System.out.println(data);
			}

		}
	}







}


