package com.crm.qa.testUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTestData { 
	
    public  static Object[][] readExcel(String filePath,String fileName,String sheetName) throws IOException{
    	System.out.println("m inside readtestdata");
    File file =    new File(filePath+"\\"+fileName);
    FileInputStream inputStream = new FileInputStream(file);
    Workbook guru99Workbook = null;
    String fileExtensionName = fileName.substring(fileName.indexOf("."));
    if(fileExtensionName.equals(".xlsx")){
    guru99Workbook = new XSSFWorkbook(inputStream);
    }
    else if(fileExtensionName.equals(".xls")){
        guru99Workbook = new HSSFWorkbook(inputStream);   }
    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
    
    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
    Object[][] data = new Object[guru99Sheet.getLastRowNum()][guru99Sheet.getRow(0).getLastCellNum()];
    for(int i=0; i<guru99Sheet.getLastRowNum(); i++){
    	for(int j=0; j<guru99Sheet.getRow(0).getLastCellNum(); j++){
        data[i][j] = guru99Sheet.getRow(i+1).getCell(j).toString();
        	System.out.println("data inside is "+data[i][j]);
        	    }
           }
     //   System.out.println();
      //  return data;
    System.out.println("returnd testdata is "+data);
	return data;
    }
}
    

    