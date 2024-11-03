package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;
import utilities.WaitUtils;


public class DashboardPage extends BasePage {
    @FindBy(xpath = "//*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement dashboardHeader;

    @FindBy(className = "oxd-userdropdown-name")
    private WebElement profileDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutButton;

    public void clickProfileDropdown() {
        WaitUtils.waitUntilElmIsClickable(profileDropdown);
        profileDropdown.click();
    }

    public void clickLogoutButton() {
        WaitUtils.waitUntilElmIsClickable(logoutButton);
        logoutButton.click();
    }

    public boolean isDashboardDisplayed() {
        WaitUtils.waitUntilElmIsVisible(dashboardHeader);
        return dashboardHeader.isDisplayed() && dashboardHeader.getText().equalsIgnoreCase("Dashboard");
    }
}
