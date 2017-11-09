package aluciano.assignment.tests; 


import org.testng.annotations.Test;

import aluciano.assignment.actions.SeleniumToolBox;
import aluciano.assignment.helper.TableHelper;
import aluciano.assignment.ui.HomePage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

/*
 * US02 - Check that the table is displayed in the page
 * 
 * 
 */

public class US02_View_the_list_of_pets {

	private static WebDriver driver;

	private String driverType = "Chrome";
	private String driverPath =  "C:\\Users\\aluciano\\eclipse-workspace\\aluciano.assignment\\chromedriver.exe";
	HomePage homepage;
	TableHelper table;
	
	
	  @BeforeMethod
	  public void beforeMethod() {  
	  driver =SeleniumToolBox.getDriver(driverType, driverPath);
	 
		  
	  }

	
	@Test
	public void The_List_Is_Displayed() {
  
		
		
		SeleniumToolBox.goTo(homepage.getUrl());
		
		
		waitSd(2);


		Assert.assertEquals(true,homepage.getTableList().isDisplayed() );

  }
  
  
  
  
	@AfterMethod
	public void afterMethod() {

		driver.quit();
	}



	public static void waitSd(int seconds)
	{

		try {
			Thread.sleep(1000*seconds);


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	


}
