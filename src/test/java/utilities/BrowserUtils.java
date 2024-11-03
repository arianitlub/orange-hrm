package utilities;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowserUtils extends BasePage{


    public static void pageVerification(String exp, String act){

        Assert.assertEquals(exp, act);
    }

    public static void selectByValue(String str, WebElement elm){

        select = new Select(elm);
        select.selectByValue(str);
    }

    public static void selectByVisibleText(String str, WebElement elm){

        select = new Select(elm);
        select.selectByVisibleText(str);
    }

    public static void moveToElement(WebElement elm){

        actions.moveToElement(elm).click().perform();
    }

    public static void dragAndDropTest(WebElement startLocation, WebElement destination) {

        actions.dragAndDrop(startLocation, destination).perform();
    }

    public static void switchToAlert(){

        alert = driver.switchTo().alert();
    }

    public static void switchToParentFrame(){

        driver.switchTo().parentFrame();
    }

    public static void switchToFrame(String name){

        driver.switchTo().frame(name);
    }
}
