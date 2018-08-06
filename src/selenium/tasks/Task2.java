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

import static org.junit.Assert.*;

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
        /* TODO:
         * 1) click on start loading green button
         * 2) check that button does not appear,
         * but loading text is seen instead
         * 3) check that both button
         * and loading text is not seen,
         * success is seen instead
         */
        driver.findElement(By.id("start_green")).click();
        assertTrue(driver.findElement(By.id("start_green")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
        Thread.sleep(5000);
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());

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
        driver.findElement(By.id("start_green")).click();
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());

        driver.findElement(By.id("finish_green"));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());


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

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.id("start_green")).click();
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish_green")));
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());

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