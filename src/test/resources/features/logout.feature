Feature: Logout functionality

  @orangehrm_positiveLogout
  Scenario Outline: User successfully logs out of the application
    Given User is on the Orange HRM login page
    When User fills valid <username>, <password>
    And User clicks the login button
    Then User should see the dashboard
    When the user clicks on the profile dropdown and selects Logout
    Then the user should be redirected to the login page

    Examples:
      | username | password  |
      | Admin    | admin123  |
