Feature: Assign a Claim in Claim Module

  Scenario Outline: User successfully assigns a claim
    Given User is on the Orange HRM login page
    When User fills valid <username>, <password>
    And User clicks the login button
    Then User should see the dashboard
    When User navigates to the Claim module
    And User clicks on the "Assign Claim" button
    And User enters Employee Name "<employeeName>", selects Event, and sets Currency
    And User clicks the create button
    Then A success message for assigning the claim should be displayed

    Examples:
      | username | password | employeeName |
      | Admin    | admin123 | A |
