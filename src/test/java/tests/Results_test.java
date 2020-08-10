package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.checkerframework.common.reflection.qual.NewInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Home_page;
import Pages.Result_page;
import data.Excel_reader;
import data.Excel_writer;
import data.Excel_writer_new_col;


public class Results_test extends Base_Tests {

	Home_page home_obj ;
	Result_page result_obj;
	List<String> list_percentage=new ArrayList<String>();
	List<String> list_name=new ArrayList<String>();
	List<String> list_division =new ArrayList<String>();
	
	@DataProvider(name = "seating_numbers")
	public Object[][] user_regestration_data() throws IOException{
		Excel_reader ex = new Excel_reader();
		ex.get_file_input_stream("Seating_numbers_results.xlsx");
		return ex.get_excel_data("Seating_numbers_results.xlsx", 3,1);
		
	}
	
	@Test(priority = 1,dataProvider = "seating_numbers")
	public void check_results(String seating_number_value) throws IOException {
	
		home_obj=new Home_page(drivver);
		result_obj=new Result_page(drivver);
		
		home_obj.scroll_to_seating_no(drivver);
		home_obj.clear_seating_no_text();
		home_obj.send_seating_no_text(seating_number_value);
		home_obj.click_submit();
		
		String text_percentage =result_obj.Result_percentage.getText();
		String text_name =result_obj.Student_name.getText();
		String text_division =result_obj.Division.getText();
		list_percentage.add(text_percentage);
		list_name.add(text_name);
		list_division.add(text_division);
		
		String[] Percentages_Array = new String[list_percentage.size()];
		Percentages_Array = list_percentage.toArray(Percentages_Array);
		Excel_writer_new_col ex_write= new Excel_writer_new_col();
		ex_write.writeExcel("Seating_numbers_results.xlsx", "Sheet6", Percentages_Array, 0);
		
		String[] Names_Array = new String[list_name.size()];
		Names_Array = list_name.toArray(Names_Array);
		ex_write.writeExcel("Seating_numbers_results.xlsx", "Sheet6", Names_Array, 1);
		
		String[] Divisions_Array = new String[list_division.size()];
		Divisions_Array = list_division.toArray(Divisions_Array);
		ex_write.writeExcel("Seating_numbers_results.xlsx", "Sheet6", Divisions_Array, 2);
		
		drivver.navigate().back();
		
	}
	
}
