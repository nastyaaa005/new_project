package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.*;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage(){

        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task1");
    }

    @After
    public void closeBrowser(){
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO
//        enter a text instead of a number, check that correct error is seen
        WebElement textField = driver.findElement(By.cssSelector("#numb"));
        textField.sendKeys("I am writing a text here");
        driver.findElement(By.className("w3-btn")).click();
        WebElement errorText = driver.findElement(By.cssSelector("#ch1_error"));
        assertTrue(errorText.isDisplayed());
        assertEquals("Please enter a number", errorText.getText());
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        WebElement textField = driver.findElement(By.cssSelector("#numb"));
        textField.sendKeys("27");
        driver.findElement(By.className("w3-btn")).click();
        WebElement errorText = driver.findElement(By.cssSelector("#ch1_error"));
        assertTrue(errorText.isDisplayed());
        assertEquals("Number is too small", errorText.getText());
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        WebElement textField = driver.findElement(By.cssSelector("#numb"));
        textField.sendKeys("127");
        driver.findElement(By.className("w3-btn")).click();
        WebElement errorText = driver.findElement(By.cssSelector("#ch1_error"));
        assertTrue(errorText.isDisplayed());
        assertEquals("Number is too big", errorText.getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        WebElement textField = driver.findElement(By.cssSelector("#numb"));
        textField.sendKeys("81");
        driver.findElement(By.className("w3-btn")).click();

        Alert alert = driver.switchTo().alert();

        assertEquals("Square root of 81 is 9.00", alert.getText());

        alert.accept();

        WebElement errorText = driver.findElement(By.cssSelector("#ch1_error"));
        assertFalse(errorText.isDisplayed());


    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        WebElement textField = driver.findElement(By.cssSelector("#numb"));
        textField.sendKeys("57");
        driver.findElement(By.className("w3-btn")).click();

        Alert alert = driver.switchTo().alert();

        assertEquals("Square root of 57 is 7.55", alert.getText());

        alert.accept();

        WebElement errorText = driver.findElement(By.cssSelector("#ch1_error"));
        assertFalse(errorText.isDisplayed());
    }
}
