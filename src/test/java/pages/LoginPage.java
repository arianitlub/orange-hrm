package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BasePage;
import utilities.Driver;
import utilities.WaitUtils;

public class LoginPage extends BasePage {

    public LoginPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@class='oxd-alert-content oxd-alert-content--error']")
    private WebElement errorMessage;

    public void enterUsername(String username) {

        WaitUtils.waitUntilElmIsVisible(usernameField);
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WaitUtils.waitUntilElmIsVisible(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WaitUtils.waitUntilElmIsVisible(loginButton);
        loginButton.click();
    }

    public boolean isErrorDisplayed() {
        WaitUtils.waitUntilElmIsVisible(errorMessage);
        return errorMessage.isDisplayed();
    }
}
