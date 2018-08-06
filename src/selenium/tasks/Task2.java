package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
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
        driver.get("https://kristinek.github.io/test-sample/tasks/task2");
        wait = (WebDriverWait) new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class);
    }

    @After
    public void closeBrowser(){
        driver.close();
    }

    @Test
    public void loadGreenSleep() throws Exception{  //using sleep
        /* TODO:
         * 1) click on start loading green button
         * 2) check that button does not appear,
         * but loading text is seen instead
         * 3) check that both button
         * and loading text is not seen,
         * success is seen instead
         */
        WebElement greenButton= driver.findElement(By.cssSelector("#start_green"));
        greenButton.click();
        WebElement loadingGreen=driver.findElement(By.cssSelector("#loading_green"));
        assertEquals(loadingGreen.getText(), "Loading green...");
        assertFalse(driver.findElement(By.cssSelector("#start_green")).isDisplayed());
        Thread.sleep(5000);
        WebElement greenLoaded=driver.findElement(By.cssSelector("#finish_green"));
        assertEquals(greenLoaded.getText(),"Green Loaded");
        assertFalse(driver.findElement(By.cssSelector("#start_green")).isDisplayed());
        assertFalse(driver.findElement(By.cssSelector("#loading_green")).isDisplayed());

    }

    @Test
    public void loadGreenImplicit() { //using implicit wait
        /* TODO:
         * 1) click on start loading green button
         * 2) check that button does not appear,
         * but loading text is seen instead
         * 3) check that both button
         * and loading text is not seen,
         * success is seen instead
         */

        WebElement greenButton= driver.findElement(By.cssSelector("#start_green"));
        greenButton.click();
        WebElement loadingGreen=driver.findElement(By.cssSelector("#loading_green"));
        assertFalse(driver.findElement(By.cssSelector("#start_green")).isDisplayed());
        assertEquals(loadingGreen.getText(), "Loading green...");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement greenLoaded=driver.findElement(By.cssSelector("#finish_green"));
        assertEquals(greenLoaded.getText(),"Green Loaded");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);  //since the same time is ussed to wait for findElements change value to 1 second
        assertFalse(driver.findElement(By.cssSelector("#start_green")).isDisplayed());
        assertFalse(driver.findElement(By.cssSelector("#loading_green")).isDisplayed());


    }

    @Test
    public void loadGreenExplicitWait() { //using explicit wai
        /* TODO:
         * 1) click on start loading green button
         * 2) check that button does not appear,
         * but loading text is seen instead
         * 3) check that both button
         * and loading text is not seen,
         * success is seen instead
         */
        WebElement greenButton= driver.findElement(By.cssSelector("#start_green"));
        greenButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loading_green")));
        WebElement loadingGreen=driver.findElement(By.cssSelector("#loading_green"));
        assertEquals(loadingGreen.getText(), "Loading green...");
        assertFalse(driver.findElement(By.cssSelector("#start_green")).isDisplayed());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish_green")));
        WebElement greenLoaded=driver.findElement(By.cssSelector("#finish_green"));
        assertEquals(greenLoaded.getText(),"Green Loaded");
        assertFalse(driver.findElement(By.cssSelector("#start_green")).isDisplayed());
        assertFalse(driver.findElement(By.cssSelector("#loading_green")).isDisplayed());
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
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#start_green_and_blue")));
        driver.findElement(By.cssSelector("#start_green_and_blue")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loading_green_without_blue")));
        assertEquals(driver.findElement(By.cssSelector("#loading_green_without_blue")).getText(),"Loading green...");

        assertFalse(driver.findElement(By.cssSelector("#start_green_and_blue")).isDisplayed());
        assertTrue("something is not right",driver.findElement(By.cssSelector("#loading_green_without_blue")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("#loading_green_without_blue")).getText(),"Loading green...");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loading_green_with_blue")));
        assertTrue(driver.findElement(By.cssSelector("#loading_green_with_blue")).isDisplayed());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loading_blue_without_green")));
        assertEquals(driver.findElement(By.cssSelector("#loading_blue_without_green")).getText(),"Green finished waiting for blue");
        assertTrue(driver.findElement(By.cssSelector("#loading_blue_without_green")).isDisplayed());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish_green_and_blue")));
        assertTrue(driver.findElement(By.cssSelector("#finish_green_and_blue")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("#finish_green_and_blue")).getText(),"Green and Blue Loaded");
        
    }

}