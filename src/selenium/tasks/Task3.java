package selenium.tasks;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

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
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
//        check that the button send is blue with white letters
//        click "send"
//        check that the feedback was filled correctly
//        check that the button yes is green and no is red but both have white letters

        String name = "Maria";
        String age = "35";

        driver.findElement(By.id("fb_name")).sendKeys(name);
        driver.findElement(By.id("fb_age")).sendKeys(age);
        driver.findElement(By.cssSelector(".w3-check[type='checkbox'][value='French']")).click();
        driver.findElement(By.cssSelector(".w3-radio[type='radio'][value='female']")).click();
        Select dropdown = new Select(driver.findElement(By.id("like_us")));
        dropdown.selectByVisibleText("Good");
        driver.findElement(By.name("comment")).sendKeys("Selenium");

        WebElement sendButton;
        sendButton = driver.findElement(By.cssSelector(".w3-btn-block[type='submit']"));
        assertEquals("rgba(33, 150, 243, 1)", sendButton.getCssValue("background-color"));
        assertEquals(("rgba(255, 255, 255, 1)"), sendButton.getCssValue("color"));
        sendButton.click();

        assertEquals(name, driver.findElement(By.id("name")).getText());
        assertEquals(age, driver.findElement(By.id("age")).getText());
        assertEquals("French", driver.findElement(By.id("language")).getText());
        assertEquals("female", driver.findElement(By.id("gender")).getText());
        assertEquals("Good", driver.findElement(By.id("option")).getText());
        assertEquals("Selenium", driver.findElement(By.id("comment")).getText());

        WebElement yesButton;
        yesButton = driver.findElement(By.cssSelector(".w3-green[onclick='openFeedback()']"));
        assertEquals(("rgba(76, 175, 80, 1)"), yesButton.getCssValue("background-color"));
        assertEquals(("rgba(255, 255, 255, 1)"), yesButton.getCssValue("color"));

        WebElement noButton;
        noButton = driver.findElement(By.cssSelector(".w3-red[onclick='window.history.back();']"));
        assertEquals(("rgba(244, 67, 54, 1)"), noButton.getCssValue("background-color"));
        assertEquals(("rgba(255, 255, 255, 1)"), noButton.getCssValue("color"));

        yesButton.click();
        String thankYouMessage = "Thank you, " + name + ", for your feedback!";
        assertEquals(thankYouMessage,driver.findElement(By.id("message")).getText());
    }
}
