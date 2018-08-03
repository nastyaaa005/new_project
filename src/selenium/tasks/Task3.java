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
//        click "send"
        driver.findElement(By.cssSelector(".w3-btn-block[type='submit']")).click();
//        check that the feedback was filled correctly
        assertEquals(name, driver.findElement());
//        check that the button yes is green and no is red but both have white letters
    }
}
