package selenium.tasks;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task3 {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task4");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void feedback() {

        driver.findElement(By.id("fb_name")).sendKeys("del");
        driver.findElement(By.id("fb_age")).sendKeys("23");
        driver.findElement(By.cssSelector("input[value='male']")).click();

        List<WebElement> all = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement el : all) {
            if (!el.isSelected()) {
                el.click();
            }
        }
        driver.findElement(By.name("comment")).sendKeys("nothing-much");
    }

    public void styleChecks() throws Exception {

        assertEquals("rgba(33, 150, 243)", driver.findElement(By.xpath("//*[@class='w3-btn-block w3-blue w3-section']"))
                .getCssValue("background-color"));

        assertEquals("rgba(255, 255, 255)",
                driver.findElement(By.xpath("//*[@class='w3-container w3-pale-yellow']"))
                        .getCssValue("background-color"));

        driver.findElement(By.className("submit")).click();


        assertEquals("rgba(76, 175, 80", driver.findElement(By.xpath("//*[@class='w3-btn w3-green w3-xlarge']"))
                .getCssValue("background-color"));

        assertEquals("rgba(244, 67, 54)",
                driver.findElement(By.xpath("//*[@class='w3-btn w3-red w3-xlarge']"))
                        .getCssValue("background-color"));
        driver.findElement(By.className("openFeedback()")).click();

    }

}




// TODO:
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
//        check that the button send is blue with white letters
//        click "send"
//        check that the feedback was filled correctly
//        check that the button yes is green and no is red but both have white letters

