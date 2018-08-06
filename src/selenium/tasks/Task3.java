package selenium.tasks;

import org.apache.bcel.generic.Select;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task3 {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty ( "user.dir" ) + "\\lib\\";
        System.setProperty ( "webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe" );
        driver = new ChromeDriver ( );
        driver.get ( "https://kristinek.github.io/test-sample/tasks/task4" );
    }

    @After
    public void closeBrowser() {
        driver.quit ( );
    }

    @Test
    public void feedback() throws InterruptedException {
// TODO:
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
//        check that the button send is blue with white letters
//        click "send"
//        check that the feedback was filled correctly
//        check that the button yes is green and no is red but both have white letters

        WebElement name = driver.findElement(By.id("fb_name"));
        String myName = "Greeshma";
        name.sendKeys(myName);
        assertTrue(name.isDisplayed());
        assertEquals(myName, name.getAttribute("value"));

        WebElement age = driver.findElement(By.id("fb_age"));
        String myAge = "21";
        age.sendKeys(myAge);
        assertTrue(age.isDisplayed());
        assertEquals(myAge, age.getAttribute("value"));

        //select 1 or more language
       /* List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));

        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected());
        } */

        WebElement english = driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'"));
        english.click();
        assertTrue(english.isSelected());


        // select gender
        WebElement Male = driver.findElement(By.cssSelector(".w3-radio[value='male'][type='radio'"));
        assertFalse(Male.isSelected());

        WebElement Female = driver.findElement(By.cssSelector(".w3-radio[value='female'][type='radio'"));
        assertFalse(Female.isSelected());

        Female.click();
        assertTrue(Female.isSelected());

        //select option
        org.openqa.selenium.support.ui.Select mySelector = new org.openqa.selenium.support.ui.Select (driver.findElement(By.xpath("//*[@class = 'w3-select']")));
        mySelector.selectByValue("Good");
        assertEquals("Good", mySelector.getFirstSelectedOption().getText());

        //add a comment
        WebElement comment = driver.findElement(By.name("comment"));
        String myComment = "NA";
        comment.sendKeys(myComment);
        assertTrue(comment.isDisplayed());
        assertEquals(myComment, comment.getAttribute("value"));


        //check that the button send is blue with white letters
        WebElement sendButton = driver.findElement(By.xpath("//*[@type = 'submit']"));
        assertEquals("rgba(33, 150, 243, 1)", sendButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", sendButton.getCssValue("color"));
        Thread.sleep ( 5000 );

        // click "send"
        sendButton.click();

        //check that the feedback was filled correctly
        System.out.println(driver.findElement(By.xpath("//h2")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@class='w3-container']")).getText());

        // check that the button yes is green and no is red but both have white letters
        WebElement GreenButton = driver.findElement(By.xpath("//*[@class = 'w3-btn w3-green w3-xlarge']"));
        assertEquals("rgba(76, 175, 80, 1)", GreenButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", GreenButton.getCssValue("color"));
       
        WebElement RedButton = driver.findElement(By.xpath("//*[@class = 'w3-btn w3-red w3-xlarge']"));
        assertEquals("rgba(244, 67, 54, 1)", RedButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", RedButton.getCssValue("color"));
        Thread.sleep ( 5000 );
    }
}
