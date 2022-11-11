package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By emailInput = By.xpath("//input[@id='username']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@type='submit' and @name='login']");
    private By lostPassword = By.xpath("//a[contains(text(),'Lost your password?')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean isLostPasswordLink(){
        return driver.findElement(lostPassword).isDisplayed();
    }

    public void enterUsername(String username){
        driver.findElement(emailInput).sendKeys(username);
    }

    public void enterPassword(String pass){
        driver.findElement(passwordInput).sendKeys(pass);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public AccountPage doLogin(String username, String pass){
        System.out.println("Login with: \nusername: "+username+"\npassword: "+pass);

        driver.findElement(emailInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(pass);
        driver.findElement(loginButton).click();

        return new AccountPage(driver);
    }
}
