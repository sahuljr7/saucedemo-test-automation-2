package com.saucedemo.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
    	 WebDriverManager.chromedriver().setup();
    	    ChromeOptions options = new ChromeOptions();
    	    boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));
    	    if (headless) options.addArguments("--headless=new");
    	    options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080");
    	    driver = new ChromeDriver(options);
    	    driver.manage().window().maximize();
    	    driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
