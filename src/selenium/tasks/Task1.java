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
        WebElement textInput = driver.findElement(By.id("numb"));

        String sendKeyOne = "abcde";
        textInput.sendKeys(sendKeyOne);

        WebElement button = driver.findElement(By.cssSelector("button.w3-margin"));
        button.click();

        WebElement error = driver.findElement(By.id("ch1_error"));

        String originalText = "Please enter a number";

        assertEquals(originalText, error.getText());
//        TODO
//        enter a text instead of a number, check that correct error is seen
    }

    @Test
    public void errorOnNumberTooSmall() {
        WebElement textInput = driver.findElement(By.id("numb"));

        String sendKeyOne = "35";
        textInput.sendKeys(sendKeyOne);

        WebElement button = driver.findElement(By.cssSelector("button.w3-margin"));
        button.click();

        WebElement error = driver.findElement(By.id("ch1_error"));

        String originalText = "Number is too small";

        assertEquals(originalText, error.getText());

//        TODO
//        enter number which is too small (below 50), check that correct error is seen
    }

    @Test
    public void errorOnNumberTooBig() {
        WebElement textInput = driver.findElement(By.id("numb"));

        String sendKeyOne = "101";
        textInput.sendKeys(sendKeyOne);

        WebElement button = driver.findElement(By.cssSelector("button.w3-margin"));
        button.click();

        WebElement error = driver.findElement(By.id("ch1_error"));

        String originalText = "Number is too big";

        assertEquals(originalText, error.getText());

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
    }

    @Test
    public void errorOnNumberTooBigCheckingKnownBug() {
        WebElement textInput = driver.findElement(By.id("numb"));

        String sendKeyOne = "666";
        textInput.sendKeys(sendKeyOne);

        WebElement button = driver.findElement(By.cssSelector("button.w3-margin"));
        button.click();

        WebElement error = driver.findElement(By.id("ch1_error"));

        String originalText = "Number is too big";

        assertEquals(originalText, error.getText());

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
    }

    @Test
    public void correctSquareRootWithoutRemainder() throws Exception {
        WebElement textInput = driver.findElement(By.id("numb"));

        textInput.sendKeys("81");

        WebElement button = driver.findElement(By.cssSelector("button.w3-margin"));
        button.click();

        Alert alert = driver.switchTo().alert();

        assertEquals("Square root of 81 is 9.00", alert.getText());

        alert.accept();

        WebElement error = driver.findElement(By.id("ch1_error"));

        String originalText = "";

        assertEquals(originalText, error.getText());


//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
    }

    @Test
    public void correctSquareRootWithRemainder() {
        WebElement textInput = driver.findElement(By.id("numb"));

        textInput.sendKeys("51");

        WebElement button = driver.findElement(By.cssSelector("button.w3-margin"));
        button.click();

        Alert alert = driver.switchTo().alert();

        assertEquals("Square root of 51 is 7.14", alert.getText());

        alert.accept();

        WebElement error = driver.findElement(By.id("ch1_error"));

        String originalText = "";

        assertEquals(originalText, error.getText());
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
