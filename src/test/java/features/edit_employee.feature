Feature: Edit Employee

  Background:
    Given I am on the "Employee List" page


  Scenario: Edit employee details successfully
    When I select an employee "John Doe"
    And I click the "Edit" button
    And I update the email to "john.doe.updated@example.com"
    And I click the "Save" button
    Then I should see a confirmation message "Employee details updated successfully"

  Scenario: Attempt to edit employee with invalid email
    When I select an employee "John Doe"
    And I click the "Edit" button
    And I update the email to "invalid-email"
    And I click the "Save" button
    Then I should see an error message "Invalid email format"

  Scenario: Cancel editing employee details
    When I select an employee "John Doe"
    And I click the "Edit" button
    And I click the "Cancel" button
    Then I should be redirected back to the "Employee List" page
