package com.endava.straus.atf.page;

import com.endava.straus.atf.common.action.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(className = "btn-danger")
    public WebElement later;
    @FindBy(xpath = "//a[@ng-click='continue()']")
    public WebElement setAddress;
    @FindBy(xpath = "//ul[@id='login-popup']//a[@class='dropdown-toggle']")
    public WebElement loginDropdown;
    @FindBy(xpath = "//a[@href=\"/accounts/login/\"]")
    public WebElement login;
    @FindBy(xpath = "//a[@href='/accounts/logout/?next=/en/']")
    public WebElement signOut;
    @FindBy(xpath = "//a[@class=\"provider-root\"]")
    public List<WebElement> homeRestaurants;
    @FindBy(xpath = "//button[@go-click=\"/en/cart/\"]")
    public WebElement cart;
    @FindBy(xpath = "//h3[@ng-click=\"goToFilteredPage('top')\"]")
    private WebElement topRestaurants;
    @FindBy(xpath = ".//h1[@ng-click=\"goToFilteredPage('card_payment')\"]")
    private WebElement onlinePayment;
    @FindBy(xpath = "//h1[@ng-click=\"goToFilteredPage('promo')\"]")
    private WebElement restaurantsWithPromotions;
    @FindBy(xpath = "//h1[@ng-click=\"goToFilteredPage('new')\"]")
    private WebElement newRestaurants;
    @FindBy(xpath = "//h1[@ng-click=\"goToFilteredPage('fastest')\"]")
    private WebElement fastDelivery;
    @FindBy(xpath = "//input[@id='addressInput']")
    public WebElement addressInput;
    @FindBy(xpath = "//button[@class='btn btn-warning ng-binding ng-scope']")
    public WebElement saveAddress;
    @FindBy(xpath = "//button[@class='btn btn-success ng-binding']")
    public WebElement confirm;
    @FindBy(xpath = "//input[@id='number']")
    public WebElement streetInput;
    @FindBy(xpath = "//a[@href=\"cola-promo/\"]")
    private WebElement cocaCola;
    @FindBy(xpath = "//a[@href='/en/?filter=all'][contains(text(),'Restaurants')]")
    public WebElement restaurants;
    @FindBy(xpath = "//ymaps[@class='ymaps-2-1-71-zoom__icon ymaps-2-1-71-float-button-icon']")
    public WebElement zoom;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return cocaCola.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkIfUserIsLoggedIn(WebElement obj) {
        try {
            if (obj.getText() != null) return true;
            else return false;
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getSpecificRestaurant(String name) {
        for (WebElement restaurant : homeRestaurants) {
            //restaurant.findElement(By.xpath("//img[@title=\"" + name + "\"]"));
            //if (restaurant.findElement(By.xpath("//h3[@class=\"ng-binding\"]")).getText().equals(name)){
            if (restaurant.getAttribute("href").contains(name.toLowerCase())) {
                return restaurant;
            }
        }
        System.out.println("No such restaurant was found.");
        return null;
    }

    public void insertAddress() {
        addressInput.sendKeys("pparis"); //There is no typo.. Double S at the beginning due to
        // system bug which does not read the first character when you write the address.
        addressInput.sendKeys(Keys.ENTER);
        saveAddress.click();
    }

    public void insertSteetNumber() {
        streetInput.sendKeys("13");
    }

    public void setAddress() {
        insertAddress();
        insertSteetNumber();
    }

    public void clickLogDrop() {
        loginDropdown.click();
    }

    public void clickLogIn() {
        login.click();
    }

    public void navigateToLogin() {
        clickLogDrop();
        clickLogIn();
    }

    public void clarifyAddress() throws InterruptedException {
        addressInput.clear();
        addressInput.sendKeys("str Schinoasa");
        addressInput.sendKeys(Keys.DOWN, Keys.RETURN);
        Thread.sleep(3000);
        for (int i = 0; i < 3; i++) zoom.click();
        saveAddress.click();
    }
}
