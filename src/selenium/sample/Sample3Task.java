package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class Sample3Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void assertEqualsTask() throws Exception {
//         TODO:
//         check how many element with class "test" there are on page (5)
//         check that value of second button is "This is also a button"
        int expectedNumber = 5;
        int actualNumber = driver.findElements(By.className("test")).size();
        assertEquals(expectedNumber, actualNumber);
        String expected = "This is also a button";
        String actual = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertEquals(expected, actual);
    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
        String value = driver.findElement(By.id("buttonId")).getAttribute("value");
        assertTrue(value.equalsIgnoreCase("this is Also a Button"));
        fail("Some custom message.");
//         check that it is True that value of second button is "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
        //String elementTextOnPage = driver.findElement(By.cssSelector("this is Also a Button")).getText();
        //assertTrue(elementTextOnPage.equals("this is Also a Button"));
        //assertTrue(elementTextOnPage.contains("this also a Button"));
    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
        String element = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertFalse(element.equals("This is a button"));
//        check that it is False that value of second button is "This is a button"
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
        List<WebElement> myListOfElements = driver.findElements(By.className("test"));
        for (WebElement myElement : myListOfElements) {
            System.out.println(myElement.getText());
            assertFalse(myElement.getText().contains("190"));
        }

//        check that none of items with class "test" contain number 190
    }
}
