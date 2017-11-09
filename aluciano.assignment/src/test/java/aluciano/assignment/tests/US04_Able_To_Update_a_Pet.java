package aluciano.assignment.tests;

import org.testng.annotations.Test;

import aluciano.assignment.actions.SeleniumToolBox;
import aluciano.assignment.helper.TableHelper;
import aluciano.assignment.ui.HomePage;

import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

/*
 * US04 - update a pet
 *  - Update a pet and press "enter"
 *  - Update a pet and press "escape"
 *  - Update a pet and click other element
 * 
 */

public class US04_Able_To_Update_a_Pet {

	private static WebDriver driver;

	private String driverType = "Chrome";
	private String driverPath = "C:\\Users\\aluciano\\eclipse-workspace\\aluciano.assignment\\chromedriver.exe";
	HomePage homepage;
	TableHelper table;

	String petName = "new_test_name";
	String petStatus = "new_test_status";
	String petNameUpdated = "updated_test_name";

	@BeforeMethod
	public void beforeMethod() {
		driver = SeleniumToolBox.getDriver(driverType, driverPath);
		homepage = new HomePage(driver);
		table = new TableHelper(driver);

	}

	@Test
	public void Update_a_pet_press_enter() {

		SeleniumToolBox.goTo(homepage.getUrl());
		waitSd(2);

		clearPetsList();
		fillPetFields(petName, petStatus);

		waitSd(2);

		table.updatePetName(petName, petNameUpdated);

		pressEnter();
		homepage.getBannerDate().click();

		waitSd(2);

		Assert.assertEquals(true, table.petIsPresent(petNameUpdated, petStatus));

	}

	@Test
	public void Update_a_pet_press_escape() {

		SeleniumToolBox.goTo(homepage.getUrl());
		waitSd(2);

		clearPetsList();

		fillPetFields(petName, petStatus);

		waitSd(2);

		table.updatePetName(petName, petNameUpdated);

		pressEscape();
		// homepage.getBannerDate().click();

		waitSd(2);

		Assert.assertEquals(true, table.petIsPresent(petName, petStatus));

	}

	@Test
	public void Update_a_pet_click_banner() {

		SeleniumToolBox.goTo(homepage.getUrl());
		waitSd(2);

		clearPetsList();

		fillPetFields(petName, petStatus);

		waitSd(2);

		table.updatePetName(petName, petNameUpdated);

		homepage.getBannerDate().click();

		waitSd(2);

		Assert.assertEquals(true, table.petIsPresent(petNameUpdated, petStatus));

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	public void fillPetFields(String petName, String petStatus) {
		homepage.getPetNameInput().sendKeys(petName);
		homepage.getPetStatusInput().sendKeys(petStatus);
		homepage.getCreateButton().click();

	}

	public static void waitSd(int seconds) {

		try {
			Thread.sleep(1000 * seconds);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pressEnter() {

		try {
			Robot r;
			r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void pressEscape() {

		try {
			Robot r;
			r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clearPetsList() {
		while (table.clearPetList()) {

			waitSd(1);
		}

	}

}
