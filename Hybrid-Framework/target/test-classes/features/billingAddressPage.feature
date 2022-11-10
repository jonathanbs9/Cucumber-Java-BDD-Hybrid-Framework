Feature: Billing Address Feature
  Scenario Outline: Billing Address form with different set of data
    Given user has already logged in to application
      |username                  | password         |
      |jonathan_cucho@hotmail.com| realpassword12345|
    And user navigates to billing address page
    When user fills the form from the given sheetname "<SheetName>" and rowNumber <rowNumber>
    And user clicks on save address
    Then it shows a message "Address changed successfully."
    Examples:
      |SheetName  | rowNumber|
      |billingData|0         |
      |billingData|1         |
      |billingData|2         |
