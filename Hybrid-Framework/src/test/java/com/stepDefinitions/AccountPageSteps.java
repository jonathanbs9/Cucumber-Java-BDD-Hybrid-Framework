package com.stepDefinitions;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AccountPageSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountPage accountPage;


    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable credTable) {
        List<Map<String, String>> crdList = credTable.asMaps();
        String username = crdList.get(0).get("username");
        String password = crdList.get(0).get("password");

        DriverFactory.getDriver().get("https://practice.automationtesting.in/my-account/");
        accountPage = loginPage.doLogin(username, password);
    }
    @Given("user is on Account Page")
    public void user_is_on_account_page() {
        String title = accountPage.getAccountTitle();
        System.out.println("Actual Account page title: "+title);
    }

    @Then("user get account section")
    public void user_get_account_section(DataTable expectedSectionTable) {
        List<String> expectedList = expectedSectionTable.asList();
        System.out.println("Expected Account Section List: \n" +expectedList);

        List<String> actualList = accountPage.getAccountSectionList();
        System.out.println("  Actual Account Section List: \n" +actualList);

        Assert.assertTrue(actualList.containsAll(expectedList));
    }
    @Then("account section count should be {int}")
    public void account_section_count_should_be(Integer expectedSectionCount) {
        System.out.println("Cantidad de elemento de la seccion: "+ accountPage.getAccountSectionCount());
        Assert.assertTrue(accountPage.getAccountSectionCount() == expectedSectionCount);
    }
}
