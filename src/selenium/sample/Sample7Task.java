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
//         TODO:
//        check that none of the checkboxes are ticked
        List<WebElement> manyCheckBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));

        for (WebElement oneCheckBox : manyCheckBoxes) {
            assertFalse(oneCheckBox.isSelected());
        }


//        tick  "Option 2"
//        check that "Option 1" and "Option 3' are not ticked, but "Option 2" is ticked
                WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='checkbox'"));
                WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox'"));
                WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox'"));
                WebElement resultText = driver.findElement(By.id("result_checkbox"));

                option2.click();
                assertFalse(option1.isSelected());
                assertTrue(option2.isSelected());
                assertFalse(option3.isSelected());

//        tick  "Option 3"
                option3.click();
                assertFalse(option1.isSelected());
                assertTrue(option2.isSelected());
                assertTrue(option3.isSelected());

//        click result
                driver.findElement(By.cssSelector("#result_button_checkbox")).click();

//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
                assertTrue(resultText.isDisplayed());
                assertEquals("You selected value(s): Option 2, Option 3", resultText.getText());



        }

            @Test
            public void selectRadioButton() throws Exception {
//         TODO:
//        check that none of the radio are selected
                List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));

                for (WebElement radioButton : radioButtons) {
                    assertFalse(radioButton.isSelected());

                }

//        select  "Option 3"
                WebElement option1 = driver.findElement(By.cssSelector("#vfb-7-1"));
                WebElement option2 = driver.findElement(By.cssSelector("#vfb-7-2"));
                WebElement option3 = driver.findElement(By.cssSelector("#vfb-7-3"));
                WebElement resultButtonRadio = driver.findElement(By.cssSelector("#result_button_ratio"));
                WebElement resultText = driver.findElement(By.cssSelector("#result_radio"));
                assertFalse(option3.isSelected());
                option3.click();

//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
                assertFalse(option1.isSelected());
                assertFalse(option2.isSelected());
                assertTrue(option3.isSelected());

//        select  "Option 1"
                option1.click();

//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
                for (WebElement radioButton : radioButtons) {
                    if (radioButton.getAttribute("value").equals(option1.getAttribute("value"))) {
                        assertTrue(radioButton.isSelected());
                    } else {
                        assertFalse(radioButton.isSelected());
                    }
                }

//        click result
                resultButtonRadio.click();

//        check that 'You selected option: Option 1' text is being displayed
                assertTrue(resultText.isDisplayed());
                assertEquals("You selected option: Option 1", resultText.getText());
            }

            @Test
            public void selectOption ()throws Exception {
//         TODO:
//        select "Option 3" in Select
                Select mySelector = new Select(driver.findElement(By.id("vfb-12")));
                mySelector.selectByValue("value");

//        check that selected option is "Option 3"
                assertEquals("Option 3", mySelector.getFirstSelectedOption().getText());

//        select "Option 2" in Select
                mySelector.selectByVisibleText("Option 2");

//        check that selected option is "Option 2"
                assertEquals("Option 2", mySelector.getFirstSelectedOption().getText());

//        click result
                driver.findElement(By.id("result_button_select")).click();

//        check that 'You selected option: Option 2' text is being displayed
                WebElement text = driver.findElement(By.id("result_select"));
                assertTrue(text.isDisplayed());
                assertEquals("You selected option: Option 2", text.getText());
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


