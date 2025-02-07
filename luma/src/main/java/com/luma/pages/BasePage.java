package com.luma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    protected void clickOnElement(WebElement webElement) {
    	this.wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
    
    protected void clearElement(WebElement webElement) {
    	this.wait.until(ExpectedConditions.elementToBeClickable(webElement)).clear();
    }
    
    protected void sendKeysToElement(WebElement webElement, String sInput) {
    	this.wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(sInput);
    }
    
    protected boolean isElementDisplayed(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    protected String getElementText(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement)).getText();
    }
}
