package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DecimalFormat;

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
        WebElement enterNumber = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-btn"));
        WebElement errorMessage = driver.findElement(By.className("error"));

        String stringText = "oioioioioi";

        enterNumber.clear();
        assertEquals(enterNumber.getAttribute("value"),"");
        enterNumber.sendKeys(stringText);
        submitButton.click();
        assertEquals(enterNumber.getAttribute("value"), stringText);
        assertEquals("Please enter a number", errorMessage.getText());
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        WebElement enterNumber = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-btn"));
        WebElement errorMessage = driver.findElement(By.className("error"));

        String stringNumberSmall = "14";

        enterNumber.clear();
        assertEquals(enterNumber.getAttribute("value"),"");
        enterNumber.sendKeys(stringNumberSmall);
        submitButton.click();
        assertEquals(enterNumber.getAttribute("value"), stringNumberSmall);
        assertEquals("Number is too small", errorMessage.getText());
    }

    @Test
    public void errorOnNumberTooBig() {

//        TODO
//        enter number which is too big (above 100), check that correct error is seen

        WebElement enterNumber = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-btn"));
        WebElement errorMessage = driver.findElement(By.className("error"));

        String stringNumberBig = "444";

        enterNumber.clear();
        //assertEquals(enterNumber.getAttribute("value"), "");
        enterNumber.sendKeys(stringNumberBig);
        submitButton.click();
        //assertEquals(enterNumber.getAttribute("value"), stringNumberBig);
        assertEquals("Number is too big", errorMessage.getText());
    }

    //        BUG: if I enter number 666 no errors where seen

    @Test
    public void errorOnNumber666() {

        WebElement enterNumber = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-btn"));
        WebElement errorMessage = driver.findElement(By.className("error"));

        String stringEvil = "666";

        enterNumber.clear();
        //assertEquals(enterNumber.getAttribute("value"),"");
        enterNumber.sendKeys(stringEvil);
        submitButton.click();
       // assertEquals(enterNumber.getAttribute("value"), stringEvil);
        assertEquals("Number is too big", errorMessage.getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly

        WebElement enterNumber = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-btn"));
        WebElement errorMessage = driver.findElement(By.className("error"));

        String Number50To100NoReminder = "100";
        double root = Math.sqrt(100);

        DecimalFormat df = new DecimalFormat("#.00");
        String rootFormatted = df.format(root);
        System.out.println(rootFormatted);

        enterNumber.clear();
        assertEquals(enterNumber.getAttribute("value"),"");
        enterNumber.sendKeys(Number50To100NoReminder);
        submitButton.click();
        //assertEquals(enterNumber.getAttribute("value"), Number50To100NoReminder);
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of " + Number50To100NoReminder + " is " + rootFormatted, alert.getText());
        alert.accept();
        assertFalse(errorMessage.isDisplayed());
    }


    @Test
    public void correctSquareRootWithRemainder() {

//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which has a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly

        WebElement enterNumber = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-btn"));
        WebElement errorMessage = driver.findElement(By.className("error"));

        String Number50To100Reminder = "93";
        double root = Math.sqrt(93);
        double scale = Math.pow(10, 2);
        double rootRounded = Math.round(root * scale) / scale;

        enterNumber.clear();
        assertEquals(enterNumber.getAttribute("value"),"");
        enterNumber.sendKeys(Number50To100Reminder);
        submitButton.click();
        //assertEquals(enterNumber.getAttribute("value"), Number50To100NoReminder);
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of " + Number50To100Reminder + " is " + rootRounded, alert.getText());
        alert.accept();
        assertFalse(errorMessage.isDisplayed());
    }
}