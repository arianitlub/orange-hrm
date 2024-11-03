Feature: Apply for Leave in the Leave module

  Scenario Outline: User successfully applies for leave
    Given User is on the Orange HRM login page
    When User fills valid <username>, <password>
    And User clicks the login button
    Then User should see the dashboard
    When User navigates to the Leave module
    And User opens the Apply Leave section
    And User selects a leave type
    And User sets the leave period from "<fromDate>" to "<toDate>"
    And User submits the leave application
    Then A success message for applying leave should be displayed

    Examples:
      | username | password | fromDate    | toDate      |
      | Admin    | admin123 | 2024-12-01  | 2024-12-05  |
