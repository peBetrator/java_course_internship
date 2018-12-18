package stepDefinition;

import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import com.endava.straus.atf.page.HomePage;
import testContext.TestContext;

public class HomeSteps extends BaseStep {
    public HomeSteps(TestContext context) {
        super(context);
    }

    @And("^user clarifies address$")
    public void userClarifiesAddress() throws InterruptedException {
        page = utilities.getPageByName("Home");
        HomePage homePage = (HomePage) page;
        homePage.clarifyAddress();
    }
}
