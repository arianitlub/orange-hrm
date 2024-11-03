Feature: Delete a record in the PIM module

  Scenario Outline: User successfully deletes a record from PIM
    Given User is on the Orange HRM login page
    When User fills valid <username>, <password>
    And User clicks the login button
    Then User should see the dashboard
    When User navigates to the PIM module
    And User selects a record to delete
    And User confirms the deletion in the popup
    Then A success message should be displayed

    Examples:
      | username | password |
      | Admin    | admin123 |
