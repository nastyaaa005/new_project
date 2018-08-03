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
        assertEquals(5, driver.findElements(By.className("test")).size());
//         check how many element with class "test" there are on page (5)
        assertEquals("This is also a button", driver.findElement(By.id("buttonId")).getAttribute("value"));
//         check that value of second button is "This is also a button"
    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
        String val = driver.findElement(By.id("buttonId")).getAttribute("value");
        assertTrue(val.equalsIgnoreCase("this is Also a Button"));
        fail("Error!");
//         check that it is True that value of second button is "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
        String val = driver.findElement(By.id("buttonId")).getAttribute("value");
        assertFalse(val.contentEquals("This is a button"));
//        check that it is False that value of second button is "This is a button"
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
        List<WebElement> allElementsWithClass = driver.findElements(By.className("test"));
        for(WebElement elementWithClass : allElementsWithClass)
        {
           // System.out.println(elementWithClass.getText());
            assertFalse(elementWithClass.getText().contains("190"));
        }


     //  if(driver.findElements(By.xpath("//*[@class='test' and contains(text(),'190')]")).isEmpty()) fail();
     }
     //fail();
//        check that none of items with class "test" contain number 190
    }

