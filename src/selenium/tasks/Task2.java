package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task2 {
    WebDriver driver;

    @Before
    public void openPage(){
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task2");
    }

    @After
    public void closeBrowser(){
        driver.close();
    }

    @Test
    public void loadGreenSleep() throws Exception{
        WebElement greenButton= driver.findElement(By.cssSelector("#start_green"));
        WebElement blueGreenButton= driver.findElement(By.cssSelector("#start_green_and_blue"));
        WebElement loadingGreen= driver.findElement(By.cssSelector("#green_loader"));

        //WebElement statusGreen= driver.findElement(By.cssSelector("#status_green"));
       // WebElement statusGreenandBlue= driver.findElement(By.cssSelector("#status_green_and_blue"));
        WebElement loadingGreenBlue= driver.findElement(By.cssSelector("#green_and_blue_loader"));
      //  WebElement finishBoth= driver.findElement(By.cssSelector("#finish_green_and_blue"));


        greenButton.click();

        assertTrue(loadingGreen.isDisplayed());
        assertEquals("Green Status:\nLoading green...",loadingGreen.getText());
        Thread.sleep(10000);
        WebElement finishGreen= driver.findElement(By.cssSelector("#finish_green"));
        assertTrue(finishGreen.isDisplayed());

        /* TODO:

         * 1) click on start loading green button
         * 2) check that button does not appear,
         * but loading text is seen instead
         * 3) check that both button
         * and loading text is not seen,
         * success is seen instead
         */
    }

    @Test
    public void loadGreenImplicit() {
        /* TODO:
         * 1) click on start loading green button
         * 2) check that button does not appear,
         * but loading text is seen instead
         * 3) check that both button
         * and loading text is not seen,
         * success is seen instead
         */
    }

    @Test
    public void loadGreenExplicitWait() {
        /* TODO:
         * 1) click on start loading green button
         * 2) check that button does not appear,
         * but loading text is seen instead
         * 3) check that both button
         * and loading text is not seen,
         * success is seen instead
         */
    }

    @Test
    public void loadGreenAndBlueBonus(){
		/* TODO:
		 * 0) wait until button to load green and blue appears
		 * 1) click on start loading green and blue button
		 * 2) check that button does not appear, but loading text is seen instead for green
		 * 3) check that button does not appear, but loading text is seen instead for green and blue
		 * 4) check that button and loading green does not appear,
		 * 		but loading text is seen instead for blue and success for green is seen
		 * 5) check that both button and loading text is not seen, success is seen instead
		 */
    }

}