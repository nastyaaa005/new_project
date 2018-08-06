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
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
        String Name = "Jim Carrey";
        String Age = "56";
        driver.findElement(By.id("fb_name")).sendKeys(Name);
        driver.findElement(By.id("fb_age")).sendKeys(Age);
        driver.findElement(By.cssSelector(".w3-check[type='checkbox'][value='English']")).click();
        driver.findElement(By.cssSelector(".w3-check[type='checkbox'][value='Chinese']")).click();
        driver.findElement(By.cssSelector(".w3-radio[type='radio'][value='male']")).click();
        Select dropdown = new Select(driver.findElement(By.name("option")));
        dropdown.selectByVisibleText("Ok, i guess");
        driver.findElement(By.name("comment")).sendKeys("this is a comment");

//        check that the button send is blue with white letters
        WebElement SendButton = driver.findElement(By.cssSelector(".w3-btn-block[type='submit']"));
        assertEquals("rgba(33, 150, 243, 1)", SendButton.getCssValue("background-color"));
        assertEquals(("rgba(255, 255, 255, 1)"), SendButton.getCssValue("color"));

//        click "send"
        SendButton.click();

//        check that the feedback was filled correctly
        assertEquals(Name, driver.findElement(By.id("name")).getText());
        assertEquals(Age, driver.findElement(By.id("age")).getText());
        assertEquals("English,Chinese", driver.findElement(By.id("language")).getText());
        assertEquals("male", driver.findElement(By.id("gender")).getText());
        assertEquals("Ok, i guess", driver.findElement(By.id("option")).getText());
        assertEquals("this is a comment", driver.findElement(By.id("comment")).getText());

//        check that the button yes is green and no is red but both have white letters
        WebElement YesButton = driver.findElement(By.cssSelector(".w3-btn.w3-green.w3-xlarge[onclick='openFeedback()']"));
        WebElement NoButton = driver.findElement(By.cssSelector(".w3-btn.w3-red.w3-xlarge[onclick='window.history.back();']"));
        assertEquals(("rgba(76, 175, 80, 1)"), YesButton.getCssValue("background-color"));
        assertEquals(("rgba(244, 67, 54, 1)"), NoButton.getCssValue("background-color"));
        assertEquals(("rgba(255, 255, 255, 1)"), YesButton.getCssValue("color"));
        assertEquals(("rgba(255, 255, 255, 1)"), NoButton.getCssValue("color"));

        // checking colors and text of the Thank you screen
        YesButton.click();
        WebElement ThankYouFieldText = driver.findElement(By.id("message"));
        assertEquals(("rgba(255, 255, 255, 1)"), ThankYouFieldText.getCssValue("color"));
        WebElement ThankYouFieldBackground = driver.findElement(By.cssSelector(".w3-panel.w3-green"));
        assertEquals(("rgba(76, 175, 80, 1)"), ThankYouFieldBackground.getCssValue("background-color"));
        assertEquals("Thank you, Jim Carrey, for your feedback!", ThankYouFieldText.getText());

    }
}
