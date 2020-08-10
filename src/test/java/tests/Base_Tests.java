package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Parameters;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

public class Base_Tests 
{

	public static WebDriver drivver;
	
	
	@BeforeSuite
	@Parameters({"browser"})
	 public void strart_driver(@Optional("chrome")String browser_value) {
		if (browser_value.equalsIgnoreCase("chrome")) {
			String chrome_path = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",chrome_path);
			drivver =new ChromeDriver();
		}
		else if (browser_value.equalsIgnoreCase("firefox")) {
			String chrome_path = System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",chrome_path);
			drivver=new FirefoxDriver();
		}
		else if (browser_value.equalsIgnoreCase("ie")) {
			
		}
	
		//drivver.manage().window().fullscreen();
		drivver.navigate().to("https://natiga.dostor.org/");
		drivver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void end_driver() {
		//drivver.quit();
	}
	
}
