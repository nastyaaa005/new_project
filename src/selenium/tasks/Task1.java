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

        WebElement enterText = driver.findElement(By.id("numb"));
        WebElement SubmitButton = driver.findElement(By.className("w3-btn"));
        WebElement resultText = driver.findElement(By.id("ch1_error"));
        enterText.clear();
        String text = "abc";
        enterText.sendKeys(text);
        SubmitButton.click();
        assertEquals("Please enter a number", resultText.getText());
//        Alert correctalert = driver.switchTo().alert();
//        assertEquals("Please enter a number", correctalert.getText());




    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen

        WebElement enterNum = driver.findElement(By.id("numb"));
        WebElement SubmitButton = driver.findElement(By.className("w3-btn"));
        WebElement resultText = driver.findElement(By.id("ch1_error"));
        enterNum.clear();
        int num = 25;
        enterNum.sendKeys(String.valueOf(num));
        SubmitButton.click();
        assertEquals("Number is too small", resultText.getText());




    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        WebElement enterNum = driver.findElement(By.id("numb"));
        WebElement SubmitButton = driver.findElement(By.className("w3-btn"));
        WebElement resultText = driver.findElement(By.id("ch1_error"));
        enterNum.clear();
        int num = 700;
        enterNum.sendKeys(String.valueOf(num));
        SubmitButton.click();
        assertEquals("Number is too big", resultText.getText());



    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        WebElement enterNum = driver.findElement(By.id("numb"));
        WebElement SubmitButton = driver.findElement(By.className("w3-btn"));
        WebElement resultText = driver.findElement(By.id("ch1_error"));
        enterNum.clear();
        int num = 81;
        enterNum.sendKeys(String.valueOf(num));
        SubmitButton.click();
        Alert myAlert = driver.switchTo().alert();
        myAlert.getText();
        assertEquals("Square root of 81 is 9.00",myAlert.getText());




    }

    @Test
    public void correctSquareRootWithRemainder() {

        WebElement enterNum = driver.findElement(By.id("numb"));
        WebElement SubmitButton = driver.findElement(By.className("w3-btn"));
        WebElement resultText = driver.findElement(By.id("ch1_error"));
        enterNum.clear();
        int num = 98;
        enterNum.sendKeys(String.valueOf(num));
        SubmitButton.click();
        Alert myAlert = driver.switchTo().alert();
        myAlert.getText();
        assertEquals("Square root of 98 is 9.90",myAlert.getText());



//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
