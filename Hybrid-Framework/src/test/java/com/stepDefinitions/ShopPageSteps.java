package com.stepDefinitions;

import com.pages.HomePage;
import com.pages.ShopPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopPageSteps {
    private ShopPage shopPage = new ShopPage(DriverFactory.getDriver());
    private HomePage homePage;

    @Given("user is on Shop Page")
    public void user_is_on_shop_page() {
        shopPage.navigateToShopPage();
    }
    @When("user clicks on Home menu")
    public void user_clicks_on_home_menu() {
        homePage = shopPage.clickHomeMenuLink();
    }
    @Then("the Home page must contains only three sliders")
    public void the_home_page_must_contains_only_three_sliders() {
        homePage.hasSlider3elements();
    }

    @Then("the Home page must contains only arrivals \\(real sliders)")
    public void theHomePageMustContainsOnlyArrivalsRealSliders() {
        homePage.getSizeFromSlider();
    }
}
