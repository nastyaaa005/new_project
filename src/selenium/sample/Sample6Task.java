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


        System.out.println(driver.findElement(By.xpath("//*[@id='heading_2']")).getText());
        System.out.println(driver.findElement(By.xpath("//h2[2]")).getText());

//        "Test Text 1"
        System.out.println(driver.findElement(By.xpath("//*[@class='test']")).getText());
        //System.out.println(driver.findElement(By.xpath("//p[contains(@class='test')]")).getText()); not right

//        "Test Text 2"
        System.out.println(driver.findElement(By.xpath("//*[@class='twoTest']")).getText());
        System.out.println(driver.findElement(By.xpath("//p[contains(text(), 'Test Text 2')]")).getText());

//        "Test Text 3"
       System.out.println(driver.findElement(By.xpath("//*[@id='test3']/p[1]")).getText());
       System.out.println(driver.findElement(By.xpath("//p[text()='Test Text 3']")).getText());


//        "Test Text 4"
        System.out.println(driver.findElement(By.xpath("//*[@id='test3']/p[2]")).getText());

//        "Test Text 5"
        System.out.println(driver.findElement(By.xpath("//*[@id='test2']/p[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id='test2']/p")).getText());
        System.out.println(driver.findElement(By.xpath("//p[text()='Test Text 5']")).getText());
        System.out.println(driver.findElement(By.xpath("//p[contains(text(), '5')]")).getText());

//        "This is also a button"
        System.out.println(driver.findElement(By.xpath("//*[@value='This is also a button']")).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath("//input[@id='buttonId']")).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath("//input[@name='randomButton2']")).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath("//input[2]")).getAttribute("value"));



    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//         1-2 ways to write css to

        //*[@class='text amazing']; //p[contains(text(), 'amazing'); //p[text()='amazing sample text']
        System.out.println(driver.findElement(By.xpath("//*[@class='text amazing']")).getText());
        System.out.println(driver.findElement(By.xpath("//p[contains(text(), 'amazing')]")).getText());
        System.out.println(driver.findElement(By.xpath("//p[text()='amazing sample text']")).getText());

        //*[@id='dummy']; //p[contains(text(), 'dummy'); //p[text()='dummy text']
        System.out.println(driver.findElement(By.xpath("//*[@id='dummy']")).getText());
        System.out.println(driver.findElement(By.xpath("//p[contains(text(), 'dummy')]")).getText());

        //dummy css
        System.out.println(driver.findElement(By.cssSelector("#dummy")).getText());
        System.out.println(driver.findElement(By.cssSelector("#nonStandartText p:nth-child(3)")).getText());


        // #standartText p:nth-child(2); #standartText p:nth-of-type(2)
        System.out.println(driver.findElement(By.cssSelector("#standartText p:nth-child(2)")).getText());
        System.out.println(driver.findElement(By.cssSelector("#standartText p:nth-of-type(2)")).getText());

        // p.amazing; #nonStandartText p:nth-child(2);
        System.out.println(driver.findElement(By.cssSelector("p.amazing")).getText());
        System.out.println(driver.findElement(By.cssSelector("#nonStandartText p:nth-child(2)")).getText());

        //button xpath
        System.out.println(driver.findElement(By.xpath("//*[@value='This is a button']")).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath("//input[@name='randomButton1']")).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath("//input[1]")).getAttribute("value"));

        //button css
        System.out.println(driver.findElement(By.cssSelector("[name='randomButton1']")).getAttribute("value"));
        System.out.println(driver.findElement(By.cssSelector("[type='button']:nth-of-type(1)")).getAttribute("value"));

        //Heading1 xpath
        System.out.println(driver.findElement(By.xpath("//*[@id='heading_1']")).getText());
        System.out.println(driver.findElement(By.xpath("//h2[1]")).getText());

        //Heading1 css
        System.out.println(driver.findElement(By.cssSelector("#heading_1")).getText());
        System.out.println(driver.findElement(By.cssSelector("h2#heading_1")).getText());



//        "Heading 2 text":
        System.out.println(driver.findElement(By.cssSelector("#heading_2")).getText());
        System.out.println(driver.findElement(By.cssSelector("h2#heading_2")).getText());

//        "Test Text 1"
        System.out.println(driver.findElement(By.cssSelector(".test")).getText());
        System.out.println(driver.findElement(By.cssSelector("p.test")).getText());

//        "Test Text 2"
        System.out.println(driver.findElement(By.cssSelector(".twoTest")).getText());
        System.out.println(driver.findElement(By.cssSelector("p.twoTest")).getText());

//        "Test Text 3"
        System.out.println(driver.findElement(By.cssSelector("#test3 p:nth-child(1)")).getText());
        System.out.println(driver.findElement(By.cssSelector("#test3 p")).getText());
        System.out.println(driver.findElement(By.cssSelector("#test3 p:nth-of-type(1)")).getText());
        System.out.println(driver.findElement(By.cssSelector("#test3 .test")).getText());
        System.out.println(driver.findElement(By.cssSelector("#test3 > .test")).getText());
        System.out.println(driver.findElement(By.cssSelector("#test3 p.test")).getText());

        //Sample text 2


//        "This is also a button"
        System.out.println(driver.findElement(By.cssSelector("#buttonId")).getAttribute("value"));
        System.out.println(driver.findElement(By.cssSelector("[name='randomButton2']")).getAttribute("value"));
        System.out.println(driver.findElement(By.cssSelector("[type='button']:nth-of-type(2)")).getAttribute("value"));
    }
}