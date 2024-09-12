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
