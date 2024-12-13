package com.abstracta.automation.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;

    // Localizadores
    private By addToCartButton = By.id("button-cart");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        WebElement addToCartBtn = driver.findElement(addToCartButton);
        addToCartBtn.click();
    }

    public CartPage goToCart() {
        WebElement cartButton = driver.findElement(By.id("cart-total"));
        cartButton.click();
        return new CartPage(driver);
    }
}