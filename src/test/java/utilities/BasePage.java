package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected static WebDriver driver = Driver.getDriver();
    protected static Faker faker = new Faker();
    protected static Actions actions = new Actions(driver);
    protected static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));;
    protected static Select select;
    protected static Alert alert;

    public BasePage(){
        PageFactory.initElements(driver, this);
    }
}
