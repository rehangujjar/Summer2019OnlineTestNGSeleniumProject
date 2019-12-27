package TestCaseHomeWork;

import TestCaseHomeWork.Utilities.BrowserFactory;
import TestCaseHomeWork.Utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase7 {
    private WebDriver driver;

    @Test
    public void Testcase6() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("File Upload")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.cssSelector("[id='file-upload']")).sendKeys("C:\\Users\\sadia\\Desktop\\public class Batch12.txt");
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(3);
       WebElement uploaded= driver.findElement(By.xpath("//h3['File Uploaded!']"));
        BrowserUtils.wait(3);
        String actual=uploaded.getText();
        String expected="File Uploaded!";
        BrowserUtils.wait(3);
        Assert.assertEquals(actual,expected,"file is not uploaded");
        BrowserUtils.wait(3);
        WebElement uploadedfile=driver.findElement(By.cssSelector("[id='uploaded-files']"));
        BrowserUtils.wait(3);
        Assert.assertTrue(uploadedfile.isDisplayed(),"its not displayed");
        BrowserUtils.wait(3);




    }


}
