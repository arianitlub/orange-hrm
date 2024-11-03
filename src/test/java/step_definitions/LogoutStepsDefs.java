package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.Driver;

public class LogoutStepsDefs {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final WebDriver driver = Driver.getDriver();

    @When("User fills valid {string}, {string}")
    public void userFillsValidCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user clicks on the profile dropdown and selects Logout")
    public void theUserClicksOnTheProfileDropdownAndSelectsLogout() {
        dashboardPage.clickProfileDropdown();
        dashboardPage.clickLogoutButton();
    }

    @Then("the user should be redirected to the login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        Assert.assertTrue(loginPage.loginButonIsDisplay(), "Login page is not displayed after logout.");
    }
}
