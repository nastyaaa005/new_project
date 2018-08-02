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
    public void assertEqualsTask1() throws Exception {
//         TODO:
//         check how many element with class "test" there are on page (5)
        int expectedNumberOfElements = 5;
        int actualNumberOfElements = driver.findElements(By.className("test")).size();
        assertEquals(expectedNumberOfElements, actualNumberOfElements);
    }

//         check that value of second button is "This is also a button"
    @Test
    public void assertEqualsTask2() throws Exception {
    String expected = "This is also a button";
    String actual = driver.findElement(By.name("randomButton2")).getAttribute("value");
    assertEquals(expected, actual);
}

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
//         check that it is True that value of second button is "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
        String value = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertTrue(value.equalsIgnoreCase("this is Also a Button"));
        // pass:
        //assertTrue(true);
        ///fail("some custom message");
        // fail:
        //assertTrue(false);

    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
        String element = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertFalse(element.equals("This is a button"));
        // fail:
//        assertFalse(true);
        // pass:
        //assertFalse(false);
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test" contain number 190
        List<WebElement> myListOfElements = driver.findElements(By.className("test"));
        for (WebElement myElement : myListOfElements) {

                System.out.println(myElement.getText());

                assertFalse(myElement.getText().contains("190"));
        }
    }
}