package com.luma.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    @FindBy(id = "option-label-size-143-item-169")
    private WebElement sizeOption_large;

    @FindBy(id = "option-label-color-93-item-50")
    private WebElement colorOption_blue;

    @FindBy(id = "qty") 
    private WebElement quantityField;

    @FindBy(id = "product-addtocart-button") 
    private WebElement addToCartButton;
    
    @FindBy(xpath = "(//a[contains(text(),'shopping cart')])[1]")
    private WebElement youAddedProductToCartMessageText;

    @FindBy(id = "qty-error") 
    private WebElement errorMessage;

    public ProductPage(WebDriver driver) {
        super(driver);
        super.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectSizeAndColor() {
        wait.until(ExpectedConditions.elementToBeClickable(sizeOption_large)).click();
        wait.until(ExpectedConditions.elementToBeClickable(colorOption_blue)).click();
    }

    public void enterQuantity(String sQty) {
        wait.until(ExpectedConditions.elementToBeClickable(quantityField)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(quantityField)).sendKeys(sQty);
    }

    public void clickAddToCart() {
    	wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public boolean isProductAddedMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(youAddedProductToCartMessageText));
            return youAddedProductToCartMessageText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
    }
}
