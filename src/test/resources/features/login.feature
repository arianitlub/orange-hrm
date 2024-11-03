@orangehrm_login
Feature: OrangeHRM login positive and negative scenarios

  @orangehrm_positiveLogin
  Scenario Outline: Positive login
    Given User is on the Orange HRM login page
    When User fills valid <username>, <password>
    And User clicks the login button
    Then User should see the dashboard

    Examples:
      | username | password  |
      | Admin    | admin123  |

  @orangehrm_negativeLogin
  Scenario Outline: Negative login
    Given User is on the Orange HRM login page
    When User fills invalid <username>, <password>
    And User clicks the login button
    Then User should see an error message

    Examples:
      | username    | password  |
      | Admin       | wrongPwd  |
      | wrongUser   | admin123  |
      | arianit     | admin123  |