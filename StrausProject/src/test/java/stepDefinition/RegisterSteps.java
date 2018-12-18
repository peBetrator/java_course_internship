package stepDefinition;

import com.endava.straus.atf.common.action.Screenshot;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.endava.straus.atf.page.HomePage;
import com.endava.straus.atf.page.LoginPage;
import com.endava.straus.atf.page.RegisterPage;
import testContext.TestContext;

import static org.hamcrest.CoreMatchers.is;
import static utilities.Logger.assertThat;

public class RegisterSteps extends BaseStep {

    public RegisterSteps(TestContext context) {
        super(context);
    }

    @When("^user navigates to RegisterPage$")
    public void user_navigates_to_RegisterPage() {
        page = utilities.getPageByName("Home");
        HomePage homePage = (HomePage) page;
        homePage.navigateToLogin();
        page = utilities.getPageByName("Login");
        LoginPage loginPage = (LoginPage) page;
        loginPage.navigateToRegister();
    }

    @Then("^user user is registered$")
    public void userUserIsRegistered() {
        page = utilities.getPageByName("Register");
        RegisterPage registerPage = (RegisterPage) page;
        Screenshot.takeScreenshot(driver, registerPage.confirmationMsg, flag);
        assertThat("User is registered", registerPage.receives(registerPage.confirmationMsg), is("You are now registered."));
    }

    @And("^user fills in duplicate account$")
    public void userFillsInExistingAccount() {
        page = utilities.getPageByName("Register");
        RegisterPage registerPage = (RegisterPage) page;
        registerPage.createAccount("test_user","prank@mail.com","123");
        registerPage.clickSubmitButton();
    }

    @Then("^user is warned about duplicate$")
    public void userIsWarnedAboutDuplicate() {
        page = utilities.getPageByName("Register");
        RegisterPage registerPage = (RegisterPage) page;
        Screenshot.takeScreenshot(driver, registerPage.errorMsg, flag);
        assertThat("User is warned about duplicate",registerPage.receives(registerPage.errorMsg),is("A user with that username already exists."));
    }

    @When("^user fills in different passwords$")
    public void userFillsInDifferentPasswords() {
        page = utilities.getPageByName("Register");
        RegisterPage registerPage = (RegisterPage) page;
        registerPage.createAccount("lyambda","m","123");
        registerPage.typeConfirmPass("123");
        registerPage.clickSubmitButton();
    }

    @Then("^user is warned about password mismatch$")
    public void userIsWarnedAboutPasswordMismatch() {
        page = utilities.getPageByName("Register");
        RegisterPage registerPage = (RegisterPage) page;
        Screenshot.takeScreenshot(driver, registerPage.errorMsg, flag);
        assertThat("User is warned about password mismatch",registerPage.receives(registerPage.errorMsg),is("The two password fields didn't match."));
    }
}
