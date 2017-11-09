package aluciano.assignment.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*	This helper contain functions to manipulate easily tables.
 * 
 * 	We can:
 * 
 * 	- Relead the lsit of pet, after an insert
 * 	- Return the number of pet in the table
 *  - Check if the pet is present
 *  - delete a pet
 * 	- return a "pet" element
 *  - Clear the list of pet.
 */

public class TableHelper {
	
	WebElement table;
	WebDriver driver;
	List<WebElement> listOfPets;

	public TableHelper(WebDriver driver) {
	this.driver = driver;
	}	
	
	
	
	public void loadListOfPets()
	{
		listOfPets = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div/div[2]/div/table")).findElements(By.className("pet-item"));
		
	}
	
	
	public int getNumberOfRow()
	{
		
		return 	table.findElements(By.className("pet-item")).size();
		
	}
	
	public boolean petIsPresent(String petName,String petStatus)
	{
		
		List<WebElement> listOfPets = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div/div[2]/div/table")).findElements(By.className("pet-item"));
		
		
		for(WebElement pet: listOfPets)
		{		
			
			if(pet.findElement(By.className("pet-name")).getText().equals(petName) && pet.findElement(By.className("pet-status")).getText().equals(petStatus))
			{
				return true;
			}
				
		}

		return false;

	}	
	

	public boolean deletePet(String petName,String petStatus)
	{
		
		for(WebElement pet: 		table.findElements(By.className("pet-item")))
		{		
			
		if(pet.findElement(By.className("pet-name")).getText().equals(petName) && pet.findElement(By.className("pet-status")).getText().equals(petStatus))
		{
				
			pet.findElement(By.className("delete")).click();
		return true;
		}
			
			
		}

		return false;

	}	
	
	public WebElement getPetElement(String petName,String petStatus)
	{
		
		for(WebElement pet: 		table.findElements(By.className("pet-item")))
		{		
			
		if(pet.findElement(By.className("pet-name")).getText().equals(petName) && pet.findElement(By.className("pet-status")).getText().equals(petStatus))
		{
				
		return pet;
		}
			
			
		}

		return null;

	}	

	
	public boolean updatePetName(String petName,String newName)
	{
		
		loadListOfPets();
		for(int i=0;i<listOfPets.size();i++)
		{		
			WebElement pet =  listOfPets.get(i);
		if(pet.findElement(By.className("pet-name")).getText().equals(petName) )
		{
				
			pet.click();
		
			
			WebElement edit = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div/div[2]/div/table")).findElement(By.className("edit"));
			
			List<WebElement> fields = pet.findElements(By.tagName("input"));
			
			for(WebElement field:fields)
			{
				
				System.out.println("text = "+field.getAttribute("value"));

				
				if(field.getAttribute("value").equals(petName))
				{
					field.click();
					field.clear();
					field.sendKeys(newName);
					
					return true;

				}
				
			}
				}
			
			
		}

		return false;

	}	
	
	
	public boolean clearPetList()
	{
		
		loadListOfPets();

		
		if(listOfPets.size()>0)
		{
			listOfPets.get(0).findElement(By.className("delete")).click();
			return true;
		}

		return false;


	}	
	

}
