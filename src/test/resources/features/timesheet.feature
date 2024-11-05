Feature: Timesheet Management

  Scenario Outline: Edit timesheet entry for an employee
    Given User is on the Orange HRM login page
    When User fills valid <username>, <password>
    And User clicks the login button
    Then User should see the dashboard
    When User navigates to the Timesheet module
    When User searches for employee name "<employeeName>"
    And User clicks "View" for the employee's timesheet
    And User clicks "Edit" on the timesheet
    And User fills the first entry with "ac"
    And User fills the second entry with "fix"
    And User clicks "Save"
    Then A success popup is displayed at the bottom indicating the save was successful

    Examples:
      | username | password | employeeName |
      | Admin    | admin123 | test         |
