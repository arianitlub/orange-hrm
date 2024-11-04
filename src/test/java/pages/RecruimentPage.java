package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BasePage;
import utilities.WaitUtils;

public class RecruimentPage extends BasePage {

    public RecruimentPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "a[href*='viewRecruitmentModule']")
    private WebElement recruitmentModule;

    @FindBy(xpath = "//button[contains(., ' Add ')]")
    private WebElement addButton;

    @FindBy(css = "input.oxd-input.oxd-input--active.orangehrm-firstname")
    private WebElement firstNameInput;

    @FindBy(css = "input.oxd-input--active.orangehrm-lastname")
    private WebElement lastNameInput;

    @FindBy(xpath = "//ancestor_element_xpath//input[@placeholder='Type here']")
    private WebElement emailInput;

    @FindBy(css = "button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    private WebElement saveButton;

    @FindBy(className = "oxd-toast-container")
    private WebElement successMessage;

    public void clickRecruitmentModule() {
        recruitmentModule.click();
    }

    public void clickAddButton() {
        WaitUtils.waitUntilElmIsVisible(addButton);
        WaitUtils.waitUntilElmIsClickable(addButton);
        addButton.click();
    }

    public void enterFirstName(String firstName) {
        WaitUtils.waitUntilElmIsVisible(firstNameInput);
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WaitUtils.waitUntilElmIsVisible(lastNameInput);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('input[data-dashlane-rid=\"d67b0e4ec3e4fa71\"]').value = arguments[0];", email);
    }

    public void clickSaveButton() {
        WaitUtils.waitUntilElmIsClickable(saveButton);
        saveButton.click();
    }

    public boolean isAddCandidateSuccessMessageDisplayed() {
       WaitUtils.waitUntilElmIsVisible(successMessage);
       return successMessage.isDisplayed();
    }
}
