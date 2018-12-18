package stepDefinition;

import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.endava.straus.atf.page.HomePage;
import testContext.TestContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static utilities.Logger.assertThat;

public class LoginSteps extends BaseStep {

    public LoginSteps(TestContext context) {
        super(context);
    }

    @And("^user navigates to LoginPage$")
    public void user_navigates_to_LoginPage() throws InvocationTargetException, IllegalAccessException {
        Method method = utilities.getClickMethod(page, "clicks");
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(utilities.getWebElementByName(page, "loginDropdown")));
        method.invoke(page, webElement);
        webElement = wait.until(ExpectedConditions.elementToBeClickable(utilities.getWebElementByName(page, "login")));
        method.invoke(page, webElement);
    }

    @And("^user is(.*) authenticated$")
    public void user_is_authenticated(String arg0) throws InvocationTargetException, IllegalAccessException {
        Method method = utilities.getClickMethod(page, "clicks");
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(utilities.getWebElementByName(page, "loginDropdown")));
        method.invoke(page, webElement);
        HomePage homePage = (HomePage) page;
        switch (arg0) {
            case "":
                assertThat("User is authenticated ", homePage.checkIfUserIsLoggedIn(homePage.signOut), is(true));
                break;
            case "not":
                assertThat("User is not authenticated ",homePage.checkIfUserIsLoggedIn(homePage.signOut),is(false));
        }
    }
}
