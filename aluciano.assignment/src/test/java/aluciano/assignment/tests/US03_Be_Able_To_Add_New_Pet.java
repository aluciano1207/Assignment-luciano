package aluciano.assignment.tests; 


import org.testng.annotations.Test;

import aluciano.assignment.actions.SeleniumToolBox;
import aluciano.assignment.helper.TableHelper;
import aluciano.assignment.ui.HomePage;

import org.testng.annotations.BeforeMethod;

import java.security.Timestamp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

/*US03 - Test the pet insertion
 * 
 * - Add a new pet
 * - Add a pet with wrong values.
 * 
 */

public class US03_Be_Able_To_Add_New_Pet {

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
	public void add_New_Pet() {

		String petName ="new_pet_name";
		String petStatus = "new_pet_status";


		SeleniumToolBox.goTo(homepage.getUrl());

		clearPetsList();
		waitSd(2);
		
		fillPetFields(petName,petStatus);


		waitSd(2);


		Assert.assertEquals(true, table.petIsPresent(petName, petStatus));



	}



	@Test
	public void add_Empty_Pet() {

		String petName ="";
		String petStatus = "";


		SeleniumToolBox.goTo(homepage.getUrl());


		clearPetsList();
		waitSd(2);
		

		fillPetFields(petName,petStatus);



		waitSd(2);

		Assert.assertEquals(false, table.petIsPresent(petName, petStatus));



	}

	@Test
	public void add_Empty_Name() {

		String petName ="";
		String petStatus = "new_pet_status";


		SeleniumToolBox.goTo(homepage.getUrl());


		clearPetsList();
		waitSd(2);
		

		fillPetFields(petName,petStatus);



		waitSd(2);

		Assert.assertEquals(false, table.petIsPresent(petName, petStatus));



	}

	@Test
	public void add_Empty_Status() {

		String petName ="new_pet_name";
		String petStatus = "";


		SeleniumToolBox.goTo(homepage.getUrl());

		clearPetsList();
		waitSd(2);
		

		fillPetFields(petName,petStatus);


		waitSd(2);

		Assert.assertEquals(false, table.petIsPresent(petName, petStatus));

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
	
	public void fillPetFields(String petName,String petStatus)
	{
		homepage.getPetNameInput().sendKeys(petName);
		homepage.getPetStatusInput().sendKeys(petStatus);
		homepage.getCreateButton().click();

		
	}

	public void clearPetsList()
	{
		while(table.clearPetList())
		{
		
		waitSd(1);
		}
	
	}

}
