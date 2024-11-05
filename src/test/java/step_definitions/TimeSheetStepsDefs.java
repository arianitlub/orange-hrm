package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;
import pages.TimeSheetPage;

public class TimeSheetStepsDefs {

    DashboardPage dashboardPage = new DashboardPage();

    TimeSheetPage timesheetPage = new TimeSheetPage();

    @When("User navigates to the Timesheet module")
    public void userNavigatesToTimesheetModule() {
        dashboardPage.clickTimeSheetModule();
        Assert.assertTrue(timesheetPage.isTimeSheetDisplayed(), "Claim page is not displayed");
    }

    @When("User searches for employee name {string}")
    public void userSearchesForEmployeeName(String employeeName) {
        timesheetPage.searchEmployee(employeeName);
    }

    @And("User clicks {string} for the employee's timesheet")
    public void userClicksViewForTheEmployeesTimesheet(String action) {
        timesheetPage.clickViewButton();
    }

    @And("User clicks {string} on the timesheet")
    public void userClicksEditOnTheTimesheet(String action) {
        timesheetPage.clickEditButton();
    }

    @And("User fills the first entry with {string}")
    public void userFillsTheFirstEntry(String entryText) {
        timesheetPage.fillFirstEntry(entryText);
    }

    @And("User fills the second entry with {string}")
    public void userFillsTheSecondEntry(String entryText) {
        timesheetPage.fillSecondEntry(entryText);
    }

    @And("User clicks {string}")
    public void userClicksSave(String action) {
        timesheetPage.clickSaveButton();
    }

    @Then("A success popup is displayed at the bottom indicating the save was successful")
    public void successPopupIsDisplayed() {
        Assert.assertTrue(timesheetPage.isSuccessPopupDisplayed(),"Success popup was not displayed");
    }
}
