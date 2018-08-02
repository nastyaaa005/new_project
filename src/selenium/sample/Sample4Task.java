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
//        enter a number under "Number"
        WebElement enterNumber = driver.findElement(By.id("number"));
        WebElement resultButton = driver.findElement(By.id("result_button_number"));
        WebElement resultText = driver.findElement(By.id("result_number"));
        WebElement clearButton = driver.findElement(By.id("clear_result_button_number"));
        String stringNumber1 = "89";
        String stringNumber2 = "You entered number: ";

        enterNumber.clear();
        assertEquals(enterNumber.getAttribute("value"), "");
        enterNumber.sendKeys(stringNumber1);

        assertEquals(enterNumber.getAttribute("value"), stringNumber1);

//        check that button is not clickable
//        assertFalse(resultButton.isEnabled());
        assertTrue(resultButton.isEnabled());

//        click on "Result" button
        resultButton.click();

//        check that text is displayed
        assertTrue(resultText.isDisplayed());

//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
        assertEquals(stringNumber2 + '"' + stringNumber1 + "\"", resultText.getText());
        assertEquals(stringNumber2 + '"' + stringNumber1 + '"', resultText.getText());
        assertEquals(stringNumber2 + "\"" + stringNumber1 + "\"", resultText.getText());
        assertEquals(stringNumber2 + "\"" + stringNumber1 + '"', resultText.getText());

//        check that the button "Clear Result" is clickable now
        assertTrue(clearButton.isEnabled());

//        click on "Clear Result"
        clearButton.click();
        assertEquals("", resultText.getText());

//        check that the text is still ("You entered number: "NUMBER YOU ENTERED""), but it is not displayed
        assertFalse(resultText.isDisplayed());
    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
        assertEquals(base_url, driver.getCurrentUrl());
//        click on "This is a link to Homepage"
        driver.findElement(By.id("homepage_link")).click();
//        check that current url is not base_url
        assertFalse(driver.getCurrentUrl().equals(base_url));
//        verify that current url is homepage
        assertEquals("https://kristinek.github.io/test-sample/", driver.getCurrentUrl());
    }
}
