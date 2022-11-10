Feature: Login page Feature

  Scenario: Login Page Title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "My Account – Automation Practice Site"

  Scenario: Forgot Password Link
    Given user is on login page
    Then Lost your password link should be displayed

  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "jonathan_cucho@hotmail.com"
    And user enters password "realpassword12345"
    And user clicks on Login Button
    #Then user gets the title of the home page
    And page title should be "My Account – Automation Practice Site"