package aluciano.assignment.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*	This class contain the definition of webelements in the homepage.
 * 	The WebDriver is send in the constructor.* 
 * 
 */
public class HomePage {

	public HomePage(WebDriver driver) {

		this.driver = driver;

	}

	private static WebDriver driver;
	private String url = "https://qa-petstore.herokuapp.com/";

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		HomePage.driver = driver;
	}

	public String getUrl() {

		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public WebElement getPetNameInput() {
		return driver.findElement(By.className("pet-name"));
	}

	public WebElement getPetStatusInput() {
		return driver.findElement(By.className("pet-status"));
	}

	public WebElement getCreateButton() {
		return driver.findElement(By.id("btn-create"));
	}

	public WebElement getTableList() {
		return driver.findElement(By.className("table"));
	}

	public WebElement getBannerDate() {
		return driver.findElement(By.className("banner-date"));
	}

}
