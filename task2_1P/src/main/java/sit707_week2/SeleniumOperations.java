package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/Users/andre/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get("https://www.officeworks.com.au/app/identity/create-account");
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement firstName = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + firstName);
		// Send first name
		firstName.sendKeys("Andrei");
		
		WebElement lastName = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + lastName);
		// Send last name
		lastName.sendKeys("Angeles");
		
		WebElement phNumber = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found element: " + phNumber);
		// Send last name
		phNumber.sendKeys("0452600971");
		
		WebElement email = driver.findElement(By.id("email"));
		System.out.println("Found element: " + email);
		// Send last name
		email.sendKeys("andreiangeles738@gmail.com");
		
		
		WebElement password = driver.findElement(By.id("password"));
		System.out.println("Found element: " + password);
		// Send last name
		password.sendKeys("Testing123.Password");
		
		WebElement passworConfirm = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found element: " + passworConfirm);
		// Send last name
		passworConfirm.sendKeys("123testing");
		
		WebElement clickSubmit = driver.findElement(By.cssSelector("[data-testid='account-action-btn']"));
		System.out.println("Found element: " + clickSubmit);
		// Click Submit
		clickSubmit.click();
		
		
WebDriver driver2 = new ChromeDriver();
		
		System.out.println("Driver info: " + driver2);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver2.get("https://www.bunnings.com.au/register");
		
		// Find first input field which is firstname
		WebElement firstName2 = driver2.findElement(By.id("firstName"));
		System.out.println("Found element: " + firstName2);
		// Send first name
		firstName2.sendKeys("Andrei");
		
		WebElement lastName2 = driver2.findElement(By.id("lastName"));
		System.out.println("Found element: " + lastName2);
		// Send last name
		lastName2.sendKeys("Angeles");
		
		WebElement email2 = driver2.findElement(By.id("uid"));
		System.out.println("Found element: " + email2);
		// Send last name
		email2.sendKeys("andreiangeles738@gmail.com");
		
		
		WebElement password2 = driver2.findElement(By.id("password"));
		System.out.println("Found element: " + password2);
		// Send last name
		password2.sendKeys("test");

		
		WebElement clickSubmit2 = driver2.findElement(By.cssSelector("[data-locator='input_CreateAccount']"));
		System.out.println("Found element: " + clickSubmit2);
		// Click Submit
		clickSubmit2.click();
		
		
		// Sleep a while
		sleep(10);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
