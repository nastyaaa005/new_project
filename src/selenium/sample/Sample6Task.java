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
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
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

        System.out.println("Find element using xPath:");
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.xpath("//*[@id='heading_2']")).getText() + "'");

        System.out.println("\t text of element with class 'test' is '" +
                driver.findElement(By.xpath("//*[@class='test']")).getText() + "'");

        System.out.println("\t text of element with class 'twoTest' is '" +
                driver.findElement(By.xpath("//*[@class='twoTest']")).getText() + "'");

        System.out.println(driver.findElement(By.xpath("//p[text()='Test Text 3']")).getText());

        System.out.println("\t text of element with class 'test' and id 'test3' is '" +
                driver.findElement(By.xpath("//*[@id = 'test3']//p[2]")).getText() + "'");

        System.out.println("\t text of element with id 'test2' is '" +
                driver.findElement(By.xpath("//*[@id = 'test2']/p")).getText() + "'");

        System.out.println(driver.findElement(By.xpath("//input[@id='buttonId']")).getAttribute("value"));
                driver.findElement(By.xpath("//*[@value = 'This is also a button']")).getAttribute("value" + "'");
                driver.findElement(By.xpath("//input[@name = 'randomButton2']")).getAttribute("value" + "'");


//         TODO:
////         1-2 ways to write xapth to
//        "Heading 2 text":
//        "Test Text 1"
//        "Test Text 2"
//        "Test Text 3"
//        "Test Text 4"
//        "Test Text 5"
//        "This is also a button"
    }

    @Test
    public void findElementByCssName() throws Exception {
        System.out.println("Find element by name using CSS:");
        System.out.println("\t text of element with name 'heading_2' is '" +
                driver.findElement(By.cssSelector("#heading_2")).getText() + "'");

        System.out.println("\t text of element with name 'test_text_1' is '" +
                driver.findElement(By.cssSelector(".test")).getText() + "'");

        System.out.println("\t text of element with name 'test_text_2' is '" +
                driver.findElement(By.cssSelector(".twoTest")).getText() + "'");

        System.out.println("\t text of element with name 'test_text_3' is '" +
                driver.findElement(By.cssSelector("#test3 p:nth-child(1)")).getText() + "'");

        System.out.println("\t text of element with name 'randomButton2' is '" +
                driver.findElement(By.cssSelector("#buttonId")).getText() + "'");
        driver.findElement(By.cssSelector("[name = 'randomButton2']")).getAttribute("value" + "'");

//         TODO:
//         1-2 ways to write css to
//        "Heading 2 text":
//        "Test Text 1"
//        "Test Text 2"
//        "Test Text 3"
//        "This is also a button"
    }
}
