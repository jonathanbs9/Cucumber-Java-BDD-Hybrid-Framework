package com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By firstSlider = By.xpath("//div[@class='n2-ss-slider-3']//div[@data-slide-duration='0']");
    private By titleSliders = By.xpath("//div//div[@class='woocommerce']//li//h3");
    private List<String> titles = new ArrayList<String>();

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public int getSizeFromSlider(){
        return driver.findElements(firstSlider).size();
    }

    public int getSizeOfElements(){
        return driver.findElements(titleSliders).size();
    }

    public void hasSlider3elements(){
        Assert.assertEquals(3, getSizeOfElements());
    }

    public void realSliderHas3Elements(){
        Assert.assertEquals(3, getSizeFromSlider());
    }

}
