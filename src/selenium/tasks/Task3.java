package selenium.tasks;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
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
// TODO:
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment

        driver.findElement(By.id("fb_name")).sendKeys("Mary");
        driver.findElement(By.id("fb_age")).sendKeys("18");
        assertTrue(driver.findElement(By.cssSelector("#lang_check > input:nth-child(2)")).isSelected());
        driver.findElement(By.className("w3-validate")).isSelected(); // -> true/false
        driver.findElement(By.className("w3-select")).isSelected(); // -> true/false
        driver.findElement(By.name("comment")).sendKeys("Everything is good. Thank you.");

//        check that the button send is blue with white letters
        WebElement sendButton = driver.findElement(By.className("w3-btn-block"));
        assertEquals("rgba(33, 150, 243, 1)", sendButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", sendButton.getCssValue("color"));
//        click "send"

        driver.findElement(By.className("w3-btn-block w3-blue w3-section")).click();

//        check that the feedback was filled correctly

        assertTrue(driver.findElement(By.className("w3-btn-group")).getText().equals("Everything is good. Thank you."));

//        check that the button yes is green and no is red but both have white letters

        WebElement sendButton = driver.findElement(By.className("w3-btn w3-green w3-xlarge"));
        assertEquals("rgba(76, 175, 80)", sendButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255)", sendButton.getCssValue("color"));
        WebElement sendButton = driver.findElement(By.className("w3-btn w3-red w3-xlarge"));
        assertEquals("rgba(244, 67, 54)", sendButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255)", sendButton.getCssValue("color"));


//
}



