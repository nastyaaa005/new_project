package selenium.tasks;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

        //fill in "name", "age"
        WebElement name = driver.findElement(By.id("fb_name"));
        String myName = "Annie";
        name.sendKeys(myName);
        assertTrue(name.isDisplayed());
        assertEquals(myName, name.getAttribute("value"));

        WebElement age = driver.findElement(By.id("fb_age"));
        String myAge = "28";
        age.sendKeys(myAge);
        assertTrue(age.isDisplayed());
        assertEquals(myAge, age.getAttribute("value"));

        //select 1 or more language
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));

        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected());
        }

        WebElement english = driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'"));
        WebElement french = driver.findElement(By.cssSelector(".w3-check[value='French'][type='checkbox'"));
        WebElement spanish = driver.findElement(By.cssSelector(".w3-check[value='Spanish'][type='checkbox'"));
        WebElement chinese = driver.findElement(By.cssSelector(".w3-check[value='Chinese'][type='checkbox'"));

        english.click();
        assertTrue(english.isSelected());

        french.click();
        assertTrue(french.isSelected());

        spanish.click();
        assertTrue(spanish.isSelected());

        chinese.click();
        assertTrue(chinese.isSelected());

        // select gender
        WebElement male = driver.findElement(By.cssSelector(".w3-radio[value='male'][type='radio'"));
        assertFalse(male.isSelected());

        WebElement female = driver.findElement(By.cssSelector(".w3-radio[value='female'][type='radio'"));
        assertFalse(female.isSelected());

        female.click();
        assertTrue(female.isSelected());

        //select option
        Select mySelector = new Select(driver.findElement(By.xpath("//*[@class = 'w3-select']")));
        mySelector.selectByValue("Why me?");
        assertEquals("Why me?", mySelector.getFirstSelectedOption().getText());

        //add a comment
        WebElement comment = driver.findElement(By.name("comment"));
        String myComment = "no comments";
        comment.sendKeys(myComment);
        assertEquals(myComment, comment.getAttribute("value"));


        //check that the button send is blue with white letters
        WebElement sendButton = driver.findElement(By.xpath("//*[@type = 'submit']"));
        assertEquals("rgba(33, 150, 243, 1)", sendButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", sendButton.getCssValue("color"));

       // click "send"
        sendButton.click();

        //check that the feedback was filled correctly
        System.out.println(driver.findElement(By.xpath("//h2")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@class='w3-container']")).getText());

       // check that the button yes is green and no is red but both have white letters
        WebElement yesButton = driver.findElement(By.xpath("//*[@class = 'w3-btn w3-green w3-xlarge']"));
        assertEquals("rgba(76, 175, 80, 1)", yesButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", yesButton.getCssValue("color"));

        WebElement noButton = driver.findElement(By.xpath("//*[@class = 'w3-btn w3-red w3-xlarge']"));
        assertEquals("rgba(244, 67, 54, 1)", noButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", noButton.getCssValue("color"));
    }
}
