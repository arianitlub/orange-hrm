Feature: Search Employee in Directory module

  Scenario Outline: User successfully searches for an employee
    Given User is on the Orange HRM login page
    When User fills valid <username>, <password>
    And User clicks the login button
    Then User should see the dashboard
    When User navigates to the Directory module
    And User enters "<employeeName>" in the Employee Name field
    And User clicks the Search button
    Then User should see that at least one record is found

    Examples:
      | username | password | employeeName |
      | Admin    | admin123 | ame          |
