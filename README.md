# Assignment-luciano
## Install the project
 The project should be import in an eclipse and use maven and testNG framework.
 
## Project architecture
* pom.xlm							Maven xml configuration file 

* 	src/test/java
** 		aluciano.assignment.actions		Contain files to communicate with the webdriver
** 		aluciano.assignment.helper		Contain files to manipulate conplex elements (tables, etc)
** 		aluciano.assignment.tests		Contain tests files
**	 	aluciano.assignment.ui			Contain files with page object definition
 
## Configuration

3 parametters should be configured to execute tests.

###	aluciano.assignment.actions.SeleniumToolBox
*	driverType	-  	the type of driver to use - Chrome - but it's possible to use other webdrivers
*	driverPath	-	the path where the driver is saved. by default, the driver is saved in the main directory.

###	aluciano.assignment.ui.HomePage
*	url 	-	The url of the homepage.

## Automated scope


### US01 Display the current date
*	Check if the correct date is displayed. 

### US02 View the list of pets
*	Check that the table is displayed in the page

### US03 - Be able to add a new pet
*	Test the pet insertion

**  	Add a new pet
**  	Add a pet with wrong values.
 

### US04 - Be able to modify an existing pet
*	Update a pet

**  	Update a pet and press "enter"
**  	Update a pet and press "escape"
**  	Update a pet and click other element

### US05 - Exposing a REST API 

* No time to automated.