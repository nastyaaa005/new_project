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
       WebElement inputfield=driver.findElement(By.cssSelector("#numb"));
       WebElement submit=driver.findElement(By.cssSelector("[type=\"button\"]"));
       WebElement error=driver.findElement(By.cssSelector("#ch1_error"));

       inputfield.clear();
       inputfield.sendKeys("lalala");
       assertFalse(error.isDisplayed());
       submit.click();
        assertTrue(error.isDisplayed());
        assertEquals(error.getText(),"Please enter a number");
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        WebElement inputfield=driver.findElement(By.cssSelector("#numb"));
        WebElement submit=driver.findElement(By.cssSelector("[type=\"button\"]"));
        WebElement error=driver.findElement(By.cssSelector("#ch1_error"));

        inputfield.clear();
        inputfield.sendKeys("20");
        assertFalse(error.isDisplayed());
        submit.click();
        assertTrue(error.isDisplayed());
        assertEquals(error.getText(),"Number is too small");
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        WebElement inputfield=driver.findElement(By.cssSelector("#numb"));
        WebElement submit=driver.findElement(By.cssSelector("[type=\"button\"]"));
        WebElement error=driver.findElement(By.cssSelector("#ch1_error"));

        inputfield.clear();
        inputfield.sendKeys("130");
        assertFalse(error.isDisplayed());
        submit.click();
        assertTrue(error.isDisplayed());
        assertEquals(error.getText(),"Number is too big");
    }

    @Test
    public void correctSquareRootWithoutRemainder() throws Exception {
//        TODO
        WebElement inputfield=driver.findElement(By.cssSelector("#numb"));
        WebElement submit=driver.findElement(By.cssSelector("[type=\"button\"]"));
        WebElement error=driver.findElement(By.cssSelector("#ch1_error"));

        inputfield.clear();
        inputfield.sendKeys("81");
        assertFalse(error.isDisplayed());
        submit.click();

        Alert alert = driver.switchTo().alert();
        assertEquals("error1","Square root of 81 is 9.00", alert.getText());
        alert.accept();
        assertFalse(error.isDisplayed());
      //  assertEquals(error.getText(),"Number is too small");
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
    }

    @Test
    public void correctSquareRootWithRemainder () throws Exception{
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly

        WebElement inputfield=driver.findElement(By.cssSelector("#numb"));
        WebElement submit=driver.findElement(By.cssSelector("[type=\"button\"]"));
        WebElement error=driver.findElement(By.cssSelector("#ch1_error"));

        inputfield.clear();
        inputfield.sendKeys("85");
        assertFalse(error.isDisplayed());
        submit.click();

        Alert alert = driver.switchTo().alert();
        assertEquals("error1","Square root of 85 is 9.22", alert.getText());
        alert.accept();
        assertFalse(error.isDisplayed());
    }
}
