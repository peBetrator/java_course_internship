
package stepDefinition;

import com.endava.straus.atf.common.action.Screenshot;
import comonSteps.BaseStep;
import cucumber.api.java.en.Then;
import com.endava.straus.atf.page.CartPage;
import com.endava.straus.atf.page.CheckoutPage;
import com.endava.straus.atf.page.RestaurantPage;
import testContext.TestContext;
import cucumber.api.java.en.And;

import static org.hamcrest.CoreMatchers.is;
import static utilities.Logger.assertThat;

public class PlaceOrder extends BaseStep {


    public PlaceOrder(TestContext context) {
        super(context);
    }

    @And("^user goes back to Restaurants page$")
    public void backToHomePage() throws InterruptedException {
        page = utilities.getPageByName("Restaurant");
        RestaurantPage restaurantPage = (RestaurantPage) page;
        restaurantPage.navigateBackTo("https://www.straus.md/en/?filter=all");
    }

    @And("^user makes the order$")
    public void userMakesTheOrder() {
        page = utilities.getPageByName("Cart");
        CartPage cartPage = (CartPage) page;
        cartPage.orderFood();
    }

    @And("^user fills in the fields with '(<name>)', '(<phone>)', '(<email>)', '(<call>)', '(<terms>)'$")
    public void userFillsFieldsWith(String name, String phone, String email, String call, String terms) throws InterruptedException {
        page = utilities.getPageByName("Checkout");
        CheckoutPage checkoutPage = (CheckoutPage) page;
        checkoutPage.insertValue(checkoutPage.name, name);
        checkoutPage.insertValue(checkoutPage.phone, phone);
        Thread.sleep(1000);
        checkoutPage.insertValue(checkoutPage.email, email);
        Thread.sleep(1000);
        if(Boolean.valueOf(call)) {
            checkoutPage.callOnArrial.click();
        }
        if(Boolean.valueOf(terms)) {
            checkoutPage.agreeTermsAndConditions.click();
        }
        Thread.sleep(2000);
    }

    @And("^user submits the order$")
    public void userSubmitsTheOrder() throws InterruptedException {
        page = utilities.getPageByName("Checkout");
        CheckoutPage checkoutPage = (CheckoutPage) page;
        checkoutPage.submitOrder.click();
        checkoutPage.acceptOrderFromMultipleRestaurants(true);
        Thread.sleep(5000);
    }

    @Then("^user is warned that delivery is not possible$")
    public void userIsWarnedThatDeliveryIsNotPossible() throws Throwable {
        page = utilities.getPageByName("Checkout");
        CheckoutPage checkoutPage = (CheckoutPage) page;
        Screenshot.takeScreenshot(driver, checkoutPage.deliveryWarning, flag);
        assertThat("User is warned that delivery is not possible ",checkoutPage.receives(checkoutPage.deliveryWarning),is("The delivery address is outside the territory served by the straus.md service. Delivery to this address may not be possible or cost more."));
    }
}
