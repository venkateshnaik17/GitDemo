package com.zohocrm.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
public String getPropertyData(String key) throws IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/crmdata.property");
	Properties p= new Properties();
	p.load(fis);
	String data = p.getProperty(key);
	return data;
}

public String getExceldata(String sheetname,int row,int cell) throws IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/testscript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	return data;
	
}
}
