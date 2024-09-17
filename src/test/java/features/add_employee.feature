Feature: Add Employee in PIM menu

  Background:
    Given I am logged in as a user with permissions to access the PIM menu

  Scenario Outline: Adding a new employee with valid details
    When I navigate to the PIM menu
    And I click on the "Add" button
    And I fill in the employee details with name "<name>", employee ID "<emp_id>", and job title "<job_title>"
    And I submit the form
    Then I should see a confirmation message that the employee with ID "<emp_id>" has been added

    Examples:
      | name        | emp_id | job_title     |
      | John Doe    | 12345  | Software Engineer |
      | Jane Smith  | 67890  | Project Manager  |
      | Emily Davis | 11223  | QA Analyst      |

  Scenario Outline: Adding an employee with missing required fields
    When I navigate to the PIM menu
    And I click on the "Add" button
    And I fill in the employee details with name "<name>", employee ID "<emp_id>", and job title "<job_title>"
    And I submit the form
    Then I should see an error message indicating the missing required fields

    Examples:
      | name        | emp_id | job_title |
      | John Doe    |        | QA Analyst|
      |            | 67890  | Project Manager|
      | Emily Davis | 11223  |          |

  Scenario Outline: Adding an employee with duplicate information
    Given I have already added an employee with name "<name>" and employee ID "<emp_id>"
    When I navigate to the PIM menu
    And I click on the "Add" button
    And I fill in the employee details with name "<name>" and employee ID "<emp_id>"
    And I submit the form
    Then I should see an error message indicating a duplicate employee

    Examples:
      | name        | emp_id |
      | John Doe    | 12345  |
      | Jane Smith  | 67890  |
      | Emily Davis | 11223  |
