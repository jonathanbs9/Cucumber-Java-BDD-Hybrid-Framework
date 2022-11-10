package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillingAddressPage {
    private WebDriver driver;

    private By firstNameInput = By.xpath("//input[@id='billing_first_name']");
    private By lastNameInput = By.xpath("//input[@id='billing_last_name']");
    private By companyInput = By.xpath("//input[@id='billing_company']");
    private By emailInput = By.xpath("//input[@id='billing_email']");
    private By phoneInput = By.xpath("//input[@id='billing_phone']");

    private By countryDiv = By.xpath("//span[@id='select2-chosen-1']");
    private By countrySelect = By.xpath("//div[@id='select2-drop-mask']");
    private By countryInput = By.xpath("//input[@id='s2id_autogen1_search']");
    private By addressOneInput = By.xpath("//input[@id='billing_address_1']");
    private By addressTwoInput = By.xpath("//input[@id='billing_address_2']");
    private By cityInput = By.xpath("//input[@id='billing_city']");

    //private By stateDiv = By.xpath("//span[@id='select2-chosen-2']");
    private By stateInput = By.xpath("//input[@id='s2id_autogen2']");
    private By zipCodeInput = By.xpath("//input[@id='billing_postcode']");

    private By saveAddressButton = By.xpath("//p//input[@type='submit'][@class='button']");

    private By invisibleSaveButton = By.xpath("//input[@type='hidden'][@name='_wp_http_referer']");

    private By successMessage = By.xpath("//div[contains(text(),'Address changed successfully.')]");

    private WebElement successText = driver.findElement(By.xpath("//div[contains(text(),'Address changed successfully.')]"));
    public BillingAddressPage(WebDriver driver){
        this.driver = driver;
    }

    public AccountPage clickSaveAddress(){
        driver.findElement(saveAddressButton).click();
        return new AccountPage(driver);
    }

    public String getMessage(){
        waitForMessage();
        String message = driver.findElement(successMessage).getText();
        return message;
    }
    public void fillTheForm(String firstName, String lastName, String company, String email, String phone, String country,
                            String address1, String address2, String city, String state, String zipCode){
        // First Name
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);

        // Last Name
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);

        // Company
        driver.findElement(companyInput).clear();
        driver.findElement(companyInput).sendKeys(company);

        // Email
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);

        // Phone
        driver.findElement(phoneInput).clear();
        driver.findElement(phoneInput).sendKeys(phone);

        // Country
        driver.findElement(countryDiv).click();
        //Select countrySel = new Select(driver.findElement(countrySelect));

        driver.findElement(countryInput).clear();
        driver.findElement(countryInput).sendKeys(country+ Keys.ENTER);
        System.out.println("Pais ingresado: "+country );

        // Address 1
        driver.findElement(addressOneInput).clear();
        driver.findElement(addressOneInput).sendKeys(address1);

        // Address 2
        driver.findElement(addressTwoInput).clear();
        driver.findElement(addressTwoInput).sendKeys(address2);
        System.out.println("Direccion ingresada: "+address1 + " - "+address2 );

        // City
        driver.findElement(cityInput).clear();
        driver.findElement(cityInput).sendKeys(city);
        System.out.println("Ciudad ingresada: "+city );

        // State
        moveToState();
        //driver.findElement(stateDiv).click();
        driver.findElement(stateInput).clear();
        driver.findElement(stateInput).sendKeys(state+Keys.ENTER);
        System.out.println("Estado ingresado: "+state );

        // ZipCode
        driver.findElement(zipCodeInput).clear();
        driver.findElement(zipCodeInput).sendKeys(zipCode);
        System.out.println("Codigo Postal ingresado: "+zipCode );


        System.out.println("Campos completados");
    }

    public void navigateToAddressPage(){
        driver.get("https://practice.automationtesting.in/my-account/edit-address/billing/");
    }

    public void moveToState(){
        WebElement element = driver.findElement(stateInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void waitForMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(successText));
    }

    public void clickInvisibleSaveButton() throws InterruptedException {
        WebElement element = driver.findElement(invisibleSaveButton);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
        Thread.sleep(5000);
    }
}
