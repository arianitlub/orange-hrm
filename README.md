# Orange HRM - QA Training Task

This project contains automated tests for the Orange HRM system, developed as part of QA training. The test automation is implemented using the **Cucumber** framework, which allows for behavior-driven development (BDD).

## Framework and Tools Used
- **Cucumber**: Used for writing test cases in a feature file format, making it easy to understand and align with business requirements.
- **Selenium WebDriver**: For browser interaction and UI testing.
- **JUnit/TestNG**: Used as the test runner.
- **Java**: The programming language for step definitions and additional test logic.

## Test Scenarioss
The following test cases have been automated:
1. **Login** - Valid and Invalid login scenarios to ensure authentication works as expected.
2. **Reset Password** - Testing the reset password functionality.
3. **Logout** - Verifying the user logout process.
4. **PIM Module** - Delete a record within the PIM module.
5. **Apply Leave** - End-to-end flow to apply for leave.
6. **Edit Timesheet** - Edit timesheet entries for an employee.
7. **Recruitment Module** - Add a new candidate record in the recruitment section.
8. **Directory Search** - Search for an employee in the directory.
9. **Claims** - Create a new claim request.
10. **Buzz** - Create a new post in the Buzz section.

## Project Structure
- **src/test/resources/features**: Contains feature files written in Gherkin syntax, detailing the test scenarios.
- **src/test/java/step_definitions**: Houses the step definitions for each feature.
- **src/test/java/pages**: Page Object Model (POM) classes encapsulating page elements and methods.
- **src/test/java/utilities**: Utility classes, including custom wait functions, configurations, and other helpers.

## How to Run
- **Pre-requisites**: Ensure JDK, Maven, and an IDE (like IntelliJ or Eclipse) are installed.
- **Run command**: Use `mvn test` to execute all tests.

## Reporting
The framework generates reports after the execution, which can be reviewed to analyze the test results.