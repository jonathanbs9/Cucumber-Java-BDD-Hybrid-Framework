package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the ThreadLocal driver on the basis of given browser
     *
     * @param browser
     * @return this will return threadLocalDriver
     */
    public WebDriver init_driver(String browser){
        System.out.println("Browser value is: "+browser);

        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            threadLocalDriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            threadLocalDriver.set(new FirefoxDriver());
        } else if (browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            threadLocalDriver.set(new EdgeDriver());
        } else if (browser.equals("safari")){
            WebDriverManager.safaridriver().setup();
            threadLocalDriver.set(new SafariDriver());
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    /**
     * Use of synchronized because of the parallel execution
     * This is used to get the driver with ThreadLocal
     */
    public static synchronized WebDriver getDriver(){
        return threadLocalDriver.get();
    }
}
