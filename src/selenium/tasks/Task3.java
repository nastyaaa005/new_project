package selenium.tasks;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

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
// TODO:
        String name = "John";
        String age = "22";

//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
        driver.findElement(By.id("fb_name")).sendKeys(name);
        driver.findElement(By.id("fb_age")).sendKeys(age);
        driver.findElement(By.cssSelector(".w3-check[type='checkbox'][value='English']")).click();
        driver.findElement(By.cssSelector(".w3-radio[type='radio'][value='male']")).click();
        Select dropdown = new Select(driver.findElement(By.name("option")));
        dropdown.selectByVisibleText("Why me?");
        driver.findElement(By.name("comment")).sendKeys("A comment");

//        check that the button send is blue with white letters
        WebElement sendButton = driver.findElement(By.cssSelector(".w3-btn-block[type='submit']"));
        assertEquals("rgba(33, 150, 243, 1)", sendButton.getCssValue("background-color"));
        assertEquals(("rgba(255, 255, 255, 1)"), sendButton.getCssValue("color"));

//        click "send"
        sendButton.click();

//        check that the feedback was filled correctly
        assertEquals(name, driver.findElement(By.id("name")).getText());
        assertEquals(age, driver.findElement(By.id("age")).getText());
        assertEquals("English", driver.findElement(By.id("language")).getText());
        assertEquals("male", driver.findElement(By.id("gender")).getText());
        assertEquals("Why me?", driver.findElement(By.id("option")).getText());
        assertEquals("A comment", driver.findElement(By.id("comment")).getText());

//        check that the button yes is green and no is red but both have white letters
        WebElement yesButton = driver.findElement(By.cssSelector(".w3-green[onclick='openFeedback()']"));
        WebElement noButton = driver.findElement(By.cssSelector(".w3-red[onclick='window.history.back();']"));
        assertEquals(("rgba(76, 175, 80, 1)"), yesButton.getCssValue("background-color"));
        assertEquals(("rgba(255, 255, 255, 1)"), yesButton.getCssValue("color"));
        assertEquals(("rgba(244, 67, 54, 1)"), noButton.getCssValue("background-color"));
        assertEquals(("rgba(255, 255, 255, 1)"), yesButton.getCssValue("color"));

//        check that the "thank you" message is green with white letters
        yesButton.click();
        String thankYouMessage = "Thank you, " + name + ", for your feedback!";
        assertEquals(thankYouMessage,driver.findElement(By.id("message")).getText());
    }
}
