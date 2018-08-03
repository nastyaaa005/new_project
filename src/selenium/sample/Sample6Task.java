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
//        "Test Text 1"
//        "Test Text 2"
//        "Test Text 3"
//        "Test Text 4"
//        "Test Text 5"
//        "This is also a button"

        System.out.println(driver.findElement(By.xpath("//*[@id=\"heading_2\"]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"heading_2\"]")).getText());

        "Test Text 1"
        System.out.println(driver.findElement(By.xpath("//*[@class=\"test\"]")));

        "Test Text 3"
        System.out.println(driver.findElement(By.xpath("//p[text()='Test Text3']")));

        "Test Text 5"
        System.out.println(driver.findElement(By.xpath("//*[@id='test2']/p")));
        "//*[@id='test2']/p[1]"
        "//p[text(), 'Test Text 5']"
        "//p[containstext(), 'Text 5')]"
        "//p[containstext(), '5')]"

        "This is also a button"
        "//*[@value='This is also a button']"
        "//input[@id='buttonId']"
        "//input[@name='randomButton2']"
        "//input[2]"
    }

    /*
    @Test
    public void findElementById() throws Exception {
//        find element by id using xPath
        System.out.println("Find element by id using xPath:");
        System.out.println("\t text of element with id 'heading_1' is '" +
                driver.findElement(By.xpath("//*[@id='heading_1']")).getText() + "'");
        System.out.println("\t text of element with id 'standartText' is '" +
                driver.findElement(By.xpath("//*[@id='standartText']")).getText() + "'");
        System.out.println("\t text of element with id 'nonStandartText' is '" +
                driver.findElement(By.xpath("//*[@id='nonStandartText']")).getText() + "'");

     */

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//         1-2 ways to write css to
//        "Heading 2 text":
//        "Test Text 1"
//        "Test Text 2"
//        "Test Text 3"
//        "This is also a button"

        System.out.println(driver.findElement(By.ByCssSelector("#heading_2")).getText();

        "Test Text 1"
        ".test"
        "p.test"


        "Test Text 2"
        "two.test"
        "p.two.test"

        Test Text 3
        "#test3 p:nth-child(1)"
        "#test3 p:nth-of-type(1)"


        "This is also a button"

        "#buttonId"
        "[name='randomButton2']"
        "[type='randomButton2']"


    }
}
