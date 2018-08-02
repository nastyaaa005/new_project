package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/test-sample/examples/act";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void enterNumber() throws Exception {
//         TODO:
        WebElement inputFieldNumber = driver.findElement(By.name("vfb-9"));
        WebElement resultButton = driver.findElement(By.id("result_button_number"));
        WebElement clearResultButton = driver.findElement(By.id("clear_result_button_number"));
        WebElement resultText = driver.findElement(By.id("result_number"));

//        enter a number under "Number"
        String originalInuputFieldNumber = "5";
        String Number1 = "79";
        String Number2 = "You entered number: ";

//        check that button is not clickable
        assertTrue(inputFieldNumber.isDisplayed());
        assertTrue(resultButton.isEnabled());
        assertFalse(clearResultButton.isEnabled());
        assertFalse(resultText.isDisplayed());

        assertEquals(inputFieldNumber.getAttribute("value"), originalInuputFieldNumber);
        inputFieldNumber.clear();
        inputFieldNumber.sendKeys(Number1);

        assertEquals(inputFieldNumber.getAttribute("value"), Number1);

//        click on "Result" button
        resultButton.click();

//        check that text is displayed
        assertTrue(resultButton.isEnabled());

        assertTrue(resultText.isDisplayed());

        //        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
        assertEquals(Number2 + "\"" + Number1 + "\"", resultText.getText());

        //        check that the button "Clear Result" is clickable now
        assertTrue(clearResultButton.isEnabled());

        //        click on "Clear Result"
        clearResultButton.click();

//        check that the text is still (""), but it is not displayed
        assertFalse(resultText.isDisplayed());
        assertEquals("", resultText.getText());


    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
        //check current url is base_url
        assertEquals(base_url, driver.getCurrentUrl());

        //click on "This is a link to Homepage"
        driver.findElement(By.id("homepage_link")).click();

        //check that current url is not base_url
        assertEquals("This is a link to Homepage", driver.findElement(By.id("homepage_link")).getText());
        assertNotEquals(driver.getCurrentUrl(), base_url);

        // verify that current url is homepage
        assertEquals("https://kristinek.github.io/test-sample/", driver.getCurrentUrl());






    }
}
