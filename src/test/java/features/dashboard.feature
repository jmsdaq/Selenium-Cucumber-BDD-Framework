Feature: Dashboard Page

  Background:
    Given I am logged in

  Scenario: Verify dashboard widgets are present
    When I am on the dashboard page
    Then I should see "Quick Launch" widget
    And I should see "Welcome" message

  Scenario: Check user profile link
    When I am on the dashboard page
    Then I should see a user profile link
    And the profile link should redirect to the user profile page

  Scenario: Check logout functionality
    When I click the logout button
    Then I should be redirected to the login page
