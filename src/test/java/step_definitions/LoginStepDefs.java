package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.testng.Assert.assertTrue;

public class LoginStepDefs {
    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private WebDriver driver = Driver.getDriver();

    @Given("User is on the Orange HRM login page")
    public void userIsOnOrangeHRMLoginPage() {
        driver.get(ConfigurationReader.getProperty("orangehrm.url"));
    }

    @When("User fills valid (.*), (.*)$")
    public void userFillsValidUsernamePassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User fills invalid (.*), (.*)$")
    public void userFillsInvalidUsernamePassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("User clicks the login button")
    public void userClicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User should see the dashboard")
    public void userShouldSeeTheDashboard() {
        assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed");
    }

    @Then("User should see an error message")
    public void userShouldSeeAnErrorMessage() {
        assertTrue(loginPage.isErrorDisplayed(), "Error message is not displayed");
    }
}
