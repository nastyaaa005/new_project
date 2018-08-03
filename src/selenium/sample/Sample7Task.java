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
    public void selectCheckBox() throws Exception {
//         TODO:
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected());
            checkBox.click();
            assertTrue(checkBox.isSelected());
            checkBox.click();
            assertFalse(checkBox.isSelected());
        }
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox'"));
        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='checkbox'"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox'"));
        WebElement result=driver.findElement(By.cssSelector("#result_button_checkbox"));
        WebElement resultText=driver.findElement(By.cssSelector("#result_checkbox"));
//        check that none of the checkboxes are ticked
//        tick  "Option 2"
        option2.click();
//        check that "Option 1" and "Option 3' are not ticked, but "Option 2" is ticked
        assertTrue(option2.isSelected());
        assertFalse(option3.isSelected());
        assertFalse(option1.isSelected());
//        tick  "Option 3"
        option3.click();
//        click result
        result.click();
        assertTrue(resultText.isDisplayed());
        assertEquals("You selected value(s): Option 2, Option 3",resultText.getText());
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed

    }


    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio'"));
        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='radio'"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio'"));
        WebElement result=driver.findElement(By.cssSelector("#result_button_ratio"));
        WebElement resultText=driver.findElement(By.cssSelector("#result_radio"));

//        check that none of the radio are selected
        assertFalse(option1.isSelected());
        assertFalse(option2.isSelected());
        assertFalse(option3.isSelected());
//        select  "Option 3"
        option3.click();
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
        assertFalse(option1.isSelected());
        assertFalse(option2.isSelected());
        assertTrue(option3.isSelected());
//        select  "Option 1"
        option1.click();
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
        assertTrue(option1.isSelected());
        assertFalse(option2.isSelected());
        assertFalse(option3.isSelected());
//        click result
        result.click();
        assertEquals("You selected option: Option 1",resultText.getText());
//        check that 'You selected option: Option 1' text is being displayed
    }

    @Test
    public void selectOption() throws Exception {
        //         TODO:
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));  //dropdown
        assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText()); //ka ir default
        //        select "Option 3" in Select
        //        check that selected option is "Option 3"
        dropdown.selectByVisibleText("Option 3");
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());
        //        select "Option 2" in Select
        dropdown.selectByVisibleText("Option 2");
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());
        //        check that selected option is "Option 2"
        WebElement result=driver.findElement(By.cssSelector("#result_button_select"));
        WebElement resultText=driver.findElement(By.cssSelector("#result_select"));
        //        click result
        //       check that 'You selected option: Option 2' text is being displayed
        result.click();
        assertEquals("You selected option: Option 2", resultText.getText());

    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
//        enter date '4 of July 2007' using calendar widget
        Calendar cal = Calendar.getInstance(); //todays date 08/03/2018
        cal.add(Calendar.MONTH, -1);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.YEAR,-1);
        String result = new SimpleDateFormat("MM/dd/yyyy").format(cal.getTime());
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        assertEquals("07/04/2017", result);
//        check that correct date is added
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
        String dateToEnter = "05/02/1959";
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        dateBox.clear();
        assertEquals("", dateBox.getAttribute("value"));
        dateBox.sendKeys(dateToEnter);
        assertEquals(dateToEnter, dateBox.getAttribute("value"));
//        enter date '2 of May 1959' using text
//        check that correct date is added
    }
}
