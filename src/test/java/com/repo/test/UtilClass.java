package com.repo.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

/**
 * This class contains reuseable commonents.
 * @author neethu.mohan
 *
 */
public class UtilClass {
    
   private final WebDriver driver;
    
    public UtilClass() {
        this.driver = DriverFactory.getDriver();
    }
    
    /**
     * implicit wait.
     */
    public void waitForPageToLoad() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
