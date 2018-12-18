package stepDefinition;

import com.endava.straus.atf.common.action.Screenshot;
import com.endava.straus.atf.page.CheckoutPage;
import com.endava.straus.atf.pojo.ClientDetailsPojo;
import comonSteps.BaseStep;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebElement;
import testContext.TestContext;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static utilities.Logger.assertThat;

public class CheckCancelOrder extends BaseStep {
    public CheckCancelOrder(TestContext context) {
        super(context);
    }

    @And("^the cart contain (\\d+) '(.*)'$")
    public void theCartContainBigMac(int quantity, String productName) {
        page = utilities.getPageByName("Cart");
        WebElement webElement = utilities.getWebElementByName(page, "oneItem");
        Screenshot.takeScreenshot(driver, webElement, flag);
        boolean expectedResult = webElement.getText().contains(productName) && webElement.getText().contains("" + quantity);
        assertThat("The cart contain " + quantity + " " + productName, expectedResult, is(true));
    }

    @And("^user completes the '(.*)' form with following data$")
    public void userCompletesTheCheckoutFormWithFollowingData(String pageName, DataTable details) {
        List<ClientDetailsPojo> clientDetails = details.asList(ClientDetailsPojo.class);
        page = utilities.getPageByName(pageName);
        CheckoutPage checkoutPage = (CheckoutPage) page;
        checkoutPage.completeFields(clientDetails.get(0));
    }

    @And("^user check the profile page$")
    public void userCheckTheProfilePage() {

    }
}
