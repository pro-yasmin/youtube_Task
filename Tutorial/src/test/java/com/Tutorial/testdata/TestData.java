package com.Tutorial.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {

	
	public static Object[][]  getExcelData() throws IOException {
		// TODO Auto-generated method stub

		//ini excel file path
		File file= new File("C:\\Users\\Yasmi\\eclipse-workspace\\Tutorial\\src\\test\\resources\\TestDataFiles\\TestDataEx.xlsx");
		
	    FileInputStream fis= new FileInputStream(file);
	  
	    
	    XSSFWorkbook workBook= new XSSFWorkbook(fis);
	    
	    XSSFSheet sheet= workBook.getSheet("testcases");
	    
	    String fname= sheet.getRow(0).getCell(0).toString();
	    
        int row= sheet.getLastRowNum();
        int col= sheet.getRow(0).getLastCellNum();
        
        Object data[][]= new Object[row][col];
        
        for(int r=0;r<row;r++) {
        	for(int c=0;c<col;c++) {
        		data[r][c]= sheet.getRow(r+1).getCell(c).toString();
        	}
        }
         return data;
        
	}

	
}
