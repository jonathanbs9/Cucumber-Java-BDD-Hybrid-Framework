package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class AccountPage {
    private WebDriver driver;

    private By accountSection = By.xpath("//nav[@class='woocommerce-MyAccount-navigation']//ul//li");
    private By messageText = By.xpath("//div[@class='woocommerce-message']");
    private By addressesLink = By.xpath("//a[contains(text(),'Addresses')]");

    private By editBillingAddressLink = By.xpath("//a[@href='https://practice.automationtesting.in/my-account/edit-address/billing']");

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public String getAccountTitle(){
        return driver.getTitle();
    }

    public int getAccountSectionCount(){
        int size = driver.findElements(accountSection).size();
        return size;
    }

    public List<String> getAccountSectionList(){
        List<String> accountList = new ArrayList<>();
        List<WebElement> sectionList = driver.findElements(accountSection);
        for(WebElement element: sectionList){
            accountList.add(element.getText());
        }
        return accountList;
    }

    public String getSuccessMessage(){
        String message = driver.findElement(messageText).getText();
        return message;
    }

    public void clickAddressesLink(){
        WebElement addresses = driver.findElement(addressesLink);
        addresses.click();
    }

    public BillingAddressPage clickEditBillingAddress(){
        driver.findElement(editBillingAddressLink).click();
        return new BillingAddressPage(driver);
    }

    public void clickEscape() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
    }
}
