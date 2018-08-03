package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/test-sample/examples/act";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
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
    public void selectCheckBox() throws Exception {
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));

        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected());
        }

        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type=checkbox"));
        option2.click();

        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type=checkbox"));

        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type=checkbox"));

        assertFalse(option1.isSelected());
        assertFalse(option3.isSelected());
        assertTrue(option2.isSelected());

        option3.click();

        driver.findElement(By.id("result_button_checkbox")).click();
        WebElement resultText = driver.findElement(By.id("result_checkbox"));
        assertTrue(resultText.isDisplayed());
        assertEquals("You selected value(s): Option 2, Option 3", resultText.getText());
    }


//         TODO:
//        check that none of the checkboxes are ticked
//        tick  "Option 2"
//        check that "Option 1" and "Option 3' are not ticked, but "Option 2" is ticked
//        tick  "Option 3"
//        click result
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed



    @Test
    public void selectRadioButton() throws Exception {
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));

        for (WebElement radioButton : radioButtons) {
            assertFalse(radioButton.isSelected());

        }

        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio'"));

        option3.click();

        WebElement option1 = driver.findElement(By.id("vfb-7-1"));
        WebElement option2 = driver.findElement(By.id("vfb-7-2"));


        assertFalse(option1.isSelected());
        assertFalse(option2.isSelected());
        assertTrue(option3.isSelected());

        option1.click();

        for (WebElement oneRadio : radioButtons) {
            if (oneRadio.getAttribute("value").equals(option1.getAttribute("value"))) {
                assertTrue(oneRadio.isSelected());
            } else {
                assertFalse(oneRadio.isSelected());
            }

        }
        driver.findElement(By.id("result_button_ratio")).click();
        WebElement text = driver.findElement(By.id("result_radio"));
        assertTrue(text.isDisplayed());
        assertEquals("You selected option: Option 1", text.getText());
    }




//         TODO:
//        check that none of the radio are selected
//        select  "Option 3"
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
//        select  "Option 1"
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
//        click result
//        check that 'You selected option: Option 1' text is being displayed


    @Test
    public void selectOption() throws Exception {
        Select select = new Select(driver.findElement(By.id("vfb-12")));
        select.selectByValue("value3");
        assertEquals("Option 3", select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 2");

        assertEquals("Option 2", select.getFirstSelectedOption().getText());

        driver.findElement(By.id("result_button_select")).click();

        WebElement text = driver.findElement(By.id("result_select"));
        assertTrue(text.isDisplayed());
        assertEquals("You selected option: Option 2", text.getText());




//         TODO:
//        select "Option 3" in Select
//        check that selected option is "Option 3"
//        select "Option 2" in Select
//        check that selected option is "Option 2"
//        click result
//        check that 'You selected option: Option 2' text is being displayed
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
//        check that correct date is added
    }
}
