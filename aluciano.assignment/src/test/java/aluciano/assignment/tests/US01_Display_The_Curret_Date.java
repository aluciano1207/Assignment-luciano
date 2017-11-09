package aluciano.assignment.tests; 


import org.testng.annotations.Test;

import aluciano.assignment.actions.SeleniumToolBox;
import aluciano.assignment.helper.TableHelper;
import aluciano.assignment.ui.HomePage;

import org.testng.annotations.BeforeMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


/*
 * US01 - this test check if the correct date is displayed. * 
 * 
 */

public class US01_Display_The_Curret_Date {

	private static WebDriver driver;

	private String driverType = "Chrome";
	private String driverPath =  "C:\\Users\\aluciano\\eclipse-workspace\\aluciano.assignment\\chromedriver.exe";
	HomePage homepage;
	TableHelper table;
	
	
	@BeforeMethod
	public void beforeMethod() {  
		driver =SeleniumToolBox.getDriver(driverType, driverPath);
		homepage = new HomePage(driver);
		table = new TableHelper(driver);
	}

	
	@Test
	public void Check_the_list_is_displayed() {
  
	
		 homepage = new HomePage(driver);
		
		SeleniumToolBox.goTo(homepage.getUrl());
		
		Assert.assertEquals(true, table.getNumberOfRow()>0);
	
	
	
		
  }
  
	

  

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
