Feature: Add Employee in PIM menu

  Background:
    Given I am logged in as a user with permissions to access the PIM menu

  Scenario Outline: Adding a new employee with valid details
    When I navigate to the PIM menu
    And I click on the "Add" button
    And I fill in the employee details with firstname "<firstName>", middlename "<middleName>", lastname "<lastName>", and employee ID "<emp_ID>"
    And I submit the form
    Then I should see a confirmation message that the employee was successfully added

    Examples:
      | firstName  | middleName| lastName   | emp_ID  |
      | Eren       | ymir      | Yeager     |         |
      | Mikasa     | kenny     | Ackerman   |         |
      | Armin      | ymir      | Smith      |         |

  Scenario Outline: Adding an employee with missing required fields
    When I navigate to the PIM menu
    And I click on the "Add" button
    And I fill in the employee details with firstname "<firstName>", and employee ID "<emp_ID>"
    And I submit the form
    Then I should see an error message indicating the missing required fields

    Examples:
      | firstName    | emp_ID |
      | John Doe    |        |
      |             | 67890  |
      | Emily Davis | 11223  |

  Scenario Outline: Adding an employee with duplicate information
    Given I have already added an employee with firstname "<firstName>", middlename "<middleName>", lastname "<lastName>", and employee ID "<emp_ID>"
    When I navigate to the PIM menu
    And I click on the "Add" button
    And I fill in the employee details with firstname "<firstName>", middlename "<middleName>", lastname "<lastName>", and employee ID "<emp_ID>"
    And I submit the form
    Then I should see an error message indicating a duplicate employee ID

    Examples:
      | firstName  | middleName| lastName   | emp_ID|
      | Eren       | ymir      | Yeager     | 2000        |
      | Mikasa     | kenny     | Ackerman   | 2000        |
