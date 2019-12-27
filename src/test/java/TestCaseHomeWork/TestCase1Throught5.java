package TestCaseHomeWork;

import TestCaseHomeWork.Utilities.BrowserFactory;
import TestCaseHomeWork.Utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase1Throught5 {
      private WebDriver driver;
      private WebDriverWait wait;

     @BeforeMethod
    public void setup(){
         driver= BrowserFactory.getDriver("chrome");
         driver.get("https://practice-cybertekschool.herokuapp.com/");
        //BrowserUtils.wait(5);
         driver.findElement(By.linkText("Registration Form")).click();
     }

     @Test(description = "Verify that warning message is displayed: ")
     public void test1(){

         driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
         String actual= driver.findElement(By.xpath("//small[@*='INVALID']")).getText();
         String expected="The date of birth is not valid";
         Assert.assertEquals(actual,expected,"its wrong result");

     }

     @Test(description = "Verify that following options for programming languages are displayed: c++, java, JavaScript")
    public void test2(){
        List<WebElement> checkboxs=driver.findElements(By.xpath("//input[@*='form-check-input']"));

         for (WebElement checkbox:checkboxs) {
           if(!checkbox.isSelected()) {

             checkbox.click();

          }
             Assert.assertTrue(checkbox.isDisplayed(), "its not display");

         }
     }

    @Test(description = "Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”")
    public void tes3(){
              driver.findElement(By.name("firstname")).sendKeys("a");
            String actualresult=driver.findElement(By.cssSelector("[data-bv-result='INVALID']")).getText();
            String expectedresult="first name must be more than 2 and less than 64 characters long";
            Assert.assertEquals(actualresult,expectedresult,"result is not same");
    }

    @Test(description = " Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”")
     public void test4(){

        driver.findElement(By.name("lastname")).sendKeys("b");
        String actaual=driver.findElement(By.cssSelector("[data-bv-result='INVALID']")).getText();
        String expected="The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actaual,expected);
        BrowserUtils.wait(2);
    }

    @Test(description = "Verify that registration form completion message is displayed")
    public void test5(){
        driver.findElement(By.name("firstname")).sendKeys("rehan");
        driver.findElement(By.name("lastname")).sendKeys("mehmood");
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("rehanmehmood");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("reh55@gmail.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("qwertyui");
        BrowserUtils.wait(2);
        driver.findElement(By.name("phone")).sendKeys("516-829-3333");
        driver.findElement(By.cssSelector("[value='male']")).click();

        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("01/02/2001");

        WebElement dropdown= driver.findElement(By.cssSelector("[name='department']"));
        Select select= new Select(dropdown);
        select.selectByVisibleText("Department of Engineering");
        BrowserUtils.wait(2);

        WebElement dropdown2=driver.findElement(By.cssSelector("[name='job_title']"));
        BrowserUtils.wait(2);
        Select select12= new Select(dropdown2);
        select12.selectByVisibleText("Manager");
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[id=\"inlineCheckbox2\"]")).click();
        driver.findElement(By.cssSelector("[id=\"wooden_spoon\"]")).click();
       String actualresult= driver.findElement(By.xpath("//p[\"You've successfully completed registration!\"]")).getText();
       String expectedresult="You've successfully completed registration!";
       Assert.assertEquals(actualresult,expectedresult,"its not match");

    }
    @AfterMethod
     public void teardown(){
         System.out.println("After method!");
         driver.quit();
     }
}
