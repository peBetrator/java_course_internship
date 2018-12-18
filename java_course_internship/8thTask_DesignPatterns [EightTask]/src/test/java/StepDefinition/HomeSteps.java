package StepDefinition;

import Pages.MainPage;
import TestContext.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class HomeSteps {
    MainPage mainPage;
    TestContext testContext;

    public HomeSteps(TestContext context) {
        testContext = context;
        mainPage = testContext.getPageObjectManager().getMainPage();
    }

    @Given("^User is on Home page$")
    public void user_is_on_Home_page() {
        mainPage.clickLater();
    }
}
