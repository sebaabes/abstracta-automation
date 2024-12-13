package com.abstracta.automation.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    private WebDriver driver;

    @FindBy(css = ".img-responsive")
    private WebElement firstProduct;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectFirstProduct() {
        firstProduct.click();
    }
}