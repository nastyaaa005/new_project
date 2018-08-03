package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Sample8Task {
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
        driver.get("https://kristinek.github.io/test-sample/examples/po");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void styleChecks() throws Exception {
//         TODO:
        WebElement lr = driver.findElement(By.cssSelector(".w3-pale-red"));
        assertEquals("rgba(255, 221, 221, 1)", lr.getCssValue("background-color"));
//        check the background of top 2 sections
        WebElement ld = driver.findElement(By.cssSelector(".w3-pale-yellow"));
        assertEquals("rgba(255, 255, 204, 1)", ld.getCssValue("background-color"));
//        check h1 element font-size 64px
        WebElement h1 = driver.findElement(By.cssSelector(".w3-jumbo"));
        assertEquals("64px", h1.getCssValue("font-size"));
    }
}
