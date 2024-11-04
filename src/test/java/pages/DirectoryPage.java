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

public class DirectoryPage extends BasePage {

    public DirectoryPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module') and text()='Directory']")
    private WebElement directoryMenuItem;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button--secondary') and text()=' Search ']")
    private WebElement searchButton;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']")
    private WebElement recordsFound;

    public boolean isDirectoryDisplayed() {
        WaitUtils.waitUntilElmIsVisible(directoryMenuItem);
        return directoryMenuItem.isDisplayed();
    }

    public void clickDirectoryMenuItem() {
        WaitUtils.waitUntilElmIsClickable(directoryMenuItem);
        directoryMenuItem.click();
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

    public void clickSearchButton() {
        WaitUtils.waitUntilElmIsClickable(searchButton);
        searchButton.click();
    }

    public boolean isRecordFound() {
        WaitUtils.waitUntilElmIsVisible(recordsFound);
        return recordsFound.isDisplayed();
    }
}
