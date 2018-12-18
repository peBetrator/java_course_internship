package com.endava.straus.atf.page;

import com.endava.straus.atf.common.action.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchRestaurantPage extends BasePage {

    public SearchRestaurantPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.allFromCategory.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    public WebElement next;

    @FindAll({
        @FindBy(xpath = "//div[@class='category-root slick-slide slick-active']"),
        @FindBy(xpath = "//div[@class='category-root slick-slide']")})
    public List<WebElement> foodCategories;

    @FindBy(xpath = "//a[@class=\"provider-root\"]")
    public List<WebElement> restaurants;

    @FindBy(xpath = "//li[@ng-click=\"goToFilteredPage('top')\" ]")
    public WebElement top;

    @FindBy(xpath = "//li[@ng-click=\"goToFilteredPage('new')\" ]")
    public WebElement newRestaurants;

    @FindBy(xpath = "//li[@ng-click=\"goToFilteredPage('promo')\" ]")
    public WebElement promo;

    @FindBy(xpath = "//li[@ng-click=\"goToFilteredPage('fastest')\" ]")
    public WebElement fastDelivery;

    @FindBy(xpath = "//li[@ng-click=\"goToFilteredPage('active')\" ]")
    public WebElement open;

    @FindBy(xpath = "//li[@ng-click=\"goToFilteredPage('card_payment')\" ]")
    public WebElement onlinePayment;

    @FindBy(xpath = "//li[@ng-click=\"goToFilteredPage('all')\" ]")
    public WebElement allFromCategory;

    public void selectFoodCategory(String name, WebDriver driver) {
//        for (WebElement category : foodCategories) {
//            if (category.getAttribute("href").equals("?query=".concat(name))) {
//                while (!category.isDisplayed()) {
//                    next.click();
//                }
//                category.click();
//            } else {
//                System.out.println("No such category.");
//            }
//        }
        WebElement category = driver.findElement(By.xpath("//a[@href='?query="+name+"']"));
        //while ()
        category.click();
    }

    public void selectRestaurantType(String option) {
        switch(option.toLowerCase()) {
            case "top": {top.click(); break;}
            case "new": {newRestaurants.click(); break;}
            case "promo": {promo.click(); break;}
            case "fast": {fastDelivery.click(); break;}
            case "open": {open.click(); break;}
            case "card": {onlinePayment.click(); break;}
            default: allFromCategory.click();
        }
    }

    public WebElement getSpecificRestaurant(String name) {
        for (WebElement restaurant : restaurants) {
            //restaurant.findElement(By.xpath("//img[@title=\"" + name + "\"]"));
            //if (restaurant.findElement(By.xpath("//h3[@class=\"ng-binding\"]")).getText().equals(name)){
            if (restaurant.getAttribute("href").contains(name.toLowerCase())) {
                return restaurant;
            }
        }
        System.out.println("No such restaurant was found.");
        return null;
    }

    public void updateRestaurantList(WebDriver driver) {
        restaurants = driver.findElements(By.xpath("//a[@class=\"provider-root\"]"));
    }

    public void selectRestaurant(String restaurant) {
        if (restaurant.equalsIgnoreCase("restaurant")) {
            restaurants.get(0).click();
        } else {
            getSpecificRestaurant(restaurant);
        }
    }

}
