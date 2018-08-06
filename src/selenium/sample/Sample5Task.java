package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Sample5Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/test-sample/examples/al_and_pu");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void goToAlertedPageViaButton() throws Exception {
        WebElement alertpage = driver.findElement(By.className("w3-blue"));
        String page = "https://kristinek.github.io/test-sample/examples/al_p";
        String correctPage = "https://kristinek.github.io/test-sample/examples/al_p";
//         TODO:
//        click on "To go to alerted page press Ok. Or stay here" button
        alertpage.click();
//        switch to alert
        Alert alert = driver.switchTo().alert();
        assertEquals("Want to see an alerted page?!", alert.getText());
//        click ok
        alert.accept();
//        switch to second alert
        Alert alert1 = driver.switchTo().alert();
//        verify alert text
        assertEquals("Booooooooo!", alert1.getText());
//        click ok on second alert
        alert1.accept();
//        verify that the correct page is opened
        assertEquals(page, correctPage);
    }
    public void goToAlertedPageViaButton2() throws Exception {
//        click on "To go to alerted page press Ok. Or stay here" button
        driver.findElement(By.className("w3-blue")).click();

//        switch to alert
        Alert alert = driver.switchTo().alert();

//        click ok
        alert.accept();

//        switch to second alert
        Alert alert123 = driver.switchTo().alert();

//        verify alert text
        assertEquals("Booooooooo!", alert123.getText());

//        click ok on second alert
        alert123.accept();

//        verify that the correct page is opened
        assertEquals("https://kristinek.github.io/test-sample/examples/al_p", driver.getCurrentUrl());

    }

    @Test
    public void doNotGoToAlertedPageViaButton() throws Exception {
//        click on "To go to alerted page press Ok. Or stay here" button
        WebElement alertpage= driver.findElement(By.className("w3-blue"));
        WebElement message=driver.findElement(By.id("textForAlerts"));
        alertpage.click();
//        switch to alert
        Alert alert=driver.switchTo().alert();
        assertEquals("Want to see an alerted page?!", alert.getText());
//        click cancel
        alert.dismiss();
//        verify the text on page
        assertEquals("So you desided to say? Good!", message.getText());

        driver.findElement(By.className("w3-blue")).click();

//        switch to alert
        Alert denyAlert = driver.switchTo().alert();

//        click cancel
        denyAlert.dismiss();

//        verify the text on page
        assertEquals("So you desided to say? Good!", driver.findElement(By.id("textForAlerts")).getText());

    }
}
