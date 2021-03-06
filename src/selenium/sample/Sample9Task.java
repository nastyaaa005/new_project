package selenium.sample;

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

public class Sample9Task {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task2");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void loadGreenSleep() throws Exception {
        driver.findElement(By.id("start_green")).click();
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertEquals(driver.findElement(By.id("loading_green")).getText(), "Loading green...");
        Thread.sleep(5000);
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        assertEquals(driver.findElement(By.id("finish_green")).getText(), "Green Loaded");

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
        assertEquals(driver.findElement(By.id("loading_green")).getText(), "Loading green...");

        WebElement myGreen = driver.findElement(By.id("finish_green"));
        assertTrue(myGreen.isDisplayed());
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        assertEquals(myGreen.getText(), "Green Loaded");
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
    public void loadGreenExplicitWait() throws Exception {
        WebDriverWait myNewWait = new WebDriverWait(driver, 10);
        driver.findElement(By.id("start_green")).click();
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertEquals(driver.findElement(By.id("loading_green")).getText(), "Loading green...");

        //myNewWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading_green"))));
//        OR
//        myNewWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish_green"))));
//        OR
        myNewWait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish_green")));
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        assertEquals(driver.findElement(By.id("finish_green")).getText(), "Green Loaded");
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
    public void loadGreenAndBlueBonus() {
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