package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ClaimPage;
import pages.DashboardPage;

public class ClaimStepsDefs {
    DashboardPage dashboardPage = new DashboardPage();
    ClaimPage claimPage = new ClaimPage();

    @When("User navigates to the Claim module")
    public void userNavigatesToClaimModule() {
        dashboardPage.clickClaimModule();
        Assert.assertTrue(claimPage.isClaimDisplayed(), "Claim page is not displayed");
    }

    @And("User clicks on the {string} button")
    public void userClicksOnAssignClaimButton(String button) {
        claimPage.clickAssignClaimButton();
    }

    @And("User enters Employee Name {string}, selects Event, and sets Currency")
    public void userFillsClaimDetails(String employeeName) {
        claimPage.enterEmployeeName(employeeName);
        claimPage.selectEvent();
        claimPage.selectCurrency();
    }

    @And("User clicks the create button")
    public void userClicksCreateButton() {
        claimPage.clickCreateButton();
    }

    @Then("A success message for assigning the claim should be displayed")
    public void successMessageDisplayed() {
        claimPage.verifySuccessMessage();
    }
}
