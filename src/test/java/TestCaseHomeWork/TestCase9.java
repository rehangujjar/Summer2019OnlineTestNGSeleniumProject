package TestCaseHomeWork;

import TestCaseHomeWork.Utilities.BrowserFactory;
import TestCaseHomeWork.Utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase9 {
    private WebDriver driver;
    private WebDriverWait wait;
    //@Test
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        wait=new WebDriverWait(driver,10);
    }

   @Test(dataProvider ="verify data")
  public void TestCase9(String link, String expectedresult){
     WebElement button=  driver.findElement(By.linkText(link));
     wait.until(ExpectedConditions.visibilityOf(button));
       button.click();

      WebElement text= driver.findElement(By.xpath("//p"));

      wait.until(ExpectedConditions.visibilityOf(text));
        String actualresult= text.getText();

        int textdot=actualresult.indexOf(".");
        actualresult=actualresult.substring(0,textdot);
        System.out.println( actualresult);
        Assert.assertEquals(actualresult, expectedresult);
   }

    @DataProvider(name ="verify data")
    public Object[][] verfiydata(){
        return new Object[][]{
                {"200", "This page returned a 200 status code"},
                {"301", "This page returned a 301 status code"},
                {"404", "This page returned a 404 status code"},
                {"500", "This page returned a 500 status code"}
        };
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    }