package Pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Result_page extends Base_Page{

	public Result_page(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//*[@id=\"pills-tab\"]/li[3]/h1")
	public WebElement Result_percentage;
	
	@FindBy(xpath="/html/body/div[1]/main/div[2]/div/div[4]/div[1]/div[5]/ul/li[1]/span[2]")
	public WebElement Student_name;
	
	@FindBy(xpath = "/html/body/div[1]/main/div[2]/div/div[4]/div[1]/div[5]/ul/li[7]/span[2]")
	public WebElement Division;
	
	public static List<String> list_percentage=new ArrayList<String>();
	public static List<String> list_name=new ArrayList<String>();
	public static List<String> list_division =new ArrayList<String>();
	public static int x =0;

	public void scroll_to_result(WebDriver driverrr) {
		scroll_to_element(Result_percentage, driverrr);
	}
	
}

