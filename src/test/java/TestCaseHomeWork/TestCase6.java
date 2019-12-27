package TestCaseHomeWork;

import TestCaseHomeWork.Utilities.BrowserFactory;
import TestCaseHomeWork.Utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase6 {
    private WebDriver driver;

    @Test
    public void Testcase6(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");
        BrowserUtils.wait(3);
       String email= driver.findElement(By.cssSelector("[id='email']")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//input[@*='full_name']")).sendKeys("Ryangggddd");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//input[@*='email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@*='submit']")).click();
        String actual=driver.findElement(By.cssSelector("[name='signup_message']")).getText();
        BrowserUtils.wait(3);
        String expected="Thank you for signing up. Click the button below to return to the home page.”";
         driver.navigate().to("https://www.tempmailaddress.com/");
         //email verification

        WebElement tempemail=driver.findElement(By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]"));
         String cybertekmail="do-not-reply@practice.cybertekschool.com";

            String emailvefification=tempemail.getText().trim();

         Assert.assertEquals(emailvefification,cybertekmail,"its not cybertek eamil");
       tempemail.click();
       String acutalsender =driver.findElement(By.cssSelector("[id='odesilatel']")).getText();
       String expectsender="do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(acutalsender,expectsender,"no its from cybertek");
        String actualsubject=driver.findElement(By.cssSelector("[id='predmet']")).getText();
        String expectsubject="Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualsubject,expectsubject);

    }
}
