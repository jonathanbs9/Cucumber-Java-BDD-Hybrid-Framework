package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountPage {
    private WebDriver driver;

    private By accountSection = By.xpath("//nav[@class='woocommerce-MyAccount-navigation']//ul//li");
    private By messageText = By.xpath("//div[@class='woocommerce-message']");


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
}
