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

    @FindBy(xpath = "//a[contains(@class, 'oxd-main-menu') and contains(., 'PIM')]")
    private WebElement pimModuleLink;

    @FindBy(xpath = "//a[contains(@class, 'oxd-main-menu') and contains(., 'Buzz')]")
    private WebElement buzzModuleLink;

    @FindBy(xpath = "//a[contains(@class, 'oxd-main-menu') and contains(., 'Claim')]")
    private WebElement claimModuleLink;

    @FindBy(xpath = "//a[contains(@class, 'oxd-main-menu') and contains(., 'Leave')]")
    private WebElement leaveModuleLink;

    @FindBy(xpath = "//a[contains(@class, 'oxd-main-menu') and contains(., 'Recruitment')]")
    private WebElement recruitmentModuleLink;

    public void clickProfileDropdown() {
        WaitUtils.waitUntilElmIsClickable(profileDropdown);
        profileDropdown.click();
    }

    public void clickLogoutButton() {
        WaitUtils.waitUntilElmIsClickable(logoutButton);
        logoutButton.click();
    }

    public void clickPIMModule() {
        WaitUtils.waitUntilElmIsClickable(pimModuleLink);
        pimModuleLink.click();
    }

    public void clickBuzzModule() {
        WaitUtils.waitUntilElmIsClickable(buzzModuleLink);
        buzzModuleLink.click();
    }

    public void clickClaimModule() {
        WaitUtils.waitUntilElmIsClickable(claimModuleLink);
        claimModuleLink.click();
    }

    public void clickLeaveModule() {
        WaitUtils.waitUntilElmIsClickable(leaveModuleLink);
        leaveModuleLink.click();
    }

    public void clickRecruitmentModule() {
        WaitUtils.waitUntilElmIsClickable(recruitmentModuleLink);
        recruitmentModuleLink.click();
    }

    public boolean isDashboardDisplayed() {
        WaitUtils.waitUntilElmIsVisible(dashboardHeader);
        return dashboardHeader.isDisplayed() && dashboardHeader.getText().equalsIgnoreCase("Dashboard");
    }

}
