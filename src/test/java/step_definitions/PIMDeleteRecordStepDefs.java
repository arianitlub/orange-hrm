package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PimPage;
import utilities.Driver;

public class PIMDeleteRecordStepDefs {

    private final DashboardPage dashboardPage = new DashboardPage();
    private final PimPage pimPage = new PimPage();

    @When("User navigates to the PIM module")
    public void userNavigatesToPIMModule() {
        dashboardPage.clickPIMModule();
        Assert.assertTrue(pimPage.isPIMPageDisplayed(), "PIM page is not displayed");
    }

    @And("User selects a record to delete")
    public void userSelectsRecordToDelete() {
        pimPage.clickDeleteIconForFirstRecord();
    }

    @And("User confirms the deletion in the popup")
    public void userConfirmsDeletionInPopup() {
        pimPage.confirmDeletion();
    }

    @Then("A success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        Assert.assertTrue(pimPage.isDeletionSuccessMessageDisplayed(), "Success message is not displayed");
    }
}
