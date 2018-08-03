package selenium.sample;

import com.sun.xml.internal.bind.v2.TODO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample6Task {
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
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void findElementByXPath() throws Exception {
//         TODO:
////         1-2 ways to write xapth to
//        "Heading 2 text":
        System.out.println(driver.findElement(By.xpath("//h2[@id='heading_2']")).getText());

        System.out.println(driver.findElement(By.xpath("//h2[2]")).getText());
//        "Test Text 1"
        System.out.println(driver.findElement(By.xpath("// div[@id=\"test1\"]/p[1]")).getText());
//        "Test Text 2"
        System.out.println(driver.findElement(By.xpath("// div[@id=\"test1\"]/p[2]")).getText());
//        "Test Text 3"
        System.out.println(driver.findElement(By.xpath("// div[@id=\"test3\"]/p[1]")).getText());
//        "Test Text 4"
        System.out.println(driver.findElement(By.xpath("// div[@id=\"test3\"]/p[2]")).getText());
//        "Test Text 5"
        System.out.println(driver.findElement(By.xpath("//*[@id='buttonId']")).getAttribute("value"));
//        "This is also a button"

    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//         1-2 ways to write css to
            System.out.println(driver.findElement(By.cssSelector("#heading_2")).getText());
//        "Heading 2 text":
        System.out.println(driver.findElement(By.cssSelector("#test1 .test")).getText());
//        "Test Text 1"
        System.out.println(driver.findElement(By.cssSelector("#test1 .twotest")).getText());
//        "Test Text 2"
        System.out.println(driver.findElement(By.cssSelector("#test3 .test")).getText());
//        "Test Text 3"

        //test3 p:nth-child(1)
        System.out.println(driver.findElement(By.cssSelector("#buttonId")).getAttribute("value"));
//        "This is also a button"
    }
}
