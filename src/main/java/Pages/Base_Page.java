package Pages;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Base_Page   {
	protected WebDriver draaiver;
	
	

	public Base_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	protected static boolean Check_element_is_present(WebDriver driver,By by) {
		try {
			driver.findElement(by);
			
			return true;
			
		} catch (NoSuchElementException e) {
			return false;
			
		}
		
	}
	
	protected static void  click_element(WebElement element) {
		
		element.click();
	
	}
	
	protected static void clear_text_box(WebElement element) {
		element.clear();
	}
	
	protected static void set_text_element(WebElement element, String text ) {
		
		element.sendKeys(text);
	}
	
	public void scroll_to_element(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", element);
		
	}
}

