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
        WebElement inputNumber = driver.findElement(By.cssSelector("#numb"));
        inputNumber.sendKeys("AB");
        driver.findElement(By.cssSelector("[type='button']")).click();
        WebElement errorMessge = driver.findElement(By.cssSelector("#ch1_error"));
        assertEquals("Please enter a number", errorMessge.getText());

    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        WebElement inputNumber = driver.findElement(By.cssSelector("#numb"));
        inputNumber.sendKeys("49");
        driver.findElement(By.cssSelector("[type='button']")).click();
        WebElement errorMessge = driver.findElement(By.cssSelector("#ch1_error"));
        assertEquals("Number is too small", errorMessge.getText());
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        WebElement inputNumber = driver.findElement(By.cssSelector("#numb"));
        inputNumber.sendKeys("101");
        //inputNumber.sendKeys("666");
        driver.findElement(By.cssSelector("[type='button']")).click();
        WebElement errorMessge = driver.findElement(By.cssSelector("#ch1_error"));
        assertEquals("Number is too big", errorMessge.getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        WebElement inputNumber = driver.findElement(By.cssSelector("#numb"));
        inputNumber.sendKeys("64");
        driver.findElement(By.cssSelector("[type='button']")).click();
        //inputNumber.sendKeys("666");

       Alert alert =  driver.switchTo().alert();
       assertEquals("Square root of 64 is 8.00", alert.getText());
       alert.accept();

        WebElement errorMessge = driver.findElement(By.cssSelector("#ch1_error"));
        assertEquals("", errorMessge.getText());

    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly

        WebElement inputNumber = driver.findElement(By.cssSelector("#numb"));
        inputNumber.sendKeys("50");
        driver.findElement(By.cssSelector("[type='button']")).click();
        //inputNumber.sendKeys("666");

        Alert alert =  driver.switchTo().alert();
        assertEquals("Square root of 50 is 7.07", alert.getText());
        alert.accept();

        WebElement errorMessge = driver.findElement(By.cssSelector("#ch1_error"));
        assertEquals("", errorMessge.getText());

    }
}
