package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;
import utilities.WaitUtils;

import java.time.Duration;

public class TimeSheetPage extends BasePage {

    public TimeSheetPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module') and text()='Time']")
    private WebElement timeModuleItem;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button') and text()=' View ']")
    private WebElement viewButton;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--ghost') and text()=' Edit ']")
    private WebElement editButton;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement firstEntryInput;

    @FindBy(xpath = "//div[contains(@class, 'oxd-select-text-input') and text()='-- Select --']")
    private WebElement secondEntryInput;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button') and text()=' Save ']")
    private WebElement saveButton;

    @FindBy(className = "oxd-toast-container")
    private WebElement successPopup;

    public boolean isTimeSheetDisplayed() {
        WaitUtils.waitUntilElmIsVisible(timeModuleItem);
        return timeModuleItem.isDisplayed();
    }

    public void searchEmployee(String employeeName) {
        WaitUtils.waitUntilElmIsVisible(employeeNameInput);

        employeeNameInput.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));", employeeNameInput, employeeName);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement firstSuggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'oxd-autocomplete-dropdown')]//div[@role='option'][1]")));

            firstSuggestion.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to select the first suggestion for employee name.");
        }
    }

    public void clickViewButton() {
        WaitUtils.waitUntilElmIsClickable(viewButton);
        viewButton.click();
    }

    public void clickEditButton() {
        WaitUtils.waitUntilElmIsClickable(editButton);
        editButton.click();
    }

    public void fillFirstEntry(String entryText) {

        WaitUtils.waitUntilElmIsVisible(firstEntryInput);
        firstEntryInput.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));", firstEntryInput, entryText);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement firstSuggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'oxd-autocomplete-dropdown')]//div[@role='option'][1]")));

            firstSuggestion.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to select the first suggestion for employee name.");
        }
    }

    public void fillSecondEntry(String entryText) {

        WaitUtils.waitUntilElmIsClickable(secondEntryInput);
        secondEntryInput.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']//div[@role='option'][2]//span")));
        firstOption.click();
    }

    public void clickSaveButton() {
        WaitUtils.waitUntilElmIsClickable(saveButton);
        saveButton.click();
    }

    public boolean isSuccessPopupDisplayed() {
        WaitUtils.waitUntilElmIsVisible(successPopup);
        return successPopup.isDisplayed();
    }
}
