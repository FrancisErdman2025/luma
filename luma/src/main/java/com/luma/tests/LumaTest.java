package com.luma.tests;

import com.luma.pages.*;
import com.luma.utils.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LumaTest {
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverSetup.initializeDriver();
        driver.get("https://magento.softwaretestingboard.com");
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void testAddSingleItemToCart() {
        homePage.clickFirstProduct();
        productPage.selectSizeAndColor();
        productPage.enterQuantity("1");
        productPage.clickAddToCart();

        Assert.assertTrue(productPage.isProductAddedMessageDisplayed(), "Product was not added to cart successfully!");
    }

    @Test
    public void testAddZeroQuantityItem() {
        homePage.clickFirstProduct();
        productPage.selectSizeAndColor();
        productPage.enterQuantity("0");
        productPage.clickAddToCart();

        Assert.assertTrue(productPage.getErrorMessage().contains("Please enter a quantity greater than 0."), "Error message should appear for zero quantity.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}