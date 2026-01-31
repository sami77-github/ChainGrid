package com.tekpyramid.chaingrid.generic_utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ChainGrid_Excel_Utility {
	String path = "./TestData/SCM_Regression_Test_Data_60_Rows.xlsx";

	/*
	 * To read the single data
	 */
	public String readDataFromChainGridExcel(int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		String exceldata = wb.getSheet("SCM_Test_Data").getRow(rowNum).getCell(cellNum).toString();
		wb.close();
		return exceldata;
	}

	/*
	 * To set the data back to excel
	 */
	public void setDataToChainGridExcel(int rowNum, int cellNum, String cellValue)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cel = wb.getSheet("SCM_Test_Data").getRow(rowNum).createCell(cellNum);
		cel.setCellType(CellType.STRING);
		cel.setCellValue(cellValue);

		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();
	}

	/*
	 * To read the whole single coloum data
	 */
	String cellNum1data;

	public String printWholeDataOfSingleColoumn(int cellNum1)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("SCM_Test_Data");
		int rowCount = sh.getLastRowNum();
		for (int i = 0; i < rowCount; i++) {
			cellNum1data = sh.getRow(i).getCell(cellNum1).toString();
			System.out.println(cellNum1data);
		}
		wb.close();
		return cellNum1data;
		
	}

	/*
	 * To read the whole single coloum data
	 */
	String cellNum2data;
	String cellNumData;

	public String printMultipleDataOfTwoColoumns(int cellNum1, int cellNum2)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("SCM_Test_Data");
		int rowCount = sh.getLastRowNum();
		for (int i = 1; i<rowCount; i++) {
			cellNum1data = sh.getRow(i).getCell(cellNum1).toString();
			cellNum2data = sh.getRow(i).getCell(cellNum2).toString();
			System.out.println(cellNum1data+"||"+cellNum2data);
			
		}
		wb.close();
		return cellNumData;
		
	}

}
