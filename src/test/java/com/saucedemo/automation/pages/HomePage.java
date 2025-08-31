package com.saucedemo.automation.pages;

import com.saucedemo.automation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBtn;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return pageTitle.getText();
    }

    public void addItemToCart() {
        addToCartBtn.click();
    }

    public void goToCart() {
        cartLink.click();
    }
}
