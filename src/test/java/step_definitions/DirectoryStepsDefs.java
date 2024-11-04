package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;
import pages.DirectoryPage;

public class DirectoryStepsDefs {

    DirectoryPage directoryPage = new DirectoryPage();

    DashboardPage dashboardPage = new DashboardPage();

    @When("User navigates to the Directory module")
    public void userNavigatesToTheDirectoryModule() {
        dashboardPage.clickDirectoryModule();
        Assert.assertTrue(directoryPage.isDirectoryDisplayed(), "Claim page is not displayed");
    }

    @And("User enters {string} in the Employee Name field")
    public void userEntersEmployeeName(String employeeName) {
        directoryPage.enterEmployeeName(employeeName);
    }

    @And("User clicks the Search button")
    public void userClicksTheSearchButton() {
        directoryPage.clickSearchButton();
    }

    @Then("User should see that at least one record is found")
    public void userShouldSeeThatAtLeastOneRecordIsFound() {
        Assert.assertTrue(directoryPage.isRecordFound(),"No records found");
    }
}
