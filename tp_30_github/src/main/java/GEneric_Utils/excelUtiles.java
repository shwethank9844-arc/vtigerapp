package GEneric_Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtiles {
     
	/**
	 * this is read the single data from excel
	 * @author Supriya
	 * @param SheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws IOException
	 */
	public String readSingleDataFromEXcel(String SheetName,int rowNo,int cellNo) throws  IOException {
		FileInputStream fi = new FileInputStream(IPathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		 String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	/**
	 * this is read multiple data from excel
	 * @author Supriya
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public ArrayList<String> readMultipleDataFromExcel(String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IPathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("SheetName");
		int rowCount = sh.getLastRowNum();
		int celCount = sh.getRow(0).getLastCellNum();
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i=0;i<=rowCount;i++)
		{
			for(int j=0;j<celCount;j++)
			{
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				list.add(value);
			}
		}
		return list;
		
		}
	
	/**
	 * this is get the row count
	 * @author Supriya
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getRowCount(String SheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fi = new FileInputStream(IPathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}
	/**
	 * this is get the cell count
	 * @author Supriya
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public int getCelCount(String SheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fi = new FileInputStream(IPathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		 int celCount = sh.getRow(0).getLastCellNum();
		 return celCount;
}

/**
 * this is write the data from excel
 * @author Supriya
 * @param SheetName
 * @param value
 * @throws EncryptedDocumentException
 * @throws IOException
 */

public void writeDataFromExcel(String SheetName,String value) throws EncryptedDocumentException, IOException {
	FileInputStream fi = new FileInputStream(IPathConstants.excelpath);
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(SheetName);
	Row row = sh.getRow(0);
	Cell cel = row.createCell(0);
	cel.setCellType(CellType.STRING);//deprecated
	cel.setCellValue(value);
	
	FileOutputStream fo = new FileOutputStream(IPathConstants.excelpath);
	wb.write(fo);
	wb.close();
	
}

public Object[][] excelData(String SheetName) throws EncryptedDocumentException, IOException {
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
