package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;
import pages.RecruimentPage;

public class RecruimentStepsDefs {

    private final DashboardPage dashboardPage = new DashboardPage();
    private final RecruimentPage recruitmentPage = new RecruimentPage();

    @When("User navigates to the Recruitment module")
    public void userNavigatesToRecruitmentModule() {
        dashboardPage.clickRecruitmentModule();
    }

    @And("User opens the Add Candidate section")
    public void userOpensAddCandidateSection() {
        recruitmentPage.clickAddButton();
    }

    @And("User enters candidate first name {string}, last name {string}, and email {string}")
    public void userEntersCandidateDetails(String firstName, String lastName, String email) {
        recruitmentPage.enterFirstName(firstName);
        recruitmentPage.enterLastName(lastName);
        recruitmentPage.enterEmail(email);
    }

    @And("User submits the candidate application")
    public void userSubmitsTheCandidateApplication() {
        recruitmentPage.clickSaveButton();
    }

    @Then("A success message for adding candidate should be displayed")
    public void successMessageForAddingCandidateShouldBeDisplayed() {
        Assert.assertTrue(recruitmentPage.isAddCandidateSuccessMessageDisplayed(), "Success message is not displayed");
    }
}
