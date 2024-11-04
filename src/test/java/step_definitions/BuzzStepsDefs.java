package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BuzzPage;
import pages.DashboardPage;

public class BuzzStepsDefs {

    private final DashboardPage dashboardPage = new DashboardPage();
    BuzzPage buzzPage = new BuzzPage();

    @When("User navigates to the Buzz module")
    public void userNavigatesToBuzzModule() {
        dashboardPage.clickBuzzModule();
        Assert.assertTrue(buzzPage.isBuzzPageDisplayed(), "PIM page is not displayed");
    }

    @And("User writes {string} in the status input")
    public void userWritesInStatusInput(String statusMessage) {
        buzzPage.enterStatusMessage(statusMessage);
    }

    @And("User clicks the Post button")
    public void userClicksPostButton() {
        buzzPage.clickPostButton();
    }

    @Then("A success message for posting should be displayed")
    public void successMessageForPostingShouldBeDisplayed() {
        Assert.assertTrue(buzzPage.isPostSuccessMessageDisplayed(), "Success message for posting is not displayed");
    }
}
