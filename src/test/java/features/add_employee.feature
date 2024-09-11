Feature: Add Employee

  Scenario: Add a new employee with valid details
    Given I am logged in
    And I am on the "Add Employee" page
    When I enter valid details "John" "Doe" "john.doe@example.com"
    And I click the "Save" button
    Then I should see a confirmation message "Employee added successfully"

  Scenario: Attempt to add an employee with missing details
    Given I am logged in
    And I am on the "Add Employee" page
    When I enter details "John" "" "john.doe@example.com"
    And I click the "Save" button
    Then I should see an error message "Last name cannot be empty"

  Scenario: Attempt to add an employee with duplicate email
    Given I am logged in
    And I am on the "Add Employee" page
    When I enter details "Jane" "Smith" "john.doe@example.com"
    And I click the "Save" button
    Then I should see an error message "Email already exists"
