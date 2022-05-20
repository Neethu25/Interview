package com.repo.test;

import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeSpec;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * user set up.
 * @author neethu.mohan
 *
 */
public class DriverFactory {

    private static WebDriver driver = null;
    private static final String URL = "https://github.com/orgs/google/repositories";

    public static WebDriver getDriver() {
        if (driver == null) {
        System.setProperty("webdriver.gecko.driver","/Users/neethu.mohan/Downloads/"
                + "gauge-selenium-sample-master/geckodriver");
        driver = new FirefoxDriver();
        }
        return driver;
    }

    @BeforeSpec
    public void setUp() {
        try {
                
                driver.get(URL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @AfterSpec
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
