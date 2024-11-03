package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils{

    private static WebDriver driver = Driver.getDriver();
    private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void waitUntilElmIsClickable(WebElement elm){

        wait.until(ExpectedConditions.elementToBeClickable(elm));
    }

    public static void waitUntilElmIsVisible(WebElement elm){

        wait.until(ExpectedConditions.visibilityOf(elm));
    }

    public static void waitUntilTitleContains(String title){

        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void waitUntilElmIsPresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void sleep(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
