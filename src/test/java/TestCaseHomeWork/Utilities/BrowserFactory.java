package TestCaseHomeWork.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    //we gonna create a method
    //that will return driver object
    public static WebDriver getDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        }
        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("EdgeDriver")){
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("safari")){
            //WebDriverManager.SafariDriver.setup();
            return  null;
        }
        return null;


    }
}
