package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
//         TODO:
//        click on "To go to alerted page press Ok. Or stay here" button
//        switch to alert
//        click ok
//        switch to second alert
//        verify alert text
//        click ok on second alert
//        verify that the correct page is opened
    }
        public void alertOnclickingButton() throws Exception {
            driver.findElement(By.className("w3-btn w3-round-xlarge w3-ripple w3-blue")).click();
            Alert alert = driver.switchTo().alert();

            alert.accept();

             alert = driver.switchTo().alert();
            assertEquals("", driver.findElement(By.id("Booooooooo!")).getText());
    }

    @Test
    public void doNotGoToAlertedPageViaButton()throws Exception {
//         TODO:
//        click on "To go to alerted page press Ok. Or stay here" button
//        switch to alert
//        click cancel
//        verify the text on page
    }
            public void popUpDeny()throws Exception{
                driver.findElement(By.className("w3-btn w3-round-xlarge w3-ripple w3-blue")).click();
                Alert alert = driver.switchTo().alert();
                assertEquals("Press a button!", alert.getText());

                alert.dismiss();
                assertEquals("So you desided to say? Good!", driver.findElement(By.id("textForAlerts")).getText());
    }
}
