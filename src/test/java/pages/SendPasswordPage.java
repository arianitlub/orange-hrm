package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BasePage;
import utilities.Driver;
import utilities.WaitUtils;

public class SendPasswordPage extends BasePage {

    public SendPasswordPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h6.oxd-text--h6.orangehrm-forgot-password-title")
    public WebElement successMessage;

    public boolean isSuccessMessageDisplayed() {
        WaitUtils.waitUntilElmIsVisible(successMessage);
        return successMessage.isDisplayed();
    }
}
