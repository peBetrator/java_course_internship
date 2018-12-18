package com.endava.straus.atf.page;

import com.endava.straus.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends BasePage {

    @FindBy(className = "btn-success")
    WebElement rateOrder;
    @FindBy(className = "btn-danger")
    WebElement cancelOrder;
    @FindBy(id = "cancelReason")
    WebElement reason;
    @FindBy(xpath = "//a[@ng-click='confirmCancel()']")
    WebElement confirmCancel;
    @FindBy(xpath = "//ul[@id='login-popup']//a[@class='dropdown-toggle']")
     WebElement profileDropdown;


    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        return rateOrder.isDisplayed();
    }
}