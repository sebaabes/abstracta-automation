package com.abstracta.automation.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CartPage {
    private WebDriver driver;

    // Localizadores
    private By viewCartButton = By.xpath("//a[@href ='http://opencart.abstracta.us:80/index.php?route=checkout/cart']");
    private By removeButton = By.cssSelector(".btn-danger:nth-child(2)");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void viewCart() {
        driver.findElement(viewCartButton).click();
    }

    public void removeProductFromCart() {
        driver.findElement(removeButton).click();
    }
    
    public boolean isCartEmpty() {
        WebElement emptyMessageCart = driver.findElement(By.id("cart-total"));
        WebElement emptyMessage = driver.findElement(By.cssSelector("p:nth-child(2)"));
        
        return emptyMessage.getText().equals("Your shopping cart is empty!") && emptyMessageCart.getText().equals("0 item(s) - $0.00");
    }
}