Feature: General View of Product list
  Scenario: Validate general user is able to view products

    Given User navigate to the the hamburger menu
    When User clicks on the online products
    And User clicks on formal shoes drop down
    Then User should be able to view the formal shoe products