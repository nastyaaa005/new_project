package selenium.tasks;

import org.openqa.selenium.support.PageFactory;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void feedbackData() {
        WebElement name=driver.findElement(By.cssSelector("#fb_name"));
        WebElement age=driver.findElement(By.cssSelector("#fb_age"));
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check"));
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-radio"));
        Select dropdown= new Select(driver.findElement(By.id("like_us")));
        WebElement comment=driver.findElement(By.cssSelector("[name=\"comment\"]"));
        WebElement submit= driver.findElement(By.cssSelector("[type=\"submit\"]"));

        name.clear();
        name.sendKeys("Vanda");
        assertEquals("Vanda",name.getAttribute("value"));
        age.clear();
        age.sendKeys("23");
        assertEquals("23",age.getAttribute("value"));
        for (WebElement checkBox : checkBoxes) {
            try {
                assertFalse(checkBox.isSelected()); // checkboxes are NOT selected
            }catch(java.lang.AssertionError e){ checkBox.click();}
        }
        WebElement English=driver.findElement(By.cssSelector("[value=\"English\"]"));
        English.click();
        assertTrue(English.isSelected());
        String language=English.getAttribute("value");
        WebElement Spanish=driver.findElement(By.cssSelector("[value=\"Spanish\"]"));
        Spanish.click();
        assertTrue(Spanish.isSelected());
        language+=","+Spanish.getAttribute("value");

        for (WebElement radioButton : radioButtons) {
            if(radioButton.isEnabled()){
            assertFalse(radioButton.isSelected());
            radioButton.click();
            assertTrue(radioButton.isSelected());
        }}
        WebElement woman=driver.findElement(By.cssSelector("[value=\"female\"]"));
        woman.click();
        assertTrue(woman.isSelected());
        assertFalse(driver.findElement(By.cssSelector("[value=\"male\"]")).isSelected());

        assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Why me?");
        assertEquals(dropdown.getFirstSelectedOption().getText(),"Why me?");
        comment.clear();
        comment.sendKeys("Why not?");
        assertEquals(comment.getAttribute("value"),"Why not?");

        assertEquals("rgba(255, 255, 255, 1)", submit.getCssValue("color"));
        assertEquals("rgba(33, 150, 243, 1)", submit.getCssValue("background-color"));
        submit.click();

        //check feedback
        assertFalse(driver.getCurrentUrl().equals("https://kristinek.github.io/test-sample/tasks/task4"));
        assertEquals(driver.findElement(By.id("name")).getText(),"Vanda");
        assertEquals(driver.findElement(By.id("age")).getText(),"23");
        assertEquals(driver.findElement(By.id("language")).getText(),language);
        assertEquals(driver.findElement(By.id("gender")).getText(),"female");
        assertEquals(driver.findElement(By.id("option")).getText(),"Why me?");
        assertEquals(driver.findElement(By.id("comment")).getText(),"Why not?");

        WebElement yesButton=driver.findElement(By.cssSelector(".w3-green"));
        WebElement noButton=driver.findElement(By.cssSelector(".w3-red"));

        assertEquals("rgba(76, 175, 80, 1)", yesButton.getCssValue("background-color"));
        assertEquals("rgba(244, 67, 54, 1)", noButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", yesButton.getCssValue("color"));
        assertEquals("rgba(255, 255, 255, 1)", noButton.getCssValue("color"));
        noButton.click();


        name=driver.findElement(By.cssSelector("#fb_name"));
        age=driver.findElement(By.cssSelector("#fb_age"));
        dropdown= new Select(driver.findElement(By.id("like_us")));
        comment=driver.findElement(By.cssSelector("[name=\"comment\"]"));
        submit= driver.findElement(By.cssSelector("[type=\"submit\"]"));
        woman=driver.findElement(By.cssSelector("[value=\"female\"]"));
        English=driver.findElement(By.cssSelector("[value=\"English\"]"));
        Spanish=driver.findElement(By.cssSelector("[value=\"Spanish\"]"));


        assertEquals(name.getAttribute("value"),"Vanda");
        assertEquals(age.getAttribute("value"),"23");
        assertEquals(name.getAttribute("value"),"Vanda");
        assertTrue(English.isSelected());
        assertTrue(Spanish.isSelected());
        assertTrue(woman.isSelected());
        assertEquals(dropdown.getFirstSelectedOption().getText(),"Why me?");
        assertEquals(comment.getAttribute("value"),"Why not?");
        age.clear();
        age.sendKeys("24");
        assertEquals(age.getAttribute("value"),"24");
        name.sendKeys(" Tomasa");
        assertEquals(name.getAttribute("value"),"Vanda Tomasa");
        submit.click();
        yesButton=driver.findElement(By.cssSelector(".w3-green"));
        yesButton.click();
        WebElement message=driver.findElement(By.id("message"));
        assertTrue(message.isDisplayed());
        assertEquals(message.getText(),"Thank you, Vanda Tomasa, for your feedback!");

// TODO:
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
//        check that the button send is blue with white letters
//        click "send"
//        check that the feedback was filled correctly
//        check that the button yes is green and no is red but both have white letters
    }

    @Test
    public void emptyForm(){
        WebElement submit= driver.findElement(By.cssSelector("[type=\"submit\"]"));
        assertTrue(driver.findElement(By.id("fb_name")).getAttribute("value").equals(""));
        assertTrue(driver.findElement(By.id("fb_age")).getAttribute("value").equals(""));
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check"));
        for (WebElement checkBox : checkBoxes) {
            try {
                assertFalse(checkBox.isSelected()); // checkboxes are NOT selected
            }catch(java.lang.AssertionError e){ checkBox.click();}
        }
        assertFalse(driver.findElement(By.cssSelector("[value=\"female\"]")).isSelected());
        assertFalse(driver.findElement(By.cssSelector("[value=\"male\"]")).isSelected());
        Select dropdown= new Select(driver.findElement(By.id("like_us")));
        assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText());
        assertTrue(driver.findElement(By.cssSelector("[name=\"comment\"]")).getAttribute("value").equals(""));
        submit.click();
        assertEquals(driver.findElement(By.id("name")).getText(),"");
        assertEquals(driver.findElement(By.id("age")).getText(),"");
        assertEquals(driver.findElement(By.id("language")).getText(),"");
        assertEquals(driver.findElement(By.id("gender")).getText(),"null");
        assertEquals(driver.findElement(By.id("option")).getText(),"null");
        assertEquals(driver.findElement(By.id("comment")).getText(),"");
        WebElement yesButton=driver.findElement(By.cssSelector(".w3-green"));
        yesButton.click();
        WebElement message=driver.findElement(By.id("message"));
        assertTrue(message.isDisplayed());
        assertEquals(message.getText(),"Thank you for your feedback!");
    }

    @Test
    public void checkDropdownOptions(){
        Select dropdown= new Select(driver.findElement(By.id("like_us")));
        assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Good");
        assertEquals("Good", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Ok, i guess");
        assertEquals("Ok, i guess", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Bad");
        assertEquals("Bad", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Why me?");
        assertEquals("Why me?", dropdown.getFirstSelectedOption().getText());
    }

}
