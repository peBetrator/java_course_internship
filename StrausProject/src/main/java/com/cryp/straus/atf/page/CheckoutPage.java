package com.endava.straus.atf.page;

import com.endava.straus.atf.common.action.BasePage;
import com.endava.straus.atf.pojo.ClientDetailsPojo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    public WebElement name;
    @FindBy(id = "phone")
    public WebElement phone;
    @FindBy(id = "email")
    public WebElement email;
    @FindBy(id = "apartment")
    public WebElement apartment;
    @FindBy(id = "floor")
    public WebElement floor;
    @FindBy(id = "entrance")
    public WebElement entrance;
    @FindBy(id = "entrance_code")
    public WebElement code;
    @FindBy(id = "cutlery")
    public WebElement cutlery;
    @FindBy(id = "instructions")
    public WebElement instructions;
    @FindBy(id = "call_client_on_arrival")
    public WebElement callOnArrial;
    @FindBy(id = "is_preorder")
    public WebElement isPreorder;
    @FindBy(id = "conditions_agree")
    public WebElement agreeTermsAndConditions;
    @FindBy(xpath = "//button[@ng-click='saveOrder()']")
    public WebElement submitOrder;
    @FindBy(xpath = "//a[@class='btn btn-danger btn-link pull-left ng-binding']")
    public WebElement cancelMultipleRestaurantsOrder;
    @FindBy(xpath = "//a[@class='btn btn-success pull-right ng-binding']")
    public WebElement acceptMultipleRestaurantsOrder;
    @FindBy(xpath = "//p[@class='text-warning ng-binding ng-scope']")
    public WebElement deliveryWarning;

    @Override
    public boolean isElementDisplayed() {
        return true;
    }

    public void insertValue(WebElement element, String s) {
        element.sendKeys(s);
    }

    public void acceptOrderFromMultipleRestaurants(boolean accept) {
        if (accept) {
            acceptMultipleRestaurantsOrder.click();
        } else {
            cancelMultipleRestaurantsOrder.click();
        }
    }

    public void completeFields(ClientDetailsPojo details) {
        name.sendKeys(details.getName());
        phone.sendKeys(details.getPhone());
        email.clear();
        email.sendKeys(details.getEmail());
        apartment.sendKeys(details.getApartment());
        entrance.sendKeys(details.getEntrance());
        floor.sendKeys(details.getFloor());
        code.sendKeys(details.getCode());
        if (details.getAcceptTerm())
            agreeTermsAndConditions.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        submitOrder.click();
    }
}
