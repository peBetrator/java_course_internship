package StepDefinition;

import Pages.LoginPage;
import Pages.MainPage;
import TestContext.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    MainPage mainPage;
    LoginPage loginPage;
    TestContext testContext;

    public LoginSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        mainPage = testContext.getPageObjectManager().getMainPage();
    }

    @When("^User navigates to LoginPage$")
    public void user_navigates_to_LoginPage() {
        mainPage.clickLoginButton();
        String res = loginPage.getHeadingText();
        Assert.assertEquals("Log in", res);
    }

    @And("^User fills in \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userFillsInNameAndPassword(String arg0, String arg1) {
        loginPage.typeCredentials(arg0, arg1);
        loginPage.clickSubmitButton();
    }

    @Then("^User is authenticated$")
    public void user_is_logged_in() {
        mainPage.clickLoginDropdown();
        Assert.assertTrue(mainPage.checkIfUserIsLogedIn());
    }

    @Then("^User is not authenticated$")
    public void user_is_not_logged_in() {
        mainPage.clickLoginDropdown();
        Assert.assertFalse(mainPage.checkIfUserIsLogedIn());
    }

    @When("^User logs out$")
    public void userLogsOut() {
        mainPage.clickSignOutButton();
    }
}
