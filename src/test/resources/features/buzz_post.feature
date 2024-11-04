Feature: Post a status update in the Buzz module

  Scenario Outline: User successfully posts a status update
    Given User is on the Orange HRM login page
    When User fills valid <username>, <password>
    And User clicks the login button
    Then User should see the dashboard
    When User navigates to the Buzz module
    And User writes "<statusMessage>" in the status input
    And User clicks the Post button
    Then A success message for posting should be displayed

    Examples:
      | username | password | statusMessage             |
      | Admin    | admin123 | Hello team, this is a test post! |
