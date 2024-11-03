package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.WaitUtils;

public class ApplyLeavePage {

    private final WebDriver driver = Driver.getDriver();

    public ApplyLeavePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Leave']")
    private WebElement leaveMenu;

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item' and text()='Apply']")
    private WebElement applyTab;

    @FindBy(xpath = "//div[@class='oxd-select-text-input' and contains(text(),'Select')]")
    private WebElement leaveTypeDropdown;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input oxd-input--active')])[1]")
    private WebElement fromDateInput;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input oxd-input--active')])[2]")
    private WebElement toDateInput;

    @FindBy(css = "button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    private WebElement applyButton;


    @FindBy(className = "oxd-toast-container")
    private WebElement successMessageContainer;

    public void navigateToLeaveSection() {
        WaitUtils.waitUntilElmIsClickable(leaveMenu);
        leaveMenu.click();
    }

    public void clickApplyTab() {
        WaitUtils.waitUntilElmIsClickable(applyTab);
        applyTab.click();
    }

    public void selectLeaveType(String leaveType) {
        WaitUtils.waitUntilElmIsClickable(leaveTypeDropdown);
        leaveTypeDropdown.click();
        WebElement leaveOption = driver.findElement(By.xpath("//span[contains(text(),'" + leaveType + "')]"));
        leaveOption.click();
    }

    public void selectFromDate(String fromDate) {
        WaitUtils.waitUntilElmIsClickable(fromDateInput);
        fromDateInput.clear();
        toDateInput.sendKeys(fromDate);
    }

    public void selectToDate(String fromDate, String toDate) {
        WaitUtils.waitUntilElmIsClickable(toDateInput);
        toDateInput.sendKeys(toDateInput.getText().replace(fromDate, toDate));
    }

    public void clickApplyButton() {
        WaitUtils.waitUntilElmIsClickable(applyButton);
        applyButton.click();
    }

    public boolean isApplySuccessMessageDisplayed() {
        WaitUtils.waitUntilElmIsVisible(successMessageContainer);
        return successMessageContainer.isDisplayed();
    }
}
