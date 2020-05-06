package com.util.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.util.ConfigConstants;

public class ExcelUtils {

	public static Workbook workbook;
	
		
	private static void initialize(){
		try {
			
		FileInputStream excelFile = new FileInputStream(new File("D:/InfosysAppiumProject/src/main/resources/Data_Sheet.xlsx"));//"C:/Users/Admin/InfosysAppiumProject/src/main/resources/Data_Sheet.xlsx"
        workbook = new XSSFWorkbook(excelFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/*private static void initialize(){
		try {
			
		FileInputStream excelFile = new FileInputStream(new File("C:/Users/Admin/InfosysAppiumProject/src/main/resources/Data_Sheet.xlsx"));
        workbook = new XSSFWorkbook(excelFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static ArrayList<String> getCredintials() {
		if(workbook== null) {
			initialize();
		}
		Sheet datatypeSheet = workbook.getSheet(ConfigConstants.SHEET_CONSTRAINT);
		Row row = datatypeSheet.getRow(1);
		ArrayList<String> credentials =  new ArrayList<String>();
		DataFormatter formatter = new DataFormatter();
		credentials.add(formatter.formatCellValue(row.getCell(0)));
		credentials.add(row.getCell(1).getStringCellValue());
		System.out.println(credentials);
		return credentials;
	}
	
	public static void addProductDetails(Map<String, String> productDetails, int rowNum) {
		Sheet datatypeSheet = workbook.getSheet(ConfigConstants.SHEET_PRODUCTDETAIL);
		Row row = datatypeSheet.createRow(rowNum);
		row.createCell(0).setCellValue(productDetails.get("productName"));
		row.createCell(1).setCellValue(productDetails.get("price"));		
	}
	
	public static String getProductDetails(int rowNum, int columNum) {
		Sheet datatypeSheet = workbook.getSheet(ConfigConstants.SHEET_PRODUCTDETAIL);
		Row row = datatypeSheet.getRow(rowNum);
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(row.getCell(0));		
	}
	
}
