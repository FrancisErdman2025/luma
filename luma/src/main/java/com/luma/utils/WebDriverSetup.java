package com.luma.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup {
    public static WebDriver initializeDriver() {
    	WebDriverManager.chromedriver().clearDriverCache().setup(); // Clears cache and updates driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximizes the browser window
        return driver;
    }
}