Feature: General View
  Scenario: Validate general user is able to view products without logging in
    Given User navigate to the online products page
    When User clicks on formal shoes drop down
    Then User should be able to view the products