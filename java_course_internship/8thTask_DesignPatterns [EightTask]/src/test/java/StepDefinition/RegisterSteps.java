package StepDefinition;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegisterPage;
import TestContext.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class RegisterSteps {
    TestContext testContext;
    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;

    public RegisterSteps(TestContext context) {
        testContext = context;
        mainPage = testContext.getPageObjectManager().getMainPage();
        loginPage = testContext.getPageObjectManager().getLoginPage();
        registerPage = testContext.getPageObjectManager().getRegisterPage();
    }

    @When("^User navigates to RegisterPage$")
    public void user_navigates_to_RegisterPage() {
        mainPage.clickLoginButton();
        loginPage.clickRegisterButton();
        String res = registerPage.getHeadingText();
        Assert.assertEquals("Register", res);

    }

    @And("^User fills in \"([^\"]*)\", \"([^\"]*)\"and \"([^\"]*)\"$")
    public void user_regs(String arg1, String arg2, String arg3) {
        registerPage.createAccount(arg1, arg2, arg3);
        loginPage.clickSubmitButton();
        String res = registerPage.getConfirmation();
        Assert.assertEquals("You are now registered.", res);
    }

    @And("^User fills in existing account$")
    public void userFillsInExistingAccount() {
        registerPage.createAccount("test_user", "prank@mail.com", "123");
        loginPage.clickSubmitButton();
        String res = registerPage.getErrorMessage();
        Assert.assertEquals("A user with that username already exists.", res);
    }

    @Then("^User is warned$")
    public void userIsWarnedAboutDuplicate() {
        Assert.assertTrue(registerPage.checkErrorMsg());
    }

    @When("^User fills in different passwords$")
    public void userFillsInDifferentPasswords() {
        registerPage.usernameInput.clear();
        registerPage.mailInput.clear();
        registerPage.createAccount("new_user", "prank@mail.com", "123");
        registerPage.typeConfirmPass("321");
        loginPage.clickSubmitButton();
        String res = registerPage.getErrorMessage();
        Assert.assertEquals("The two password fields didn't match.", res);
    }
}
