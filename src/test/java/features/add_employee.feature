Feature: New User Registration View
  Scenario: Validate user is able to view after Login
    Given User navigate to the Login page
    When User clicks on new Registration button
    Then User should be able to view the Registration page