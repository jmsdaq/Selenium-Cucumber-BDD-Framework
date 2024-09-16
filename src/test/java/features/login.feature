Feature: Login Functionality

  Background:
    Given I am on the login page

  Scenario: Successful login with valid credentials
    When I enter "Admin" and "admin123"
    And I click the login button
    Then I should be redirected to the dashboard page

  Scenario: Login with invalid credentials
    When I enter "invalidUser" and "invalidPass"
    And I click the login button
    Then I should see an error message "Invalid credentials"

  Scenario: Login with empty fields
    When I enter "" and ""
    And I click the login button
    Then I should see a message "Required"
