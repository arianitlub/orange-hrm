package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BasePage;
import utilities.Driver;
import utilities.WaitUtils;

public class PimPage extends BasePage {

    private final WebDriver driver = Driver.getDriver();

    public PimPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module') and text()='PIM']")
    private WebElement pimMenuItem;

    @FindBy(xpath = "//button[contains(@class, 'oxd-icon-button')]/i[contains(@class, 'bi-trash')]")
    private WebElement deleteIcon;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button--label-danger')]")
    private WebElement confirmDeleteButton;

    @FindBy(className = "oxd-toast-container")
    private WebElement successMessageContainer;

    public boolean isPIMPageDisplayed() {
        WaitUtils.waitUntilElmIsClickable(pimMenuItem);
        return pimMenuItem.isDisplayed();
    }

    public void clickDeleteIconForFirstRecord() {
        WaitUtils.waitUntilElmIsClickable(deleteIcon);
        deleteIcon.click();
    }

    public void confirmDeletion() {
        WaitUtils.waitUntilElmIsClickable(confirmDeleteButton);
        confirmDeleteButton.click();
    }

    public boolean isDeletionSuccessMessageDisplayed() {
        WaitUtils.waitUntilElmIsVisible(successMessageContainer);
        return successMessageContainer.isDisplayed();
    }
}
