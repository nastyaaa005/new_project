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
        WebElement numberInput=driver.findElement(By.id("number"));
        WebElement resultbuttont=driver.findElement(By.id("result_button_number"));
        WebElement result=driver.findElement(By.id("result_number"));
        WebElement clearButton=driver.findElement(By.id("clear_result_button_number"));
        String stringNumber="81";
        String enterNumber="your entered number";






        int originalNum=323;
        WebElement onClick=driver.findElement(By.id("result_button_number"));
        WebElement onClear=driver.findElement(By.id("clear_result_button_number"));
        driver.findElement(By.id("clear_result_button_number")).isEnabled();
        driver.findElement(By.id("result_button_number")).isDisplayed();
        driver.findElement(By.id("result_button_number")).isEnabled();

//         TODO:
//        enter a number under "Number"
//        check that button is not clickable
//        click on "Result" button
//        check that text is displayed
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
//        check that the button "Clear Result" is clickable now
//        click on "Clear Result"
//        check that the text is still ("You entered number: "NUMBER YOU ENTERED""), but it is not displayed
    }

    @Test
    public void clickOnLink() throws Exception {

        assertEquals(base_url, driver.getCurrentUrl());
        driver.findElement(By.id("link1")).click();
        assertEquals("Link Page 1", driver.findElement(By.id("h1")).getText());
        assertFalse(driver.getCurrentUrl().equals(base_url));
        assertEquals("https://kristinek.github.io/test-sample/examples/link1", driver.getCurrentUrl());
    }
//         TODO:
//        check current url is base_url
//        click on "This is a link to Homepage"
//        check that current url is not base_url
//        verify that current url is homepage
    }

