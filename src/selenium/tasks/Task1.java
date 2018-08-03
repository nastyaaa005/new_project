package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;

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
        WebElement textInput =  driver.findElement(By.id("numb"));
        WebElement err = driver.findElement(By.id("ch1_error"));
        WebElement submit = driver.findElement(By.className("w3-orange"));
        String wrgText = "abc";
        String Expected ="Please enter a number";
        textInput.sendKeys( wrgText );
        submit.click();
        assertEquals ( Expected,err.getText () );}


//        enter a text instead of a number, check that correct error is seen


    @Test
    public void errorOnNumberTooSmall() {
//        TODO
        WebElement textInput =  driver.findElement(By.id("numb"));
        WebElement err = driver.findElement(By.id("ch1_error"));
        WebElement submit = driver.findElement(By.className("w3-orange"));
        String wrg = "3";
        String Exp ="Number is too small";
        textInput.sendKeys( wrg );
        submit.click();
        assertEquals(Exp,err.getText());

//        enter number which is too small (below 50), check that correct error is seen
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
        WebElement textInput = driver.findElement(By.id("numb"));
        WebElement err = driver.findElement(By.id("ch1_error"));
        WebElement submit = driver.findElement(By.className("w3-orange"));
        String wrg = "103";
        String Exp = "Number is too big";
        textInput.sendKeys(wrg);
        submit.click();
        assertEquals(Exp, err.getText());
//        enter number which is too big (above 100), check that correct error is seen
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
        WebElement textInput =  driver.findElement(By.id("numb"));
        WebElement err = driver.findElement(By.id("ch1_error"));
        WebElement submit = driver.findElement(By.className("w3-orange"));
        String square = "81";
        String Exp ="Square root of 81 is 9.00";
        textInput.sendKeys( square );
        submit.click();
        Alert alert = driver.switchTo().alert();
        assertEquals(Exp, alert.getText());

//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
        WebElement textInput =  driver.findElement(By.id("numb"));
        WebElement err = driver.findElement(By.id("ch1_error"));
        WebElement submit = driver.findElement(By.className("w3-orange"));
        String square = "82";
        String Exp ="Square root of 82 is 9.06";
        textInput.sendKeys( square );
        submit.click();
        Alert alert = driver.switchTo().alert();
        assertEquals(Exp, alert.getText());
        alert.accept();
        assertFalse(err.isDisplayed());
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
