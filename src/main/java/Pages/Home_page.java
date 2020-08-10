package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class Home_page extends Base_Page {

	public Home_page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "seating_no")
	public WebElement seating_no;
	@FindBy(id =  "submit")
	WebElement submit_button;
	
	public void clear_seating_no_text()
	{
		clear_text_box(seating_no);
	}
	
	public void send_seating_no_text(String seating_number)
	{
		set_text_element(seating_no, seating_number);
	}
	
	public void click_submit()
	{
		click_element(submit_button);;
	}
	
	public void scroll_to_seating_no(WebDriver driverrr) {
		scroll_to_element(seating_no, driverrr);
	}

}