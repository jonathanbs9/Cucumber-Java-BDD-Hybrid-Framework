package com.stepDefinitions;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class LoginPageSteps {
     private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
     private String title;
     @Given("user is on login page")
     public void user_is_on_login_page(){
          DriverFactory.getDriver().get("https://practice.automationtesting.in/my-account/");
     }
     @When("user gets the title of the page")
     public void user_gets_the_title_of_the_page(){
          title = loginPage.getLoginPageTitle();
     }

     @Then("page title should be {string}")
     public void page_title_should_be(String expectedTitle){
          System.out.println("Title of this page is: "+ title);
          Assert.assertTrue(title.contains(expectedTitle));
     }

     @Then("Lost your password link should be displayed")
     public void lost_your_password_link_should_be_displayed(){
          Assert.assertTrue(loginPage.isLostPasswordLink());
     }

     @When("user enters username {string}")
     public void user_enters_username(String username){
          loginPage.enterUsername(username);
     }

     @When("user enters password {string}")
     public void user_enters_password(String password){
          loginPage.enterPassword(password);
     }

     @When("user clicks on Login Button")
     public void user_clicks_on_login_button(){
          loginPage.clickLogin();
     }

     @Then("user gets the title of the home page")
     public void user_gets_the_title_of_the_home_page(){

     }

}
