package selenium.tasks;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task3 {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task4");
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void feedback() throws InterruptedException {
// TODO:
        WebElement Name = driver.findElement(By.id("fb_name"));
        WebElement age = driver.findElement(By.id("fb_age"));
       WebElement sendbutton= driver.findElement(By.xpath("//button[text()='Send']"));
        WebElement boxEng = driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'"));
        WebElement boxFrench = driver.findElement(By.cssSelector(".w3-check[value='French'][type='checkbox'"));
        WebElement boxChin = driver.findElement(By.cssSelector(".w3-check[value='Chinese'][type='checkbox'"));
        WebElement Genre = driver.findElement(By.cssSelector(".w3-radio[value='female'][type='radio'"));
        WebElement commentBox = driver.findElement(By.cssSelector("textarea[name='comment']"));

        // fill in "name", "age", select 1 or more language, select genre, select option, add a comment
        String MyName= "May";
        String MyAge="67";
        String comment= "Veni, vidi, vici.";
//name
        Name.clear();
        Name.sendKeys(MyName);
        assertEquals(Name.getAttribute("value"), MyName);
//age
        age.clear();
        age.sendKeys(MyAge);
        assertEquals(age.getAttribute("value"), MyAge);

//Languages: English, French, Chineese
        boxEng.click();
        assertTrue(boxEng.isSelected());
        boxFrench.click();
        assertTrue(boxFrench.isSelected());
        boxChin.click();
        assertTrue(boxChin.isSelected());
 //Genre: Female
        Genre.click();
        assertTrue(Genre.isSelected());
// Options:Why me?
        Select option = new Select(driver.findElement(By.id("like_us")));
        assertEquals("Choose your option", option.getFirstSelectedOption().getText());
        option.selectByVisibleText("Why me?");
        assertEquals("Why me?", option.getFirstSelectedOption().getText());
//Comment: Veni,vidi,vici
        commentBox.clear();
        commentBox.sendKeys(comment);
        assertEquals(commentBox.getAttribute("value"), comment);

//        check that the button send is blue with white letters
        assertEquals("rgba(255, 255, 255, 1)", sendbutton.getCssValue("color"));
        assertEquals("rgba(33, 150, 243, 1)", sendbutton.getCssValue("background-color"));

        //For check before "send" button
        Thread.sleep(5000);

//        click "send"
       assertTrue(sendbutton.isEnabled());
       sendbutton.click();


//        check that the feedback was filled correctly
        WebElement FedName = driver.findElement((By.id("name")));
        WebElement FedAge=driver.findElement((By.id("age")));
        WebElement Languages=driver.findElement((By.id("language")));
        WebElement GenreFed =driver.findElement((By.id("gender")));
        WebElement Opinion=driver.findElement((By.id("option")));
        WebElement Comment=driver.findElement((By.id("comment")));

   //Field Name
        assertEquals(FedName.getText(),MyName);
   // Field Age
        assertEquals(FedAge.getText(),MyAge );
   // Field Languages
        assertEquals(Languages.getText(),"English,French,Chinese" );
   // Genrer
        assertEquals(GenreFed.getText(),"female");
   //Opinion:
        assertEquals(Opinion.getText(),"Why me?" );
   //Comment
        assertEquals(Comment.getText(),"Veni, vidi, vici." );
//        check that the button yes is green and no is red but both have white letters
   //Yes button
        WebElement Yesbutton= driver.findElement(By.xpath("//button[text()='Yes']"));
        assertEquals("rgba(255, 255, 255, 1)", Yesbutton.getCssValue("color"));
        assertEquals("rgba(76, 175, 80, 1)", Yesbutton.getCssValue("background-color"));

    //No button
        WebElement Nobutton= driver.findElement(By.xpath("//button[text()='No']"));
        assertEquals("rgba(255, 255, 255, 1)", Nobutton.getCssValue("color"));
        assertEquals("rgba(244, 67, 54, 1)", Nobutton.getCssValue("background-color"));

 // Scenario No1 for "Yes button"
        //P.S dont wanna run, becouse there another scenario for Yes
        // I just putt in comment or all below when check, or scenario no1 ;D
        Yesbutton= driver.findElement(By.xpath("//button[text()='Yes']"));
        Yesbutton.click();

        WebElement message= driver.findElement((By.id("message")));
        assertEquals(message.getText(), "Thank you, "+ MyName+", for your feedback!" );


//Scenario for "No button"
      Nobutton= driver.findElement(By.xpath("//button[text()='No']"));
        Nobutton.click();

        assertEquals("https://kristinek.github.io/test-sample/tasks/task4", driver.getCurrentUrl());
        Thread.sleep(5000);

// Check taht all fields have previous info:
     //Name
        Name = driver.findElement(By.id("fb_name"));
        assertEquals(Name.getAttribute("value"), MyName);
     //Age
        age = driver.findElement(By.id("fb_age"));
        assertEquals(age.getAttribute("value"), MyAge);
   // Languages
        boxEng = driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'"));
        assertTrue(boxEng.isSelected());

        boxFrench = driver.findElement(By.cssSelector(".w3-check[value='French'][type='checkbox'"));
        assertTrue(boxFrench.isSelected());

        boxChin = driver.findElement(By.cssSelector(".w3-check[value='Chinese'][type='checkbox'"));
        assertTrue(boxChin.isSelected());
    //Gender
        Genre = driver.findElement(By.cssSelector(".w3-radio[value='female'][type='radio'"));
        assertTrue(Genre.isSelected());

    //Option
        option = new Select(driver.findElement(By.id("like_us")));
        option.selectByVisibleText("Why me?");
        assertEquals("Why me?", option.getFirstSelectedOption().getText());

    //Comment
        commentBox = driver.findElement(By.cssSelector("textarea[name='comment']"));
        assertEquals(commentBox.getAttribute("value"), comment);



        //Make Changes:
// Clear name and leave it empty
        Name.clear();
        assertEquals(Name.getAttribute("value"), "");


// Change age
     String age2="33";
        age.clear();
        age.sendKeys(age2);
        assertEquals(age.getAttribute("value"), age2);
 // Change gender
        WebElement Genre2 = driver.findElement(By.cssSelector(".w3-radio[value='male'][type='radio'"));
        Genre2.click();
        assertTrue(Genre2.isSelected());

// Add to comment:
        String Addcomment= "(c) Guy Julius Caesar";
        commentBox.sendKeys(Addcomment);
        assertEquals(commentBox.getAttribute("value"), comment + Addcomment);

  //For check before "send" button
        Thread.sleep(5000);

 // Again button send
        sendbutton= driver.findElement(By.xpath("//button[text()='Send']"));
        assertTrue(sendbutton.isEnabled());
        sendbutton.click();

  //Check all info again:
        //Field Name
        FedName = driver.findElement((By.id("name")));
        assertEquals(FedName.getText(),"");

        // Field Age
        FedAge=driver.findElement((By.id("age")));
        assertEquals(FedAge.getText(),age2 );

        // Field Languages
        Languages=driver.findElement((By.id("language")));
        assertEquals(Languages.getText(),"English,French,Chinese" );

        // Genrer
        GenreFed =driver.findElement((By.id("gender")));
        assertEquals(GenreFed.getText(),"male");

        //Opinion:
        Opinion=driver.findElement((By.id("option")));
        assertEquals(Opinion.getText(),"Why me?" );

        //Comment
        Comment=driver.findElement((By.id("comment")));
        assertEquals(Comment.getText(),"Veni, vidi, vici.(c) Guy Julius Caesar" );



 // Scenario for "Yes button" for second case:
     WebElement Yesbutton= driver.findElement(By.xpath("//button[text()='Yes']"));
       Yesbutton.click();

       WebElement message= driver.findElement((By.id("message")));
        assertEquals(message.getText(), "Thank you for your feedback!" );




    }
}
