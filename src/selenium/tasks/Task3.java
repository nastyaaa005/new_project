package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
    public void feedback1() {
// TODO:

//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
        WebElement myName = driver.findElement(By.id("fb_name"));
        myName.sendKeys("Bobby");

        WebElement myAge = driver.findElement(By.id("fb_age"));
        myAge.sendKeys("28");

        WebElement english = driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'"));
        WebElement chinese = driver.findElement(By.cssSelector(".w3-check[value='Chinese'][type='checkbox'"));
        english.click();

        chinese.click();

        WebElement female = driver.findElement(By.cssSelector(".w3-radio[value='female'][type='radio'"));
        female.click();

        Select dropdown = new Select(driver.findElement(By.id("like_us")));
        dropdown.selectByValue("Ok, i guess");

        WebElement comment = driver.findElement(By.name("comment"));
        comment.sendKeys("I am not writing a comment!");

//        check that the button send is blue with white letters
        WebElement sendButton = driver.findElement(By.cssSelector(".w3-btn-block[type='submit']"));
        assertEquals("rgba(33, 150, 243, 1)", sendButton.getCssValue("background-color"));
        assertEquals(("rgba(255, 255, 255, 1)"), sendButton.getCssValue("color"));

//        click "send"
        sendButton.click();

//        check that the feedback was filled correctly
        assertEquals("Bobby", driver.findElement(By.id("name")).getText());
        assertEquals("28", driver.findElement(By.id("age")).getText());
        assertEquals("English,Chinese", driver.findElement(By.id("language")).getText());
        assertEquals("female", driver.findElement(By.id("gender")).getText());
        assertEquals("Ok, i guess", driver.findElement(By.id("option")).getText());
        assertEquals("I am not writing a comment!", driver.findElement(By.id("comment")).getText());

//        check that the button yes is green and no is red but both have white letters
        WebElement yesButton = driver.findElement(By.cssSelector(".w3-green[onclick='openFeedback()']"));
        WebElement noButton = driver.findElement(By.cssSelector(".w3-red[onclick='window.history.back();']"));
        assertEquals(("rgba(76, 175, 80, 1)"), yesButton.getCssValue("background-color"));
        assertEquals(("rgba(255, 255, 255, 1)"), yesButton.getCssValue("color"));
        assertEquals(("rgba(244, 67, 54, 1)"), noButton.getCssValue("background-color"));
        assertEquals(("rgba(255, 255, 255, 1)"), yesButton.getCssValue("color"));

        yesButton.click();

//        check that the message after clicking on YES is displayed correctly
        assertEquals("Thank you, Bobby, for your feedback!", driver.findElement(By.id("message")).getText());

    }

    @Test
    public void feedback2() {
//         Scenario when after submitting press NO and make some changes
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
    WebElement myName = driver.findElement(By.id("fb_name"));
    myName.sendKeys("Bobby");

    WebElement myAge = driver.findElement(By.id("fb_age"));
    myAge.sendKeys("28");

    WebElement english = driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'"));
    WebElement chinese = driver.findElement(By.cssSelector(".w3-check[value='Chinese'][type='checkbox'"));
    english.click();

    chinese.click();

    WebElement female = driver.findElement(By.cssSelector(".w3-radio[value='female'][type='radio'"));
    female.click();

    Select dropdown = new Select(driver.findElement(By.id("like_us")));
    dropdown.selectByValue("Ok, i guess");

    WebElement comment = driver.findElement(By.name("comment"));
    comment.sendKeys("I am not writing a comment!");

//        check that the button send is blue with white letters
    WebElement sendButton = driver.findElement(By.cssSelector(".w3-btn-block[type='submit']"));
    assertEquals("rgba(33, 150, 243, 1)", sendButton.getCssValue("background-color"));
    assertEquals(("rgba(255, 255, 255, 1)"), sendButton.getCssValue("color"));

//        click "send"
    sendButton.click();

//        check that the feedback was filled correctly
    assertEquals("Bobby", driver.findElement(By.id("name")).getText());
    assertEquals("28", driver.findElement(By.id("age")).getText());
    assertEquals("English,Chinese", driver.findElement(By.id("language")).getText());
    assertEquals("female", driver.findElement(By.id("gender")).getText());
    assertEquals("Ok, i guess", driver.findElement(By.id("option")).getText());
    assertEquals("I am not writing a comment!", driver.findElement(By.id("comment")).getText());

    WebElement yesButton = driver.findElement(By.cssSelector(".w3-green[onclick='openFeedback()']"));
    WebElement noButton = driver.findElement(By.cssSelector(".w3-red[onclick='window.history.back();']"));
    assertEquals(("rgba(76, 175, 80, 1)"), yesButton.getCssValue("background-color"));
    assertEquals(("rgba(255, 255, 255, 1)"), yesButton.getCssValue("color"));
    assertEquals(("rgba(244, 67, 54, 1)"), noButton.getCssValue("background-color"));
    assertEquals(("rgba(255, 255, 255, 1)"), yesButton.getCssValue("color"));

//         click "no" button
    noButton.click();

//         check if all filled information is same as before
    myName = driver.findElement(By.id("fb_name"));
    myAge = driver.findElement(By.id("fb_age"));
    english = driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'"));
    chinese = driver.findElement(By.cssSelector(".w3-check[value='Chinese'][type='checkbox'"));
    female = driver.findElement(By.cssSelector(".w3-radio[value='female'][type='radio'"));
    dropdown = new Select(driver.findElement(By.id("like_us")));
    comment = driver.findElement(By.name("comment"));
    sendButton = driver.findElement(By.cssSelector(".w3-btn-block[type='submit']"));

    assertEquals("Bobby", myName.getAttribute("value"));
    assertEquals("28", myAge.getAttribute("value"));
    assertTrue(english.isSelected());
    assertTrue(chinese.isSelected());
    assertTrue(female.isSelected());
    assertEquals("Ok, i guess", dropdown.getFirstSelectedOption().getText());
    assertEquals("I am not writing a comment!", comment.getAttribute("value"));

//      clear field "Name" and unchecked "Chinese" language
    myName.clear();
    chinese.click();

//      check if "Name" field is cleared
        assertEquals("", myName.getAttribute("value"));

//      check if "Chinese" checkbox is unchecked
        assertFalse(chinese.isSelected());

//      click on "send" button
    sendButton.click();

//      check if all filled information is correct and with changes
    assertEquals("", driver.findElement(By.id("name")).getText());
    assertEquals("28", driver.findElement(By.id("age")).getText());
    assertEquals("English", driver.findElement(By.id("language")).getText());
    assertEquals("female", driver.findElement(By.id("gender")).getText());
    assertEquals("Ok, i guess", driver.findElement(By.id("option")).getText());
    assertEquals("I am not writing a comment!", driver.findElement(By.id("comment")).getText());

//      click on "yes" button
    yesButton = driver.findElement(By.cssSelector(".w3-green[onclick='openFeedback()']"));

    yesButton.click();

//      check that the message after clicking on YES is displayed correctly
    assertEquals("Thank you for your feedback!", driver.findElement(By.id("message")).getText());

    }
}
