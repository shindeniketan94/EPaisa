package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper
{
  
	XSSFWorkbook wb;
	XSSFSheet sheet1;
      public ExcelHelper(String Filepath)
      {
    	  File src=new File(Filepath);  //specify where test sheet is located
  		
  		FileInputStream fis;
		try 
		{
			fis = new FileInputStream(src);  		
  		
			wb = new XSSFWorkbook(fis);
			//sheet1=wb.getSheetAt(0);
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}  
      }
		public String getdata(int sheetnum,int rownum,int columnnum)
		{
			sheet1=wb.getSheetAt(sheetnum);
			
			String data=sheet1.getRow(rownum).getCell(columnnum).getStringCellValue();
			return data;
			
		}
		public int getrowcount(int sheetindex)
	      {
	    	int rownum= wb.getSheetAt(sheetindex).getLastRowNum();   	
	    
	    	return rownum;
	  
	    	
	      }
	
	
	 public void writeData(String pathOfFile, String sheetName, int rowNum, int cellNum, String value) throws EncryptedDocumentException, InvalidFormatException, IOException
	 {
	    
		FileInputStream fis = new FileInputStream(pathOfFile);
	    Workbook wb = WorkbookFactory.create(fis);
	    wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(value);	    
	    FileOutputStream fos = new FileOutputStream(pathOfFile);
	    wb.write(fos);
	}
	 
	
	 }

