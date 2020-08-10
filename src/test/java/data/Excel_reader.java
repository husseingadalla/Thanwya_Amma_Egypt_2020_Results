package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.lang.*;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.checker.formatter.qual.Format;

import java.lang.String;

public class Excel_reader {
	static FileInputStream fis=null;
	
	public FileInputStream get_file_input_stream(String excel_sheet_name) {
		String filepath =System.getProperty("user.dir")+"/src/test/java/data/"+excel_sheet_name;
		File source_file = new File(filepath);
		try {
			fis = new FileInputStream(source_file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fis;
	}
	
	public Object [][] get_excel_data(String excel_sheet_name,int sheet_index,int col_num) throws IOException{
		fis = get_file_input_stream(excel_sheet_name);
		
			XSSFWorkbook workbook_object = new XSSFWorkbook(fis);
		
			XSSFSheet sheet	= workbook_object.getSheetAt(sheet_index);
			
			int total_number_rows = sheet.getLastRowNum()+1;
			
			int total_number_cols = col_num;
			
			Object [][] array_excel_data = new String[total_number_rows][total_number_cols];
			
			for (int i = 0; i < total_number_rows; i++) {
				for (int j = 0; j < total_number_cols; j++) {
					XSSFRow row = sheet.getRow(i);
					array_excel_data[i][j]=row.getCell(j).toString();
					
				}
			}
			
		return array_excel_data;	
	
	}
	
	public Object  excel_data_by_row_col_names(String excel_sheet_name,int sheet_index,int col_num,String row_name,String col_name) throws IOException{
		Object row_tofind =row_name;
		Object col_tofind = col_name;
		int row_index=0;
		int col_index=0;
		
		fis = get_file_input_stream(excel_sheet_name);
		
			XSSFWorkbook workbook_object = new XSSFWorkbook(fis);
		
			XSSFSheet sheet	= workbook_object.getSheetAt(sheet_index);
			
			int total_number_rows = sheet.getLastRowNum()+1;
			
			int total_number_cols = col_num;
			
			String [][] array_excel_data = new String[total_number_rows][total_number_cols];
			
			for(Row row:sheet)
				for(Cell cell:row) {
					CellReference cellref = new CellReference(row.getRowNum(),cell.getColumnIndex());
					XSSFRow roww = sheet.getRow(row.getRowNum());
					array_excel_data[row.getRowNum()][cell.getColumnIndex()]=roww.getCell(cell.getColumnIndex()).toString();
					
					DataFormatter formatter = new DataFormatter();
					String row_text = formatter.formatCellValue(cell);
					String col_text = formatter.formatCellValue(cell);
					if(row_tofind.equals(row_text)) {
					row_index=row.getRowNum();	
					}
					if(col_tofind.equals(col_text)) {
						col_index=cell.getColumnIndex();
					}
				}
			
		return array_excel_data[row_index][col_index];
	
	}
	
	
	

}
