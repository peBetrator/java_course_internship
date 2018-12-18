package StepDefinition;

import TestContext.TestContext;
import cucumber.api.java.After;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @After
    public void AfterSteps() {
        testContext.getWebDriverManager().closeDriver();
    }

}
