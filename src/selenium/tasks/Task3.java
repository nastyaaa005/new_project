package selenium.tasks;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
//        check that the button send is blue with white letters
//        click "send"
//        check that the feedback was filled correctly
//        check that the button yes is green and no is red but both have white letters
        WebElement inputName = driver.findElement(By.id("fb_name"));
        WebElement inputAge = driver.findElement(By.id("fb_age"));
        WebElement selectLanguage = driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'"));
        WebElement selectGender = driver.findElement(By.cssSelector(".w3-radio[value='female'][type='radio'"));
        WebElement likeDropDown = driver.findElement(By.cssSelector("#like_us option:nth-child(2)"));
        WebElement inputComment = driver.findElement(By.className("w3-input"));
        WebElement sendButton = driver.findElement(By.className("w3-blue"));
        String name = "Leila";
        String age = "25";
        String comment = "okay";

        inputName.sendKeys(name);
        inputAge.sendKeys(age);
        selectLanguage.click();
        selectGender.click();
        likeDropDown.click();
        inputComment.sendKeys(comment);
        assertEquals("rgba(33, 150, 243, 1)", sendButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", sendButton.getCssValue("color"));
        sendButton.click();

        assertEquals("Is this the feedback you want to give us?", driver.findElement(By.xpath("//h2")).getText());
        WebElement greenButton = driver.findElement(By.className("w3-green"));
        WebElement redButton = driver.findElement(By.className("w3-red"));
        assertEquals("rgba(76, 175, 80, 1)", greenButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", greenButton.getCssValue("color"));
        assertEquals("rgba(244, 67, 54, 1)", redButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", redButton.getCssValue("color"));
        greenButton.click();
    }
}
