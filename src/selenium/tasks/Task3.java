package selenium.tasks;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task3 {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task4");
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void feedback() {
        WebElement nameField = driver.findElement(By.id("fb_name"));
        String nameText = "abc";
        nameField.sendKeys(nameText);
        assertEquals(nameText, nameField.getAttribute("value"));

        WebElement ageField = driver.findElement(By.id("fb_age"));
        String ageText = "12";
        ageField.sendKeys(ageText);
        assertEquals(ageText, ageField.getAttribute("value"));

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));

        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected());
        }

        WebElement English = driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox']"));
        English.click();
        WebElement French = driver.findElement(By.cssSelector(".w3-check[value='French'][type=checkbox]"));
        WebElement Spanish = driver.findElement(By.cssSelector(".w3-check[value='Spanish'][type=checkbox]"));
        Spanish.click();
        WebElement Chinese = driver.findElement(By.cssSelector(".w3-check[value='Chinese'][type=checkbox]"));
        assertFalse(French.isSelected());
        assertTrue(Spanish.isSelected());
        assertFalse(Chinese.isSelected());
        assertTrue(English.isSelected());


        WebElement Male = driver.findElement(By.cssSelector(".w3-radio[value='male'][type='radio']"));
        WebElement Female = driver.findElement(By.cssSelector(".w3-radio[value='female'][type='radio']"));
        WebElement DontKnow = driver.findElement(By.cssSelector(".w3-radio:nth-of-type(3)"));

        assertFalse(Male.isSelected());
        assertTrue(DontKnow.isSelected());
        assertFalse(Female.isSelected());
        assertFalse(DontKnow.isEnabled());

        Female.click();

        assertFalse(Male.isSelected());
        assertFalse(DontKnow.isSelected());
        assertTrue(Female.isSelected());


        Select dropdown = new Select(driver.findElement(By.id("like_us")));

        assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("Why me?");
        assertEquals("Why me?", dropdown.getFirstSelectedOption().getText());

            WebElement textInput = driver.findElement(By.name("comment"));

            String commentText = "qwerty";
            textInput.sendKeys(commentText);
            assertEquals(commentText, textInput.getAttribute("value"));


            assertEquals("rgba(33, 150, 243, 1)",
                    driver.findElement(By.xpath("//*[@class='w3-btn-block w3-blue w3-section']"))
                            .getCssValue("background-color"));

            assertEquals("rgba(255, 255, 255, 1)",
                    driver.findElement(By.xpath("//*[@class='w3-btn-block w3-blue w3-section']"))
                            .getCssValue("color"));

            WebElement sendButton = driver.findElement(By.xpath("//*[@class='w3-btn-block w3-blue w3-section']"));
            sendButton.click();

            WebElement name = driver.findElement(By.id("name"));
            assertEquals(nameText, name.getText());

            WebElement age = driver.findElement(By.id("age"));
            assertEquals(ageText,age.getText());

            WebElement language = driver.findElement(By.id("language"));
            assertEquals("English,Spanish",language.getText());

            WebElement gender = driver.findElement(By.id("gender"));
            assertEquals("female",gender.getText());

            WebElement option = driver.findElement(By.id("option"));
            assertEquals("Why me?",option.getText());

            WebElement comment = driver.findElement(By.id("comment"));
            assertEquals("qwerty",comment.getText());


        assertEquals("rgba(76, 175, 80, 1)",
                driver.findElement(By.xpath("//*[@class='w3-btn w3-green w3-xlarge']"))
                        .getCssValue("background-color"));

        assertEquals("rgba(255, 255, 255, 1)",
                driver.findElement(By.xpath("//*[@class='w3-btn w3-green w3-xlarge']"))
                        .getCssValue("color"));

        assertEquals("rgba(244, 67, 54, 1)",
                driver.findElement(By.xpath("//*[@class='w3-btn w3-red w3-xlarge']"))
                        .getCssValue("background-color"));

        assertEquals("rgba(255, 255, 255, 1)",
                driver.findElement(By.xpath("//*[@class='w3-btn w3-red w3-xlarge']"))
                        .getCssValue("color"));
//
//
//
//// TODO:
////        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
////        check that the button send is blue with white letters
////        click "send"
////        check that the feedback was filled correctly
////        check that the button yes is green and no is red but both have white letters
//    }
    }
}
