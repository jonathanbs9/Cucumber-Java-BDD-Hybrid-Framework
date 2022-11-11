Feature: Shop Page Feature
  Scenario: Shop Page must contain only 3 sliders
    Given user is on Shop Page
    When user clicks on Home menu
    Then the Home page must contains only three sliders

    Scenario: Shop Page must contain 3 arrivals
      Given user is on Shop Page
      When user clicks on Home menu
      Then the Home page must contains only arrivals (real sliders)