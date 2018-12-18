package stepDefinition;

import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import com.endava.straus.atf.page.RestaurantPage;
import com.endava.straus.atf.page.SearchRestaurantPage;
import testContext.TestContext;

public class SearchSteps extends BaseStep {
    public SearchSteps(TestContext context) {
        super(context);
    }

    @When("^user searches for '(.*)' from '(.*)' '(.*)'$")
    public void userSearchesFrom(String item, String convenient, String restaurant) {
        page = utilities.getPageByName("SearchRestaurant");
        SearchRestaurantPage searchRestaurantPage = (SearchRestaurantPage) page;
        searchRestaurantPage.selectFoodCategory(item, driver);
        searchRestaurantPage.selectRestaurantType(convenient);
        searchRestaurantPage.updateRestaurantList(driver);
        String url = page.nameToUrl(restaurant);
        searchRestaurantPage.selectRestaurant(url);
    }

    @And("^user selects '(.*)' '(.*)'$")
    public void userSelectsCheapBurger(String optimal, String category) throws InterruptedException {
        page = utilities.getPageByName("Restaurant");
        RestaurantPage restaurantPage = (RestaurantPage) page;
        Thread.sleep(1000);
        restaurantPage.setCatXpath(category);
        int index = restaurantPage.selectOptimalProduct(optimal, true);
        restaurantPage.simpleAddProductToCart(index, true);
    }
}
