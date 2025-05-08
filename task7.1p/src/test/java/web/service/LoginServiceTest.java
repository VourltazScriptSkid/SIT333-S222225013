package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void runLoginTest(String username, String password, String dob, String expectedTitle) {
    	System.setProperty(
    		    "webdriver.chrome.driver",
    		    "C:/Users/andre/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe"
    		);


        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///C:/Users/andre/Downloads/7.1P-resources/pages/login.html");
        sleep(2);

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(password);

        driver.findElement(By.id("dob")).clear();
        driver.findElement(By.id("dob")).sendKeys(dob); // send as yyyy-MM-dd
        
        driver.findElement(By.cssSelector("[type=submit]")).submit();

        sleep(2);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assert.assertEquals(expectedTitle, title);

        driver.close();
    }

    @Test
    public void testLoginSuccess() {
        runLoginTest("andrei", "andrei_pass", "01-03-2003", "success");
    }
    
    @Test
    public void testInvalidUsername() {
        runLoginTest("wronguser", "andrei_pass", "01-03-2003", "fail");
    }

    @Test
    public void testInvalidPassword() {
        runLoginTest("andrei", "wrongpass", "01-03-2003", "fail");
    }

    @Test
    public void testInvalidDob() {
        runLoginTest("andrei", "andrei_pass", "01-03-2004", "fail");
    }

    @Test
    public void testEmptyFields() {
        runLoginTest("", "", "", "fail");
    }

    @Test
    public void testPartialFields() {
        runLoginTest("andrei", "", "01-03-2003", "fail");
    }

    @Test
    public void testWhitespaceInputs() {
        runLoginTest("  ", "  ", "  ", "fail");
    }

}
