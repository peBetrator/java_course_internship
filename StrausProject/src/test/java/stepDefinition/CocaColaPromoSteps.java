package stepDefinition;

import com.endava.straus.atf.common.action.Screenshot;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testContext.TestContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static utilities.Logger.assertThat;

public class CocaColaPromoSteps extends BaseStep {
    public CocaColaPromoSteps(TestContext context) {
        super(context);
    }

    @Given("^user is on '(.*)' page$")
    public void userIsOnTheStrausPage(String pageName) {
        page = utilities.getPageByName(pageName);
        assertThat("User is on " + pageName + "com/endava/straus/atf/page", page.isElementDisplayed(), is(true));
    }

    @When("^user (clicks) on '(.*)' menu item$")
    public void userClickOnCocaColaMenuItem(String action, String element) throws InvocationTargetException, IllegalAccessException {
        Method method = utilities.getClickMethod(page, action);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(utilities.getWebElementByName(page, element)));
        Screenshot.takeScreenshot(driver, webElement, flag);
        method.invoke(page, webElement);
    }

    @When("^user (completes) the '(.*)' field with '(.*)' value$")
    public void userCompleteTheField(String action, String element, String valueToComplete) throws IllegalAccessException, InvocationTargetException {
        Method method = utilities.getWriteMethod(page, action);
        WebElement webElement = utilities.getWebElementByName(page, element);
        method.invoke(page, webElement, valueToComplete);
        Screenshot.takeScreenshot(driver, webElement, flag);
    }


    @And("^user (clicks) on '(.*)' checkbox$")
    public void userClickOnTerms_and_conditionsCheckbox(String action, String element) throws IllegalAccessException, InvocationTargetException {
        Method method = utilities.getClickMethod(page, action);
        WebElement webElement = utilities.getWebElementByName(page, element);
        Screenshot.takeScreenshot(driver, webElement, flag);
        method.invoke(page, webElement);
        Assert.assertTrue(webElement.isSelected());
    }

    @And("^user (clicks) on '(.*)' button$")
    public void userClickOnPlayButton(String action, String element) throws IllegalAccessException, InvocationTargetException {
        Method method = utilities.getClickMethod(page, action);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(utilities.getWebElementByName(page, element)));
        Screenshot.takeScreenshot(driver, webElement, flag);
        method.invoke(page, webElement);
    }

    @Then("^the '(.*)' button become available$")
    public void theSpinButtonBecomeAvailable(String element) {
        WebElement webElement = utilities.getWebElementByName(page, element);
        Screenshot.takeScreenshot(driver, webElement, flag);
        Assert.assertTrue(webElement.isDisplayed());
    }

    @And("^'(\\d+)' remaining '(.*)' are displayed$")
    public void remainingAttemptsAreDisplayed(int expectedResult, String element) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement webElement = utilities.getWebElementByName(page, element);
        Screenshot.takeScreenshot(driver, webElement, flag);
        int actualResult = Integer.valueOf(webElement.getText());
        Assert.assertEquals("Actual number of attemps don't match with the expected number", expectedResult, actualResult);
    }

    @Then("^the raffle result is displayed$")
    public void theRaffleResultIsDisplayed() {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(utilities.getWebElementByName(page, "resultImage")));
        Screenshot.takeScreenshot(driver, element, flag);
        Assert.assertTrue("The raffle result is not displayed.", element.isDisplayed());
    }
}
