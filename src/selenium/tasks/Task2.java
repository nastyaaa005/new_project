package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
    private static WebDriverWait wait;
    static long startTime;

    @Before
    public void openPage(){
       /* String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task2");
        WebDriverWait wait = new WebDriverWait(driver,10);*/


        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        driver.get("https://kristinek.github.io/test-sample/tasks/task2");
        startTime = System.currentTimeMillis();

    }

    @After
    public void closeBrowser(){
        driver.close();
    }

    @Test
    public void loadGreenSleep() throws Exception{


        driver.findElement(By.id("start_green")).click();
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertEquals("Loading green..." ,driver.findElement(By.id("loading_green")).getText());
        Thread.sleep(10000);
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        assertEquals("Green Loaded" ,driver.findElement(By.id("finish_green")).getText());

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
    public void loadGreenImplicit() throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("start_green")).click();
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertEquals("Loading green..." ,driver.findElement(By.id("loading_green")).getText());
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertEquals("Green Loaded" ,driver.findElement(By.id("finish_green")).getText());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());

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

       // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("start_green_and_blue")));
        driver.findElement(By.id("start_green")).click();
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertEquals("Loading green..." ,driver.findElement(By.id("loading_green")).getText());
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish_green")));
        assertEquals("Green Loaded" ,driver.findElement(By.id("finish_green")).getText());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());

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