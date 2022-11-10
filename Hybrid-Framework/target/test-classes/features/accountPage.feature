Feature: Account Page Feature
  Background:
    Given user has already logged in to application
      |username                  | password         |
      |jonathan_cucho@hotmail.com| realpassword12345|

    Scenario: Account Page Title
      Given user is on Account Page
      When user gets the title of the page
      Then page title should be "My Account – Automation Practice Site"

    Scenario: Account section count
      Given user is on Account Page
      Then user get account section
      |Dashboard|
      |Orders   |
      |Downloads|
      |Addresses|
      |Account Details|
      |Logout|
      And account section count should be 6