package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BasePage;
import utilities.Driver;
import utilities.WaitUtils;

public class RequestPasswordPage extends BasePage {

    public RequestPasswordPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(xpath = "//button[contains(., 'Reset Password')]")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "//h6[contains(@class, 'oxd-text--h6 orangehrm-forgot-password-title')]")
    private WebElement successMessage;

    public RequestPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        WaitUtils.waitUntilElmIsVisible(usernameField);
        usernameField.sendKeys(username);
    }

    public void clickResetPasswordButton() {
        WaitUtils.waitUntilElmIsClickable(resetPasswordButton);
        WaitUtils.waitUntilElmIsClickable(resetPasswordButton);
        resetPasswordButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        WaitUtils.waitUntilElmIsVisible(successMessage);
        return successMessage.isDisplayed();
    }
}
