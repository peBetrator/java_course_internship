package com.endava.straus.atf.page;

import com.endava.straus.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//a[@ng-click='clearCart()']")
    public WebElement clear;

    @FindBy(xpath = "//a[@go-click='/en/checkout/']")
    public WebElement checkout;

    @FindBy(xpath = "//span[@class='glyphicon glyphicon-minus']")
    public List<WebElement> minusProduct;

    @FindBy(xpath = "//span[@class='glyphicon glyphicon-plus']")
    public List<WebElement> plusProduct;

    @FindBy(xpath = "//table[@class='no-margin-table ng-scope']")
    public WebElement cartContent;
    @FindBy(xpath = "//tr[@class='ng-scope']")
    public WebElement oneItem;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return cartContent.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clearCart() {
        clear.click();
    }

    public void orderFood() {
        checkout.click();
    }

    public void addQuantity(int product, int amount) {
        for (int i = 0; i < amount; i++) {
            plusProduct.get(product - 1).click();
        }
    }

    public void substractQuantity(int product, int amount) {
        int size = minusProduct.size();
        for (int i = 0; i < amount; i++) {
            minusProduct.get(product - 1).click();
            // if the list size will change after the product quantity reaches 0, break the loop
            // in order not to change the amount of other products.
            if (minusProduct.size() != size) break;
        }
    }
}
