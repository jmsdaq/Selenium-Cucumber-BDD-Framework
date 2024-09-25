Feature: Manage Employees in PIM Menu

  Background:
    Given I am logged in as a user with permissions to access the PIM menu
    And I am on the "Employee List" page

  # Adding Employee Scenarios
  Scenario Outline: Adding a new employee with valid details
    When I navigate to the "PIM" menu
    And I click on the "Add Employee" button
    And I fill in the employee details with:
      | firstname | "<firstName>" |
      | middlename | "<middleName>" |
      | lastname | "<lastName>" |
      | employee ID | "<emp_ID>" |
    And I submit the employee form
    Then I should see a confirmation message that the employee was successfully added
    And I should see the employee "<firstName> <lastName>" listed in the "Employee List"

    Examples:
      | firstName  | middleName | lastName   | emp_ID |
      | Eren       | Ymir       | Yeager     | 1234   |
      | Mikasa     | Kenny      | Ackerman   | 12345  |
      | Armin      | Ymir       | Smith      | 123456 |

  Scenario: Adding an employee with missing required fields
    When I navigate to the "PIM" menu
    And I click on the "Add Employee" button
    And I fill in the employee details with:
      | firstname | "first" |
    And I submit the employee form
    Then I should see an error message indicating that required fields are missing

  Scenario Outline: Adding an employee with invalid details
    When I navigate to the "PIM" menu
    And I click on the "Add Employee" button
    And I fill in the employee details with:
      | firstname | "<firstName>" |
      | middlename | "<middleName>" |
      | lastname | "<lastName>" |
      | employee ID | "<emp_ID>" |
    And I submit the employee form
    Then I should see an error message indicating invalid input

    Examples:
      | firstName | middleName | lastName | emp_ID |
      | 123       | Invalid    | Name     | 123    |
      | !!@       | Test       | User     | ABC123 |

  Scenario Outline: Adding an employee with duplicate information
    Given I have already added an employee with firstname "<firstName>", middlename "<middleName>", lastname "<lastName>", and employee ID "<emp_ID>"
    When I navigate to the "PIM" menu
    And I click on the "Add Employee" button
    And I fill in the employee details with:
      | firstname | "<firstName>" |
      | middlename | "<middleName>" |
      | lastname | "<lastName>" |
      | employee ID | "<emp_ID>" |
    And I submit the employee form
    Then I should see an error message indicating a duplicate employee ID

    Examples:
      | firstName  | middleName | lastName   | emp_ID |
      | Eren       | Ymir       | Yeager     | 2000  |
      | Mikasa     | Kenny      | Ackerman   | 2000  |

  # Editing Employee Scenarios
  Scenario Outline: Edit employee details successfully
    Given I have selected an employee "<employeeName>" from the "Employee List"
    When I click the "Edit" button
    And I update the employee's personal information with:
      | field   | newValue         |
      | email   | "<email>"        |
      | address | "<address>"      |
    And I click the "Save" button
    Then I should see a confirmation message "Employee details updated successfully"
    And the updated employee details should be visible in the "Employee List"

    Examples:
      | employeeName | email             | address      |
      | Eren Yeager  | eren@paradise.com | Wall Maria   |
      | Mikasa Ackerman | mikasa@army.org | Wall Rose    |

  Scenario: Attempt to edit employee with invalid email
    Given I have selected an employee "John Doe" from the "Employee List"
    When I click the "Edit" button
    And I update the email to "invalid-email"
    And I click the "Save" button
    Then I should see an error message "Invalid email format"

  Scenario: Cancel editing employee details
    Given I have selected an employee "John Doe" from the "Employee List"
    When I click the "Edit" button
    And I click the "Cancel" button
    Then I should be redirected back to the "Employee List" page

  # Searching Employee Scenarios
  Scenario Outline: Search for an existing employee
    When I search for an employee with "<query>"
    Then I should see "<expectedResult>"

    Examples:
      | query        | expectedResult     |
      | John Doe     | John Doe           |
      | Non Existent | No results found   |
      |              | List of employees  |

  Scenario: Search with invalid input
    When I search for an employee with "$$%^&*()"
    Then I should see an error message "Invalid search query"
