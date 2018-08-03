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
        WebElement inputArea = driver.findElement(By.id("numb"));
        WebElement errorMsg = driver.findElement(By.id("ch1_error"));
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        String wrongText = "aba";
        String expectedErrorMsg = "Please enter a number";
        inputArea.sendKeys(wrongText);
        submitButton.click();
        assertEquals(expectedErrorMsg, errorMsg.getText());
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        WebElement inputArea = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        WebElement errorMsg = driver.findElement(By.id("ch1_error"));
        String numberSmall = "20";
        String expectedErrorMsg = "Number is too small";
        inputArea.sendKeys(numberSmall);
        submitButton.click();
        assertEquals(expectedErrorMsg, errorMsg.getText());
    }

    @Test
    public void errorOnNumberTooBig() {
//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        WebElement inputArea = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        WebElement errorMsg = driver.findElement(By.id("ch1_error"));
        String numberBig = "120";
        String expectedErrorMsg = "Number is too big";
        inputArea.sendKeys(numberBig);
        submitButton.click();
        assertEquals(expectedErrorMsg, errorMsg.getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        WebElement inputArea = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        WebElement errorMsg = driver.findElement(By.id("ch1_error"));
        String numberWithout = "64";
        inputArea.sendKeys(numberWithout);
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 64 is 8.00", alert.getText());
        alert.accept();
        assertFalse(errorMsg.isDisplayed());
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        WebElement inputArea = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        WebElement errorMsg = driver.findElement(By.id("ch1_error"));
        String numberWithout = "65";
        inputArea.sendKeys(numberWithout);
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 65 is 8.06", alert.getText());
        alert.accept();
        assertFalse(errorMsg.isDisplayed());
    }
}
