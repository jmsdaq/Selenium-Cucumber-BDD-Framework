Feature: Add Employee in PIM menu

  Background:
    Given I am logged in as a user with permissions to access the PIM menu

  Scenario Outline: Adding a new employee with valid details
    When I navigate to the PIM menu
    And I click on the add button
    And I fill in the employee details with firstname "<firstName>", middlename "<middleName>", lastname "<lastName>", and employee ID "<emp_ID>"
    And I submit the form
    Then I should see a confirmation message that the employee was successfully added

    Examples:
      | firstName  | middleName| lastName   | emp_ID  |
      | Eren       | ymir      | Yeager     | 1234        |
      | Mikasa     | kenny     | Ackerman   | 12345        |
      | Armin      | ymir      | Smith      | 123456        |

  Scenario: Adding an employee with missing required fields
    When I navigate to the PIM menu
    And I click on the add button
    And I fill in the employee details with firstname "first"
    And I submit the form
    Then I should see an error message indicating the missing required fields


  Scenario Outline: Adding an employee with duplicate information
    Given I have already added an employee with firstname "<firstName>", middlename "<middleName>", lastname "<lastName>", and employee ID "<emp_ID>"
    When I navigate to the PIM menu
    And I click on the add button
    And I fill in the employee details with firstname "<firstName>", middlename "<middleName>", lastname "<lastName>", and employee ID "<emp_ID>"
    And I submit the form
    Then I should see an error message indicating a duplicate employee ID

    Examples:
      | firstName  | middleName| lastName   | emp_ID|
      | Eren       | ymir      | Yeager     | 2000        |
      | Mikasa     | kenny     | Ackerman   | 2000        |


Feature: Edit Employee

  Background:
    Given I am on the "Employee List" page


  Scenario: Edit employee details successfully
    When I select an employee
    And I click the Edit button
    And I update the personal information
    And I click the save button
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


Feature: Search Employee

  Scenario Outline: Search for an existing employee
    Given I am on the "Employee List" page
    When I search for employee with "<query>"
    Then I should see "<expectedResult>"

    Examples:
      | query        | expectedResult     |
      | John Doe     | John Doe           |
      | Non Existent | No results found   |
      |              | List of employees  |
