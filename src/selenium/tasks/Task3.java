package selenium.tasks;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Task3 {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openPage() {
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task4");
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void feedback() throws Exception{
// TODO:
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
        String[] languages = {"English", "French"};
        addData("Anna", "25", languages, "female", "Good", "The comment." );

//        check that the button send is blue with white letters
        checkAndClickButtonSend();

//        check that the feedback was filled correctly
        checkFeedBackIsFilledCorrectly("Anna", "25", languages, "female", "Good", "The comment.");

//        check that the button yes is green and no is red but both have white letters
        checkGreenAndRedButton();

       clickYesButton();

       checkFeedbackMessage("Anna");

    }


    @Test
    public void feedbackWithNo() throws Exception{
// TODO:
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
        String[] languages = {"English", "French"};
        addData("Anna", "25", languages, "female", "Good", "The comment." );

//        check that the button send is blue with white letters
        checkAndClickButtonSend();

//        check that the feedback was filled correctly
        checkFeedBackIsFilledCorrectly("Anna", "25", languages, "female", "Good", "The comment.");

//        check that the button yes is green and no is red but both have white letters
        checkGreenAndRedButton();

        clickNoButton();

        //re-check that all data are the same as before "sending"
        checkInputFormAfterReturn("Anna", "25", languages, "female", "Good", "The comment.");

        //clear all possible text fields before new input
        clearAllDataFromForm();

        String[] languages2 = {"Chinese"};
        addData("Bob", "30", languages2, "male", "Why me?", "Don't have one." );

//        check that the button send is blue with white letters
        checkAndClickButtonSend();
        clickYesButton();

        checkFeedbackMessage("Bob");

    }

    public void checkInputFormAfterReturn(String pName, String pAge, String[] pLanguages,
                                          String pGender, String pLikeUs, String pComment){

        assertEquals("Name is incorrect after return", pName, driver.findElement(By.cssSelector("#fb_name")).getAttribute("value"));
        assertEquals("Age is not correct after return", pAge, driver.findElement(By.cssSelector("#fb_age")).getAttribute("value"));

        List<WebElement> langs = driver.findElements(By.cssSelector("input[class = 'w3-check'][type = 'checkbox']"));

        for (WebElement e : langs){
            Boolean isSelected = false;
            for (String s : pLanguages){
              if (e.getAttribute("value").equalsIgnoreCase(s)){
                    isSelected = true;
                }
            }
            if(isSelected){
                assertTrue(e.isSelected());
            }else{
                assertFalse(e.isSelected());
            }
        }


        WebElement radioMale = driver.findElement(By.cssSelector("input[type='radio'][name='gender'][value='male']"));
        WebElement radioFemale = driver.findElement(By.cssSelector("input[type='radio'][name='gender'][value='female']"));
        if(pGender.equalsIgnoreCase("male")){
              assertTrue(radioMale.isSelected());
              assertFalse(radioFemale.isSelected());
        }
        else{
            if(pGender.equalsIgnoreCase("female")){
                assertFalse(radioMale.isSelected());
                assertTrue(radioFemale.isSelected());
            }
            else{
                assertFalse(radioMale.isSelected());
                assertFalse(radioFemale.isSelected());
            }
        }

      
        Select dropdown = new Select(driver.findElement(By.id("like_us")));
        assertEquals(pLikeUs, dropdown.getFirstSelectedOption().getAttribute("value"));

        assertEquals(pComment, driver.findElement(By.cssSelector("textarea[name='comment']")).getAttribute("value"));

    }

    public void clickNoButton(){
        driver.findElement(By.cssSelector(".w3-red")).click();
    }

    public void checkFeedbackMessage(String name){

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("message")));
        WebElement feedback_text = driver.findElement(By.id("message"));
        String expectedtext = "Thank you, " + name + ", for your feedback!";
        assertEquals("Feedback text is not correct", expectedtext, feedback_text.getText());
    }

   public void clickYesButton(){
       driver.findElement(By.cssSelector(".w3-green")).click();
   }

    public void checkGreenAndRedButton(){

        WebElement greenButton = driver.findElement(By.cssSelector(".w3-green"));
        WebElement redButton = driver.findElement(By.cssSelector(".w3-red"));

        assertEquals("The green button is not green", "rgba(76, 175, 80, 1)",
                                                           greenButton.getCssValue("background-color"));
        assertEquals("The red button is not red", "rgba(244, 67, 54, 1)",
                                                             redButton.getCssValue("background-color"));
        assertEquals("Text of the green button is not white", "rgba(255, 255, 255, 1)",
                greenButton.getCssValue("color"));

        assertEquals("Text of the red button is not white", "rgba(255, 255, 255, 1)",
                redButton.getCssValue("color"));


    }

    public void checkFeedBackIsFilledCorrectly(String pName, String pAge, String[] pLanguages,
                                               String pGender, String pLikeUs, String pComment ){
        //        check that the feedback was filled correctly

        assertEquals("Wrong page", "Is this the feedback you want to give us?", driver.findElement(By.tagName("h2")).getText());
        WebElement name = driver.findElement(By.id("name"));
        assertEquals("Name is not correct", pName, name.getText());

        WebElement age = driver.findElement(By.id("age"));
        assertEquals("Age is not correct", pAge, age.getText());

        String languagesSet = "";
        for (String s : pLanguages){
            languagesSet += s + ",";
        }
        languagesSet = languagesSet.substring(0, languagesSet.length()-1);
        assertEquals("Languages are not correct", languagesSet, driver.findElement(By.id("language")).getText());

        assertEquals("Gender is not correct", pGender, driver.findElement(By.id("gender")).getText());

        assertEquals("The opinion is not correct", pLikeUs, driver.findElement(By.id("option")).getText());

        assertEquals("The comment is not correct", pComment, driver.findElement(By.id("comment")).getText());

    }

    public void checkAndClickButtonSend(){

//        check that the button send is blue with white letters

        WebElement buttonSend = driver.findElement(By.xpath("//button[text()='Send']"));
        assertEquals("Button is not blue", "rgba(33, 150, 243, 1)", buttonSend.getCssValue("background-color"));
        assertEquals("Text of the button is not white", "rgba(255, 255, 255, 1)",
                             buttonSend.getCssValue("color"));
//       click "send"
        buttonSend.click();

    }

    public void addData(String name, String age, String[] languages, String gender, String likeUs, String comment ){
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
        WebElement fb_name = driver.findElement(By.cssSelector("#fb_name"));
        fb_name.sendKeys(name);
        WebElement fb_age = driver.findElement(By.cssSelector("#fb_age"));
        fb_age.sendKeys(age);

        for (String e : languages) {
            switch (e) {
                case "English":
                    WebElement checkBoxEng = driver.findElement
                            (By.cssSelector("input[class = 'w3-check'][type = 'checkbox'][value='English']"));
                    checkBoxEng.click();
                    break;
                case "French":
                    WebElement checkBoxFre = driver.findElement
                            (By.cssSelector("input[class = 'w3-check'][type = 'checkbox'][value='French']"));
                    checkBoxFre.click();
                    break;
                case "Spanish":
                    WebElement checkBoxSpa = driver.findElement
                            (By.cssSelector("input[class = 'w3-check'][type = 'checkbox'][value='Spanish']"));
                    checkBoxSpa.click();
                    break;
                case "Chinese":
                    WebElement checkBoxCha = driver.findElement
                            (By.cssSelector("input[class = 'w3-check'][type = 'checkbox'][value='Chinese']"));
                    checkBoxCha.click();
                    break;

            }
        }

        WebElement radio;
        switch (gender){
            case "male":
                radio = driver.findElement(By.cssSelector("input[type='radio'][name='gender'][value='male']"));
                radio.click();
                break;
            case "female":
                radio = driver.findElement(By.cssSelector("input[type='radio'][name='gender'][value='female']"));
                radio.click();
                break;
        }


       Select dropdown = new Select(driver.findElement(By.id("like_us")));
       dropdown.selectByVisibleText(likeUs);

        WebElement textAreaComment = driver.findElement(By.cssSelector("textarea[name='comment']"));
        textAreaComment.sendKeys(comment);
    }

    public void clearAllDataFromForm(){
        driver.findElement(By.cssSelector("#fb_name")).clear();
        driver.findElement(By.cssSelector("#fb_age")).clear();

        List<WebElement> languages = driver.findElements(By.cssSelector("input[class = 'w3-check'][type = 'checkbox']"));
        for (WebElement e : languages){
            if(e.isSelected()){
                e.click();
            }
        }

        driver.findElement(By.cssSelector("textarea[name='comment']")).clear();

    }
}
