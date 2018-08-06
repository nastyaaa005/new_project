package selenium.tasks;

import org.junit.*;
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
    public void feedback() {
// TODO:
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
//        check that the button send is blue with white letters
//        click "send"
//        check that the feedback was filled correctly
//        check that the button yes is green and no is red but both have white letters
        WebElement enterName = driver.findElement(By.id("fb_name"));
        WebElement enterAge = driver.findElement(By.id("fb_age"));
        enterName.clear();
        enterAge.clear();
        String Name = "oleg";
        int age = 33;
        enterName.sendKeys(Name);
        enterAge.sendKeys(String.valueOf(age));
        WebElement English = driver.findElement(By.className("w3-check"));
        English.click();
        driver.findElement(By.xpath("//input[@name='gender' and @value='male']")).click();
        WebElement mySelectOption = driver.findElement(By.id("like_us"));
        WebElement select = driver.findElement(By.name("gender"));
        new Select(driver.findElement(By.id("like_us"))).selectByVisibleText("Ok, i guess");
        WebElement Comment =   driver.findElement(By.cssSelector("[name=\"comment\"]"));
        Comment.sendKeys("goodbye");
        assertEquals("rgba(33, 150, 243, 1)",
        driver.findElement(By.xpath("//*[@class='w3-btn-block w3-blue w3-section']"))
        .getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)",
        driver.findElement(By.xpath("//*[@class='w3-btn-block w3-blue w3-section']"))
        .getCssValue("border-bottom-color"));
        driver.findElement(By.className("w3-blue") ).click();
        assertEquals("oleg", driver.findElement(By.id("name")).getText());
        assertEquals("33", driver.findElement(By.id("age")).getText());
        assertEquals("English", driver.findElement(By.id("language")).getText());
        assertEquals("male", driver.findElement(By.id("gender")).getText());
        assertEquals("Ok, i guess", driver.findElement(By.id("option")).getText());
        assertEquals("goodbye", driver.findElement(By.id("comment")).getText());


        assertEquals("rgba(76, 175, 80, 1)",
        driver.findElement(By.xpath("//*[@class='w3-btn w3-green w3-xlarge']"))
        .getCssValue("background-color"));
        assertEquals("rgba(244, 67, 54, 1)",
        driver.findElement(By.xpath("//*[@class='w3-btn w3-red w3-xlarge']"))
        .getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)",
         driver.findElement(By.xpath("//*[@class='w3-btn w3-red w3-xlarge']"))
         .getCssValue("color"));










    }
}
