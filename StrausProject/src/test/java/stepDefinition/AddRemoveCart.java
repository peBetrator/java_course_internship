package stepDefinition;

import com.endava.straus.atf.common.action.Screenshot;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.endava.straus.atf.page.CartPage;
import com.endava.straus.atf.page.RestaurantPage;
import com.endava.straus.atf.page.SearchRestaurantPage;
import testContext.TestContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static utilities.Logger.assertThat;

public class AddRemoveCart extends BaseStep {
    public AddRemoveCart(TestContext context) {
        super(context);
    }


    @And("^user (clicks) on '(.*)' restaurant$")
    public void userClicksOnRestaurant(String action, String restName) throws InvocationTargetException, IllegalAccessException {
        Method method = utilities.getClickMethod(page, action);
        String url = page.nameToUrl(restName);
        page = utilities.getPageByName("SearchRestaurant");
        SearchRestaurantPage searchRestaurants = (SearchRestaurantPage) page;
        WebElement restaurant = searchRestaurants.getSpecificRestaurant(url);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(restaurant));
        Screenshot.takeScreenshot(driver, webElement, flag);
        method.invoke(page, webElement);
        page = utilities.getPageByName("Restaurant");
        RestaurantPage restaurantPage = (RestaurantPage) page;
        assertThat("User is on ".concat(restName).concat(" restaurant"), restaurantPage.isElementDisplayed(), is(true));
    }

    @And("^user sets address$")
    public void userSetsAddress() {
        page = utilities.getPageByName("Restaurant");
        RestaurantPage restaurantPage = (RestaurantPage) page;
        restaurantPage.insertAddress();
    }

    @And("^user adds to cart a '(.*)'$")
    public void userAddsToCartA(String arg0) throws InterruptedException {
        page = utilities.getPageByName("Restaurant");
        RestaurantPage restaurantPage = (RestaurantPage) page;
        Thread.sleep(1000);
        int index = restaurantPage.selectProductIndex(arg0);
        restaurantPage.simpleAddProductToCart(index, false);
    }

    @Then("^user accesses cart$")
    public void userAccessesCart() throws InterruptedException {
        Thread.sleep(1000);
        page = utilities.getPageByName("Restaurant");
        RestaurantPage restaurantPage = (RestaurantPage) page;
        restaurantPage.scrollToFind(restaurantPage.cart);
        restaurantPage.cart.click();
        page = utilities.getPageByName("Cart");
        assertThat("User is on cart com.endava.straus.atf.page.", page.isElementDisplayed(), is(true));
    }

    @And("^user removes all from cart$")
    public void user_removes_from_cart() throws InterruptedException {
        page = utilities.getPageByName("Cart");
        CartPage cartPage = (CartPage) page;
        cartPage.clearCart();
        Thread.sleep(2000);
        assertThat("There are no elements left in the cart", page.isElementDisplayed(), is(false));
    }

    @Then("^user is warned about higher price$")
    public void userIsWarnedAboutHigherPrice() {
        page = utilities.getPageByName("Restaurant");
        RestaurantPage restaurantPage = (RestaurantPage) page;
        Screenshot.takeScreenshot(driver, restaurantPage.deliveryWarning, flag);
        assertThat("User is warned about higher price",restaurantPage.receives(restaurantPage.deliveryWarning),is("Extra costs may apply."));
    }
}

