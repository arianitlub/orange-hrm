package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ApplyLeavePage;
import pages.DashboardPage;

public class ApplyLeaveStepsDefs {

    private final DashboardPage dashboardPage = new DashboardPage();
    private final ApplyLeavePage applyLeavePage = new ApplyLeavePage();

    @When("User navigates to the Leave module")
    public void userNavigatesToLeaveModule() {
        dashboardPage.clickLeaveModule();
        applyLeavePage.navigateToLeaveSection();
    }

    @And("User opens the Apply Leave section")
    public void userOpensApplyLeaveSection() {
        applyLeavePage.clickApplyTab();
    }

    @And("User selects a leave type")
    public void userSelectsLeaveType() {
        applyLeavePage.selectLeaveType("CAN - FMLA");
    }

    @And("User sets the leave period from {string} to {string}")
    public void userSetsLeavePeriod(String fromDate, String toDate) {
        applyLeavePage.selectFromDate(fromDate);
        applyLeavePage.selectToDate(fromDate, toDate);
    }

    @And("User submits the leave application")
    public void userSubmitsLeaveApplication() {
        applyLeavePage.clickApplyButton();
    }

    @Then("A success message for applying leave should be displayed")
    public void successMessageForApplyingLeaveShouldBeDisplayed() {
        Assert.assertTrue(applyLeavePage.isApplySuccessMessageDisplayed(), "Success message is not displayed");
    }
}
