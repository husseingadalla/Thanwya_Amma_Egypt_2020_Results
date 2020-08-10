package data;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_writer_new_col {
	public void writeExcel(String fileName,String sheetName,String[] dataToWrite,int col_index) throws IOException{

		//Create an object of File class to open xlsx file
		String filepath =System.getProperty("user.dir")+"/src/test/java/data";

        File file =    new File(filepath+"\\"+fileName);
      //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook_obj = null;
      //Find the file extension by splitting  file name in substring and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if(fileExtensionName.equals(".xlsx")){

        //If it is xlsx file then create object of XSSFWorkbook class

        	workbook_obj = new XSSFWorkbook(inputStream);
        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of XSSFWorkbook class

        	workbook_obj = new HSSFWorkbook(inputStream);

        }  
       //Read excel sheet by sheet name    

        Sheet sheet_obj = workbook_obj.getSheet(sheetName);
        
       //Get the current count of rows in excel file

        int rowCount = sheet_obj.getLastRowNum()-sheet_obj.getFirstRowNum();
      //Create a new row and append it at last of sheet

        Row newRow = sheet_obj.createRow(rowCount+1);
        
        

        //Get the first row from the sheet

        Row row = sheet_obj.getRow(0);

        
      //Create a loop over the cell of newly created Row

        

            Cell cell = newRow.createCell(col_index);
            

            cell.setCellValue(dataToWrite[dataToWrite.length-1]);

           
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook_obj.write(outputStream);
        outputStream.close();
}
}

