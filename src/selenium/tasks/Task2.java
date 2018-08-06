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

    @Before
    public void openPage(){
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
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
        WebElement greenButton = driver.findElement(By.id("start_green"));
        WebElement loadingGreen = driver.findElement(By.id("loading_green"));
        WebElement myGreen = driver.findElement(By.id("finish_green"));
        greenButton.click();
        assertFalse(greenButton.isDisplayed());
        assertEquals(loadingGreen.getText(), "Loading green...");
        Thread.sleep(5000);
        assertFalse(greenButton.isDisplayed());
        assertFalse(loadingGreen.isDisplayed());
        assertEquals("Green Loaded", myGreen.getText());
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
        WebElement greenButton = driver.findElement(By.id("start_green"));
        WebElement loadingGreen = driver.findElement(By.id("loading_green"));
        WebElement myGreen = driver.findElement(By.id("finish_green"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        greenButton.click();
        assertFalse(greenButton.isDisplayed());
        assertEquals(loadingGreen.getText(), "Loading green...");
        assertTrue(myGreen.isDisplayed());
        assertFalse(greenButton.isDisplayed());
        assertFalse(loadingGreen.isDisplayed());
        assertEquals(myGreen.getText(), "Green Loaded");

//        OR
//        myNewWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish_green"))));
//        OR
//        myNewWait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish_green")));
//        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
//        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
//        assertEquals(driver.findElement(By.id("finish_green")).getText(), "Green Loaded");
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
        WebDriverWait myNewWait = new WebDriverWait(driver, 10);
        driver.findElement(By.id("start_green")).click();
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertEquals(driver.findElement(By.id("loading_green")).getText(), "Loading green...");
        myNewWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading_green"))));
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