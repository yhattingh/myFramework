package frameWorkClasses;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel extends BasePage {
	
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] data = null;  //String[][] is a string array and we initialize it to null
		try {
			/*
			 * Java FileInputStream class object obtains input bytes from a file.  It is used for
			 * reading byte-oriented data (streams of raw bytes) such as image data, audio,
			 * video etc.  You can also read character-stream data. But, for reading streams
			 * of characters, it is recommended to use FileReader class
			 */
			FileInputStream fis = new FileInputStream(fileName);
			/*
			 * High level representation of a SpreadsheetML workbook. This is the first
			 * ojbect most user will construct whether they are reading or writing a
			 * workbook.  It is also the top level object for creating new sheets/etc.
			 */
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(sheetName);
			DataFormatter formatter = new DataFormatter();  //used when we read the data
			XSSFRow row = sh.getRow(0);  //the first row is our header
			int noOfRows = sh.getPhysicalNumberOfRows();
			int noOfCols = row.getLastCellNum();
			// High level representation of a cell in a row of a spreadsheet.

			//to populate the array :
			data = new String[noOfRows -1][noOfCols]; // noOfRows -1 is to exclude the header row
														//we have an array of 2 rows and 2 columns
			for (int i = 1; i < noOfRows; i++) {		//rows: nested for loop start at 1 and stop when i < the number of rows
				for (int j = 0; j < noOfCols; j++) {	//columns:  start at 0 and stop when j < than number of cols
//					formatCellValue(Cell cell)
//					Returns the formatted value of a cell as a String regardless of the cell type.
					data[i -1][j] = formatter.formatCellValue(sh.getRow(i).getCell(j));
					System.out.println((data[i - 1][j]));
				}
			}
		} 
		
		catch (Exception e) {
			System.out.println("The exception is: " + e.getMessage());
		}
		return data;
	}
}
