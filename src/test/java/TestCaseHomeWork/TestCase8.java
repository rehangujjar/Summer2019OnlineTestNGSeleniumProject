package TestCaseHomeWork;

import TestCaseHomeWork.Utilities.BrowserFactory;
import TestCaseHomeWork.Utilities.BrowserUtils;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase8 {
    private WebDriver driver;
    @Test
    public void Testcase8(){
        driver =BrowserFactory.getDriver("chrome");
       driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.cssSelector("[id='myCountry']")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("[type='button']")).click();
        String actual=driver.findElement(By.cssSelector("[id='result']")).getText();

        String expected="You selected: United States of America";
        Assert.assertEquals(actual,expected);




    }




}
