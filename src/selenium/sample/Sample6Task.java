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

        System.out.println("Find element by id using xPath:");
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.xpath("//*[@id='heading_2']")).getText() + "'");
        System.out.println("\t text of element with id 'Test Text 1' is '" +
                driver.findElement(By.xpath("//p[contains(@class,'test')]")).getText() + "'");
        System.out.println("\t text of element with id 'Test Text 2' is '" +
                driver.findElement(By.xpath("//p[contains(@class,'twoTest')]")).getText() + "'");
        System.out.println("\t text of element with id 'Test Text 3' is '" +
                driver.findElement(By.xpath("//*[@id='test3']//p[1]")).getText() + "'");
        System.out.println("\t text of element with id 'Test Text 4' is '" +
                driver.findElement(By.xpath("//*[@id='test3']//p[2]")).getText() + "'");
        System.out.println("\t text of element with id 'Test Text 5' is '" +
                driver.findElement(By.xpath("//p[contains(text(),'5')]")).getText() + "'");
        System.out.println("\t text of element with id 'buttonId' is '" +
                driver.findElement(By.xpath("//input[@id='buttonId']")).getAttribute("value") + "'");

    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//         1-2 ways to write css to
//        "Heading 2 text":
//        "Test Text 1"
//        "Test Text 2"
//        "Test Text 3"
//        "This is also a button"

        System.out.println ( "Find element by id using CSS:" );
//        System.out.println("\t text of element with id 'heading_2' is '" +
//                driver.findElement(By.cssSelector("#heading_2")).getText() + "'");
        System.out.println ( "\t text of element with id 'heading_2' is '" +
                driver.findElement ( By.cssSelector ( "h2#heading_2" ) ).getText ( ) + "'" );
        System.out.println ( "\t text of element with id 'Test text 1' is '" +
                driver.findElement ( By.cssSelector ( ".test" ) ).getText ( ) + "'" );
        System.out.println ( "\t text of element with id 'Test text 2' is '" +
                driver.findElement ( By.cssSelector ( ".twoTest" ) ).getText ( ) + "'" );
        System.out.println ( "\t text of element with id 'Test text 2' is '" +
                driver.findElement ( By.cssSelector ( "#test3 p" ) ).getText ( ) + "'" );
        System.out.println("\t text of element with name Random button 2 is '" +
                driver.findElement(By.cssSelector("[name='randomButton2']")).getAttribute("value") + "'");


    }
}
