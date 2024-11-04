package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BasePage;
import utilities.WaitUtils;

public class BuzzPage extends BasePage {

    public BuzzPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module') and text()='Buzz']")
    private WebElement buzzMenuItem;

    @FindBy(css = "textarea.oxd-buzz-post-input")
    private WebElement statusInput;

    @FindBy(css = "button.oxd-button.oxd-button--medium.oxd-button--main")
    private WebElement postButton;

    @FindBy(className = "oxd-toast-container")
    private WebElement successMessage;

    public boolean isBuzzPageDisplayed() {
        WaitUtils.waitUntilElmIsClickable(buzzMenuItem);
        return buzzMenuItem.isDisplayed();
    }

    public void enterStatusMessage(String message) {
        WaitUtils.waitUntilElmIsVisible(statusInput);
        statusInput.clear();
        statusInput.sendKeys(message);
    }

    public void clickPostButton() {
        WaitUtils.waitUntilElmIsClickable(postButton);
        postButton.click();
    }

    public boolean isPostSuccessMessageDisplayed() {
        WaitUtils.waitUntilElmIsVisible(successMessage);
        return successMessage.isDisplayed();
    }
}
