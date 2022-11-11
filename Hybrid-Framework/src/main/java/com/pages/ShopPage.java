package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage {
    private WebDriver driver;

    private By homeMenuLink = By.xpath("//a[contains(text(),'Home')]");

    public ShopPage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage clickHomeMenuLink(){
        driver.findElement(homeMenuLink).click();
        return new HomePage(driver);
    }

    public void navigateToShopPage() {
        driver.get("https://practice.automationtesting.in/shop/");
    }
}
