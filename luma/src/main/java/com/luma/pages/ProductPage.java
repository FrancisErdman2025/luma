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
        super.clickOnElement(sizeOption_large);
        super.clickOnElement(colorOption_blue);
    }

    public void enterQuantity(String sQty) {
        super.clearElement(quantityField);
        super.sendKeysToElement(quantityField, sQty);
    }

    public void clickAddToCart() {
    	wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public boolean isProductAddedMessageDisplayed() {
        return super.isElementDisplayed(youAddedProductToCartMessageText);
    }
    
    public String getErrorMessage() {
        return super.getElementText(errorMessage);
    }
}
