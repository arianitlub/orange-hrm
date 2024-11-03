package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private Driver (){ }

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver == null){

            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    throw new RuntimeException("Browser type is wrong");
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!= null){
            driver.quit();
            driver = null;
        }
    }
}
