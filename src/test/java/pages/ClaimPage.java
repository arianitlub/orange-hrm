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

public class ClaimPage extends BasePage {
    public ClaimPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module') and text()='Claim']")
    private WebElement claimMenuItem;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button--secondary') and contains(., ' Assign Claim ')]")
    private WebElement assignClaimButton;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;

    @FindBy(xpath = "//div[contains(@class, 'oxd-select-text') and contains(., '-- Select --')]")
    private WebElement eventDropdown;

    @FindBy(xpath = "//div[contains(@class, 'oxd-select-text') and contains(., '-- Select --')]")
    private WebElement currencyDropdown;

    @FindBy(css = "button.oxd-button--secondary.orangehrm-left-space")
    private WebElement createButton;

    @FindBy(className = "oxd-toast-container")
    private WebElement successMessage;

    public boolean isClaimDisplayed() {
        WaitUtils.waitUntilElmIsClickable(claimMenuItem);
        return claimMenuItem.isDisplayed();
    }

    public void clickAssignClaimButton() {
        WaitUtils.waitUntilElmIsVisible(assignClaimButton);
        assignClaimButton.click();
    }

    public void enterEmployeeName(String employeeName) {
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

    public void selectEvent() {
        WaitUtils.waitUntilElmIsClickable(eventDropdown);
        eventDropdown.click();

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

    public void selectCurrency() {
        WaitUtils.waitUntilElmIsClickable(currencyDropdown);
        currencyDropdown.click();

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

    public void clickCreateButton() {
        WaitUtils.waitUntilElmIsClickable(createButton);
        createButton.click();
    }

    public void verifySuccessMessage() {
        WaitUtils.waitUntilElmIsVisible(successMessage);
        assert successMessage.isDisplayed();
    }
}
