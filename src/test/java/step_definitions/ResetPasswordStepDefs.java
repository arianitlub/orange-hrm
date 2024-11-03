package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.RequestPasswordPage;
import pages.SendPasswordPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class ResetPasswordStepDefs {

    LoginPage loginPage = new LoginPage();
    RequestPasswordPage requestPasswordPage = new RequestPasswordPage();
    SendPasswordPage sendPasswordPage = new SendPasswordPage();
    private WebDriver driver = Driver.getDriver();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver.get(ConfigurationReader.getProperty("orangehrm.url"));
    }

    @When("the user clicks on the {string} link")
    public void theUserClicksOnTheLink(String linkText) {
        if (linkText.equals("Forgot your password?")) {
            loginPage.clickForgotPasswordLink();
        }
    }

    @Then("the {string} page should be displayed")
    public void thePageShouldBeDisplayed(String pageTitle) {
        Assert.assertTrue(requestPasswordPage.isSuccessMessageDisplayed(), "Reset Password page did not display as expected.");
    }

    @When("the user enters {string} as the username")
    public void theUserEntersAsTheUsername(String username) {
        requestPasswordPage.enterUsername(username);
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonText) {
        if (buttonText.equals("Reset Password")) {
            requestPasswordPage.clickResetPasswordButton();
        }
    }

    @Then("a success message should be displayed on the next page")
    public void aSuccessMessageShouldBeDisplayedOnTheNextPage() {
        Assert.assertTrue(sendPasswordPage.isSuccessMessageDisplayed(), "Success message not displayed.");
    }
}
