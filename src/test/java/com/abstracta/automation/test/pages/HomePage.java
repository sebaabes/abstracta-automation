package com.abstracta.automation.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class HomePage {
    private WebDriver driver;

    // Localizadores
    private By searchBox = By.name("search");
    
    @FindBy(name = "search")
    private WebElement searchBox2;
    
    private By searchButton = By.cssSelector("button[type='button'][class='btn btn-default btn-lg']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(String productName) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.sendKeys(productName);
        searchInput.sendKeys(Keys.ENTER);
    }

    public ProductPage selectFirstProduct() {
        WebElement firstProduct = driver.findElement(By.cssSelector(".img-responsive"));
        firstProduct.click();
        return new ProductPage(driver);
    }
}