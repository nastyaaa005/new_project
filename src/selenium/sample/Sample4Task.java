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

        WebElement showButton = driver.findElement(By.id("result_button_number"));
        assertFalse(showButton.isEnabled()); // "Show" button is NOT enabled (clickable)

        WebElement textInput = driver.findElement(By.id("text"));
        textInput.sendKeys("88");

        WebElement enterNumber = driver.findElement(By.id("number"));

        assertTrue(clearButton.is.Enabled());
        clearButton.click();

//         TODO:
//        enter a number under "Number"
//        check that button is not clickable
//        click on "Result" button
//        check that text is displayed
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
//        check that the button "Clear Result" is clickable now
//        click on "Clear Result"
//        check that the text is still ("You entered number: "NUMBER YOU ENTERED""), but it is not displayed
        assertFalse(result.Text.isDisabled());
        assertEquals( expected "", result.Text.getText);
    }





    @Test
    public void clickOnLink() throws Exception {


        assertEquals(base_url, driver.getCurrentUrl());
        assertEquals("https://kristinek.github.io/test-sample/\"", driver.getCurrentUrl());
        assertFalse(driver.getCurrentUrl().equals(base_url));

    }

    //         TODO:
//        check current url is base_url
    assertEquals(base_url, driver.getCurrentUrl());

//        click on "This is a link to Homepage"

    WebElement link = driver.findElement(By.id("homepage_link")).click();

    //        check that current url is not base_url
    assertTrue(base_url, !Equals("https://kristinek.github.io/test-sample/"));
    //        verify that current url is homepage
    assertEquals(expected "https://kristinek.github.io/test-sample/", driver.getCurrentUrl());
}
}
