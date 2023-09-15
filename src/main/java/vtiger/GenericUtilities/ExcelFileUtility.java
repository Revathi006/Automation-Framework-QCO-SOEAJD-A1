package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic/reusable methods related to excel file
 * @author dell
 *
 */
public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel sheet
	 * @param SheetName
	 * @param RowNumber
	 * @param CellNumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
 public String readDataFromExcel(String SheetName,int RowNumber,int CellNumber) throws EncryptedDocumentException, IOException
 {
	 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 String data = wb.getSheet(SheetName).getRow(RowNumber).getCell(CellNumber).getStringCellValue();
	 wb.close();
     return data;
 }
 
 /**
  * This method will write data into Excel sheet
  * @param SheetName
  * @param RowNumber
  * @param CellNumber
  * @param value
  * @throws Throwable
  */
 
 public void writeDataIntoExcel(String SheetName, int RowNumber, int CellNumber, String value) throws Throwable
 {
	 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 wb.createSheet(SheetName).createRow(RowNumber).createCell(CellNumber).setCellValue(value);
	 FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	 wb.write(fos);
	 wb.close();
     
 }
 
 
 /**
  * This method will read multiple data from excel file for the sheet provided
  * @param sheetName
  * @return
  * @throws EncryptedDocumentException
  * @throws IOException
  */
 public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
 {
	 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	int lastRow = sh.getLastRowNum();
	int lastCel=sh.getRow(0).getLastCellNum();
	
	Object[][] data=new Object[lastRow][lastCel];
	
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCel;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return data;
 }
}
