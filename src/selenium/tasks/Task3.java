package selenium.tasks;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        String sendKeyOne = "abc";
        nameField.sendKeys(sendKeyOne);

        WebElement ageField = driver.findElement(By.id("fb_age"));
        String sendKeyTwo = "12";
        ageField.sendKeys(sendKeyTwo);

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));

        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected());
        }

        WebElement English = driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox']"));
        English.click();
        WebElement French = driver.findElement(By.cssSelector(".w3-check[value='French'][type=checkbox]"));
        WebElement Spanish = driver.findElement(By.cssSelector(".w3-check[value='Spanish'][type=checkbox]"));
        WebElement Chinese = driver.findElement(By.cssSelector(".w3-check[value='Chinese'][type=checkbox]"));
        assertFalse(French.isSelected());
        assertFalse(Spanish.isSelected());
        assertFalse(Chinese.isSelected());
        assertTrue(English.isSelected());

        List<WebElement> Radios = driver.findElements(By.cssSelector(".w3-radio[type='radio']"));

        for (WebElement oneRadio : Radios) {
            assertFalse(oneRadio.isSelected());
        }

        WebElement Male = driver.findElement(By.cssSelector(".w3-radio[value='male'][type='checkbox']"));
        WebElement Female = driver.findElement(By.cssSelector(".w3-radio[value='female'][type='checkbox']"));
        WebElement DontKnow = driver.findElement(By.xpath("//a[.='Don't know (Disabled)']"));
        Female.click();

        assertFalse(Male.isSelected());
        assertFalse(DontKnow.isSelected());
        assertTrue(Female.isSelected());
    }
    @Test
    public void selectOptionByValue() {

        Select dropdown = new Select(driver.findElement(By.id("like_us")));
        assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("Why me?");
        assertEquals("Why me?", dropdown.getFirstSelectedOption().getText());
    }
        @Test
        public void addComment() {

            WebElement textInput = driver.findElement(By.className("comment"));

            String sendKeyOne = "qwerty";
            textInput.sendKeys(sendKeyOne);
        }

        @Test
                public void buttonSend() {
            assertEquals("rgb(33, 150, 243)",
                    driver.findElement(By.xpath("//*[@class='w3-btn-block w3-blue w3-section']"))
                            .getCssValue("background-color"));

            assertEquals("rgb(255, 255, 255)",
                    driver.findElement(By.xpath("//*[@class='w3-btn-block w3-blue w3-section']"))
                            .getCssValue("color"));

            WebElement sendButton = driver.findElement(By.className("w3-btn-block w3-blue w3-section"));
            sendButton.click();
        }

        @Test
                public void fbCheck() {
            WebElement name = driver.findElement(By.id("name"));
            String textInput = "abc";
            assertEquals(textInput,name.getText());

            WebElement age = driver.findElement(By.id("age"));
            String ageInput = "12";
            assertEquals(ageInput,age.getText());

            WebElement language = driver.findElement(By.id("language"));
            String languageInput = "English";
            assertEquals(languageInput,language.getText());

            WebElement gender = driver.findElement(By.id("gender"));
            String genderInput = "female";
            assertEquals(genderInput,gender.getText());

            WebElement option = driver.findElement(By.id("option"));
            String optionInput = "Why me?";
            assertEquals(optionInput,option.getText());

            WebElement comment = driver.findElement(By.id("comment"));
            String commentInput = "qwerty";
            assertEquals(commentInput,comment.getText());

        }
        assertEquals("rgb(76, 175, 80)",
                driver.findElement(By.xpath("//*[@class='w3-btn w3-green w3-xlarge']"))
                        .getCssValue("background-color"));

        assertEquals("rgb(255, 255, 255)",
                driver.findElement(By.xpath("//*[@class='w3-btn w3-green w3-xlarge']"))
                        .getCssValue("color"));

        assertEquals("rgb(244, 67, 54)",
                driver.findElement(By.xpath("//*[@class='w3-btn w3-red w3-xlarge']"))
                        .getCssValue("background-color"));

        assertEquals("rgb(255, 255, 255)",
                driver.findElement(By.xpath("//*[@class='w3-btn w3-red w3-xlarge']"))
                        .getCssValue("color"));



// TODO:
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
//        check that the button send is blue with white letters
//        click "send"
//        check that the feedback was filled correctly
//        check that the button yes is green and no is red but both have white letters
    }
}
