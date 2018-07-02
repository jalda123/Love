package com.Data.SonuDataDriven.exceldata.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelSheet {
	
	public String[][] getExcelData(String excelpath,String sheetname) {
		
	try {
		
		String dataset[][] =null;;
		
		File src = new File(excelpath);
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wrb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wrb.getSheet(sheetname);
		
		//count number of Active Rows
		
		int totalrow =sheet.getLastRowNum();
		
		System.out.println("Total Rows are "+totalrow);
		
		//count number of active columns in row
		
		int totalcolumn =sheet.getRow(0).getLastCellNum();
		
		System.out.println("Total columns are "+totalcolumn);
		
		
		dataset=new String[totalrow][totalcolumn];
		
		Iterator<Row> rowiterator =sheet.iterator();
		
		int i=0;
		
		while(rowiterator.hasNext()) {
			i=i++;
			
			Row row = rowiterator.next();
			
			Iterator<Cell> celliterator = row.cellIterator();
			
			int j=0;
			
			while(celliterator.hasNext()) {
				
				Cell cell = celliterator.next();
				
				if(cell.getStringCellValue().contains("email")) {
					break;
				}

				switch(cell.getCellType()) {
				
				case Cell.CELL_TYPE_NUMERIC:
					dataset[i][j++]=cell.getStringCellValue();
					System.out.println(cell.getNumericCellValue());
					break;
					
				case Cell.CELL_TYPE_STRING:
					dataset[i][j++]=cell.getStringCellValue();
					System.out.println(cell.getStringCellValue());
					break;
					
				case Cell.CELL_TYPE_FORMULA:
					dataset[i][j++]=cell.getStringCellValue();
					System.out.println(cell.getStringCellValue());
					break;
				}
			}
			System.out.println("");
		
		}
		
		return dataset;

	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return null;

	}
	
	public static void main(String[] args) {
		
		String excellocation="E:\\New folder\\Workshop\\SonuDataDriven\\ExcelData.xlsx";
		
		String sheet="Lahari";
		
		ReadDataFromExcelSheet obj = new ReadDataFromExcelSheet();
		
		String[][] data = obj.getExcelData(excellocation, sheet);
		
		System.out.println(data);
	}
}