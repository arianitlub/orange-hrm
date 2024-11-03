Feature: Forgot Password functionality

  Scenario: Reset password through Forgot Password link
    Given the user is on the login page
    When the user clicks on the "Forgot your password?" link
    Then the "Reset Password" page should be displayed
    When the user enters "Admin" as the username
    And the user clicks on the "Reset Password" button
    Then a success message should be displayed on the next page
