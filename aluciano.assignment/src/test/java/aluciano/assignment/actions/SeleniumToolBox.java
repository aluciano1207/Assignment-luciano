package aluciano.assignment.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * 	this class contain functions necessary for the WebDriver
 * 
 */
public class SeleniumToolBox {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver(String driverType,String driverPath)
	{
		
		if(driverType.toUpperCase().equals("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver",driverPath);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		}

		if(driverType.toUpperCase().equals("FIREFOX"))
		{
			
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			return driver;
		}
		
			
		return null;
	}
	
	public static void goTo(String url)
	{
		driver.get(url);
		
	}
	
	
	

	
	
	

}
