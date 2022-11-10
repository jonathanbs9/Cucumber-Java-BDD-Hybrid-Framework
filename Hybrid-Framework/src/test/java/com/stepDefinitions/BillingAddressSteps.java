package com.stepDefinitions;

import com.pages.AccountPage;
import com.pages.BillingAddressPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BillingAddressSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountPage accountPage;
    private BillingAddressPage billingAddressPage = new BillingAddressPage(DriverFactory.getDriver());

    @Given("user navigates to billing address page")
    public void user_navigates_to_billing_address_page() {
        DriverFactory.getDriver().get("https://practice.automationtesting.in/my-account/edit-address/billing/");
        System.out.println(" *********************************** \n Visiting Billing Address Page \n ***********************************");
    }
    @When("user fills the form from the given sheetname {string} and rowNumber {int}")
    public void user_fills_the_form_from_the_given_sheetname_and_row_number(String sheetName, Integer rowNumber) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        ExcelReader excelReader = new ExcelReader();
        List<Map<String, String>> testData = excelReader.getData("src/test/resources/data-for-automation-practice.xlsx", 0);
        String firstName = testData.get(rowNumber).get("firstName");
        String lastName = testData.get(rowNumber).get("lastName");
        String company = testData.get(rowNumber).get("companyName");
        String email = testData.get(rowNumber).get("email");
        String phone = testData.get(rowNumber).get("phone");
        String country = testData.get(rowNumber).get("country");
        String address1 = testData.get(rowNumber).get("address");
        String address2 = testData.get(rowNumber).get("address2");
        String townCity = testData.get(rowNumber).get("townCity");
        String state = testData.get(rowNumber).get("state");
        String postCode = testData.get(rowNumber).get("postCode");

        billingAddressPage.fillTheForm(firstName, lastName, company, email, phone, country, address1, address2, townCity, state, postCode);
    }
    @When("user clicks on save address")
    public void user_clicks_on_save_address() throws InterruptedException {
        //billingAddressPage.clickSaveAddress();
        billingAddressPage.clickInvisibleSaveButton();
        accountPage = new AccountPage(DriverFactory.getDriver());
        System.out.println("*************************\n Clicked insivible button \n*************************");
    }
    @Then("it shows a message {string}")
    public void it_show_a_message(String expectedMessage) {
        billingAddressPage.waitForMessage();
        String actualMessage = billingAddressPage.getMessage();
        System.out.println("******************\n Expected Message: "+expectedMessage+"\n ******************");
        System.out.println("******************\n   Actual Message: "+actualMessage+  "\n ******************");
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
