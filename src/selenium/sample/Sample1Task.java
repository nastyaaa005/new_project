package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1Task {
    static String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
//         TODO:
//         define driver
//         go to https://kristinek.github.io/test-sample/index2.html
//         get title of page
//         get URL of current page
//         close browser
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/test-sample/index2");

        System.out.println(driver.getTitle());

        System.out.println(driver.getCurrentUrl());

//        Thread.sleep(5000);

        driver.close();
    }
}
