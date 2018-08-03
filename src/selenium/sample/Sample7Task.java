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
        List<WebElement> boxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for(WebElement box : boxes)
        {
            assertFalse(box.isSelected());
        }
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox'"));
        driver.findElement(By.id("vfb-6-1")).click();
        assertFalse(driver.findElement(By.id("vfb-6-0")).isSelected());
        assertFalse(driver.findElement(By.id("vfb-6-2")).isSelected());
        assertTrue(driver.findElement(By.id("vfb-6-1")).isSelected());

        driver.findElement(By.id("vfb-6-2")).click();
        driver.findElement(By.id("result_button_checkbox")).click();
        assertEquals("You selected value(s): Option 2, Option 3", driver.findElement(By.id("result_checkbox")).getText());

//        check that none of the checkboxes are ticked
//        tick  "Option 2"
//        check that "Option 1" and "Option 3' are not ticked, but "Option 2" is ticked
//        tick  "Option 3"
//        click result
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
    }


    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
        List<WebElement> radios = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
        for(WebElement radio : radios)
        {
            assertFalse(radio.isSelected());
        }
        radios.get(2).click();
        assertFalse(radios.get(0).isSelected());
        assertFalse(radios.get(1).isSelected());
        assertTrue(radios.get(2).isSelected());

        radios.get(0).click();
        assertFalse(radios.get(2).isSelected());
        assertFalse(radios.get(1).isSelected());
        assertTrue(radios.get(0).isSelected());

        driver.findElement(By.id("result_button_ratio")).click();
        assertEquals("You selected option: Option 1", driver.findElement(By.id("result_radio")).getText());

//        check that none of the radio are selected
//        select  "Option 3"
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
//        select  "Option 1"
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
//        click result
//        check that 'You selected option: Option 1' text is being displayed
    }

    @Test
    public void selectOption() throws Exception {
//         TODO:
        Select selector = new Select(driver.findElement(By.id("vfb-12")));
        selector.selectByValue("value3");
        assertEquals("Option 3",selector.getFirstSelectedOption().getText());
        selector.selectByValue("value2");
        assertEquals("Option 2",selector.getFirstSelectedOption().getText());
        driver.findElement(By.id("result_button_select")).click();
        assertEquals("You selected option: Option 2", driver.findElement(By.id("result_select")).getText());

//        select "Option 3" in Select
//        check that selected option is "Option 3"
//        select "Option 2" in Select
//        check that selected option is "Option 2"
//        click result
//        check that 'You selected option: Option 2' text is being displayed
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {

        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        assertEquals("", dateBox.getAttribute("value"));
        dateBox.click();
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
//    go back 10 month in calendar on page
        for (int i = 0; i < 133; i++) {
            dateWidget.findElement(By.className("ui-datepicker-prev")).click();
        }
        dateWidget.findElement(By.xpath("//a[text()='4']")).click();

        assertEquals("07/04/2007", dateBox.getAttribute("value"));
        dateBox.clear();
//         TODO:
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
        driver.findElement(By.id("vfb-8")).sendKeys("05/02/1959");
        //driver.findElement(By.id("result_button_date")).click();
        WebElement button =  driver.findElement(By.id("result_button_date"));
        System.out.println(button.getAttribute("onclick"));
        button.click();
        //System.out.println(driver.findElement(By.id("result_button_date")).getAttribute("onclick"));
        //driver.findElement(By.id("result_button_date")).click();
        assertEquals("You entered date: 05/02/1959", driver.findElement(By.id("result_date")).getText());
//        enter date '2 of May 1959' using text
//        check that correct date is added
    }
}
