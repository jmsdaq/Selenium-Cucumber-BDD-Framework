Feature: Add Employee

  Scenario Outline: Add a new employee with valid details
    Given I am logged in
    And I am on the "Add Employee" page
    When I enter valid details "<firstName>" "<lastName>" "<email>"
    And I click the "Save" button
    Then I should see a confirmation message "Employee added successfully"

    Examples:
      | firstName | lastName | email                   |
      | John      | Doe      | john.doe@example.com    |
      | Jane      | Smith    | jane.smith@example.com  |

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
