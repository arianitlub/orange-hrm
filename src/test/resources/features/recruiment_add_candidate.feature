Feature: Add Candidate in Recruitment module

  Scenario Outline: User successfully adds a candidate
    Given User is on the Orange HRM login page
    When User fills valid <username>, <password>
    And User clicks the login button
    Then User should see the dashboard
    When User navigates to the Recruitment module
    And User opens the Add Candidate section
    And User enters candidate first name "<firstName>", last name "<lastName>", and email "<email>"
    And User submits the candidate application
    Then A success message for adding candidate should be displayed

    Examples:
      | username | password | firstName | lastName | email               |
      | Admin    | admin123 | John      | Doe      | johndoe@example.com |
