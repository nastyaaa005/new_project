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
    public void feedback() throws Exception {
        driver.findElement(By.id("fb_name")).sendKeys("John Snow");
        driver.findElement(By.id("fb_age")).sendKeys("22");
        driver.findElement(By.xpath("//*[@value='English']")).click();
        driver.findElement(By.cssSelector("[value='male']")).click();
        Select selector = new Select(driver.findElement(By.id("like_us")));
        selector.selectByValue("Good");
        driver.findElement(By.xpath("//textarea[@class='w3-input w3-border']")).sendKeys("The night falls and my watch begins");
        WebElement btn = driver.findElement(By.xpath("//button[@type='submit']"));

        assertEquals("rgba(33, 150, 243, 1)", btn.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", btn.getCssValue("color"));
        btn.click();
        assertEquals("Your name: John Snow", driver.findElement(By.cssSelector(".description:nth-child(1)")).getText());
        assertEquals("Your age: 22", driver.findElement(By.cssSelector(".description:nth-child(2)")).getText());
        assertEquals("Your language: English", driver.findElement(By.cssSelector(".description:nth-child(3)")).getText());
        assertEquals("Your genre: male", driver.findElement(By.cssSelector(".description:nth-child(4)")).getText());
        assertEquals("Your option of us: Good", driver.findElement(By.cssSelector(".description:nth-child(5)")).getText());
        assertEquals("Your comment: The night falls and my watch begins", driver.findElement(By.cssSelector(".description:nth-child(6)")).getText());

        assertEquals("rgba(76, 175, 80, 1)", driver.findElement(By.cssSelector(".w3-green")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.cssSelector(".w3-green")).getCssValue("color"));

        assertEquals("rgba(244, 67, 54, 1)", driver.findElement(By.cssSelector(".w3-red")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.cssSelector(".w3-green")).getCssValue("color"));

// TODO:
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
//        check that the button send is blue with white letters
//        click "send"
//        check that the feedback was filled correctly
//        check that the button yes is green and no is red but both have white letters
    }
}
