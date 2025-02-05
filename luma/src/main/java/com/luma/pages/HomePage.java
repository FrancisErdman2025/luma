package com.luma.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//li[@class='product-item'])[1]") 
    private WebElement firstProduct;

    public HomePage(WebDriver driver) {
        super(driver);
        super.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickFirstProduct() {
    	wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
    }
}