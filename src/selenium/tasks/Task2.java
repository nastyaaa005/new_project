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

import static junit.framework.TestCase.assertEquals;
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
        assertEquals(driver.findElement(By.id("loading_green")).getText(), "Loading green...");

        Thread.sleep(5000);
        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        assertEquals(driver.findElement(By.id("finish_green")).getText(), "Green Loaded");
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("start_green")).click();

        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
        assertEquals(driver.findElement(By.id("loading_green")).getText(), "Loading green...");


        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());
        assertEquals(driver.findElement(By.id("finish_green")).getText(), "Green Loaded");
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());

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

        WebDriverWait myWait = new WebDriverWait(driver, 10);

        myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("start_green")))).click();
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());

        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading_green")));
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
        assertEquals(driver.findElement(By.id("loading_green")).getText(), "Loading green...");
        myWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("start_green")));
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());

        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish_green")));
        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());
        assertEquals(driver.findElement(By.id("finish_green")).getText(), "Green Loaded");
        myWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading_green")));
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        myWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("start_green")));
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
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

		WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start_green_and_blue")));
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("start_green_and_blue")));
		driver.findElement(By.id("start_green_and_blue")).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("start_green_and_blue")));
		assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading_green_without_blue")));
		assertTrue(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("start_green_and_blue")));
        assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading_green_with_blue")));
		assertTrue(driver.findElement(By.id("loading_green_with_blue")).isDisplayed());



    }

}