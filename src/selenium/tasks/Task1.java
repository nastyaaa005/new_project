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
        WebElement textInput = driver.findElement(By.id("numb"));
        WebElement err = driver.findElement(By.id ( "ch1_error" ));
        WebElement Submit = driver.findElement (By.className("w3-orange"));
        String wrgText ="abc";
        String Expected = "Please enter a number";
        textInput.sendKeys ( wrgText );
       Submit.click ();
       assertEquals ( Expected,err.getText () );
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        WebElement textInput = driver.findElement(By.id("numb"));
        WebElement err = driver.findElement(By.id ( "ch1_error" ));
        WebElement Submit = driver.findElement (By.className("w3-orange"));
        String wrg = "3";
        String Exp = "Number is too small";
        textInput.sendKeys (wrg);
        Submit.click ();
        assertEquals ( Exp,err.getText() );

    }

    @Test
    public void errorOnNumberTooBig() {


//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        WebElement textInput = driver.findElement(By.id("numb"));
        WebElement err = driver.findElement(By.id ( "ch1_error" ));
        WebElement Submit = driver.findElement (By.className("w3-orange"));
        String wrg = "103";
        String Exp = "Number is too big";
        textInput.sendKeys (wrg);
        Submit.click ();
        assertEquals ( Exp,err.getText() );
    }

    @Test
    public void errorOnNumberTooBigCheckingKnownBug() {

//        BUG: if I enter number 666 no errors where seen
        WebElement textInput = driver.findElement ( By.id ( "numb" ) );
        String sendKeyOne = "666";
        textInput.sendKeys ( sendKeyOne );
        WebElement button = driver.findElement ( By.cssSelector ( "button.w3-margin" ) );
        button.click ( );
        WebElement error = driver.findElement ( By.id ( "ch1_error" ) );
        String originalText = "Number is too big";
        assertEquals ( originalText, error.getText ( ) );
    }


        @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        WebElement textInput = driver.findElement(By.id("numb"));
        WebElement err = driver.findElement(By.id ( "ch1_error" ));
        WebElement Submit = driver.findElement (By.className("w3-orange"));
        String square= "64";
        String Exp = "Square root of 64 is 8.00";
        textInput.sendKeys ( square );
        Submit.click ();
        Alert alert = driver.switchTo().alert();
        assertEquals ( Exp, alert.getText() );
        alert.accept ();
        assertFalse ( err.isDisplayed () );
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        WebElement textInput = driver.findElement(By.id("numb"));
        WebElement err = driver.findElement(By.id ( "ch1_error" ));
        WebElement Submit = driver.findElement (By.className("w3-orange"));
        String square= "67";
        String Exp = "Square root of 67 is 8.19";
        textInput.sendKeys ( square );
        Submit.click ();
        Alert alert = driver.switchTo().alert();
        assertEquals ( Exp, alert.getText() );
        alert.accept ();
        assertFalse ( err.isDisplayed () );
    }
}
